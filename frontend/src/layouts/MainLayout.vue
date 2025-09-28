<template>
  <div class="main-layout">
    <!-- 顶部导航栏 -->
    <Header />
    
    <div class="content-wrapper">
      <!-- 侧边栏 - 桌面端显示 -->
      <Sidebar class="desktop-sidebar" />
      
      <!-- 主内容区域 -->
      <div class="content-area">
        <Container />
      </div>
    </div>
    
    <!-- 底部播放器 -->
    <Footer />
    
    <!-- 移动端底部导航栏 -->
    <MobileBottomNav :class="{ 'has-player': musicStore.hasCurrentMusic }" />
    
    <!-- 播放队列面板 -->
    <transition name="queue-panel">
      <div v-if="musicStore.showPlayQueue" class="play-queue-panel">
        <div class="queue-header">
          <h3>播放队列 ({{ musicStore.queueCount }})</h3>
          <div class="queue-actions">
            <el-button type="text" @click="musicStore.clearPlayQueueWithSync" size="small">
              清空队列
            </el-button>
            <el-button type="text" @click="musicStore.togglePlayQueue" size="small">
              ✕
            </el-button>
          </div>
        </div>
        
        <div class="queue-list">
          <div
            v-for="(music, index) in musicStore.playQueue"
            :key="music.id"
            class="queue-item"
            :class="{ 'current': musicStore.currentMusic?.id === music.id }"
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

          <div v-if="musicStore.queueCount === 0" class="empty-queue">
            <p>播放队列为空</p>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script setup lang="ts">
import { onMounted } from 'vue'
import { useMusicStore } from '@/stores/music'
import { useUserStore } from '@/stores/user'
import Header from '@/components/Header.vue'
import Sidebar from '@/components/Sidebar.vue'
import Container from '@/components/Container.vue'
import Footer from '@/components/Footer.vue'
import MobileBottomNav from '@/components/MobileBottomNav.vue'

const musicStore = useMusicStore()
const userStore = useUserStore()

onMounted(async () => {
  // 初始化用户信息（全局唯一初始化迁移至main.ts）
  await userStore.initUserInfo()
})
</script>

<style scoped>
.main-layout {
  height: 100vh;
  display: flex;
  flex-direction: column;
}

.content-wrapper {
  display: flex;
  flex: 1;
  overflow: hidden;
}

.content-area {
  flex: 1;
  overflow-y: auto;
  padding: 20px;
  background: #f5f5f5;
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
  font-weight: 500;
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

.queue-actions {
  display: flex;
  gap: 4px;
  align-items: center;
}

.play-btn,
.remove-btn {
  padding: 4px 8px;
  border-radius: 4px;
}

.empty-queue {
  text-align: center;
  padding: 40px 20px;
  color: #999;
}

.empty-queue p {
  margin: 0;
  font-size: 14px;
}

/* 移动端隐藏侧边栏 */
@media (max-width: 768px) {
  .desktop-sidebar {
    display: none;
  }
  
  .content-area {
    padding: 16px;
    padding-bottom: 120px; /* 为底部播放器和导航栏留出空间 */
  }
}
</style>
