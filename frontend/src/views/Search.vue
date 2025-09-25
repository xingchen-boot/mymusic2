<template>
    <div class="search">
      <!-- 搜索头部标题区 -->
      <div class="search-header">
        <h1 class="search-title">🔍 搜索结果</h1>
        <p class="search-subtitle" v-if="searchKeyword">
          搜索"{{ searchKeyword }}"的结果
        </p>
      </div>
  
      <!-- 加载中状态 -->
      <div v-if="isLoading" class="loading">
        <div class="loading-icon">⏳</div>
        <p>正在搜索音乐...</p>
      </div>
  
      <!-- 无结果状态（有搜索关键词时） -->
      <div v-else-if="musicList.length === 0 && searchKeyword" class="empty">
        <div class="empty-icon">🔍</div>
        <p>没有找到相关音乐</p>
        <p class="empty-tip">试试其他关键词吧</p>
      </div>
  
      <!-- 初始欢迎状态（无搜索关键词时） -->
      <div v-else-if="musicList.length === 0" class="welcome">
        <div class="welcome-icon">🎵</div>
        <h3>开始搜索</h3>
        <p>在顶部搜索框中输入歌曲名或歌手名</p>
      </div>
  
      <!-- 搜索结果列表 -->
      <div v-else class="search-results">
        <!-- 结果头部（可扩展显示结果数量） -->
        <div class="results-header">
          <!-- <h2>找到{{ musicList.length }}首歌曲</h2> -->
        </div>
  
        <!-- 音乐列表容器（带滚动加载） -->
        <div class="music-list" ref="musicListRef">
          <!-- 音乐项循环渲染 -->
          <div
            v-for="music in musicList"
            :key="music.id"
            class="music-item"
            :class="{ playing: currentMusic?.id === music.id && isPlaying }"
            @click="handlePlayMusic(music)"
          >
            <!-- 音乐封面 -->
            <img :src="music.cover" :alt="music.song" class="music-cover" />
            
            <!-- 音乐信息（歌名、歌手、专辑） -->
            <div class="music-info">
              <div class="music-title">{{ music.song }}</div>
              <div class="music-artist">{{ music.singer }} · {{ music.album }}</div>
            </div>
            
            <!-- 音乐操作按钮（播放、加入队列、下载） -->
            <div class="music-actions">
              <!-- 播放/暂停按钮 -->
              <el-button
                type="primary"
                circle
                size="small"
                @click.stop="handlePlayMusic(music)"
              >
                {{ currentMusic?.id === music.id && isPlaying ? '⏸️' : '▶️' }}
              </el-button>
              
              <!-- 加入队列按钮（状态区分：已在队列/未在队列） -->
              <el-button
                :type="isMusicInQueue(music.id) ? 'success' : 'warning'"
                circle
                size="small"
                @click.stop="handleAddToQueue(music)"
                style="margin-left: 8px;"
                :title="isMusicInQueue(music.id) ? '已在队列中，点击移到当前播放歌曲下面' : '加入播放队列'"
              >
                {{ isMusicInQueue(music.id) ? '🔄' : '➕' }}
              </el-button>
              
              <!-- 下载按钮 -->
              <el-button
                type="success"
                circle
                size="small"
                @click.stop="handleDownloadMusic(music)"
                style="margin-left: 8px;"
              >
                ⬇️
              </el-button>
            </div>
          </div>
  
          <!-- 加载更多指示器 -->
          <div v-if="isLoadingMore" class="loading-more">
            <div class="loading-spinner">⏳</div>
            <p>正在加载更多音乐...</p>
          </div>
  
          <!-- 没有更多数据提示 -->
          <div v-else-if="!hasMoreData && musicList.length > 0" class="no-more-data">
            <p>🎵 没有更多音乐了</p>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, computed, onMounted, onUnmounted, watch, nextTick } from 'vue'
  import { useRoute } from 'vue-router'
  import { useMusicStore } from '@/stores/music'
  
  // 路由与状态管理实例
  const route = useRoute()
  const musicStore = useMusicStore()
  
  // 响应式数据
  const searchKeyword = ref('') // 当前搜索关键词
  const musicListRef = ref<HTMLElement | null>(null) // 音乐列表DOM引用
  
  // 从Pinia Store解构计算属性
  const currentMusic = computed(() => musicStore.currentMusic) // 当前播放歌曲
  const isPlaying = computed(() => musicStore.isPlaying) // 是否正在播放
  const isLoading = computed(() => musicStore.isLoading) // 初始搜索加载状态
  const musicList = computed(() => musicStore.musicList) // 搜索结果列表
  const hasMoreData = computed(() => musicStore.hasMoreData) // 是否有更多数据
  const isLoadingMore = computed(() => musicStore.isLoadingMore) // 加载更多状态
  const playQueue = computed(() => musicStore.playQueue) // 播放队列
  
  /**
   * 处理播放音乐
   * @param music - 要播放的音乐对象
   */
  const handlePlayMusic = (music: any) => {
    musicStore.playMusic(music)
  }
  
  /**
   * 检查音乐是否已在播放队列中
   * @param musicId - 音乐ID
   * @returns 布尔值：是否在队列中
   */
  const isMusicInQueue = (musicId: number) => {
    return playQueue.value.some(item => item.id === musicId)
  }
  
  /**
   * 处理添加音乐到播放队列
   * @param music - 要添加的音乐对象
   */
  const handleAddToQueue = async (music: any) => {
    // 检查歌曲是否已在队列中
    const isAlreadyInQueue = isMusicInQueue(music.id)
  
    // 调用Store方法添加/移动歌曲到当前播放位置
    await musicStore.moveToCurrentPosition(music)
  
    // 动态导入Element Plus的ElMessage（按需加载）
    const { ElMessage } = await import('element-plus')
    // 根据状态显示不同提示
    if (isAlreadyInQueue) {
      ElMessage.success(`已移到当前播放歌曲下面: ${music.song}`)
    } else {
      ElMessage.success(`已添加到当前播放歌曲下面: ${music.song}`)
    }
  }
  
  /**
   * 处理下载音乐
   * @param music - 要下载的音乐对象
   */
  const handleDownloadMusic = async (music: any) => {
    try {
      const { ElMessage } = await import('element-plus')
      ElMessage.info(`开始下载: ${music.song}-${music.singer}`)
  
      // 调用Store的下载方法
      await musicStore.downloadMusic(music)
  
      ElMessage.success(`下载完成: ${music.song}`)
    } catch (error: any) {
      console.error('下载音乐失败:', error)
      const { ElMessage } = await import('element-plus')
      ElMessage.error(`下载失败: ${error.message || '未知错误'}`)
    }
  }
  
  /**
   * 执行搜索操作
   * @param keyword - 搜索关键词
   */
  const performSearch = async (keyword: string) => {
    if (!keyword.trim()) return // 空关键词不执行搜索
  
    searchKeyword.value = keyword
    await musicStore.searchMusic(keyword)
  }
  
  /**
   * 滚动监听处理函数（实现滚动加载更多）
   */
  const handleScroll = () => {
    // 边界条件：无DOM引用/无更多数据/正在加载更多时，不执行
    if (!musicListRef.value || !hasMoreData.value || isLoadingMore.value) {
      return
    }
  
    const element = musicListRef.value
    const scrollTop = element.scrollTop // 已滚动高度
    const scrollHeight = element.scrollHeight // 总滚动高度
    const clientHeight = element.clientHeight // 可视区域高度
  
    // 滚动到距离底部100px时，触发加载更多
    const threshold = 100
    const isNearBottom = scrollTop + clientHeight >= scrollHeight - threshold
  
    if (isNearBottom) {
      console.log('📜 滚动到底部附近，开始加载更多')
      musicStore.loadMoreMusic()
    }
  }
  
  /**
   * 添加滚动监听
   */
  const addScrollListener = () => {
    if (musicListRef.value) {
      musicListRef.value.addEventListener('scroll', handleScroll)
    }
  }
  
  /**
   * 移除滚动监听（避免内存泄漏）
   */
  const removeScrollListener = () => {
    if (musicListRef.value) {
      musicListRef.value.removeEventListener('scroll', handleScroll)
    }
  }
  
  // 监听路由参数变化（关键词变化时重新搜索）
  watch(() => route.query.keyword, (newKeyword) => {
    if (newKeyword && typeof newKeyword === 'string') {
      // 避免重复搜索相同关键词
      if (searchKeyword.value !== newKeyword) {
        performSearch(newKeyword)
      }
    }
  }, { immediate: true }) // 初始渲染时立即执行
  
  // 监听音乐列表长度变化（列表更新后重新绑定滚动监听）
  watch(() => musicList.value.length, () => {
    nextTick(() => { // 确保DOM更新后执行
      addScrollListener()
    })
  })
  
  // 生命周期：页面挂载时
  onMounted(() => {
    // 初始加载时，从路由参数获取关键词并搜索
    const keyword = route.query.keyword as string
    if (keyword) {
      if (searchKeyword.value !== keyword) {
        performSearch(keyword)
      }
    }
  
    // 绑定滚动监听（确保DOM已渲染）
    nextTick(() => {
      addScrollListener()
    })
  })
  
  // 生命周期：页面卸载时（清理监听）
  onUnmounted(() => {
    removeScrollListener()
  })
  </script>
  
  <style scoped>
  /* 页面容器基础样式 */
  .search {
    padding: 20px;
  }
  
  /* 搜索头部样式 */
  .search-header {
    text-align: center;
    margin-bottom: 30px;
  }
  
  .search-title {
    font-size: 2rem;
    font-weight: 700;
    margin: 0 0 10px 0;
    color: #333;
  }
  
  .search-subtitle {
    font-size: 1rem;
    color: #666;
    margin: 0;
  }
  
  /* 加载中状态样式 */
  .loading, 
  .empty, 
  .welcome {
    text-align: center;
    padding: 60px 20px;
    color: #666;
  }
  
  .loading-icon, 
  .empty-icon, 
  .welcome-icon {
    font-size: 4rem;
    margin-bottom: 20px;
    color: #667eea;
  }
  
  .loading p, 
  .empty p, 
  .welcome p {
    font-size: 1.1rem;
    margin: 10px 0;
  }
  
  .empty-tip {
    font-size: 0.9rem;
    color: #999;
  }
  
  .welcome h3 {
    color: #333;
    font-size: 1.8rem;
    margin-bottom: 15px;
  }
  
  /* 搜索结果容器样式 */
  .search-results {
    background: white;
    border-radius: 12px;
    padding: 20px;
    box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
  }
  
  /* 结果头部样式（可扩展） */
  .results-header {
    margin-bottom: 20px;
    padding-bottom: 15px;
    border-bottom: 1px solid #e0e0e0;
  }
  
  .results-header h2 {
    font-size: 1.2rem;
    font-weight: 600;
    margin: 0;
    color: #333;
  }
  
  /* 音乐列表容器样式（带滚动） */
  .music-list {
    display: flex;
    flex-direction: column;
    gap: 10px;
    max-height: 600px;
    overflow-y: auto;
    padding-right: 10px;
  }
  
  /* 音乐项基础样式 */
  .music-item {
    display: flex;
    align-items: center;
    padding: 15px;
    background: #f8f9fa;
    border-radius: 12px;
    cursor: pointer;
    transition: all 0.3s ease;
  }
  
  /* 音乐项hover效果 */
  .music-item:hover {
    background: #e9ecef;
    transform: translateX(5px);
  }
  
  /* 正在播放的音乐项样式 */
  .music-item.playing {
    background: linear-gradient(45deg, #667eea, #764ba2);
    color: white;
  }
  
  /* 音乐封面样式 */
  .music-cover {
    width: 50px;
    height: 50px;
    border-radius: 8px;
    margin-right: 15px;
    object-fit: cover;
  }
  
  /* 音乐信息样式 */
  .music-info {
    flex: 1;
  }
  
  .music-title {
    font-weight: 600;
    margin-bottom: 5px;
    font-size: 16px;
  }
  
  .music-artist {
    color: #666;
    font-size: 14px;
  }
  
  /* 正在播放时的歌手文字颜色 */
  .music-item.playing .music-artist {
    color: rgba(255, 255, 255, 0.8);
  }
  
  /* 音乐操作按钮容器 */
  .music-actions {
    margin-left: 15px;
  }
  
  /* 加载更多样式 */
  .loading-more {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
    color: #666;
  }
  
  .loading-spinner {
    font-size: 24px;
    margin-bottom: 10px;
    animation: spin 1s linear infinite; /* 旋转动画 */
  }
  
  /* 旋转动画定义 */
  @keyframes spin {
    from { transform: rotate(0deg); }
    to { transform: rotate(360deg); }
  }
  
  .loading-more p {
    margin: 0;
    font-size: 14px;
  }
  
  /* 没有更多数据样式 */
  .no-more-data {
    text-align: center;
    padding: 20px;
    color: #999;
    font-size: 14px;
  }
  
  .no-more-data p {
    margin: 0;
  }
  
  /* 滚动条样式优化（仅WebKit浏览器） */
  .music-list::-webkit-scrollbar {
    width: 6px;
  }
  
  .music-list::-webkit-scrollbar-track {
    background: #f1f1f1;
    border-radius: 3px;
  }
  
  .music-list::-webkit-scrollbar-thumb {
    background: #c1c1c1;
    border-radius: 3px;
  }
  
  .music-list::-webkit-scrollbar-thumb:hover {
    background: #a8a8a8;
  }
  
  /* Element Plus 按钮样式覆盖（局部作用域） */
  :deep(.el-button--primary) {
    background: linear-gradient(45deg, #667eea, #764ba2);
    border: none;
  }
  
  :deep(.el-button--primary:hover) {
    background: linear-gradient(45deg, #764ba2, #667eea);
  }
  
  :deep(.el-button--success) {
    background: linear-gradient(45deg, #56ab2f, #a8e6cf);
    border: none;
  }
  
  :deep(.el-button--success:hover) {
    background: linear-gradient(45deg, #a8e6cf, #56ab2f);
  }
  </style>