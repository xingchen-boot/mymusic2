<template>
    <div class="rank-container">
      <!-- 页面标题 -->
      <div class="page-header">
        <h1>🏆 音乐排行榜</h1>
        <p>发现最热门、最流行的音乐趋势</p>
      </div>
  
      <!-- 排行榜分类标签 -->
      <div class="rank-tabs">
        <el-radio-group v-model="activeTab" @change="handleTabChange">
          <el-radio-button label="hot">热歌榜</el-radio-button>
          <el-radio-button label="new">新歌榜</el-radio-button>
          <el-radio-button label="original">原创榜</el-radio-button>
          <el-radio-button label="global">全球榜</el-radio-button>
        </el-radio-group>
      </div>
  
      <!-- 排行榜列表 -->
      <div class="rank-list-container">
        <!-- 加载状态 -->
        <div v-if="loading" class="loading-state">
          <div class="spinner"></div>
          <p>正在加载排行榜数据...</p>
        </div>
  
        <!-- 错误状态 -->
        <div v-if="error" class="error-state">
          <p>😢 加载失败，请稍后重试</p>
          <el-button type="primary" size="small" @click="fetchRankData">重新加载</el-button>
        </div>
  
        <!-- 排行榜列表 -->
        <ul class="rank-list" v-else>
          <li 
            v-for="(song, index) in rankList" 
            :key="song.id" 
            class="rank-item"
            :class="{ top3: index < 3, hover: index >= 3 }"
            @click="playSong(song)"
          >
            <!-- 排名 -->
            <div class="rank-number">
              <span v-if="index < 3" class="top-number">{{ index + 1 }}</span>
              <span v-else>{{ index + 1 }}</span>
            </div>
  
            <!-- 歌曲信息 -->
            <div class="song-info">
              <div class="song-cover">
                <img :src="song.cover" :alt="song.name" />
                <div class="play-icon">▶</div>
              </div>
              <div class="song-detail">
                <h3 class="song-name">{{ song.name }}</h3>
                <p class="song-artist">{{ song.artist }}</p>
              </div>
            </div>
  
            <!-- 播放量/热度 -->
            <div class="song-hot">
              <span>{{ formatHotValue(song.hot) }}</span>
            </div>
          </li>
        </ul>
      </div>
  
      <!-- 分页 -->
      <div class="pagination" v-if="!loading && !error && rankList.length">
        <el-pagination
          layout="prev, pager, next"
          :total="totalCount"
          :page-size="pageSize"
          :current-page="currentPage"
          @current-change="handlePageChange"
        />
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, onMounted, computed } from 'vue'
  import { useMusicStore } from '@/stores/music'
  import { ElMessage } from 'element-plus'
  
  // 状态管理
  const musicStore = useMusicStore()
  
  // 排行榜状态
  const activeTab = ref('hot') // 当前激活的排行榜类型
  const rankList = ref([]) // 排行榜数据
  const loading = ref(true) // 加载状态
  const error = ref(false) // 错误状态
  
  // 分页相关
  const currentPage = ref(1)
  const pageSize = ref(20)
  const totalCount = ref(100)
  
  /**
   * 格式化热度值显示
   * @param value 热度值
   * @returns 格式化后的字符串
   */
  const formatHotValue = (value: number) => {
    if (value >= 10000) {
      return (value / 10000).toFixed(1) + '万'
    }
    return value.toString()
  }
  
  /**
   * 获取排行榜数据
   */
  const fetchRankData = async () => {
    loading.value = true
    error.value = false
    
    try {
      // 模拟API请求
      await new Promise(resolve => setTimeout(resolve, 800))
      
      // 生成模拟数据
      const mockData = Array.from({ length: pageSize.value }, (_, i) => ({
        id: `${activeTab.value}-${(currentPage.value - 1) * pageSize.value + i + 1}`,
        name: `${getTabName()}热门歌曲 ${(currentPage.value - 1) * pageSize.value + i + 1}`,
        artist: `歌手${Math.floor(Math.random() * 1000)}`,
        cover: `https://picsum.photos/100/100?random=${i + currentPage.value * 10}`,
        hot: Math.floor(Math.random() * 100000) + 1000
      }))
      
      rankList.value = mockData
    } catch (err) {
      console.error('获取排行榜数据失败:', err)
      error.value = true
      ElMessage.error('获取排行榜数据失败')
    } finally {
      loading.value = false
    }
  }
  
  /**
   * 获取当前标签页名称
   */
  const getTabName = () => {
    const tabNames = {
      hot: '热歌',
      new: '新歌',
      original: '原创',
      global: '全球'
    }
    return tabNames[activeTab.value] || '音乐'
  }
  
  /**
   * 处理标签页切换
   */
  const handleTabChange = () => {
    currentPage.value = 1 // 切换标签时重置到第一页
    fetchRankData()
  }
  
  /**
   * 处理分页变化
   */
  const handlePageChange = (page: number) => {
    currentPage.value = page
    fetchRankData()
  }
  
  /**
   * 播放选中的歌曲
   */
  const playSong = (song: any) => {
    // 调用音乐播放 store 播放歌曲
    musicStore.playMusic({
      id: song.id,
      song: song.name,
      singer: song.artist,
      cover: song.cover,
      url: `https://example.com/music/${song.id}.mp3` // 实际项目中替换为真实URL
    })
    ElMessage.success(`正在播放: ${song.name} - ${song.artist}`)
  }
  
  // 页面挂载时获取数据
  onMounted(() => {
    fetchRankData()
  })
  </script>
  
  <style scoped>
  .rank-container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 24px 16px;
  }
  
  .page-header {
    text-align: center;
    margin-bottom: 32px;
  }
  
  .page-header h1 {
    color: #2c3e50;
    font-size: 32px;
    margin-bottom: 12px;
    font-weight: 800;
  }
  
  .page-header p {
    color: #7f8c8d;
    font-size: 16px;
  }
  
  .rank-tabs {
    margin-bottom: 24px;
    display: flex;
    justify-content: center;
  }
  
  .rank-list-container {
    background: #fff;
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
    padding: 16px;
    margin-bottom: 24px;
  }
  
  /* 加载状态 */
  .loading-state {
    text-align: center;
    padding: 60px 0;
    color: #7f8c8d;
  }
  
  .spinner {
    width: 40px;
    height: 40px;
    margin: 0 auto 16px;
    border: 4px solid #f3f3f3;
    border-top: 4px solid #3498db;
    border-radius: 50%;
    animation: spin 1s linear infinite;
  }
  
  @keyframes spin {
    0% { transform: rotate(0deg); }
    100% { transform: rotate(360deg); }
  }
  
  /* 错误状态 */
  .error-state {
    text-align: center;
    padding: 60px 0;
    color: #7f8c8d;
  }
  
  .error-state p {
    margin-bottom: 16px;
    font-size: 16px;
  }
  
  /* 排行榜列表 */
  .rank-list {
    list-style: none;
    margin: 0;
    padding: 0;
  }
  
  .rank-item {
    display: flex;
    align-items: center;
    padding: 12px 16px;
    border-radius: 8px;
    cursor: pointer;
    transition: all 0.2s ease;
  }
  
  .rank-item.hover:hover {
    background-color: #f8f9fa;
  }
  
  .rank-item.top3 {
    background: linear-gradient(90deg, rgba(255,248,240,0.6) 0%, rgba(255,255,255,0) 100%);
  }
  
  /* 排名样式 */
  .rank-number {
    width: 48px;
    height: 48px;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 18px;
    font-weight: bold;
    color: #7f8c8d;
  }
  
  .top-number {
    width: 32px;
    height: 32px;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    border-radius: 50%;
    color: white;
  }
  
  .rank-item:nth-child(1) .top-number {
    background-color: #e74c3c;
  }
  
  .rank-item:nth-child(2) .top-number {
    background-color: #f39c12;
  }
  
  .rank-item:nth-child(3) .top-number {
    background-color: #f1c40f;
  }
  
  /* 歌曲信息 */
  .song-info {
    display: flex;
    align-items: center;
    flex: 1;
  }
  
  .song-cover {
    position: relative;
    width: 56px;
    height: 56px;
    margin-right: 16px;
  }
  
  .song-cover img {
    width: 100%;
    height: 100%;
    border-radius: 6px;
    object-fit: cover;
  }
  
  .play-icon {
    position: absolute;
    right: 4px;
    bottom: 4px;
    width: 24px;
    height: 24px;
    background-color: rgba(0, 0, 0, 0.6);
    color: white;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 12px;
    opacity: 0;
    transition: opacity 0.2s ease;
  }
  
  .rank-item:hover .play-icon {
    opacity: 1;
  }
  
  .song-detail {
    min-width: 0;
  }
  
  .song-name {
    margin: 0 0 4px 0;
    font-size: 16px;
    color: #2c3e50;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  .song-artist {
    margin: 0;
    font-size: 14px;
    color: #7f8c8d;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  /* 热度值 */
  .song-hot {
    color: #e74c3c;
    font-size: 14px;
    padding-right: 16px;
    display: flex;
    align-items: center;
  }
  
  /* 分页 */
  .pagination {
    display: flex;
    justify-content: center;
    padding: 16px 0;
  }
  
  /* 响应式调整 */
  @media (max-width: 768px) {
    .rank-item {
      padding: 8px 12px;
    }
    
    .song-hot {
      display: none;
    }
    
    .rank-number {
      width: 36px;
      height: 36px;
      font-size: 16px;
    }
    
    .song-cover {
      width: 48px;
      height: 48px;
    }
  }
  </style>
      