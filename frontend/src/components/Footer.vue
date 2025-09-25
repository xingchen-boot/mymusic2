<template>
    <footer class="footer" v-if="hasCurrentMusic">
      <div class="player-content">
        <!-- 当前播放歌曲信息 -->
        <div class="player-info">
          <router-link :to="{ name: 'player' }" class="cover-link">
            <img
              :src="currentMusic?.cover"
              :alt="currentMusic?.song"
              class="player-cover"
            />
          </router-link>
          <div class="player-details">
            <h4 class="song-title">{{ currentMusic?.song }}</h4>
            <p class="artist-name">{{ currentMusic?.singer }}</p>
          </div>
          <div class="player-actions">
            <el-button
              type="text"
              @click="toggleLike"
              class="like-btn"
              :class="{ liked: isLiked }"
            >
              {{ isLiked ? '❤️' : '🤍' }}
            </el-button>
          </div>
        </div>
  
        <!-- 播放控制 -->
        <div class="player-controls">
          <div class="control-buttons">
            <el-button type="text" @click="playPrevious" class="control-btn">
              ⏮️
            </el-button>
            <el-button
              type="primary"
              @click="togglePlay"
              class="play-btn"
              circle
            >
              {{ isPlaying ? '⏸️' : '▶️' }}
            </el-button>
            <el-button type="text" @click="playNext" class="control-btn">
              ⏭️
            </el-button>
          </div>
  
          <!-- 进度条 -->
          <div class="progress-section">
            <span class="time">{{ formatTime(currentTime) }}</span>
            <el-slider
              :model-value="progress"
              @input="setProgress"
              :show-tooltip="false"
              class="progress-slider"
            />
            <span class="time">{{ formatTime(duration) }}</span>
          </div>
        </div>
  
        <!-- 音量和其他控制 -->
        <div class="player-extra">
          <div class="volume-control">
            <el-button type="text" @click="toggleMute" class="volume-btn">
              {{ isMuted ? '🔇' : '🔊' }}
            </el-button>
            <el-slider
              :model-value="volume"
              @input="setVolume"
              :show-tooltip="false"
              class="volume-slider"
            />
          </div>
  
          <div class="extra-controls">
            <el-button type="text" @click="togglePlayMode" class="mode-btn">
              {{ playModeIcon }}
            </el-button>
            <el-button type="text" @click="togglePlaylist" class="playlist-btn">
              📋播放队列({{ queueCount }})
            </el-button>
          </div>
        </div>
      </div>
  
      <!-- 播放队列面板 -->
      <transition name="queue-panel">
        <div class="play-queue-panel" v-if="musicStore.showPlayQueue">
          <div class="queue-header">
            <h3>播放队列</h3>
            <div class="queue-actions">
              <el-button type="text" @click="musicStore.clearQueue">清空</el-button>
              <el-button type="text" @click="musicStore.togglePlayQueue">关闭</el-button>
            </div>
          </div>
          <div class="queue-list">
            <div 
              v-for="(item, index) in musicStore.queue" 
              :key="item.id || index" 
              class="queue-item"
              :class="{ current: index === musicStore.currentIndex }"
            >
              <div class="queue-number">{{ index + 1 }}</div>
              <img :src="item.cover" :alt="item.song" class="queue-cover" />
              <div class="queue-info">
                <div class="queue-title">{{ item.song }}</div>
                <div class="queue-artist">{{ item.singer }}</div>
              </div>
              <div class="queue-actions">
                <el-button 
                  type="text" 
                  class="play-btn" 
                  @click="musicStore.playByIndex(index)"
                >
                  {{ index === musicStore.currentIndex && isPlaying ? '⏸️' : '▶️' }}
                </el-button>
                <el-button 
                  type="text" 
                  class="remove-btn" 
                  @click="musicStore.removeFromQueue(index)"
                >
                  ❌
                </el-button>
              </div>
            </div>
            <div class="empty-queue" v-if="musicStore.queue.length === 0">
              <p>队列是空的</p>
              <p>添加歌曲到队列吧~</p>
            </div>
          </div>
        </div>
      </transition>
    </footer>
  </template>
  
  <script setup lang="ts">
  import { computed } from 'vue'
  import { useMusicStore } from '../stores/music'
  import { RouterLink } from 'vue-router'
  
  // 状态管理实例
  const musicStore = useMusicStore()
  
  // 计算属性 - 映射store状态
  const currentMusic = computed(() => musicStore.currentMusic)
  const isPlaying = computed(() => musicStore.isPlaying)
  const hasCurrentMusic = computed(() => musicStore.hasCurrentMusic)
  const currentTime = computed(() => musicStore.currentTime)
  const duration = computed(() => musicStore.duration)
  const progress = computed(() => musicStore.progress)
  const queueCount = computed(() => musicStore.queueCount)
  const volume = computed(() => musicStore.volume)
  const isMuted = computed(() => musicStore.isMuted)
  const playModeIcon = computed(() => musicStore.playModeIcon)
  const isLiked = computed(() => musicStore.isCurrentMusicLiked)
  
  // 播放控制方法
  const togglePlay = () => {
    musicStore.togglePlay()
  }
  
  const playPrevious = () => {
    musicStore.playPrevious()
  }
  
  const playNext = () => {
    musicStore.playNext()
  }
  
  // 进度控制方法
  const setProgress = async (value: number) => {
    await musicStore.setProgress(value)
  }
  
  // 音量控制方法
  const setVolume = async (value: number) => {
    await musicStore.setVolume(value)
  }
  
  const toggleMute = async () => {
    await musicStore.toggleMute()
  }
  
  // 其他控制方法
  const toggleLike = async () => {
    await musicStore.toggleFavorite()
  }
  
  const togglePlayMode = async () => {
    await musicStore.togglePlayMode()
  }
  
  const togglePlaylist = () => {
    musicStore.togglePlayQueue()
  }
  
  // 时间格式化工具函数
  const formatTime = (seconds: number) => {
    const mins = Math.floor(seconds / 60)
    const secs = Math.floor(seconds % 60)
    // 补零处理，确保格式为 "00:00"
    return `${mins.toString().padStart(2, '0')}:${secs.toString().padStart(2, '0')}`
  }
  </script>
  
  <style scoped>
  /* 底部播放器容器 */
  .footer {
    height: 80px;
    background: white;
    border-top: 1px solid #e0e0e0;
    box-shadow: 0 -2px 8px rgba(0, 0, 0, 0.1);
    position: sticky;
    bottom: 0;
    z-index: 1000;
  }
  
  /* 播放器内容容器 */
  .player-content {
    display: flex;
    align-items: center;
    height: 100%;
    max-width: 1200px;
    margin: 0 auto;
    padding: 0 20px;
    gap: 20px;
  }
  
  /* 歌曲信息区域 */
  .player-info {
    display: flex;
    align-items: center;
    min-width: 250px;
    gap: 12px;
  }
  
  .player-cover {
    width: 50px;
    height: 50px;
    border-radius: 6px;
    object-fit: cover;
  }
  
  .player-details {
    flex: 1;
    min-width: 0; /* 解决文本溢出问题 */
  }
  
  .song-title {
    font-size: 14px;
    font-weight: 500;
    margin: 0 0 4px 0;
    color: #333;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  .artist-name {
    font-size: 12px;
    color: #666;
    margin: 0;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  .player-actions {
    margin-left: 8px;
  }
  
  .like-btn {
    font-size: 16px;
    padding: 4px;
  }
  
  .like-btn.liked {
    color: #ff4757;
  }
  
  /* 播放控制区域 */
  .player-controls {
    flex: 1;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 0;
  }
  
  .control-buttons {
    display: flex;
    align-items: center;
    gap: 8px;
  }
  
  .control-btn {
    font-size: 18px;
    padding: 8px;
    color: #666;
  }
  
  .play-btn {
    width: 40px;
    height: 40px;
    font-size: 16px;
    background: linear-gradient(45deg, #667eea, #764ba2);
    border: none;
  }
  
  .play-btn:hover {
    background: linear-gradient(45deg, #764ba2, #667eea);
  }
  
  /* 进度条区域 */
  .progress-section {
    display: flex;
    align-items: center;
    gap: 12px;
    width: 100%;
    max-width: 400px;
  }
  
  .time {
    font-size: 12px;
    color: #666;
    min-width: 40px;
    text-align: center;
  }
  
  .progress-slider {
    flex: 1;
  }
  
  /* 音量与额外控制区域 */
  .player-extra {
    display: flex;
    align-items: center;
    gap: 15px;
    min-width: 200px;
  }
  
  .volume-control {
    display: flex;
    align-items: center;
    gap: 8px;
  }
  
  .volume-btn {
    font-size: 16px;
    padding: 4px;
    color: #666;
  }
  
  .volume-slider {
    width: 80px;
  }
  
  .extra-controls {
    display: flex;
    align-items: center;
    gap: 8px;
  }
  
  .mode-btn,
  .playlist-btn {
    font-size: 16px;
    padding: 4px;
    color: #666;
  }
  
  /* Element Plus 样式覆盖 */
  :deep(.el-button--text) {
    color: #666;
  }
  
  :deep(.el-button--text:hover) {
    color: #333;
  }
  
  :deep(.el-button--primary) {
    background: linear-gradient(45deg, #667eea, #764ba2);
    border: none;
  }
  
  :deep(.el-button--primary:hover) {
    background: linear-gradient(45deg, #764ba2, #667eea);
  }
  
  /* 播放队列面板样式 */
  .play-queue-panel {
    position: fixed;
    bottom: 80px;
    right: 20px;
    width: 400px;
    max-height: 500px;
    background: white;
    border-radius: 12px;
    box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
    z-index: 1000;
    overflow: hidden;
  }
  
  /* 队列面板过渡动画 */
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
  
  /* 队列面板头部 */
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
  
  /* 队列列表区域 */
  .queue-list {
    max-height: 400px;
    overflow-y: auto;
  }
  
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
  
  .queue-item.current {
    background-color: #e3f2fd;
    border-left: 3px solid #667eea;
  }
  
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
  
  .queue-cover {
    width: 40px;
    height: 40px;
    border-radius: 6px;
    object-fit: cover;
    margin-right: 12px;
  }
  
  .queue-info {
    flex: 1;
    min-width: 0;
  }
  
  .queue-title {
    font-size: 14px;
    font-weight: 500;
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
  
  /* 队列表项操作按钮 */
  .queue-actions {
    display: flex;
    gap: 4px;
    align-items: center;
  }
  
  .play-btn,
  .remove-btn {
    padding: 4px;
    font-size: 14px;
    color: #666;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  .remove-btn {
    margin-top: 2px;
  }
  
  .play-btn:hover {
    color: #667eea;
    background-color: rgba(102, 126, 234, 0.1);
    border-radius: 4px;
  }
  
  .remove-btn:hover {
    color: #ff4757;
    background-color: rgba(255, 71, 87, 0.1);
    border-radius: 4px;
  }
  
  /* 空队列提示 */
  .empty-queue {
    text-align: center;
    padding: 40px 20px;
    color: #999;
  }
  
  .empty-queue p {
    margin: 0;
    font-size: 14px;
  }
  
  /* 滑块样式覆盖 */
  :deep(.el-slider__runway) {
    background: #e0e0e0;
    height: 4px;
  }
  
  :deep(.el-slider__bar) {
    background: linear-gradient(45deg, #667eea, #764ba2);
    height: 4px;
  }
  
  :deep(.el-slider__button) {
    width: 12px;
    height: 12px;
    background: #667eea;
    border: 2px solid white;
  }
  
  /* 响应式设计 */
  @media (max-width: 768px) {
    .player-content {
      padding: 0 10px;
      gap: 10px;
    }
  
    .player-info {
      min-width: 180px;
    }
  
    .player-extra {
      min-width: 120px;
    }
  
    .volume-slider {
      width: 60px;
    }
  
    .progress-section {
      max-width: 200px;
    }
  }
  </style>
  