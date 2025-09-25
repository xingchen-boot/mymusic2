<template>
    <div class="recent">
      <!-- 头部标题与清空操作区 -->
      <div class="recent-header">
        <h1>🕒 最近播放</h1>
        <div class="header-actions">
          <el-button
            type="danger"
            size="small"
            @click="clearRecentPlays"
            :disabled="recentPlays.length === 0"
          >
            清空记录
          </el-button>
        </div>
      </div>
  
      <!-- 加载中状态 -->
      <div v-if="loading" class="loading-container">
        <el-loading
          v-loading="loading"
          element-loading-text="加载中..."
          element-loading-spinner="el-icon-loading"
        />
      </div>
  
      <!-- 空状态（无播放记录时） -->
      <div v-else-if="recentPlays.length === 0" class="empty-state">
        <div class="empty-icon">🎵</div>
        <h3>暂无播放记录</h3>
        <p>开始播放音乐，这里会显示你的播放历史</p>
      </div>
  
      <!-- 最近播放列表（有数据时） -->
      <div v-else class="recent-list">
        <div
          v-for="(play, index) in recentPlays"
          :key="play.id"
          class="recent-item"
          :class="{ 'playing': currentMusic?.id === parseInt(play.musicId) && isPlaying }"
        >
          <!-- 序号 -->
          <div class="item-index">{{ index + 1 }}</div>
  
          <!-- 封面图与悬浮播放按钮 -->
          <div class="item-cover">
            <img
              :src="play.musicCover || '/default-cover.png'"
              :alt="play.musicSong"
              @error="handleImageError"
            />
            <div class="play-overlay" @click="playRecentMusic(play)">
              <i :class="currentMusic?.id === parseInt(play.musicId) && isPlaying ? 'el-icon-video-pause' : 'el-icon-video-play'"></i>
            </div>
          </div>
  
          <!-- 音乐信息（歌名、歌手、播放详情） -->
          <div class="item-info">
            <div class="song-title" :title="play.musicSong">
              {{ play.musicSong }}
            </div>
            <div class="song-artist" :title="play.musicSinger">
              {{ play.musicSinger }}
            </div>
            <div class="play-info">
              <span class="play-time">{{ formatPlayTime(play.playTime) }}</span>
              <span v-if="play.playDuration > 0" class="play-duration">
                播放了{{ formatDuration(play.playDuration) }}
              </span>
              <span v-if="play.playProgress > 0" class="play-progress">
                进度{{ play.playProgress.toFixed(1) }}%
              </span>
            </div>
          </div>
  
          <!-- 操作按钮组（播放、加入队列、下载、移除） -->
          <div class="item-actions">
            <!-- 播放/暂停按钮 -->
            <el-button
              type="primary"
              circle
              size="small"
              @click="playRecentMusic(play)"
              :title="currentMusic?.id === parseInt(play.musicId) && isPlaying ? '暂停' : '播放'"
            >
              {{ currentMusic?.id === parseInt(play.musicId) && isPlaying ? '⏸️' : '▶️' }}
            </el-button>
  
            <!-- 加入队列按钮（区分已在队列/未在队列状态） -->
            <el-button
              :type="isMusicInQueue(parseInt(play.musicId)) ? 'success' : 'warning'"
              circle
              size="small"
              @click.stop="handleAddToQueueFromRecent(play)"
              style="margin-left: 8px;"
              :title="isMusicInQueue(parseInt(play.musicId)) ? '已在队列中，点击移到当前播放歌曲下面' : '加入播放队列'"
            >
              {{ isMusicInQueue(parseInt(play.musicId)) ? '🔄' : '➕' }}
            </el-button>
  
            <!-- 下载按钮 -->
            <el-button
              type="success"
              circle
              size="small"
              @click.stop="downloadRecentMusic(play)"
              style="margin-left: 8px;"
              title="下载"
            >
              ⬇️
            </el-button>
  
            <!-- 移除按钮 -->
            <el-button
              type="danger"
              circle
              size="small"
              @click.stop="removeFromRecent(play)"
              style="margin-left: 8px;"
              title="移除"
            >
              🗑️
            </el-button>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, onMounted, onUnmounted, computed } from 'vue'
  import { useUserStore } from '@/stores/user'
  import { useMusicStore } from '@/stores/music'
  
  // 1. 初始化状态管理实例
  const userStore = useUserStore()
  const musicStore = useMusicStore()
  
  // 2. 响应式数据定义
  const recentPlays = ref<any[]>([]) // 存储最近播放列表
  const loading = ref(false) // 加载状态标记
  
  // 3. 计算属性（从Store获取实时状态）
  const currentMusic = computed(() => musicStore.currentMusic) // 当前播放的歌曲
  const isPlaying = computed(() => musicStore.isPlaying) // 是否正在播放
  const playQueue = computed(() => musicStore.playQueue) // 当前播放队列
  
  // 4. 核心方法定义
  /**
   * 加载最近播放记录
   * - 仅用户登录时请求后端接口
   * - 处理加载状态与错误提示
   */
  const loadRecentPlays = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌ 用户未登录，无法加载最近播放记录')
      return
    }
  
    loading.value = true
    try {
      const response = await fetch(`/api/recent-play/user/${userStore.currentUser.id}?limit=100`)
  
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`)
      }
  
      const result = await response.json()
      if (result.code === 200) {
        recentPlays.value = result.data || []
        console.log('✅ 最近播放记录加载成功，共', recentPlays.value.length, '条')
      } else {
        console.error('❌ 加载最近播放记录失败:', result.message)
      }
    } catch (error) {
      console.error('❌ 加载最近播放记录失败:', error)
    } finally {
      loading.value = false // 无论成功失败，都关闭加载状态
    }
  }
  
  /**
   * 订阅最近播放更新（增量更新列表）
   * @param event - 事件对象，包含更新类型（record/progress）和音乐信息
   */
  const handleRecentChange = async (event: { 
    type: 'record' | 'progress'; 
    music?: any; 
    playDuration?: number; 
    playProgress?: number 
  }) => {
    // 处理“新播放记录”更新
    if (event.type === 'record' && event.music) {
      const musicId = event.music.id?.toString?.() || event.music.musicId?.toString?.()
      // 检查记录是否已存在，存在则移除（避免重复）
      const existIdx = recentPlays.value.findIndex(item => item.musicId?.toString?.() === musicId)
      
      if (existIdx > -1) {
        const existRecord = recentPlays.value.splice(existIdx, 1)[0]
        existRecord.playTime = new Date().toISOString() // 更新播放时间为当前
        recentPlays.value.unshift(existRecord) // 移到列表顶部（保持最新在前）
      } else {
        // 新增播放记录
        recentPlays.value.unshift({
          id: Date.now(),
          userId: userStore.currentUser?.id,
          musicId: musicId,
          musicMid: event.music.mid,
          musicSong: event.music.song,
          musicSinger: event.music.singer,
          musicAlbum: event.music.album || '',
          musicCover: event.music.cover || '',
          musicTime: event.music.time || '',
          musicPay: event.music.pay || '',
          playTime: new Date().toISOString(),
          playDuration: 0,
          playProgress: 0
        })
      }
    } 
    // 处理“播放进度”更新
    else if (event.type === 'progress' && currentMusic.value) {
      const musicId = (event.music?.id ?? currentMusic.value.id).toString()
      const targetIdx = recentPlays.value.findIndex(item => item.musicId?.toString?.() === musicId)
      
      if (targetIdx > -1) {
        const targetItem = recentPlays.value[targetIdx]
        // 更新进度和时长
        if (typeof event.playDuration === 'number') targetItem.playDuration = event.playDuration
        if (typeof event.playProgress === 'number') targetItem.playProgress = event.playProgress
        targetItem.playTime = new Date().toISOString() // 更新最后操作时间
        
        // 移到列表顶部（标记为“最近操作”）
        const movedItem = recentPlays.value.splice(targetIdx, 1)[0]
        recentPlays.value.unshift(movedItem)
      }
    }
  }
  
  /**
   * 播放最近播放列表中的音乐
   * @param play - 最近播放记录对象
   */
  const playRecentMusic = async (play: any) => {
    const music = {
      id: parseInt(play.musicId),
      mid: play.musicMid,
      song: play.musicSong,
      singer: play.musicSinger,
      album: play.musicAlbum || '',
      cover: play.musicCover || '',
      time: play.musicTime || '',
      pay: play.musicPay || ''
    }
    await musicStore.playMusic(music)
  }
  
  /**
   * 检查音乐是否已在播放队列中
   * @param musicId - 音乐ID
   * @returns boolean - 是否在队列中
   */
  const isMusicInQueue = (musicId: number) => {
    return playQueue.value.some(item => item.id === musicId)
  }
  
  /**
   * 从最近播放添加音乐到队列（支持“移到当前播放歌曲下方”）
   * @param play - 最近播放记录对象
   */
  const handleAddToQueueFromRecent = async (play: any) => {
    const music = {
      id: parseInt(play.musicId),
      mid: play.musicMid,
      song: play.musicSong,
      singer: play.musicSinger,
      album: play.musicAlbum || '',
      cover: play.musicCover || '',
      time: play.musicTime || '',
      pay: play.musicPay || ''
    }
    const alreadyInQueue = isMusicInQueue(music.id)
    await musicStore.moveToCurrentPosition(music)
  
    // 动态导入Element Plus提示组件（按需加载）
    const { ElMessage } = await import('element-plus')
    ElMessage.success(
      alreadyInQueue 
        ? `已移到当前播放歌曲下面: ${music.song}` 
        : `已添加到当前播放歌曲下面: ${music.song}`
    )
  }
  
  /**
   * 下载最近播放的音乐
   * @param play - 最近播放记录对象
   */
  const downloadRecentMusic = async (play: any) => {
    const music = {
      id: parseInt(play.musicId),
      mid: play.musicMid,
      song: play.musicSong,
      singer: play.musicSinger,
      album: play.musicAlbum || '',
      cover: play.musicCover || '',
      time: play.musicTime || '',
      pay: play.musicPay || ''
    }
    try {
      await musicStore.downloadMusic(music)
    } catch (error) {
      console.error('❌ 下载音乐失败:', error)
      const { ElMessage } = await import('element-plus')
      ElMessage.error('下载失败，请稍后重试')
    }
  }
  
  /**
   * 从最近播放中移除单条记录
   * @param play - 最近播放记录对象
   */
  const removeFromRecent = async (play: any) => {
    if (!userStore.isLoggedIn || !userStore.currentUser) return
  
    try {
      const response = await fetch(
        `/api/recent-play/user/${userStore.currentUser.id}/music/${play.musicId}`,
        { method: 'DELETE' }
      )
  
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`)
      }
  
      const result = await response.json()
      if (result.code === 200) {
        // 从前端列表中移除该记录
        const targetIdx = recentPlays.value.findIndex(item => item.id === play.id)
        if (targetIdx > -1) recentPlays.value.splice(targetIdx, 1)
  
        const { ElMessage } = await import('element-plus')
        ElMessage.success('已从最近播放中移除')
      } else {
        throw new Error(result.message)
      }
    } catch (error) {
      console.error('❌ 移除最近播放记录失败:', error)
      const { ElMessage } = await import('element-plus')
      ElMessage.error('移除失败，请稍后重试')
    }
  }
  
  /**
   * 清空所有最近播放记录（需用户确认）
   */
  const clearRecentPlays = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser) return
  
    try {
      // 显示确认弹窗
      const { ElMessageBox } = await import('element-plus')
      await ElMessageBox.confirm(
        '确定要清空所有最近播放记录吗？此操作不可恢复。',
        '确认清空',
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }
      )
  
      // 调用后端接口清空记录
      const response = await fetch(
        `/api/recent-play/user/${userStore.currentUser.id}/clear`,
        { method: 'DELETE' }
      )
  
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`)
      }
  
      const result = await response.json()
      if (result.code === 200) {
        recentPlays.value = [] // 清空前端列表
        const { ElMessage } = await import('element-plus')
        ElMessage.success('已清空最近播放记录')
      } else {
        throw new Error(result.message)
      }
    } catch (error) {
      // 忽略“用户取消”错误
      if (error !== 'cancel') {
        console.error('❌ 清空最近播放记录失败:', error)
        const { ElMessage } = await import('element-plus')
        ElMessage.error('清空失败，请稍后重试')
      }
    }
  }
  
  /**
   * 格式化播放时间（显示“XX天前/小时前/分钟前/刚刚”）
   * @param playTime - 原始播放时间（ISO字符串）
   * @returns string - 格式化后的时间文本
   */
  const formatPlayTime = (playTime: string) => {
    const date = new Date(playTime)
    const now = new Date()
    const timeDiff = now.getTime() - date.getTime() // 时间差（毫秒）
  
    const minutes = Math.floor(timeDiff / (1000 * 60))
    const hours = Math.floor(timeDiff / (1000 * 60 * 60))
    const days = Math.floor(timeDiff / (1000 * 60 * 60 * 24))
  
    if (days > 0) return `${days}天前`
    if (hours > 0) return `${hours}小时前`
    if (minutes > 0) return `${minutes}分钟前`
    return '刚刚'
  }
  
  /**
   * 格式化时长（秒 → MM:SS 格式）
   * @param seconds - 时长（秒）
   * @returns string - 格式化后的时长文本
   */
  const formatDuration = (seconds: number) => {
    const minutes = Math.floor(seconds / 60)
    const remainingSeconds = seconds % 60
    return `${minutes}:${remainingSeconds.toString().padStart(2, '0')}`
  }
  
  /**
   * 处理封面图片加载失败（替换为默认封面）
   * @param event - 图片错误事件
   */
  const handleImageError = (event: Event) => {
    const img = event.target as HTMLImageElement
    img.src = '/default-cover.png'
  }
  
  // 5. 生命周期钩子
  // 组件挂载时：加载数据 + 订阅更新事件
  onMounted(() => {
    loadRecentPlays()
    musicStore.addRecentPlayListener(handleRecentChange as any)
  })
  
  // 组件卸载时：取消订阅（避免内存泄漏）
  onUnmounted(() => {
    musicStore.removeRecentPlayListener(handleRecentChange as any)
  })
  </script>
  
  <style scoped>
  .recent {
    padding: 20px;
    max-width: 1200px;
    margin: 0 auto;
  }
  
  .recent-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 30px;
    padding-bottom: 20px;
    border-bottom: 1px solid #e0e0e0;
  }
  
  .recent-header h1 {
    color: #333;
    margin: 0;
    font-size: 28px;
  }
  
  .header-actions {
    display: flex;
    gap: 10px;
  }
  
  .loading-container {
    height: 200px;
    position: relative;
  }
  
  .empty-state {
    text-align: center;
    padding: 60px 20px;
    color: #666;
  }
  
  .empty-icon {
    font-size: 64px;
    margin-bottom: 20px;
  }
  
  .empty-state h3 {
    color: #333;
    margin-bottom: 10px;
  }
  
  .empty-state p {
    color: #999;
    font-size: 14px;
  }
  
  .recent-list {
    display: flex;
    flex-direction: column;
    gap: 12px;
  }
  
  .recent-item {
    display: flex;
    align-items: center;
    padding: 15px;
    background: #fff;
    border-radius: 12px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    transition: all 0.3s ease;
    border: 2px solid transparent;
  }
  
  .recent-item:hover {
    transform: translateY(-2px);
    box-shadow: 0 4px 16px rgba(0, 0, 0, 0.15);
  }
  
  .recent-item.playing {
    border-color: #409eff;
    background: linear-gradient(135deg, #f0f9ff 0%, #e6f7ff 100%);
  }
  
  .item-index {
    width: 30px;
    text-align: center;
    color: #999;
    font-weight: bold;
    font-size: 14px;
  }
  
  .item-cover {
    position: relative;
    width: 60px;
    height: 60px;
    margin: 0 15px;
    border-radius: 8px;
    overflow: hidden;
    cursor: pointer;
  }
  
  .item-cover img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  
  .play-overlay {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    align-items: center;
    justify-content: center;
    opacity: 0;
    transition: opacity 0.3s ease;
  }
  
  .item-cover:hover .play-overlay {
    opacity: 1;
  }
  
  .play-overlay i {
    color: white;
    font-size: 24px;
  }
  
  .item-info {
    flex: 1;
    min-width: 0;
    margin-right: 15px;
  }
  
  .song-title {
    font-size: 16px;
    font-weight: 600;
    color: #333;
    margin-bottom: 4px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  .song-artist {
    font-size: 14px;
    color: #666;
    margin-bottom: 6px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  .play-info {
    display: flex;
    gap: 12px;
    font-size: 12px;
    color: #999;
  }
  
  .play-time {
    font-weight: 500;
  }
  
  .play-duration {
    color: #409eff;
  }
  
  .play-progress {
    color: #67c23a;
  }
  
  .item-actions {
    display: flex;
    gap: 8px;
  }
  
  .item-actions .round-btn {
    width: 40px;
    height: 40px;
    border: none;
    color: #fff;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.12);
  }
  
  .round-btn i { font-size: 18px; }
  
  .round-btn.play { background: linear-gradient(135deg, #7a5cff, #4db6ff); }
  .round-btn.add { background: linear-gradient(135deg, #f4a261, #f4c361); }
  .round-btn.download { background: linear-gradient(135deg, #56ab2f, #a8e063); }
  .round-btn.remove { background: linear-gradient(135deg, #ff6b6b, #ff8e8e); }
  
  .round-btn:hover { filter: brightness(1.05); }
  .round-btn:active { transform: scale(0.96); }
  
  /* 响应式设计 */
  @media (max-width: 768px) {
    .recent {
      padding: 15px;
    }
  
    .recent-header {
      flex-direction: column;
      gap: 15px;
      align-items: flex-start;
    }
  
    .recent-item {
      padding: 12px;
    }
  
    .item-cover {
      width: 50px;
      height: 50px;
      margin: 0 10px;
    }
  
    .item-info {
      margin-right: 10px;
    }
  
    .song-title {
      font-size: 14px;
    }
  
    .song-artist {
      font-size: 12px;
    }
  
    .play-info {
      flex-direction: column;
      gap: 4px;
    }
  
    .item-actions {
      flex-direction: column;
      gap: 4px;
    }
  
    .item-actions .round-btn { width: 36px; height: 36px; }
  }
  </style>
  