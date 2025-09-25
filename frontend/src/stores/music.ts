import { defineStore } from 'pinia'
import { ref, computed } from 'vue'
import axios from 'axios'
import { useUserStore } from './user'

// 音乐类型定义
export interface Music {
  id: number
  mid: string
  song: string
  singer: string
  album: string
  cover: string
  time?: string
  pay?: string
}

// 播放列表类型定义
export interface Playlist {
  id: number
  name: string
  description: string
  cover: string
  userId: number
  createdAt: string
  updatedAt: string
  musicList?: PlaylistMusic[]
  musicCount: number
}

// 播放列表音乐关联类型定义
export interface PlaylistMusic {
  id: number
  playlistId: number
  musicId: number
  musicMid: string
  musicSong: string
  musicSinger: string
  musicAlbum: string
  musicCover: string
  musicUrl: string
  sortOrder: number
  addedAt: string
}

export const useMusicStore = defineStore('music', () => {
  // 用户store引用
  const userStore = useUserStore()

  // ------------------------------ 基础播放状态 ------------------------------
  const currentMusic = ref<Music | null>(null) // 当前播放音乐
  const musicList = ref<Music[]>([]) // 音乐列表（搜索结果等）
  const isPlaying = ref(false) // 是否正在播放
  const isLoading = ref(false) // 全局加载状态
  const searchKeyword = ref('') // 搜索关键词
  const audio = ref<HTMLAudioElement | null>(null) // 音频实例
  const currentTime = ref(0) // 当前播放时间（秒）
  const duration = ref(0) // 音乐总时长（秒）
  const hasRestoredFromSettings = ref(false) // 播放设置是否已从数据库恢复

  // ------------------------------ 歌词相关状态 ------------------------------
  const currentLyrics = ref<{
    lrc: string
    trans: string
    yrc: string
    roma: string
  } | null>(null) // 当前歌词
  const lyricsCache = new Map<string, { lrc: string; trans: string; yrc: string; roma: string } | null>() // 歌词缓存
  const lastLyricsKey = ref<string | null>(null) // 最后一次获取歌词的key

  // ------------------------------ 搜索相关状态 ------------------------------
  const searchSuggestions = ref<any>(null) // 搜索建议
  const searchHistory = ref<string[]>([]) // 搜索历史

  // ------------------------------ 跨标签页同步状态 ------------------------------
  const tabId = Math.random().toString(36).slice(2) // 标签页唯一标识
  let syncChannel: BroadcastChannel | null = null // 广播通道
  const leaderStorageKey = 'player_leader_tab' // 领导者标签页存储key
  const leaderId = ref<string | null>(null) // 领导者标签页ID
  const isLeader = computed(() => leaderId.value === tabId) // 是否为领导者标签页
  type SyncMessage = { type: string; payload?: any; from: string; ts: number } // 同步消息类型

  // ------------------------------ 无限滚动状态 ------------------------------
  const currentPage = ref(1) // 当前页码
  const hasMoreData = ref(true) // 是否有更多数据
  const isLoadingMore = ref(false) // 加载更多中

  // ------------------------------ 播放队列状态 ------------------------------
  const playQueue = ref<Music[]>([]) // 播放队列
  const showPlayQueue = ref(false) // 是否显示播放队列

  // ------------------------------ 音量控制状态 ------------------------------
  const volume = ref(70) // 音量（0-100）
  const isMuted = ref(false) // 是否静音
  const previousVolume = ref(70) // 静音前的音量

  // ------------------------------ 播放模式状态 ------------------------------
  const playMode = ref('list') // 播放模式：list-列表循环，single-单曲循环，random-随机播放

  // ------------------------------ 收藏相关状态 ------------------------------
  const isCurrentMusicLiked = ref(false) // 当前播放音乐是否已收藏
  const isInTempPlayMode = ref(false) // 是否在临时播放模式（播放我喜欢的）
  const originalPlayQueue = ref<Music[]>([]) // 原始播放队列（临时模式下保存）
  const favoriteStatusListeners = ref<Array<(isLiked: boolean) => void>>([]) // 收藏状态监听器

  // ------------------------------ 最近播放相关状态 ------------------------------
  type RecentPlayEvent = {
    type: 'record' | 'progress'
    music?: Music
    playDuration?: number
    playProgress?: number
    playTime?: number // ms 时间戳
  }
  const recentPlayListeners = ref<Array<(event: RecentPlayEvent) => void>>([]) // 最近播放监听器

  // ------------------------------ 其他辅助状态 ------------------------------
  let progressSyncTimer: NodeJS.Timeout | null = null // 播放进度同步定时器
  let lastRequestTime = 0 // 最后一次请求时间（频率限制）
  const REQUEST_INTERVAL = 5000 // 请求间隔（5秒）
  let isRequestingUrl = false // 是否正在请求播放URL
  const requestQueue: Array<{ 
    music: Music, 
    resolve: (value: any) => any, 
    reject: (reason: any) => any 
  }> = [] // 请求队列


  // ------------------------------ 计算属性 ------------------------------
  /** 是否有当前播放音乐 */
  const hasCurrentMusic = computed(() => currentMusic.value !== null)

  /** 播放进度百分比 */
  const progress = computed(() => {
    if (duration.value === 0) return 0
    return (currentTime.value / duration.value) * 100
  })

  /** 播放队列长度 */
  const queueCount = computed(() => playQueue.value.length)

  /** 播放模式图标 */
  const playModeIcon = computed(() => {
    switch (playMode.value) {
      case 'list': return '🔁'
      case 'single': return '🔂'
      case 'random': return '🔀'
      default: return '🔁'
    }
  })

  /** 播放模式名称 */
  const playModeName = computed(() => {
    switch (playMode.value) {
      case 'list': return '列表循环'
      case 'single': return '单曲循环'
      case 'random': return '随机播放'
      default: return '列表循环'
    }
  })


  // ------------------------------ 跨标签页同步方法 ------------------------------
  /** 确保广播通道存在 */
  const ensureChannel = () => {
    if (!('BroadcastChannel' in window)) return
    if (!syncChannel) {
      syncChannel = new BroadcastChannel('player-sync')
      
      // 监听广播消息
      syncChannel.onmessage = async (ev: MessageEvent<SyncMessage>) => {
        const msg = ev.data
        if (!msg || msg.from === tabId) return
        
        const { type, payload } = msg
        try {
          // 领导者处理意图，跟随者处理状态
          const isState = ['play', 'toggle', 'seek', 'volume', 'next', 'prev'].includes(type)
          const isIntent = type.startsWith('intent:')

          // 跟随者处理状态同步
          if (!isLeader.value && isState) {
            switch (type) {
              case 'play': {
                const music: Music = payload.music
                currentMusic.value = music
                if (typeof payload.currentTime === 'number') {
                  currentTime.value = payload.currentTime
                }
                isPlaying.value = !!payload.isPlaying
                break
              }
              case 'toggle': {
                isPlaying.value = !!payload.isPlaying
                break
              }
              case 'seek': {
                if (typeof payload.currentTime === 'number') {
                  currentTime.value = payload.currentTime
                }
                break
              }
              case 'volume': {
                if (typeof payload.volume === 'number') volume.value = payload.volume
                if (typeof payload.isMuted === 'boolean') isMuted.value = payload.isMuted
                break
              }
              case 'next':
              case 'prev':
                // 由后续状态广播驱动UI，不执行逻辑
                break
            }
          } 
          // 领导者处理意图
          else if (isLeader.value && isIntent) {
            const intent = type.slice('intent:'.length)
            switch (intent) {
              case 'play': {
                const music: Music = payload.music
                await playMusic(music)
                break
              }
              case 'toggle': {
                await togglePlay()
                break
              }
              case 'seek': {
                if (typeof payload.percent === 'number') await setProgress(payload.percent)
                break
              }
              case 'volume': {
                if (typeof payload.volume === 'number') await setVolume(payload.volume)
                if (typeof payload.toggleMute === 'boolean' && payload.toggleMute) await toggleMute()
                break
              }
              case 'next': {
                await playNext()
                break
              }
              case 'prev': {
                await playPrevious()
                break
              }
            }
          }
        } catch (e) {
          console.error('同步消息处理错误:', e)
        }
      }
    }
  }

  /** 发送同步消息 */
  const postSync = (type: string, payload?: any) => {
    if (!syncChannel) return
    try {
      // 仅发送可克隆的纯数据
      const safePayload = payload ? JSON.parse(JSON.stringify(payload)) : undefined
      const msg: SyncMessage = { 
        type, 
        payload: safePayload, 
        from: tabId, 
        ts: Date.now() 
      }
      syncChannel.postMessage(msg)
    } catch (e) {
      console.warn('postSync 克隆失败，已跳过该条消息:', type, e)
    }
  }

  /** 发送状态同步（仅领导者） */
  const postState = (type: string, payload?: any) => {
    if (!isLeader.value) return
    postSync(type, payload)
  }

  /** 发送意图同步（仅跟随者） */
  const postIntent = (type: string, payload?: any) => {
    if (isLeader.value) return
    postSync(`intent:${type}`, payload)
  }

  /** 抢占领导者身份 */
  const claimLeadership = () => {
    try {
      leaderId.value = tabId
      localStorage.setItem(leaderStorageKey, tabId)
    } catch {}
  }


  // ------------------------------ 最近播放监听器方法 ------------------------------
  /** 添加最近播放监听器 */
  const addRecentPlayListener = (listener: (event: RecentPlayEvent) => void) => {
    recentPlayListeners.value.push(listener)
  }

  /** 移除最近播放监听器 */
  const removeRecentPlayListener = (listener: (event: RecentPlayEvent) => void) => {
    const index = recentPlayListeners.value.indexOf(listener)
    if (index > -1) recentPlayListeners.value.splice(index, 1)
  }

  /** 通知最近播放监听器 */
  const notifyRecentPlayListeners = (event: RecentPlayEvent) => {
    recentPlayListeners.value.forEach(l => {
      try { l(event) } catch (e) { console.error('最近播放监听器执行错误:', e) }
    })
  }


  // ------------------------------ 音频初始化方法 ------------------------------
  /** 初始化音频实例 */
  const initAudio = () => {
    // 幂等处理：避免重复创建
    if (audio.value) return
    ensureChannel()

    // 领导者竞争：优先当前聚焦页
    try {
      const stored = localStorage.getItem(leaderStorageKey)
      if (stored) leaderId.value = stored
      if (!leaderId.value) {
        leaderId.value = tabId
        localStorage.setItem(leaderStorageKey, tabId)
      }

      // 页面卸载时释放领导者身份
      window.addEventListener('beforeunload', () => {
        if (isLeader.value) {
          localStorage.removeItem(leaderStorageKey)
        }
      })
    } catch {}

    // 创建音频实例
    audio.value = new Audio()
    // 设置初始音量
    audio.value.volume = volume.value / 100

    // 音频事件监听
    audio.value.addEventListener('play', () => {
      isPlaying.value = true
    })

    audio.value.addEventListener('playing', () => {
      isPlaying.value = true
    })

    audio.value.addEventListener('pause', () => {
      // ended事件单独处理，避免冲突
      if (!audio.value?.ended) {
        isPlaying.value = false
      }
    })

    audio.value.addEventListener('timeupdate', () => {
      currentTime.value = audio.value?.currentTime || 0
      // 每1秒同步一次播放进度到数据库
      if (Math.floor(currentTime.value) % 1 === 0 && currentTime.value > 0) {
        syncPlayProgressToDatabase()
      }
    })

    audio.value.addEventListener('loadedmetadata', () => {
      duration.value = audio.value?.duration || 0
    })

    audio.value.addEventListener('ended', () => {
      isPlaying.value = false
      // 自动播放下一首
      playNext()
      postState('toggle', { isPlaying: false })
    })

    // 页面卸载时立即同步播放进度
    window.addEventListener('beforeunload', () => {
      if (audio.value && currentMusic.value) {
        syncPlayProgressImmediately()
      }
    })

    // 页面隐藏时同步播放进度
    document.addEventListener('visibilitychange', () => {
      if (document.hidden && audio.value && currentMusic.value) {
        syncPlayProgressToDatabase()
      }
    })
  }


  // ------------------------------ 搜索相关方法 ------------------------------
  /** 搜索音乐（首次搜索） */
  const searchMusic = async (keyword: string) => {
    if (!keyword.trim()) return
    // 避免重复搜索（关键词相同且已有结果）
    if (searchKeyword.value === keyword && musicList.value.length > 0) {
      console.log('🔍跳过重复搜索，使用已有结果:', keyword)
      return
    }

    isLoading.value = true
    searchKeyword.value = keyword
    currentPage.value = 1
    hasMoreData.value = true
    musicList.value = []

    console.log('🔍开始搜索音乐，关键词:', keyword)

    try {
      const apiUrl = '/api/music/search'
      const params = {
        keyword: keyword,
        page: 1,
        size: 20
      }

      console.log('📡调用后端API:', apiUrl, params)
      const res = await axios.get(apiUrl, { params })
      console.log('✅后端API响应:', res.data)

      if (res.data.code === 200) {
        const newMusicList = res.data.data || []
        musicList.value = newMusicList
        // 检查是否还有更多数据
        hasMoreData.value = newMusicList.length >= 20

        console.log('🎵首次搜索完成，获得', newMusicList.length, '首歌曲')
        console.log('📄是否还有更多数据:', hasMoreData.value)
      } else {
        throw new Error(res.data.message || '搜索失败')
      }

    } catch (error: any) {
      console.error('❌搜索音乐失败:', error)
      console.error('错误详情:', {
        message: error.message,
        status: error.response?.status,
        statusText: error.response?.statusText,
        data: error.response?.data
      })
      musicList.value = []
      hasMoreData.value = false
    } finally {
      isLoading.value = false
    }
  }

  /** 加载更多音乐 */
  const loadMoreMusic = async () => {
    if (!hasMoreData.value || isLoadingMore.value || !searchKeyword.value.trim()) {
      return
    }

    isLoadingMore.value = true
    const nextPage = currentPage.value + 1
    console.log('📄加载更多音乐，页码:', nextPage)

    try {
      const apiUrl = '/api/music/search'
      const params = {
        keyword: searchKeyword.value,
        page: nextPage,
        size: 20
      }

      const res = await axios.get(apiUrl, { params })

      if (res.data.code === 200) {
        const newMusicList = res.data.data || []

        if (newMusicList.length > 0) {
          // 追加新数据
          musicList.value = [...musicList.value, ...newMusicList]
          currentPage.value = nextPage
          // 检查是否还有更多数据
          hasMoreData.value = newMusicList.length >= 20

          console.log('✅加载更多成功，新增', newMusicList.length, '首歌曲')
          console.log('📊总歌曲数:', musicList.value.length)
          console.log('📄是否还有更多数据:', hasMoreData.value)
        } else {
          hasMoreData.value = false
          console.log('📄没有更多数据了')
        }
      } else {
        throw new Error(res.data.message || '加载更多失败')
      }

    } catch (error) {
      console.error('❌加载更多音乐失败:', error)
      hasMoreData.value = false
    } finally {
      isLoadingMore.value = false
    }
  }


  // ------------------------------ 播放URL获取方法 ------------------------------
  /** 获取音乐播放URL（带队列管理） */
  const getMusicPlayUrl = async (music: Music, retryCount = 0) => {
    // 如果正在请求，加入队列
    if (isRequestingUrl) {
      return new Promise((resolve, reject) => {
        requestQueue.push({ music, resolve, reject })
      })
    }

    isRequestingUrl = true

    try {
      const result = await _getMusicPlayUrl(music, retryCount)

      // 处理队列中的下一个请求
      if (requestQueue.length > 0) {
        const nextRequest = requestQueue.shift()
        if (nextRequest) {
          setTimeout(() => {
            isRequestingUrl = false
            getMusicPlayUrl(nextRequest.music)
              .then((v) => nextRequest.resolve(v))
              .catch((e) => nextRequest.reject(e))
          }, REQUEST_INTERVAL)
        }
      } else {
        isRequestingUrl = false
      }

      return result
    } catch (error) {
      // 处理队列中的下一个请求
      if (requestQueue.length > 0) {
        const nextRequest = requestQueue.shift()
        if (nextRequest) {
          setTimeout(() => {
            isRequestingUrl = false
            getMusicPlayUrl(nextRequest.music)
              .then((v) => nextRequest.resolve(v))
              .catch((e) => nextRequest.reject(e))
          }, REQUEST_INTERVAL)
        }
      } else {
        isRequestingUrl = false
      }

      throw error
    }
  }

  /** 内部获取音乐播放URL方法（带重试机制） */
  const _getMusicPlayUrl = async (music: Music, retryCount = 0) => {
    // 请求频率限制
    const now = Date.now()
    const timeSinceLastRequest = now - lastRequestTime
    if (timeSinceLastRequest < REQUEST_INTERVAL) {
      const waitTime = REQUEST_INTERVAL - timeSinceLastRequest
      console.log(`⏳请求频率限制，等待${waitTime}ms`)
      await new Promise(resolve => setTimeout(resolve, waitTime))
    }
    lastRequestTime = Date.now()

    const apiUrl = '/api/music/url'
    const params = {
      ...(music.mid ? { mid: music.mid } : { id: music.id })
    }

    console.log('🎵获取播放URL:', apiUrl, params)

    try {
      const res = await axios.get(apiUrl, { params })

      if (res.data.code !== 200) {
        console.log('API响应错误:', res.data)
        // 如果是"choose超过最大值"错误，等待后重试
        const errorMessage = res.data.message || res.data.msg || ''
        if (errorMessage.includes('choose超过最大值') && retryCount < 3) {
          const waitTime = 5000 * (retryCount + 1) // 5秒、10秒、15秒
          console.log(`⚠️获取播放URL失败，${waitTime/1000}秒后重试(${retryCount+1}/3):`, errorMessage)
          await new Promise(resolve => setTimeout(resolve, waitTime))
          return _getMusicPlayUrl(music, retryCount + 1)
        }
        throw new Error(errorMessage || '获取播放URL失败')
      }

      if (!res.data.data?.url) {
        throw new Error('获取音乐播放URL失败')
      }

      return res.data.data
    } catch (error: any) {
      console.log('请求异常:', error)
      // 如果是网络错误且还有重试次数，等待后重试
      if ((error.code === 'NETWORK_ERROR' || error.message?.includes('NetworkError')) && retryCount < 2) {
        console.log(`⚠️网络错误，${2**retryCount}秒后重试(${retryCount+1}/2):`, error.message)
        await new Promise(resolve => setTimeout(resolve, 2000 * (2** retryCount)))
        return _getMusicPlayUrl(music, retryCount + 1)
      }
      throw error
    }
  }


  // ------------------------------ 下载音乐方法 ------------------------------
  /** 下载音乐 */
  const downloadMusic = async (music: Music) => {
    try {
      console.log('⬇️开始下载音乐:', music.song)

      // 获取音乐播放URL（这个URL就是音乐文件的直链）
      const musicData = await getMusicPlayUrl(music)

      if (!musicData.url) {
        throw new Error('获取音乐下载链接失败')
      }

      // 使用fetch获取文件内容
      const response = await fetch(musicData.url, {
        method: 'GET',
        headers: {
          'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36'
        }
      })

      if (!response.ok) {
        throw new Error(`下载失败: ${response.status} ${response.statusText}`)
      }

      // 获取文件内容
      const blob = await response.blob()

      // 创建blobURL
      const blobUrl = URL.createObjectURL(blob)

      // 创建下载链接
      const link = document.createElement('a')
      link.href = blobUrl
      link.download = `${music.song}-${music.singer}.${musicData.format || 'mp3'}`

      // 触发下载
      document.body.appendChild(link)
      link.click()
      document.body.removeChild(link)

      // 清理blobURL
      setTimeout(() => {
        URL.revokeObjectURL(blobUrl)
      }, 1000)

      console.log('✅音乐下载已开始:', music.song)
    } catch (error) {
      console.error('❌下载音乐失败:', error)
      throw error
    }
  }


  // ------------------------------ 最近播放记录方法 ------------------------------
  /** 记录最近播放 */
  const recordRecentPlay = async (music: Music, playDuration: number = 0, playProgress: number = 0) => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌用户未登录，无法记录最近播放')
      return
    }

    try {
      const response = await fetch('/api/recent-play/record', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          userId: userStore.currentUser.id,
          musicId: music.id.toString(),
          musicMid: music.mid,
          musicSong: music.song,
          musicSinger: music.singer,
          musicAlbum: music.album || '',
          musicCover: music.cover || '',
          musicTime: music.time || '',
          musicPay: music.pay || '',
          playDuration: playDuration,
          playProgress: playProgress
        })
      })

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`)
      }

      const result = await response.json()
      if (result.code === 200) {
        console.log('✅最近播放记录成功:', music.song)
        // 通知最近播放监听器（携带音乐数据用于增量插入）
        notifyRecentPlayListeners({ type: 'record', music })
      } else {
        console.error('❌最近播放记录失败:', result.message)
      }
    } catch (error) {
      console.error('❌记录最近播放失败:', error)
    }
  }

  /** 更新最近播放进度 */
  const updateRecentPlayProgress = async (music: Music, playDuration: number, playProgress: number) => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      return
    }

    try {
      const response = await fetch('/api/recent-play/progress', {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          userId: userStore.currentUser.id,
          musicId: music.id.toString(),
          playDuration: playDuration,
          playProgress: playProgress
        })
      })

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`)
      }

      const result = await response.json()
      if (result.code !== 200) {
        console.error('❌更新最近播放进度失败:', result.message)
      } else {
        // 通知最近播放监听器（用于实时更新当前项的进度/时间）
        notifyRecentPlayListeners({ 
          type: 'progress', 
          music, 
          playDuration, 
          playProgress, 
          playTime: Date.now() 
        })
      }
    } catch (error) {
      console.error('❌更新最近播放进度失败:', error)
    }
  }


  // ------------------------------ 核心播放控制方法 ------------------------------
  /** 播放音乐 */
  const playMusic = async (music: Music) => {
    if (!audio.value) return
    // 用户交互触发：若非领导者，先抢占领导权再本地真实播放，避免浏览器自动播放限制
    if (!isLeader.value) {
      claimLeadership()
    }

    // 如果点击的是当前正在播放的音乐，则切换播放/暂停状态
    if (currentMusic.value && currentMusic.value.id === music.id) {
      await togglePlay()
      return
    }

    // 先添加到队列（如果不在队列中才会添加）
    await addToPlayQueueWithSync(music)
    currentMusic.value = music

    // 检查当前音乐是否已收藏
    await checkCurrentMusicFavoriteStatus()

    try {
      const musicData = await getMusicPlayUrl(music)
      if (!audio.value.paused) {
        audio.value.pause()
      }
      audio.value.src = musicData.url
      await audio.value.play()
      isPlaying.value = true
      
      // 广播播放信息到其他标签页（仅发送可序列化的精简字段）
      const safeMusic = {
        id: music.id,
        mid: music.mid,
        song: music.song,
        singer: music.singer,
        album: music.album || '',
        cover: music.cover || '',
        time: music.time || '',
        pay: music.pay || ''
      }
      postState('play', { 
        music: safeMusic, 
        src: musicData.url, 
        currentTime: 0, 
        isPlaying: true 
      })

      // 同步当前播放音乐到数据库
      await syncCurrentMusicToDatabase(music, musicData.url)

      // 记录最近播放
      await recordRecentPlay(music, 0, 0)

      console.log('🎵开始播放:', music.song)
    } catch (error: any) {
      console.error('播放音乐失败:', error)

      // 显示用户友好的错误提示
      const { ElMessage } = await import('element-plus')
      if (error.message && error.message.includes('choose超过最大值')) {
        ElMessage.error('音乐服务繁忙，请稍后再试')
      } else if (error.message && error.message.includes('获取播放URL失败')) {
        ElMessage.error('无法获取音乐播放链接，请检查网络连接')
      } else {
        ElMessage.error('播放失败:' + (error.message || '未知错误'))
      }

      // 播放失败时，保持当前状态不变，不要清空currentMusic
      audio.value.src = ''
      isPlaying.value = false
    }
  }

  /** 暂停/继续播放 */
  const togglePlay = async () => {
    if (!audio.value || !currentMusic.value) return

    try {
      // 用户交互触发：若非领导者，先抢占领导权再执行
      if (!isLeader.value) {
        claimLeadership()
      }
      if (isPlaying.value) {
        audio.value.pause()
        isPlaying.value = false
        console.log('⏸️暂停播放')
      } else {
        // 若无音源，自动拉取
        if (!audio.value.src) {
          const musicData = await getMusicPlayUrl(currentMusic.value)
          audio.value.src = musicData.url
        }
        await audio.value.play()
        isPlaying.value = true
        console.log('▶️继续播放')
      }
      
      if (!isLeader.value) {
        // 跟随者发意图
        postIntent('toggle', {})
      } else {
        // 领导者发状态
        postState('toggle', { isPlaying: isPlaying.value, currentTime: currentTime.value })
      }

      // 同步播放状态到数据库
      await syncPlayStatusToDatabase()
    } catch (error) {
      console.error('切换播放状态失败:', error)
    }
  }

  /** 停止播放 */
  const stopMusic = () => {
    if (!audio.value) return

    audio.value.pause()
    audio.value.currentTime = 0
    isPlaying.value = false
  }

  /** 设置播放进度 */
  const setProgress = async (percent: number) => {
    if (!audio.value || !duration.value) return

    const time = (percent / 100) * duration.value
    audio.value.currentTime = time
    currentTime.value = time
    
    if (!isLeader.value) postIntent('seek', { percent })
    else postState('seek', { currentTime: time })

    // 立即同步播放进度到数据库
    await syncPlayProgressToDatabase()
  }


  // ------------------------------ 音量控制方法 ------------------------------
  /** 设置音量 */
  const setVolume = async (newVolume: number) => {
    volume.value = Math.max(0, Math.min(100, newVolume)) // 限制在0-100之间

    if (audio.value) {
      audio.value.volume = volume.value / 100
    }

    // 如果设置音量大于0，取消静音
    if (volume.value > 0 && isMuted.value) {
      isMuted.value = false
    }

    // 同步到数据库
    await syncVolumeToDatabase()
    if (!isLeader.value) postIntent('volume', { volume: volume.value })
    else postState('volume', { volume: volume.value, isMuted: isMuted.value })

    console.log('🔊音量设置为:', volume.value + '%')
  }

  /** 切换静音状态 */
  const toggleMute = async () => {
    if (!audio.value) return

    if (isMuted.value) {
      // 取消静音，恢复之前的音量
      isMuted.value = false
      volume.value = previousVolume.value
      audio.value.volume = volume.value / 100
      console.log('🔊取消静音，音量:', volume.value + '%')
    } else {
      // 静音，保存当前音量
      previousVolume.value = volume.value
      isMuted.value = true
      volume.value = 0
      audio.value.volume = 0
      console.log('🔇静音')
    }

    // 同步到数据库
    await syncMuteStatusToDatabase()
    if (!isLeader.value) postIntent('volume', { toggleMute: true })
    else postState('volume', { volume: volume.value, isMuted: isMuted.value })
  }

  /** 静音 */
  const mute = () => {
    if (!audio.value || isMuted.value) return

    previousVolume.value = volume.value
    isMuted.value = true
    audio.value.volume = 0
    console.log('🔇静音')
  }

  /** 取消静音 */
  const unmute = () => {
    if (!audio.value || !isMuted.value) return

    isMuted.value = false
    volume.value = previousVolume.value
    audio.value.volume = volume.value / 100
    console.log('🔊取消静音，音量:', volume.value + '%')
  }


  // ------------------------------ 播放设置数据库同步方法 ------------------------------
  /** 同步音量到数据库 */
  const syncVolumeToDatabase = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌用户未登录，无法同步音量到数据库')
      return
    }

    try {
      const response = await fetch(
        `/api/user-play-settings/volume/${userStore.currentUser.id}?volume=${volume.value}`,
        { method: 'PUT' }
      )

      const result = await response.json()

      if (response.ok && result.code === 200) {
        console.log('✅音量同步到数据库成功')
      } else {
        console.error('❌音量同步到数据库失败:', result.message)
      }
    } catch (error) {
      console.error('❌音量同步到数据库错误:', error)
    }
  }

  /** 同步静音状态到数据库 */
  const syncMuteStatusToDatabase = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌用户未登录，无法同步静音状态到数据库')
      return
    }

    try {
      const response = await fetch(
        `/api/user-play-settings/mute/${userStore.currentUser.id}?isMuted=${isMuted.value}`,
        { method: 'PUT' }
      )

      const result = await response.json()

      if (response.ok && result.code === 200) {
        console.log('✅静音状态同步到数据库成功')
      } else {
        console.error('❌静音状态同步到数据库失败:', result.message)
      }
    } catch (error) {
      console.error('❌静音状态同步到数据库错误:', error)
    }
  }

  /** 同步播放模式到数据库 */
  const syncPlayModeToDatabase = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌用户未登录，无法同步播放模式到数据库')
      return
    }

    try {
      const response = await fetch(
        `/api/user-play-settings/play-mode/${userStore.currentUser.id}?playMode=${playMode.value}`,
        { method: 'PUT' }
      )

      const result = await response.json()

      if (response.ok && result.code === 200) {
        console.log('✅播放模式同步到数据库成功')
      } else {
        console.error('❌播放模式同步到数据库失败:', result.message)
      }
    } catch (error) {
      console.error('❌播放模式同步到数据库错误:', error)
    }
  }

  /** 同步播放进度到数据库（带防抖） */
  const syncPlayProgressToDatabase = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌用户未登录，无法同步播放进度到数据库')
      return
    }

    // 清除之前的定时器
    if (progressSyncTimer) {
      clearTimeout(progressSyncTimer)
    }

    // 设置新的定时器，200ms后执行同步
    progressSyncTimer = setTimeout(async () => {
      try {
        const url = `/api/user-play-settings/play-progress/${userStore.currentUser?.id}?playProgress=${progress.value}&playTime=${currentTime.value}`

        // 使用fetch with keepalive确保请求能完成
        const response = await fetch(url, {
          method: 'PUT',
          keepalive: true // 确保请求在页面卸载时也能完成
        })

        const result = await response.json()

        if (response.ok && result.code === 200) {
          console.log('✅播放进度同步到数据库成功')

          // 同时更新最近播放的进度
          if (currentMusic.value) {
            await updateRecentPlayProgress(currentMusic.value, currentTime.value, progress.value)
          }
        } else {
          console.error('❌播放进度同步到数据库失败:', result.message)
        }
      } catch (error) {
        console.error('❌播放进度同步到数据库错误:', error)
      }
    }, 200)
  }

  /** 立即同步播放进度到数据库（用于页面卸载时） */
  const syncPlayProgressImmediately = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      return
    }

    try {
      const url = `/api/user-play-settings/play-progress/${userStore.currentUser.id}?playProgress=${progress.value}&playTime=${currentTime.value}`

      // 使用同步请求确保数据能发送出去
      const xhr = new XMLHttpRequest()
      xhr.open('PUT', url, false) // 同步请求
      xhr.setRequestHeader('Content-Type', 'application/json')
      xhr.send()

      if (xhr.status === 200) {
        console.log('✅播放进度立即同步到数据库成功')
      } else {
        console.error('❌播放进度立即同步失败，状态码:', xhr.status)
      }
    } catch (error) {
      console.error('❌播放进度立即同步到数据库错误:', error)
    }
  }

  /** 同步当前播放音乐到数据库 */
  const syncCurrentMusicToDatabase = async (music: Music, musicUrl: string) => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌用户未登录，无法同步当前播放音乐到数据库')
      return
    }

    try {
      const response = await fetch(
        `/api/user-play-settings/current-music/${userStore.currentUser.id}?musicId=${music.id}&musicName=${encodeURIComponent(music.song)}&musicArtist=${encodeURIComponent(music.singer)}&musicCover=${encodeURIComponent(music.cover)}&musicUrl=${encodeURIComponent(musicUrl)}`,
        { method: 'PUT' }
      )

      const result = await response.json()

      if (response.ok && result.code === 200) {
        console.log('✅当前播放音乐同步到数据库成功')
      } else {
        console.error('❌当前播放音乐同步到数据库失败:', result.message)
      }
    } catch (error) {
      console.error('❌当前播放音乐同步到数据库错误:', error)
    }
  }

  /** 同步播放状态到数据库 */
  const syncPlayStatusToDatabase = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌用户未登录，无法同步播放状态到数据库')
      return
    }

    try {
      const response = await fetch(
        `/api/user-play-settings/play-status/${userStore.currentUser.id}?isPlaying=${isPlaying.value}`,
        { method: 'PUT' }
      )

      const result = await response.json()

      if (response.ok && result.code === 200) {
        console.log('✅播放状态同步到数据库成功')
      } else {
        console.error('❌播放状态同步到数据库失败:', result.message)
      }
    } catch (error) {
      console.error('❌播放状态同步到数据库错误:', error)
    }
  }

  /** 从数据库加载播放设置 */
  const loadPlaySettingsFromDatabase = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌用户未登录，无法加载播放设置')
      return
    }

    // 若已恢复过一次，则不再覆盖当前进度/状态，避免从Player返回主页时倒退
    if (hasRestoredFromSettings.value) {
      return
    }

    console.log('🔄开始加载用户播放设置，用户ID:', userStore.currentUser.id)

    try {
      const response = await fetch(`/api/user-play-settings/user/${userStore.currentUser.id}`)
      const result = await response.json()

      console.log('📡播放设置API响应:', result)

      if (result.code === 200 && result.data) {
        const settings = result.data

        // 恢复音量设置
        volume.value = settings.volume || 70
        if (audio.value) {
          audio.value.volume = volume.value / 100
        }

        // 恢复静音状态
        isMuted.value = settings.isMuted || false
        if (isMuted.value && audio.value) {
          audio.value.volume = 0
        }

        // 恢复播放模式
        playMode.value = settings.playMode || 'list'

        // 恢复当前播放音乐和进度
        if (settings.currentMusicId && settings.currentMusicName) {
          const music: Music = {
            id: parseInt(settings.currentMusicId),
            mid: settings.currentMusicId,
            song: settings.currentMusicName,
            singer: settings.currentMusicArtist || '',
            album: '',
            cover: settings.currentMusicCover || '',
            time: '',
            pay: ''
          }

          // 仅在当前没有播放源时恢复，避免覆盖正在播放的进度
          if (!currentMusic.value) {
            currentMusic.value = music
          }

          // 如果有播放URL，设置音频源
          if (settings.currentMusicUrl && audio.value && !audio.value.src) {
            audio.value.src = settings.currentMusicUrl
            audio.value.currentTime = settings.playTime || 0
            currentTime.value = settings.playTime || 0
          }

          // 恢复播放状态
          if (!isPlaying.value) {
            isPlaying.value = settings.isPlaying || false
          }

          // 如果之前是播放状态，尝试继续播放
          if (settings.isPlaying && audio.value && settings.currentMusicUrl && audio.value.src) {
            try {
              await audio.value.play()
              isPlaying.value = true
              console.log('▶️恢复播放状态成功')
            } catch (error) {
              console.log('⚠️恢复播放状态失败，可能需要用户交互:', error)
              isPlaying.value = false
            }
          }

          console.log('✅播放设置加载成功:', {
            volume: volume.value,
            isMuted: isMuted.value,
            playMode: playMode.value,
            currentMusic: music.song,
            playTime: settings.playTime,
            isPlaying: isPlaying.value
          })
        } else {
          console.log('✅播放设置加载成功（无当前音乐）:', {
            volume: volume.value,
            isMuted: isMuted.value,
            playMode: playMode.value
          })
        }
        // 标记已恢复，避免后续页面切换时重复覆盖进度
        hasRestoredFromSettings.value = true
      } else {
        console.log('ℹ️用户没有保存的播放设置，使用默认设置')
      }
    } catch (error) {
      console.error('❌加载播放设置错误:', error)
    }
  }


  // ------------------------------ 播放队列相关方法 ------------------------------
  /** 添加音乐到播放队列 */
  const addToQueue = (music: Music, insertIndex?: number) => {
    // 检查是否已经在队列中
    const existingIndex = playQueue.value.findIndex(item => item.id === music.id)

    if (existingIndex > -1) {
      // 如果已存在，不改变位置，直接返回
      console.log('🎵音乐已在播放队列中，保持原位置:', music.song)
      return
    }

    // 找到当前播放歌曲的位置，插入到其下面
    let finalInsertIndex = insertIndex !== undefined ? insertIndex : playQueue.value.length // 默认插入到队尾

    if (insertIndex === undefined && currentMusic.value) {
      const currentIndex = playQueue.value.findIndex(item => item.id === currentMusic.value?.id)
      if (currentIndex > -1) {
        finalInsertIndex = currentIndex + 1 // 插入到当前播放歌曲的下面
      }
    }

    // 插入歌曲
    playQueue.value.splice(finalInsertIndex, 0, music)
    console.log('🎵添加音乐到播放队列:', music.song)
  }

  /** 从播放队列移除音乐 */
  const removeFromQueue = (musicId: number) => {
    const index = playQueue.value.findIndex(item => item.id === musicId)
    if (index > -1) {
      playQueue.value.splice(index, 1)
      console.log('🗑️从播放队列移除音乐')
    }
  }

  /** 清空播放队列 */
  const clearQueue = () => {
    playQueue.value = []
    console.log('🗑️清空播放队列')
  }

  /** 播放下一首 */
  const playNext = async () => {
    if (!audio.value || playQueue.value.length === 0) return
    if (!isLeader.value) { postIntent('next'); return }

    const currentIndex = playQueue.value.findIndex(item => item.id === currentMusic.value?.id)

    switch (playMode.value) {
      case 'list':
        // 列表循环：播放下一首，到最后一首时回到第一首
        const nextIndex = currentIndex + 1
        if (nextIndex < playQueue.value.length) {
          const nextMusic = playQueue.value[nextIndex]
          console.log('⏭️列表循环-播放下一首:', nextMusic.song)
          await playMusic(nextMusic)
        } else {
          // 播放第一首
          const firstMusic = playQueue.value[0]
          console.log('⏭️列表循环-回到第一首:', firstMusic.song)
          await playMusic(firstMusic)
        }
        break

      case 'single':
        // 单曲循环：重复播放当前歌曲
        if (currentMusic.value) {
          console.log('🔂单曲循环-重复播放:', currentMusic.value.song)
          await playMusic(currentMusic.value)
        }
        break

      case 'random':
        // 随机播放：随机选择一首歌
        const randomIndex = Math.floor(Math.random() * playQueue.value.length)
        const randomMusic = playQueue.value[randomIndex]
        console.log('🔀随机播放-随机选择:', randomMusic.song)
        await playMusic(randomMusic)
        break
    }
  }

  /** 播放上一首 */
  const playPrevious = async () => {
    if (!audio.value || playQueue.value.length === 0) return
    if (!isLeader.value) { postIntent('prev'); return }

    const currentIndex = playQueue.value.findIndex(item => item.id === currentMusic.value?.id)

    switch (playMode.value) {
      case 'list':
        // 列表循环：播放上一首，到第一首时回到最后一首
        const prevIndex = currentIndex - 1
        if (prevIndex >= 0) {
          const prevMusic = playQueue.value[prevIndex]
          console.log('⏮️列表循环-播放上一首:', prevMusic.song)
          await playMusic(prevMusic)
        } else {
          // 播放最后一首
          const lastMusic = playQueue.value[playQueue.value.length - 1]
          console.log('⏮️列表循环-回到最后一首:', lastMusic.song)
          await playMusic(lastMusic)
        }
        break

      case 'single':
        // 单曲循环：重复播放当前歌曲
        if (currentMusic.value) {
          console.log('🔂单曲循环-重复播放:', currentMusic.value.song)
          await playMusic(currentMusic.value)
        }
        break

      case 'random':
        // 随机播放：随机选择一首歌
        const randomIndex = Math.floor(Math.random() * playQueue.value.length)
        const randomMusic = playQueue.value[randomIndex]
        console.log('🔀随机播放-随机选择:', randomMusic.song)
        await playMusic(randomMusic)
        break
    }
  }

  /** 切换播放队列显示状态 */
  const togglePlayQueue = () => {
    showPlayQueue.value = !showPlayQueue.value
  }

  /** 重新排列播放队列 */
  const reorderQueue = async (fromIndex: number, toIndex: number) => {
    const music = playQueue.value.splice(fromIndex, 1)[0]
    playQueue.value.splice(toIndex, 0, music)
    // 同步到数据库
    await syncPlayQueueToDatabase()
  }

  /** 播放队列中的音乐 */
  const playMusicFromQueue = async (music: Music) => {
    // 直接播放音乐
    await playMusic(music)
  }

  /** 移动音乐到当前播放歌曲下面 */
  const moveToCurrentPosition = async (music: Music) => {
    // 检查是否已经在队列中
    const existingIndex = playQueue.value.findIndex(item => item.id === music.id)

    if (existingIndex === -1) {
      // 如果不在队列中，直接添加到当前播放歌曲下面
      await addToPlayQueueWithSync(music)
      return
    }

    // 如果已在队列中，先移除
    await removeFromPlayQueueWithSync(music.id)

    // 找到当前播放歌曲的位置，插入到其下面
    let insertIndex = playQueue.value.length // 默认插入到队尾

    if (currentMusic.value) {
      const currentIndex = playQueue.value.findIndex(item => item.id === currentMusic.value?.id)
      if (currentIndex > -1) {
        insertIndex = currentIndex + 1 // 插入到当前播放歌曲的下面
      }
    }

    // 插入歌曲
    await addToPlayQueueWithSync(music, insertIndex)
    console.log('🔄移动音乐到当前播放歌曲下面:', music.song)
  }


  // ------------------------------ 播放队列数据库同步方法 ------------------------------
  /** 同步播放队列到数据库 */
  const syncPlayQueueToDatabase = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌用户未登录，无法同步播放队列到数据库')
      return
    }

    console.log('🔄开始同步播放队列到数据库，用户ID:', userStore.currentUser.id, '队列长度:', playQueue.value.length)

    try {
      // 清空数据库中的播放队列
      console.log('🗑️清空数据库中的播放队列...')
      const clearResponse = await fetch(
        `/api/user-play-queue/clear/${userStore.currentUser.id}`,
        { method: 'DELETE' }
      )
      console.log('清空响应状态:', clearResponse.status)

      // 批量添加当前播放队列到数据库
      if (playQueue.value.length > 0) {
        console.log('📤同步播放队列到数据库...')
        const response = await fetch(
          `/api/user-play-queue/reorder/${userStore.currentUser.id}`,
          {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ musicIds: playQueue.value.map(m => m.id) })
          }
        )

        const result = await response.json()
        console.log('📡同步播放队列API响应:', result)

        if (response.ok && result.code === 200) {
          console.log('✅播放队列同步成功')
        } else {
          console.error('❌播放队列同步失败:', result.message)
        }
      } else {
        console.log('ℹ️播放队列为空，无需同步')
      }
    } catch (error) {
      console.error('❌同步播放队列错误:', error)
    }
  }

  /** 从数据库加载播放队列 */
  const loadPlayQueueFromDatabase = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌用户未登录，无法加载播放队列')
      return
    }

    console.log('🔄开始加载用户播放队列，用户ID:', userStore.currentUser.id)

    try {
      const response = await fetch(`/api/user-play-queue/user/${userStore.currentUser.id}`)
      const result = await response.json()

      console.log('📡播放队列API响应:', result)

      if (result.code === 200) {
        playQueue.value = result.data
        console.log('✅播放队列加载成功，共', result.data.length, '首音乐')
      } else {
        console.error('❌播放队列加载失败:', result.message)
      }
    } catch (error) {
      console.error('❌播放队列加载错误:', error)
    }
  }

  /** 添加音乐到播放队列（带数据库同步） */
  const addToPlayQueueWithSync = async (music: Music, insertIndex?: number) => {
    // 先添加到本地队列
    addToQueue(music, insertIndex)

    // 同步到数据库
    await syncPlayQueueToDatabase()
  }

  /** 从播放队列移除音乐（带数据库同步） */
  const removeFromPlayQueueWithSync = async (musicId: number) => {
    // 先从本地队列移除
    removeFromQueue(musicId)

    // 同步到数据库
    await syncPlayQueueToDatabase()
  }

  /** 清空播放队列（带数据库同步） */
  const clearPlayQueueWithSync = async () => {
    // 先清空本地队列
    clearQueue()

    // 同步到数据库
    await syncPlayQueueToDatabase()
  }

  /** 重新排序播放队列（带数据库同步） */
  const reorderPlayQueueWithSync = async (fromIndex: number, toIndex: number) => {
    // 先重新排序本地队列
    await reorderQueue(fromIndex, toIndex)
  }


  // ------------------------------ 收藏相关方法 ------------------------------
  /** 检查当前音乐是否已收藏 */
  const checkCurrentMusicFavoriteStatus = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser || !currentMusic.value) {
      isCurrentMusicLiked.value = false
      return
    }

    try {
      const response = await fetch(
        `/api/user-favorites/check?userId=${userStore.currentUser.id}&musicId=${currentMusic.value.id}`
      )
      const result = await response.json()

      if (response.ok && result.code === 200) {
        isCurrentMusicLiked.value = result.data
        console.log('✅检查收藏状态成功:', isCurrentMusicLiked.value)
      } else {
        console.error('❌检查收藏状态失败:', result.message)
        isCurrentMusicLiked.value = false
      }
    } catch (error) {
      console.error('❌检查收藏状态错误:', error)
      isCurrentMusicLiked.value = false
    }
  }

  /** 切换收藏状态 */
  const toggleFavorite = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser || !currentMusic.value) {
      console.log('❌用户未登录或没有当前播放音乐')
      return
    }

    try {
      if (isCurrentMusicLiked.value) {
        // 取消收藏
        const response = await fetch(
          `/api/user-favorites/remove?userId=${userStore.currentUser.id}&musicId=${currentMusic.value.id}`,
          { method: 'DELETE' }
        )
        const result = await response.json()

        if (response.ok && result.code === 200) {
          isCurrentMusicLiked.value = false
          console.log('✅取消收藏成功')

          // 通知所有监听器
          notifyFavoriteStatusListeners(false)

          // 显示提示
          const { ElMessage } = await import('element-plus')
          ElMessage.success('已取消收藏')
        } else {
          console.error('❌取消收藏失败:', result.message)
        }
      } else {
        // 添加收藏
        const response = await fetch(
          `/api/user-favorites/add?userId=${userStore.currentUser.id}&musicId=${currentMusic.value.id}&musicMid=${currentMusic.value.mid}&musicSong=${encodeURIComponent(currentMusic.value.song)}&musicSinger=${encodeURIComponent(currentMusic.value.singer)}&musicAlbum=${encodeURIComponent(currentMusic.value.album || '')}&musicCover=${encodeURIComponent(currentMusic.value.cover || '')}&musicTime=${encodeURIComponent(currentMusic.value.time || '')}&musicPay=${encodeURIComponent(currentMusic.value.pay || '')}`,
          { method: 'POST' }
        )
        const result = await response.json()

        if (response.ok && result.code === 200) {
          isCurrentMusicLiked.value = true
          console.log('✅添加收藏成功')

          // 通知所有监听器
          notifyFavoriteStatusListeners(true)

          // 显示提示
          const { ElMessage } = await import('element-plus')
          ElMessage.success('已添加到我的喜欢')
        } else {
          console.error('❌添加收藏失败:', result.message)
        }
      }
    } catch (error) {
      console.error('❌切换收藏状态错误:', error)
    }
  }

  /** 添加收藏状态监听器 */
  const addFavoriteStatusListener = (listener: (isLiked: boolean) => void) => {
    favoriteStatusListeners.value.push(listener)
  }

  /** 移除收藏状态监听器 */
  const removeFavoriteStatusListener = (listener: (isLiked: boolean) => void) => {
    const index = favoriteStatusListeners.value.indexOf(listener)
    if (index > -1) {
      favoriteStatusListeners.value.splice(index, 1)
    }
  }

  /** 通知所有收藏状态监听器 */
  const notifyFavoriteStatusListeners = (isLiked: boolean) => {
    favoriteStatusListeners.value.forEach(listener => {
      try {
        listener(isLiked)
      } catch (error) {
        console.error('收藏状态监听器执行错误:', error)
      }
    })
  }

  /** 切换到临时播放模式（播放我喜欢的） */
  const switchToTempPlayMode = async (favorites: any[]) => {
    try {
      // 如果已经在临时播放模式，直接返回
      if (isInTempPlayMode.value) {
        console.log('⚠️已经在临时播放模式')
        return
      }

      // 保存当前播放队列到原始队列
      originalPlayQueue.value = [...playQueue.value]
      console.log('💾保存原始播放队列，共', originalPlayQueue.value.length, '首音乐')

      // 清空当前播放队列
      await clearPlayQueueWithSync()

      // 将收藏列表转换为Music格式并添加到播放队列
      const favoritesMusic = favorites.map(fav => ({
        id: parseInt(fav.musicId),
        mid: fav.musicMid,
        song: fav.musicSong,
        singer: fav.musicSinger,
        album: fav.musicAlbum || '',
        cover: fav.musicCover || '',
        time: fav.musicTime || '',
        pay: fav.musicPay || ''
      }))

      // 批量添加到播放队列（不保存到数据库）
      for (const music of favoritesMusic) {
        playQueue.value.push(music)
      }

      // 设置临时播放模式
      isInTempPlayMode.value = true

      console.log('✅已切换到临时播放模式，播放我喜欢的音乐，共', favoritesMusic.length, '首')
    } catch (error) {
      console.error('❌切换到临时播放模式失败:', error)
      throw error
    }
  }

  /** 恢复原始播放队列 */
  const restoreOriginalPlayQueue = async () => {
    try {
      // 如果不在临时播放模式，直接返回
      if (!isInTempPlayMode.value) {
        console.log('⚠️不在临时播放模式，无需恢复')
        return
      }

      // 清空当前播放队列
      await clearPlayQueueWithSync()

      // 恢复原始播放队列
      for (const music of originalPlayQueue.value) {
        await addToPlayQueueWithSync(music)
      }

      // 清空临时状态
      isInTempPlayMode.value = false
      originalPlayQueue.value = []

      console.log('✅已恢复原始播放队列，共', originalPlayQueue.value.length, '首音乐')
    } catch (error) {
      console.error('❌恢复原始播放队列失败:', error)
      throw error
    }
  }


  // ------------------------------ 搜索建议相关方法 ------------------------------
  /** 获取搜索建议 */
  const getSearchSuggestions = async (word: string) => {
    if (!word.trim()) {
      searchSuggestions.value = null
      return null
    }

    try {
      const apiUrl = '/api/music/suggestions'
      const params = { word: word.trim() }

      console.log('🔍获取搜索建议:', apiUrl, params)

      const response = await axios.get(apiUrl, { params })

      if (response.data.code === 200 && response.data.data) {
        searchSuggestions.value = response.data.data
        console.log('✅搜索建议获取成功')
        return response.data.data
      } else {
        console.warn('搜索建议API响应错误:', response.data)
        searchSuggestions.value = null
        return null
      }
    } catch (error) {
      console.error('获取搜索建议失败:', error)
      searchSuggestions.value = null
      return null
    }
  }

  /** 添加搜索历史 */
  const addSearchHistory = (keyword: string) => {
    if (!keyword.trim()) return

    const trimmedKeyword = keyword.trim()
    // 移除已存在的相同关键词
    const index = searchHistory.value.indexOf(trimmedKeyword)
    if (index > -1) {
      searchHistory.value.splice(index, 1)
    }
    // 添加到开头
    searchHistory.value.unshift(trimmedKeyword)
    // 限制历史记录数量
    if (searchHistory.value.length > 10) {
      searchHistory.value = searchHistory.value.slice(0, 10)
    }

    // 保存到localStorage
    localStorage.setItem('searchHistory', JSON.stringify(searchHistory.value))
  }

  /** 加载搜索历史 */
  const loadSearchHistory = () => {
    try {
      const saved = localStorage.getItem('searchHistory')
      if (saved) {
        searchHistory.value = JSON.parse(saved)
      }
    } catch (error) {
      console.error('加载搜索历史失败:', error)
      searchHistory.value = []
    }
  }

  /** 清除搜索历史 */
  const clearSearchHistory = () => {
    searchHistory.value = []
    localStorage.removeItem('searchHistory')
  }


  // ------------------------------ 歌词相关方法 ------------------------------
  /** 获取歌词 */
  const getLyrics = async (music: Music) => {
    if (!music.id && !music.mid) {
      console.warn('无法获取歌词：缺少歌曲ID或MID')
      return null
    }

    try {
      const apiUrl = '/api/music/lyrics'
      // 优先使用id参数，因为id是数字类型，mid是字符串类型
      const params = music.id ? { id: music.id } : { mid: music.mid }
      const cacheKey = music.id ? `id:${music.id}` : `mid:${music.mid}`

      // 命中缓存则直接返回
      if (lyricsCache.has(cacheKey)) {
        const cached = lyricsCache.get(cacheKey) || null
        currentLyrics.value = cached
        lastLyricsKey.value = cacheKey
        console.log('🗂️使用歌词缓存:', cacheKey)
        return cached
      }

      console.log('🎵获取歌词:', apiUrl, params)

      const response = await axios.get(apiUrl, { params })

      if (response.data.code === 200 && response.data.data) {
        currentLyrics.value = response.data.data
        lyricsCache.set(cacheKey, response.data.data)
        lastLyricsKey.value = cacheKey
        console.log('✅歌词获取成功')
        return response.data.data
      } else {
        // 如果是"未搜索到相关歌词"的错误，这是正常情况，不需要警告
        if (response.data.message && response.data.message.includes('未搜索到相关歌词')) {
          console.log('ℹ️该歌曲暂无歌词数据')
        } else {
          console.warn('歌词API响应错误:', response.data)
        }
        lyricsCache.set(cacheKey, null)
        lastLyricsKey.value = cacheKey
        return null
      }
    } catch (error) {
      console.error('获取歌词失败:', error)
      const cacheKey = music.id ? `id:${music.id}` : `mid:${music.mid}`
      // 失败也短期缓存null，避免瞬时重复打点
      lyricsCache.set(cacheKey, null)
      lastLyricsKey.value = cacheKey
      return null
    }
  }

  /** 解析LRC歌词 */
  const parseLrc = (lrc: string) => {
    if (!lrc) return []

    const lines = lrc.split(/\r?\n/)
    const parsed: Array<{ time: number; text: string }> = []
    const timeTag = /\[(\d{2}):(\d{2})(?:\.(\d{2,3}))?\]/

    for (const line of lines) {
      const match = line.match(timeTag)
      if (match) {
        const mm = Number(match[1])
        const ss = Number(match[2])
        const ms = match[3] ? Number(match[3].padEnd(3, '0')) : 0
        const t = mm * 60 + ss + ms / 1000
        const text = line.replace(timeTag, '').trim()
        if (text) {
          parsed.push({ time: t, text })
        }
      }
    }

    parsed.sort((a, b) => a.time - b.time)
    return parsed
  }

  /** 解析逐字歌词（YRC） */
  const parseYrc = (yrc: string) => {
    if (!yrc) return []

    const lines = yrc.split(/\r?\n/)
    const parsed: Array<{
      time: number
      duration: number
      text: string
      words: Array<{ time: number; duration: number; text: string }>
    }> = []

    for (const line of lines) {
      // 匹配时间标签[start,duration]text
      const timeMatch = line.match(/^\[(\d+),(\d+)\](.*)$/)
      if (timeMatch) {
        const startTime = Number(timeMatch[1])
        const duration = Number(timeMatch[2])
        const text = timeMatch[3]

        // 解析逐字时间
        const words: Array<{ time: number; duration: number; text: string }> = []
        const wordRegex = /(\S+)\((\d+),(\d+)\)/g
        let wordMatch

        while ((wordMatch = wordRegex.exec(text)) !== null) {
          words.push({
            time: Number(wordMatch[2]),
            duration: Number(wordMatch[3]),
            text: wordMatch[1]
          })
        }

        parsed.push({
          time: startTime,
          duration: duration,
          text: text.replace(/\(\d+,\d+\)/g, ''), // 移除时间标记，保留纯文本
          words: words
        })
      }
    }

    parsed.sort((a, b) => a.time - b.time)
    return parsed
  }


  // ------------------------------ 播放模式相关方法 ------------------------------
  /** 切换播放模式 */
  const togglePlayMode = async () => {
    const modes = ['list', 'single', 'random']
    const currentIndex = modes.indexOf(playMode.value)
    const nextIndex = (currentIndex + 1) % modes.length
    const newMode = modes[nextIndex]

    playMode.value = newMode

    // 同步到数据库
    await syncPlayModeToDatabase()

    // 显示切换提示
    const { ElMessage } = await import('element-plus')
    ElMessage.success(`已切换到${playModeName.value}模式`)

    console.log('🔄播放模式切换为:', playModeName.value)
  }

  /** 设置播放模式 */
  const setPlayMode = async (mode: 'list' | 'single' | 'random') => {
    if (playMode.value === mode) return

    playMode.value = mode

    // 同步到数据库
    await syncPlayModeToDatabase()

    // 显示切换提示
    const { ElMessage } = await import('element-plus')
    ElMessage.success(`已切换到${playModeName.value}模式`)

    console.log('🔄播放模式设置为:', playModeName.value)
  }


  return {
    // 状态
    currentMusic,
    musicList,
    isPlaying,
    isLoading,
    searchKeyword,
    audio,
    currentTime,
    duration,

    // 无限滚动状态
    currentPage,
    hasMoreData,
    isLoadingMore,

    // 播放队列状态
    playQueue,
    showPlayQueue,

    // 音量控制状态
    volume,
    isMuted,

    // 播放模式状态
    playMode,
    playModeIcon,
    playModeName,

    // 收藏状态
    isCurrentMusicLiked,
    isInTempPlayMode,

    // 搜索建议状态
    searchSuggestions,
    searchHistory,

    // 计算属性
    hasCurrentMusic,
    progress,
    queueCount,

    // 方法
    initAudio,
    searchMusic,
    loadMoreMusic,
    getMusicPlayUrl,
    playMusic,
    togglePlay,
    stopMusic,
    setProgress,

    // 音量控制方法
    setVolume,
    toggleMute,
    mute,
    unmute,

    // 播放模式方法
    togglePlayMode,
    setPlayMode,

    // 播放设置数据库同步方法
    syncVolumeToDatabase,
    syncMuteStatusToDatabase,
    syncPlayModeToDatabase,
    syncPlayProgressToDatabase,
    syncPlayProgressImmediately,
    syncCurrentMusicToDatabase,
    syncPlayStatusToDatabase,
    loadPlaySettingsFromDatabase,

    // 播放队列方法
    addToQueue,
    removeFromQueue,
    clearQueue,
    playNext,
    playPrevious,
    togglePlayQueue,
    reorderQueue,
    playMusicFromQueue,
    moveToCurrentPosition,

    // 播放队列数据库同步方法
    syncPlayQueueToDatabase,
    loadPlayQueueFromDatabase,
    addToPlayQueueWithSync,
    removeFromPlayQueueWithSync,
    clearPlayQueueWithSync,
    reorderPlayQueueWithSync,

    // 收藏方法
    checkCurrentMusicFavoriteStatus,
    toggleFavorite,
    addFavoriteStatusListener,
    removeFavoriteStatusListener,
    switchToTempPlayMode,
    restoreOriginalPlayQueue,

    // 下载方法
    downloadMusic,

    // 最近播放方法
    recordRecentPlay,
    updateRecentPlayProgress,
    addRecentPlayListener,
    removeRecentPlayListener,

    // 搜索建议相关方法
    getSearchSuggestions,
    addSearchHistory,
    loadSearchHistory,
    clearSearchHistory,

    // 歌词相关
    currentLyrics,
    getLyrics,
    parseLrc,
    parseYrc
  }
})
