<template>
    <div class="player-shell">
      <!-- 播放器主内容区 -->
      <div v-if="current" class="player-page">
        <!-- 左侧：唱片、控制区 -->
        <div class="left">
          <!-- 唱片封面 -->
          <div class="disc-wrap">
            <div 
              class="disc spinning" 
              :class="{ paused: !isPlaying }" 
              @click="() => handleTap(handleDiscDoubleTap)"
            >
              <img :src="current.cover" alt="cover" />
              <div class="center-hole"></div>
            </div>
            <div class="tips">点击封面{{ isPlaying ? '暂停' : '播放' }}</div>
          </div>
  
          <!-- 歌名/歌手信息 -->
          <div class="under-meta">
            <h2 class="under-title">{{ current.song }}</h2>
            <div class="under-artist">{{ current.singer }}</div>
          </div>
  
          <!-- 进度条 -->
          <div class="under-progress">
            <span class="time">{{ formatTime(currentTime) }}</span>
            <el-slider 
              :model-value="progress" 
              @input="setProgress" 
              :show-tooltip="false" 
            />
            <span class="time">{{ formatTime(duration) }}</span>
          </div>
  
          <!-- 控制按钮行：队列|上一首|播放/暂停|下一首|模式 -->
          <div class="controls-line">
            <el-button 
              type="text" 
              class="ctl" 
              @click="musicStore.togglePlayQueue"
            >
              📋
            </el-button>
            <el-button 
              type="text" 
              class="ctl" 
              @click="playPrevious"
            >
              ⏮️
            </el-button>
            <el-button 
              type="primary" 
              circle 
              class="play" 
              @click="togglePlay"
            >
              {{ isPlaying ? '⏸️' : '▶️' }}
            </el-button>
            <el-button 
              type="text" 
              class="ctl" 
              @click="playNext"
            >
              ⏭️
            </el-button>
            <el-button 
              type="text" 
              class="ctl" 
              @click="musicStore.togglePlayMode"
            >
              {{ musicStore.playModeIcon }}
            </el-button>
          </div>
  
          <!-- 音量控制行 -->
          <div class="volume-line">
            <el-button 
              type="text" 
              class="ctl" 
              @click="musicStore.toggleMute"
            >
              {{ musicStore.isMuted ? '🔇' : '🔊' }}
            </el-button>
            <el-slider 
              class="volume-slider" 
              :model-value="musicStore.volume" 
              @input="musicStore.setVolume" 
              :show-tooltip="false" 
            />
          </div>
        </div>
  
        <!-- 右侧：歌词区 -->
        <div class="right">
          <!-- 歌曲信息与歌词控制 -->
          <div class="meta">
            <h1 class="title">{{ current.song }}</h1>
            <p class="artist">{{ current.singer }}</p>
            <div class="lyrics-controls">
              <el-button
                type="text"
                size="small"
                @click="showTranslation = !showTranslation"
                :class="{ active: showTranslation }"
              >
                {{ showTranslation ? '🌐隐藏翻译' : '🌐显示翻译' }}
              </el-button>
            </div>
          </div>
  
          <!-- 歌词显示区 -->
          <div class="lyrics" :class="{ empty: !lyricsLines.length }">
            <!-- 有歌词时显示歌词列表 -->
            <div v-if="lyricsLines.length">
              <div 
                v-for="(line, idx) in lyricsLines" 
                :key="idx" 
                :class="['line', { active: idx === activeLineIndex }]"
              >
                <div class="lyric-text">{{ line.text }}</div>
                <div 
                  v-if="showTranslation && line.translation" 
                  class="lyric-translation"
                >
                  {{ line.translation }}
                </div>
              </div>
            </div>
            
            <!-- 无歌词/加载中状态 -->
            <div v-else>
              <div v-if="isLoadingLyrics" class="loading">
                <div class="loading-spinner">⏳</div>
                <div class="loading-text">正在加载歌词...</div>
              </div>
              <div v-else class="no-lyrics">
                <div class="no-lyrics-icon">🎵</div>
                <div class="no-lyrics-text">该歌曲暂无歌词</div>
                <div class="no-lyrics-tip">请尝试播放其他歌曲</div>
              </div>
            </div>
          </div>
        </div>

        <!-- 移动端专用布局 -->
        <div class="mobile-layout">
          <!-- 封面 -->
          <div class="mobile-cover">
            <div 
              class="disc spinning" 
              :class="{ paused: !isPlaying }" 
              @click="() => handleTap(handleDiscDoubleTap)"
            >
              <img :src="current.cover" alt="cover" />
              <div class="center-hole"></div>
            </div>
          </div>

          <!-- 当前歌词（一句） -->
          <div class="mobile-current-lyric">
            <div v-if="isLoadingLyrics" class="loading">
              <div class="loading-spinner">⏳</div>
              <div>正在加载歌词...</div>
            </div>
            <div v-else-if="lyricsLines.length === 0" class="empty">
              <div class="empty-icon">🎵</div>
              <div>暂无歌词</div>
            </div>
            <div v-else-if="activeLineIndex >= 0 && lyricsLines[activeLineIndex]">
              <div class="current-lyric-text">
                {{ showTranslation && lyricsLines[activeLineIndex].translation 
                   ? lyricsLines[activeLineIndex].translation 
                   : lyricsLines[activeLineIndex].text }}
              </div>
            </div>
            <div v-else class="no-lyric">
              暂无当前歌词
            </div>
          </div>

          <!-- 歌名 -->
          <div class="mobile-song-title">
            {{ current.song }}
          </div>

          <!-- 歌手名 -->
          <div class="mobile-artist">
            {{ current.singer }}
          </div>

          <!-- 进度条 -->
          <div class="mobile-progress">
            <span class="time">{{ formatTime(currentTime) }}</span>
            <el-slider 
              :model-value="progress" 
              @input="setProgress" 
              :show-tooltip="false" 
            />
            <span class="time">{{ formatTime(duration) }}</span>
          </div>

          <!-- 播放控制 -->
          <div class="mobile-controls">
            <el-button 
              type="text" 
              class="control-btn" 
              @click="playPrevious"
            >
              ⏮️
            </el-button>
            <el-button 
              type="primary" 
              class="play-btn" 
              @click="togglePlay"
              circle
            >
              {{ isPlaying ? '⏸️' : '▶️' }}
            </el-button>
            <el-button 
              type="text" 
              class="control-btn" 
              @click="playNext"
            >
              ⏭️
            </el-button>
          </div>

          <!-- 额外控制 -->
          <div class="mobile-extra-controls">
            <el-button 
              type="text" 
              class="extra-btn" 
              @click="musicStore.togglePlayQueue"
            >
              📋
            </el-button>
            <el-button 
              type="text" 
              class="extra-btn" 
              @click="musicStore.togglePlayMode"
            >
              {{ musicStore.playModeIcon }}
            </el-button>
            <el-button 
              type="text" 
              class="extra-btn" 
              @click="showTranslation = !showTranslation"
            >
              {{ showTranslation ? '🌐隐藏翻译' : '🌐显示翻译' }}
            </el-button>
          </div>
        </div>
      </div>
  
      <!-- 无播放内容提示 -->
      <div v-else class="empty">暂无正在播放的音乐</div>
  
      <!-- 播放页面播放队列面板 -->
      <transition name="queue-panel">
        <div v-if="musicStore.showPlayQueue" class="play-queue-panel desktop-only">
          <!-- 队列头部 -->
          <div class="queue-header">
            <h3>播放队列({{ musicStore.queueCount }})</h3>
            <div class="queue-actions">
              <el-button 
                type="text" 
                @click="musicStore.clearPlayQueueWithSync" 
                size="small"
              >
                清空队列
              </el-button>
              <el-button 
                type="text" 
                @click="musicStore.togglePlayQueue" 
                size="small"
              >
                ✕
              </el-button>
            </div>
          </div>
  
          <!-- 队列列表 -->
          <div class="queue-list">
            <div
              v-for="(music, index) in musicStore.playQueue"
              :key="music.id"
              class="queue-item"
              :class="{ current: musicStore.currentMusic?.id === music.id }"
            >
              <div class="queue-number">{{ index + 1 }}</div>
              <img :src="music.cover" :alt="music.song" class="queue-cover" />
              <div class="queue-info">
                <div class="queue-title">{{ music.song }}</div>
                <div class="queue-artist">{{ music.singer }}</div>
              </div>
              <div class="queue-actions">
                <el-button
                  type="text"
                  @click="musicStore.playMusic(music)"
                  size="small"
                  class="play-btn"
                >
                  {{ musicStore.currentMusic?.id === music.id && musicStore.isPlaying ? '⏸️' : '▶️' }}
                </el-button>
                <el-button
                  type="text"
                  @click="musicStore.removeFromPlayQueueWithSync(music.id)"
                  size="small"
                  class="remove-btn"
                >
                  🗑️
                </el-button>
              </div>
            </div>
  
            <!-- 空队列提示 -->
            <div v-if="musicStore.queueCount === 0" class="empty-queue">
              <p>播放队列为空</p>
            </div>
          </div>
        </div>
      </transition>
    </div>
  </template>
  
  <script setup lang="ts">
  import { computed, ref, watch, onMounted, onUnmounted } from 'vue'
  import { useMusicStore } from '../stores/music'
  import { useUserStore } from '../stores/user'
  import { useMobileGestures, useDoubleTap } from '../composables/useMobileGestures'
  
  // 状态管理实例
  const musicStore = useMusicStore()
  const userStore = useUserStore()
  
  // 移动端手势支持
  const { addGestureListeners, removeGestureListeners } = useMobileGestures()
  const { handleTap } = useDoubleTap()
  
  // 计算属性：从store获取核心状态
  const current = computed(() => musicStore.currentMusic)
  const isPlaying = computed(() => musicStore.isPlaying)
  const progress = computed(() => musicStore.progress)
  const currentTime = computed(() => musicStore.currentTime)
  const duration = computed(() => musicStore.duration)
  
  // 清理 Element Plus 悬浮容器，避免留下空的 el-popper-container
  const removeEpPopperContainers = () => {
    const nodes = document.querySelectorAll('[id^="el-popper-container"]')
    nodes.forEach(node => node.parentElement?.removeChild(node))
  }

  // 使用 MutationObserver 实时监控和清理弹层容器
  let observer: MutationObserver | null = null
  const startPopperCleanup = () => {
    observer = new MutationObserver((mutations) => {
      mutations.forEach((mutation) => {
        if (mutation.type === 'childList') {
          mutation.addedNodes.forEach((node) => {
            if (node.nodeType === Node.ELEMENT_NODE) {
              const element = node as Element
              if (element.id && element.id.startsWith('el-popper-container')) {
                // 延迟清理，确保 Element Plus 完成渲染
                setTimeout(() => {
                  if (element.parentElement && element.children.length === 0) {
                    element.parentElement.removeChild(element)
                  }
                }, 100)
              }
            }
          })
        }
      })
    })
    
    observer.observe(document.body, {
      childList: true,
      subtree: true
    })
  }

  const stopPopperCleanup = () => {
    if (observer) {
      observer.disconnect()
      observer = null
    }
  }

  // 歌词相关状态
  const lyricsLines = ref<Array<{ 
    time: number; 
    text: string; 
    translation?: string 
  }>>([])
  const activeLineIndex = ref<number>(-1)
  const isLoadingLyrics = ref(false)
  const showTranslation = ref(true) // 是否显示歌词翻译
  const lastLoadedMusicId = ref<string | number | null>(null) // 避免重复加载歌词
  
  /**
   * 切换播放/暂停状态
   */
  const togglePlay = async () => {
    const m = current.value as any
    if (!m) return
  
    try {
      const audioSrc = (musicStore as any).audio?.src as string | undefined
      // 无音频源时，重新拉取并播放
      if (!audioSrc) {
        await musicStore.playMusic(m)
        return
      }
  
      // 有音频源时，先尝试切换播放状态
      try {
        await musicStore.togglePlay()
      } catch {
        // 切换失败时，回退到重新拉取
        await musicStore.playMusic(m)
      }
    } catch (e) {
      // 静默处理错误（store内部已做错误处理）
    }
  }
  
  /**
   * 播放上一首
   */
  const playPrevious = () => {
    musicStore.playPrevious()
  }
  
  /**
   * 播放下一首
   */
  const playNext = () => {
    musicStore.playNext()
  }
  
  /**
   * 设置播放进度
   * @param v 进度值（0-100）
   */
  const setProgress = async (v: number) => {
    await musicStore.setProgress(v)
  }
  
  /**
   * 加载歌曲歌词
   * @param music 当前播放歌曲信息
   */
  const loadLyrics = async (music: any) => {
    if (!music) return

    // 避免重复加载同一歌曲的歌词
    const currentMusicId = music.id || music.mid
    if (lastLoadedMusicId.value === currentMusicId && lyricsLines.value.length > 0) {
      console.log('🎵歌词已缓存，跳过加载:', music.song)
      return
    }

    console.log('🎵开始加载歌词:', music.song, music.id, music.mid)
    isLoadingLyrics.value = true
    // 先清空歌词，但保持容器高度稳定
    lyricsLines.value = []
    activeLineIndex.value = -1
  
    try {
      // 从store获取歌词数据
      const lyricsData = await musicStore.getLyrics(music)
      if (lyricsData) {
        console.log('📝歌词数据:', lyricsData)
        
        // 解析主歌词和翻译歌词
        const mainLyrics = musicStore.parseLrc(lyricsData.lrc)
        const transLyrics = musicStore.parseLrc(lyricsData.trans)
        console.log('📝主歌词解析结果:', mainLyrics.length, '行')
        console.log('🌐翻译歌词解析结果:', transLyrics.length, '行')
  
        // 合并主歌词与翻译（时间差<0.5秒视为匹配）
        const combinedLyrics = mainLyrics.map(line => {
          const translation = transLyrics.find(trans => 
            Math.abs(trans.time - line.time) < 0.5
          )
          return {
            time: line.time,
            text: line.text,
            translation: translation?.text
          }
        })
  
        lyricsLines.value = combinedLyrics
        lastLoadedMusicId.value = currentMusicId
        console.log('✅歌词加载完成，共', combinedLyrics.length, '行')
      } else {
        console.log('ℹ️该歌曲暂无歌词数据')
        lastLoadedMusicId.value = currentMusicId
      }
    } catch (error) {
      console.error('加载歌词失败:', error)
      lastLoadedMusicId.value = currentMusicId
    } finally {
      isLoadingLyrics.value = false
    }
  }
  
  /**
   * 监听当前歌曲变化，加载对应歌词
   */
  watch(current, async (m) => {
    if (m) {
      await loadLyrics(m)
    }
  }, { immediate: true })
  
  /**
   * 监听播放时间，高亮当前歌词并自动滚动
   */
  watch(currentTime, (t) => {
    if (lyricsLines.value.length === 0) return
  
    // 找到当前播放时间对应的歌词索引
    const idx = lyricsLines.value.findIndex((line, i) => 
      t >= line.time && (
        i === lyricsLines.value.length - 1 || 
        t < lyricsLines.value[i + 1].time
      )
    )
    activeLineIndex.value = idx
  
    // 自动滚动到当前歌词（居中显示）
    if (idx >= 0) {
      const lyricsContainer = document.querySelector('.lyrics')
      const activeLine = lyricsContainer?.querySelector('.line.active')
      if (activeLine) {
        activeLine.scrollIntoView({
          behavior: 'smooth',
          block: 'center'
        })
      }
    }
  })
  
  /**
   * 格式化时间（秒 → 分:秒）
   * @param seconds 总秒数
   * @returns 格式化后的时间字符串（如 03:45）
   */
  const formatTime = (seconds: number) => {
    const mins = Math.floor(seconds / 60)
    const secs = Math.floor(seconds % 60)
    return `${mins.toString().padStart(2, '0')}:${secs.toString().padStart(2, '0')}`
  }
  
  /**
   * 处理滑动手势
   */
  const handleSwipe = (event: CustomEvent) => {
    const { direction, distance, velocity } = event.detail
    
    if (direction === 'left') {
      // 左滑 - 下一首
      playNext()
    } else if (direction === 'right') {
      // 右滑 - 上一首
      playPrevious()
    } else if (direction === 'up') {
      // 上滑 - 显示播放队列
      musicStore.togglePlayQueue()
    }
  }
  
  /**
   * 处理双击手势
   */
  const handleDiscDoubleTap = () => {
    togglePlay()
  }
  
  /**
   * 组件挂载时初始化
   */
  onMounted(async () => {
    // 移除残留的 Element Plus 弹层容器
    removeEpPopperContainers()
    
    // 启动实时监控清理
    startPopperCleanup()

    // 初始化音频实例（避免重复初始化）
    if (!(musicStore as any).audio) {
      musicStore.initAudio()
    }
    // 初始化用户信息（若未登录）
    if (!userStore.currentUser) {
      await userStore.initUserInfo?.()
    }
    
    // 添加手势监听
    const playerElement = document.querySelector('.player-page')
    if (playerElement) {
      addGestureListeners(playerElement as HTMLElement)
      playerElement.addEventListener('swipe', handleSwipe as EventListener)
    }
  })
  
  /**
   * 组件卸载时清理
   */
  onUnmounted(() => {
    const playerElement = document.querySelector('.player-page')
    if (playerElement) {
      removeGestureListeners(playerElement as HTMLElement)
      playerElement.removeEventListener('swipe', handleSwipe as EventListener)
    }
    
    // 停止监控清理
    stopPopperCleanup()
    
    // 页面离开时也清理一次
    removeEpPopperContainers()
  })
  </script>
  
  <style scoped>
  /* 播放器外层容器 */
.player-shell {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
    background: radial-gradient(
      1200px 600px at 20% 10%, 
      #7c83ff 0%, 
      #6c5ce7 25%, 
      #6f42c1 55%, 
      #51327a 100%
    );
  padding: 16px 0 0;
  }
  
  /* 播放器主内容区（左右布局） */
  .player-page {
    max-width: 1280px;
    margin: 0 auto;
    padding: 40px 24px ;
    display: grid;
    grid-template-columns: 560px minmax(640px, 1fr);
    gap: 28px;
  }
  
  /* 移动端垂直布局 */
  @media (max-width: 768px) {
  /* 移动端使用动态视口高度，避免地址栏伸缩引起的底部空白 */
  .player-shell {
    min-height: 100dvh;
    height: 100dvh;
    overflow: hidden;
    padding-bottom: 0;
  }
  .player-shell {
    min-height: auto;
    padding-bottom: 0;
  }
    .player-page {
      padding: 32px 16px 8px;
      display: flex;
      flex-direction: column;
      gap: 12px;
      flex: 1;
    }

  /* 避免最后一块产生额外间距 */
  .mobile-extra-controls {
    margin-bottom: 0;
  }

    /* 隐藏桌面端布局 - 使用更高优先级 */
    .player-page .left,
    .player-page .right {
      display: none !important;
    }

    /* 显示移动端布局 */
    .player-page .mobile-layout {
      display: flex !important;
      flex-direction: column;
      align-items: center;
      gap: 12px;
      padding: 12px 0 0;
    }
  }

  /* 桌面端隐藏移动端布局 */
  @media (min-width: 769px) {
    .player-page .mobile-layout {
      display: none !important;
    }

    /* 确保桌面端布局显示 */
    .player-page .left,
    .player-page .right {
      display: flex !important;
    }
  }

  /* 移动端布局样式 */
  .mobile-cover {
    display: flex;
    justify-content: center;
    margin-bottom: 8px;
  }

  .mobile-cover .disc {
    width: 200px;
    height: 200px;
  }

  .mobile-current-lyric {
    text-align: center;
    margin-bottom: 12px;
    min-height: 44px;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .current-lyric-text {
    font-size: 18px;
    font-weight: 500;
    color: #fff;
    line-height: 1.5;
    padding: 0 12px;
    text-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);
  }

  .mobile-song-title {
    font-size: 24px;
    font-weight: 700;
    color: #fff;
    text-align: center;
    margin-bottom: 4px;
    line-height: 1.3;
    text-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);
  }

  .mobile-artist {
    font-size: 16px;
    color: #e5e7eb;
    text-align: center;
    margin-bottom: 12px;
    text-shadow: 0 1px 2px rgba(0, 0, 0, 0.3);
  }

  .mobile-progress {
    width: 100%;
    max-width: 280px;
    display: flex;
    align-items: center;
    gap: 8px;
    margin-bottom: 12px;
  }

  .mobile-progress .time {
    font-size: 12px;
    color: #e5e7eb;
    min-width: 36px;
    text-align: center;
    text-shadow: 0 1px 2px rgba(0, 0, 0, 0.3);
  }

  .mobile-controls {
    display: flex;
    align-items: center;
    gap: 12px;
    margin-bottom: 12px;
  }

  .mobile-controls .control-btn {
    font-size: 22px;
    padding: 6px;
    color: #fff;
    background-color: rgba(255, 255, 255, 0.1);
    border-radius: 8px;
    transition: all 0.3s ease;
  }

  .mobile-controls .control-btn:hover {
    background-color: rgba(255, 255, 255, 0.2);
    transform: scale(1.05);
  }

  .mobile-controls .play-btn {
    width: 52px;
    height: 52px;
    font-size: 18px;
    background: linear-gradient(45deg, #667eea, #764ba2);
    border: none;
  }

  .mobile-extra-controls {
    display: flex;
    gap: 12px;
    justify-content: center;
  }

  .mobile-extra-controls .extra-btn {
    font-size: 16px;
    padding: 8px 12px;
    color: #fff;
    background-color: rgba(255, 255, 255, 0.1);
    border-radius: 6px;
    transition: all 0.3s ease;
  }

  .mobile-extra-controls .extra-btn:hover {
    background-color: rgba(255, 255, 255, 0.2);
    transform: scale(1.05);
  }

  /* 移动端当前歌词样式优化 */
  @media (max-width: 768px) {
    .mobile-current-lyric .loading,
    .mobile-current-lyric .empty {
      color: #e5e7eb;
      font-size: 14px;
      text-shadow: 0 1px 2px rgba(0, 0, 0, 0.3);
    }

    .mobile-current-lyric .no-lyric {
      color: #d1d5db;
      font-size: 14px;
      text-shadow: 0 1px 2px rgba(0, 0, 0, 0.3);
    }

    .current-lyric-text {
      font-size: 16px;
      padding: 0 16px;
    }

    .mobile-song-title {
      font-size: 20px;
    }

    .mobile-artist {
      font-size: 14px;
    }
  }
  
  /* 左侧区域：唱片、控制按钮 */
  .left {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 12px;
  }
  
  /* 唱片容器 */
  .disc-wrap {
    display: grid;
    place-items: center;
  }
  
  /* 唱片样式 */
  .disc {
    width: 440px;
    height: 440px;
    border-radius: 50%;
    background: radial-gradient(
      #2b2f36 0%, 
      #151922 60%, 
      #0f1220 100%
    );
    position: relative;
    box-shadow: 0 24px 48px rgba(0, 0, 0, 0.35);
    display: grid;
    place-items: center;
    overflow: hidden;
  }
  
  /* 移动端唱片尺寸调整 */
  @media (max-width: 768px) {
    .disc {
      width: 280px;
      height: 280px;
      margin: 0 auto;
    }
  }
  
  @media (max-width: 480px) {
    .disc {
      width: 240px;
      height: 240px;
    }
  }
  
  /* 唱片封面 */
  .disc img {
    width: 88%;
    height: 88%;
    border-radius: 50%;
    object-fit: cover;
    filter: contrast(1.05) brightness(0.98);
  }
  
  /* 唱片中心圆孔 */
  .center-hole {
    position: absolute;
    width: 18px;
    height: 18px;
    background: #c7cad1;
    border-radius: 50%;
    box-shadow: inset 0 0 0 4px #2d3140;
  }
  
  /* 唱片旋转动画 */
  .spinning {
    animation: spin 14s linear infinite;
    animation-play-state: running;
  }
  
  /* 暂停时停止旋转 */
  .paused {
    animation-play-state: paused;
  }
  
  /* 旋转动画定义 */
  @keyframes spin {
    from { transform: rotate(0deg); }
    to { transform: rotate(360deg); }
  }
  
  /* 唱片下方提示文字 */
  .tips {
    margin-top: 10px;
    color: rgba(255, 255, 255, 0.75);
    font-size: 12px;
  }
  
  /* 歌曲信息（歌名/歌手） */
  .under-meta {
    margin-top: 14px;
    text-align: center;
  }
  
  .under-title {
    margin: 0;
    color: #fff;
    font-size: 22px;
    font-weight: 800;
  }
  
  .under-artist {
    margin-top: 6px;
    color: #e5e7eb;
    font-size: 13px;
  }
  
  /* 进度条区域 */
  .under-progress {
    margin-top: 12px;
    width: 100%;
    display: grid;
    grid-template-columns: 54px 1fr 54px;
    gap: 8px;
    align-items: center;
  }
  
  /* 控制按钮通用样式 */
  .ctl {
    color: #e5e7eb;
    font-size: 18px;
  }
  
  /* 播放按钮样式 */
  .play {
    width: 46px;
    height: 46px;
    border: none;
    background: linear-gradient(45deg, #67c3ff, #7b7cff);
  }
  
  /* 控制按钮行布局 */
  .controls-line {
    margin-top: 10px;
    display: grid;
    grid-template-columns: 1fr auto auto auto 1fr;
    gap: 10px;
    align-items: center;
  }
  
  /* 移动端控制按钮优化 */
  @media (max-width: 768px) {
    .controls-line {
      grid-template-columns: repeat(5, 1fr);
      gap: 8px;
      margin-top: 16px;
    }
    
    .ctl {
      font-size: 20px;
      padding: 12px;
      min-width: 44px;
      min-height: 44px;
      display: flex;
      align-items: center;
      justify-content: center;
    }
    
    .play {
      width: 56px;
      height: 56px;
      font-size: 20px;
    }
  }
  
  /* 音量控制行 */
  .volume-line {
    margin-top: 8px;
    width: 100%;
    display: grid;
    grid-template-columns: auto auto;
    gap: 10px;
    align-items: center;
    justify-content: center;
  }
  
  /* 音量滑块宽度 */
  .volume-slider {
    width: 200px;
  }
  
  /* 时间显示样式 */
  .time {
    color: #d1d5db;
    font-size: 12px;
    text-align: center;
  }
  
  /* 右侧歌词区域布局 */
  .right {
    display: flex;
    flex-direction: column;
  }
  
  /* 右侧歌曲信息 */
  .meta .title {
    margin: 0 0 6px;
    font-size: 28px;
    font-weight: 800;
    color: #fff;
  }
  
  .meta .artist {
    margin: 0 0 8px;
    color: #e5e7eb;
  }
  
  /* 歌词控制按钮 */
  .lyrics-controls {
    margin-bottom: 12px;
  }
  
  .lyrics-controls .el-button {
    color: #a0a0a0 !important;
    font-size: 12px;
    padding: 4px 8px;
    transition: all 0.2s ease;
  }
  
  .lyrics-controls .el-button:hover {
    color: #67c3ff !important;
  }
  
  .lyrics-controls .el-button.active {
    color: #67c3ff !important;
    background-color: rgba(103, 195, 255, 0.1);
  }
  
  /* 歌词容器样式 */
  .lyrics {
    margin-top: 4px;
    padding: 16px;
    height: 560px;
    min-height: 560px;
    max-height: 560px;
    overflow-y: auto;
    background: rgba(6, 10, 25, 0.85);
    border-radius: 14px;
    color: #e5e7eb;
    box-shadow: inset 0 8px 16px rgba(0, 0, 0, 0.35);
    backdrop-filter: blur(2px);
    scroll-behavior: smooth;
    /* 防止内容溢出导致的布局跳动 */
    contain: layout;
  }
  
  /* 移动端歌词区域优化 */
  @media (max-width: 768px) {
    .lyrics {
      height: 400px;
      min-height: 400px;
      max-height: 400px;
      padding: 12px;
      margin-top: 16px;
      -webkit-overflow-scrolling: touch; /* 惯性滚动 */
      overscroll-behavior: contain; /* 阻止滚动链，避免整个页面被带动抖动 */
      touch-action: pan-y; /* 仅允许纵向滚动 */
    }
    
    .lyric-text {
      font-size: 18px;
      line-height: 1.8;
    }
    
    .lyric-translation {
      font-size: 16px;
      margin-top: 4px;
    }
  }
  
  @media (max-width: 480px) {
    .lyrics {
      height: 350px;
      min-height: 350px;
      max-height: 350px;
      overscroll-behavior: contain;
      touch-action: pan-y;
    }
    
    .lyric-text {
      font-size: 16px;
    }
    
    .lyric-translation {
      font-size: 14px;
    }
  }
  
  /* 歌词行样式 */
  .lyrics .line {
    opacity: 0.6;
    padding: 8px 0;
    transition: all 0.3s ease;
    text-align: center;
    line-height: 1.6;
  }
  
  /* 当前播放歌词高亮 */
  .lyrics .line.active {
    opacity: 1;
    color: #fff;
    font-weight: 700;
    transform: scale(1.05);
    text-shadow: 0 0 10px rgba(255, 255, 255, 0.3);
  }
  
  /* 歌词文本样式 */
  .lyric-text {
    font-size: 16px;
    margin-bottom: 4px;
  }
  
  /* 歌词翻译样式 */
  .lyric-translation {
    font-size: 14px;
    color: #a0a0a0;
    opacity: 0.8;
  }
  
  /* 无歌词/加载中容器 */
  .lyrics.empty {
    display: flex;
    align-items: center;
    justify-content: center;
    color: #b6bdc6;
    /* 确保空状态时也保持固定高度 */
    min-height: 560px;
  }
  
  /* 加载中样式 */
  .loading {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 12px;
    color: #67c3ff;
  }
  
  /* 加载动画 */
  .loading-spinner {
    font-size: 24px;
    animation: pulse 1.5s ease-in-out infinite;
  }
  
  .loading-text {
    font-size: 14px;
    animation: pulse 1.5s ease-in-out infinite;
  }
  
  /* 无歌词提示 */
  .no-lyrics {
    text-align: center;
    padding: 40px 20px;
  }
  
  .no-lyrics-icon {
    font-size: 48px;
    margin-bottom: 16px;
    opacity: 0.6;
  }
  
  .no-lyrics-text {
    font-size: 16px;
    color: #e5e7eb;
    margin-bottom: 8px;
    font-weight: 500;
  }
  
  .no-lyrics-tip {
    font-size: 14px;
    color: #a0a0a0;
    opacity: 0.8;
  }
  
  /* 加载动画定义 */
  @keyframes pulse {
    0%, 100% { opacity: 0.6; }
    50% { opacity: 1; }
  }
  
  /* 响应式布局 - 小屏幕 */
  @media (max-width: 1024px) {
    .player-page {
      grid-template-columns: 1fr;
    }
    .disc {
      width: 320px;
      height: 320px;
    }
    .lyrics {
      height: 380px;
    }
  }
  
  /* 播放页面播放队列面板样式 */
  .play-queue-panel {
    position: fixed;
    bottom: 20px;
    right: 20px;
    width: 400px;
    max-height: 500px;
    background: white;
    border-radius: 12px;
    box-shadow: 0 8px 32px rgba(0, 0, 0, 0.15);
    z-index: 1000;
    overflow: hidden;
  }
  
  /* 队列面板动画 */
  .queue-panel-enter-active,
  .queue-panel-leave-active {
    transition: all 0.3s ease;
  }
  
  .queue-panel-enter-from {
    opacity: 0;
    transform: translateY(20px) scale(0.95);
  }
  
  .queue-panel-leave-to {
    opacity: 0;
    transform: translateY(20px) scale(0.95);
  }
  
  /* 队列头部 */
  .queue-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 16px 20px;
    background: linear-gradient(45deg, #667eea, #764ba2);
    color: white;
  }
  
  .queue-header h3 {
    margin: 0;
    font-size: 16px;
    font-weight: 600;
  }
  
  /* 队列头部操作按钮 */
  .queue-actions {
    display: flex;
    gap: 8px;
  }
  
  .queue-actions .el-button {
    color: white !important;
    font-weight: 500;
  }
  
  .queue-actions .el-button:hover {
    background-color: rgba(255, 255, 255, 0.2) !important;
    color: white !important;
  }
  
  /* 队列列表容器 */
  .queue-list {
    max-height: 400px;
    overflow-y: auto;
  }
  
  /* 队列项样式 */
  .queue-item {
    display: flex;
    align-items: center;
    padding: 12px 20px;
    border-bottom: 1px solid #f0f0f0;
    transition: background-color 0.2s ease;
  }
  
  .queue-item:hover {
    background-color: #f8f9fa;
  }
  
  /* 当前播放项样式 */
  .queue-item.current {
    background-color: #e3f2fd;
    border-left: 3px solid #667eea;
  }
  
  /* 队列序号 */
  .queue-number {
    width: 24px;
    height: 24px;
    display: flex;
    align-items: center;
    justify-content: center;
    background: #f0f0f0;
    border-radius: 50%;
    font-size: 12px;
    font-weight: 600;
    color: #666;
    margin-right: 12px;
  }
  
  .queue-item.current .queue-number {
    background: #667eea;
    color: white;
  }
  
  /* 队列项封面 */
  .queue-cover {
    width: 40px;
    height: 40px;
    border-radius: 6px;
    object-fit: cover;
    margin-right: 12px;
  }
  
  /* 队列项信息 */
  .queue-info {
    flex: 1;
    min-width: 0;
  }
  
  .queue-title {
    font-size: 14px;
    font-weight: 600;
    color: #333;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    margin-bottom: 2px;
  }
  
  .queue-artist {
    font-size: 12px;
    color: #666;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  /* 队列项操作按钮 */
  .queue-actions {
    display: flex;
    gap: 4px;
  }
  
  .queue-actions .el-button {
    padding: 4px 8px;
    font-size: 12px;
  }
  
  .play-btn {
    color: #667eea !important;
  }
  
  .remove-btn {
    color: #f56565 !important;
  }
  
  /* 空队列提示 */
  .empty-queue {
    padding: 40px 20px;
    text-align: center;
    color: #999;
  }
  
  .empty-queue p {
    margin: 0;
    font-size: 14px;
  }
  
  /* 移动端隐藏播放页面播放队列面板 */
  @media (max-width: 768px) {
    .play-queue-panel.desktop-only {
      display: none !important;
    }
  }
  
  /* 无播放内容提示 */
  .empty {
  min-height: auto;
    display: flex;
    align-items: center;
    justify-content: center;
    color: rgba(255, 255, 255, 0.7);
    font-size: 18px;
  }
  </style>
  