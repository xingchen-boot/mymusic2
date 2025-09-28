<template>
    <div class="favorites">
      <div class="favorites-header">
        <div class="header-left">
          <h1>❤️我喜欢的</h1>
          <p v-if="favorites.length > 0">共{{ favorites.length }}首音乐</p>
        </div>
  
        <div class="header-right" v-if="favorites.length > 0">
          <div class="play-options">
            <el-switch
              v-model="playFromFavorites"
              active-text="播放我喜欢的"
              inactive-text="播放队列"
              @change="onPlayModeChange"
            />
          </div>
        </div>
      </div>
  
      <div v-if="isLoading" class="loading">
        <div v-loading="true" element-loading-text="加载中...">
          <div style="height: 200px;"></div>
        </div>
      </div>
  
      <div v-else-if="favorites.length === 0" class="empty-state">
        <div class="empty-icon">🎵</div>
        <h3>还没有喜欢的音乐</h3>
        <p>去发现一些好听的音乐吧！</p>
      </div>
  
      <div v-else class="favorites-list">
        <div
          v-for="(favorite, index) in favorites"
          :key="favorite.id"
          class="favorite-item"
          :class="{'current-playing': currentMusic?.id === parseInt(favorite.musicId)}"
        >
          <div class="item-number">{{ index + 1 }}</div>
  
          <div class="item-cover">
            <img :src="favorite.musicCover" :alt="favorite.musicSong" />
            <div class="play-overlay" @click="playFavorite(favorite)">
              <span class="play-icon">{{ currentMusic?.id === parseInt(favorite.musicId) && isPlaying ? '⏸️' : '▶️' }}</span>
            </div>
          </div>
  
          <div class="item-info">
            <h4 class="song-title">{{ favorite.musicSong }}</h4>
            <p class="artist-name">{{ favorite.musicSinger }}</p>
          </div>
  
          <div class="item-actions">
            <el-button
              type="text"
              @click="removeFavorite(favorite)"
              class="remove-btn"
              title="取消收藏"
            >
              ❤️
            </el-button>
            <el-button
              type="text"
              @click="downloadFavorite(favorite)"
              class="download-btn"
              title="下载"
            >
              ⬇️
            </el-button>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, computed, onMounted, onUnmounted } from 'vue'
  import { useMusicStore } from '../stores/music'
  import { useUserStore } from '../stores/user'
  
  const musicStore = useMusicStore()
  const userStore = useUserStore()
  
  // 响应式数据
  const favorites = ref<any[]>([])
  const isLoading = ref(false)
  const playFromFavorites = ref(false) // 是否在收藏页面播放
  
  // 计算属性
  const currentMusic = computed(() => musicStore.currentMusic)
  const isPlaying = computed(() => musicStore.isPlaying)
  
  // 方法
  const loadFavorites = async () => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌用户未登录，无法加载收藏列表')
      return
    }
  
    isLoading.value = true
    try {
      const response = await fetch(`/api/user-favorites/user/${userStore.currentUser.id}`)
      const result = await response.json()
  
      if (response.ok && result.code === 200) {
        favorites.value = result.data
        console.log('✅收藏列表加载成功，共', result.data.length, '首音乐')
      } else {
        console.error('❌收藏列表加载失败:', result.message)
        favorites.value = []
      }
    } catch (error) {
      console.error('❌收藏列表加载错误:', error)
      favorites.value = []
    } finally {
      isLoading.value = false
    }
  }
  
  const playFavorite = async (favorite: any) => {
    const music = {
      id: parseInt(favorite.musicId),
      mid: favorite.musicMid,
      song: favorite.musicSong,
      singer: favorite.musicSinger,
      album: favorite.musicAlbum || '',
      cover: favorite.musicCover || '',
      time: favorite.musicTime || '',
      pay: favorite.musicPay || ''
    }
  
    // 直接播放音乐（会添加到播放队列）
    await musicStore.playMusic(music)
  }
  
  
  // 播放模式改变
  const onPlayModeChange = async (value: boolean) => {
    console.log('播放模式改变:', value ? '播放我喜欢的' : '播放队列')
  
    if (value) {
      // 开启临时播放模式-切换到播放我喜欢的
      try {
        await musicStore.switchToTempPlayMode(favorites.value)
        const { ElMessage } = await import('element-plus')
        ElMessage.success('已切换到播放我喜欢的音乐')
      } catch (error) {
        console.error('切换播放模式失败:', error)
        const { ElMessage } = await import('element-plus')
        ElMessage.error('切换播放模式失败')
        // 切换失败时，将开关状态重置
        playFromFavorites.value = false
      }
    } else {
      // 关闭临时播放模式-恢复原始播放队列
      try {
        await musicStore.restoreOriginalPlayQueue()
        const { ElMessage } = await import('element-plus')
        ElMessage.success('已恢复到原始播放队列')
      } catch (error) {
        console.error('切换播放模式失败:', error)
        const { ElMessage } = await import('element-plus')
        ElMessage.error('切换播放模式失败')
        // 切换失败时，将开关状态重置
        playFromFavorites.value = true
      }
    }
  }
  
  
  const removeFavorite = async (favorite: any) => {
    if (!userStore.isLoggedIn || !userStore.currentUser) {
      console.log('❌用户未登录，无法取消收藏')
      return
    }
  
    try {
      const response = await fetch(`/api/user-favorites/remove?userId=${userStore.currentUser.id}&musicId=${favorite.musicId}`, {
        method: 'DELETE'
      })
      const result = await response.json()
  
      if (response.ok && result.code === 200) {
        // 从本地列表中移除
        const index = favorites.value.findIndex(item => item.id === favorite.id)
        if (index > -1) {
          favorites.value.splice(index, 1)
        }
  
        // 如果当前播放的音乐被取消收藏，更新收藏状态
        if (currentMusic.value?.id === parseInt(favorite.musicId)) {
          await musicStore.checkCurrentMusicFavoriteStatus()
        }
  
        console.log('✅取消收藏成功')
  
        // 显示提示
        const { ElMessage } = await import('element-plus')
        ElMessage.success('已取消收藏')
      } else {
        console.error('❌取消收藏失败:', result.message)
      }
    } catch (error) {
      console.error('❌取消收藏错误:', error)
    }
  }
  
  const downloadFavorite = async (favorite: any) => {
    const music = {
      id: parseInt(favorite.musicId),
      mid: favorite.musicMid,
      song: favorite.musicSong,
      singer: favorite.musicSinger,
      album: favorite.musicAlbum || '',
      cover: favorite.musicCover || '',
      time: favorite.musicTime || '',
      pay: favorite.musicPay || ''
    }
  
    try {
      await musicStore.downloadMusic(music)
    } catch (error) {
      console.error('下载失败:', error)
    }
  }
  
  // 收藏状态变化监听器
  const onFavoriteStatusChange = (isLiked: boolean) => {
    // 如果当前播放的音乐被取消收藏，从收藏列表中移除
    if (!isLiked && currentMusic.value) {
      const index = favorites.value.findIndex(item => parseInt(item.musicId) === currentMusic.value?.id)
      if (index > -1) {
        favorites.value.splice(index, 1)
      }
    }
    // 如果当前播放的音乐被添加收藏，重新加载收藏列表
    else if (isLiked && currentMusic.value) {
      loadFavorites()
    }
  }
  
  // 生命周期
  onMounted(() => {
    loadFavorites()
  
    // 添加收藏状态监听器
    musicStore.addFavoriteStatusListener(onFavoriteStatusChange)
  })
  
  // 组件卸载时移除监听器
  onUnmounted(() => {
    musicStore.removeFavoriteStatusListener(onFavoriteStatusChange)
    // 如果还在临时播放模式，自动恢复原始播放队列
    if (musicStore.isInTempPlayMode) {
      musicStore.restoreOriginalPlayQueue()
    }
  })
  </script>
  
  <style scoped>
  .favorites {
    padding: 20px;
    max-width: 1200px;
    margin: 0 auto;
  }
  
  .favorites-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 30px;
    padding: 20px;
    background: white;
    border-radius: 12px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  }
  
  .header-left {
    text-align: left;
  }
  
  .header-left h1 {
    color: #333;
    margin-bottom: 8px;
    font-size: 28px;
  }
  
  .header-left p {
    color: #666;
    font-size: 14px;
    margin: 0;
  }
  
  .header-right {
    display: flex;
    align-items: center;
    gap: 20px;
  }
  
  .play-options {
    display: flex;
    align-items: center;
  }
  
  .loading {
    text-align: center;
    padding: 40px;
  }
  
  .empty-state {
    text-align: center;
    padding: 60px 20px;
    color: #999;
  }
  
  .empty-icon {
    font-size: 64px;
    margin-bottom: 20px;
  }
  
  .empty-state h3 {
    margin: 0 0 10px 0;
    color: #666;
  }
  
  .empty-state p {
    margin: 0;
    font-size: 14px;
  }
  
  .favorites-list {
    display: flex;
    flex-direction: column;
    gap: 12px;
  }
  
  .favorite-item {
    display: flex;
    align-items: center;
    padding: 12px 16px;
    background: white;
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    transition: all 0.2s ease;
    border: 2px solid transparent;
  }
  
  .favorite-item:hover {
    transform: translateY(-2px);
    box-shadow: 0 4px 16px rgba(0, 0, 0, 0.15);
  }
  
  .favorite-item.current-playing {
    border-color: #667eea;
    background: linear-gradient(135deg, #f8f9ff 0%, #e3f2fd 100%);
  }
  
  .item-number {
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
    margin-right: 16px;
  }
  
  .favorite-item.current-playing .item-number {
    background: #667eea;
    color: white;
  }
  
  .item-cover {
    position: relative;
    width: 50px;
    height: 50px;
    margin-right: 16px;
    border-radius: 8px;
    overflow: hidden;
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
    transition: opacity 0.2s ease;
    cursor: pointer;
  }
  
  .item-cover:hover .play-overlay {
    opacity: 1;
  }
  
  .play-icon {
    font-size: 18px;
    color: white;
  }
  
  .item-info {
    flex: 1;
    min-width: 0;
    text-align: left;
  }
  
  .song-title {
    font-size: 16px;
    font-weight: 500;
    color: #333;
    margin: 0 0 4px 0;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  .artist-name {
    font-size: 14px;
    color: #666;
    margin: 0;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  .item-actions {
    display: flex;
    gap: 8px;
    align-items: center;
  }
  
  .remove-btn, .download-btn {
    padding: 8px;
    font-size: 16px;
    color: #666;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 6px;
    transition: all 0.2s ease;
  }
  
  .remove-btn:hover {
    color: #ff4757;
    background-color: rgba(255, 71, 87, 0.1);
  }
  
  .download-btn:hover {
    color: #667eea;
    background-color: rgba(102, 126, 234, 0.1);
  }
  
  /* Element Plus样式覆盖 */
  :deep(.el-button--text) {
    color: #666;
  }
  
  :deep(.el-button--text:hover) {
    color: #333;
  }
  
  /* 响应式设计 */
  @media (max-width: 768px) {
    .favorites {
      padding: 15px;
    }

    .favorites-header {
      flex-direction: column;
      gap: 8px;
      text-align: center;
      padding: 12px 16px;
      margin-bottom: 20px;
    }

    .header-left h1 {
      font-size: 22px;
      margin-bottom: 4px;
    }

    .header-left p {
      font-size: 12px;
      margin-top: 2px;
      margin-left: 30px;
    }

    .header-right {
      flex-direction: column;
      gap: 8px;
    }
  
    .favorite-item {
      padding: 10px 12px;
    }
  
    .item-cover {
      width: 40px;
      height: 40px;
      margin-right: 12px;
    }
  
    .song-title {
      font-size: 14px;
    }
  
    .artist-name {
      font-size: 12px;
    }
  
    .item-actions {
      gap: 4px;
    }
  
    .remove-btn, .download-btn {
      padding: 6px;
      font-size: 14px;
    }
  }
  </style>
  