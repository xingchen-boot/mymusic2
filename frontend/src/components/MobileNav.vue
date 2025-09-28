<template>
  <div class="mobile-nav">
    <!-- 汉堡菜单按钮 -->
    <el-button
      type="text"
      class="hamburger-btn"
      @click="toggleDrawer"
    >
      <span class="hamburger-icon" :class="{ active: isDrawerOpen }">
        <span></span>
        <span></span>
        <span></span>
      </span>
    </el-button>

    <!-- 抽屉式导航 -->
    <el-drawer
      v-model="isDrawerOpen"
      :with-header="false"
      direction="ltr"
      size="280px"
      class="mobile-drawer"
    >
      <div class="drawer-content">
        <!-- Logo区域 -->
        <div class="drawer-header">
          <div class="logo">
            <span class="logo-icon">🎵</span>
            <span class="logo-text">MyMusic</span>
          </div>
          <el-button
            type="text"
            class="close-btn"
            @click="closeDrawer"
          >
            ✕
          </el-button>
        </div>

        <!-- 导航菜单 -->
        <nav class="drawer-nav">
          <div class="nav-section">
            <ul class="nav-list">
              <li class="nav-item">
                <router-link 
                  to="/" 
                  class="nav-link" 
                  :class="{ active: $route.name === 'home' }"
                  @click="closeDrawer"
                >
                  <span class="nav-icon">🏠</span>
                  <span class="nav-text">首页</span>
                </router-link>
              </li>
              <li class="nav-item">
                <router-link 
                  to="/playlist" 
                  class="nav-link" 
                  :class="{ active: $route.name === 'playlist' }"
                  @click="closeDrawer"
                >
                  <span class="nav-icon">📋</span>
                  <span class="nav-text">歌单</span>
                </router-link>
              </li>
              <li class="nav-item">
                <router-link 
                  to="/rank" 
                  class="nav-link" 
                  :class="{ active: $route.name === 'rank' }"
                  @click="closeDrawer"
                >
                  <span class="nav-icon">🏆</span>
                  <span class="nav-text">排行榜</span>
                </router-link>
              </li>
            </ul>
          </div>

          <div class="nav-section">
            <ul class="nav-list">
              <li class="nav-item">
                <router-link 
                  to="/favorites" 
                  class="nav-link" 
                  :class="{ active: $route.name === 'favorites' }"
                  @click="closeDrawer"
                >
                  <span class="nav-icon">❤️</span>
                  <span class="nav-text">我喜欢的</span>
                </router-link>
              </li>
              <li class="nav-item">
                <router-link 
                  to="/recent" 
                  class="nav-link" 
                  :class="{ active: $route.name === 'recent' }"
                  @click="closeDrawer"
                >
                  <span class="nav-icon">🕒</span>
                  <span class="nav-text">最近播放</span>
                </router-link>
              </li>
            </ul>
          </div>

          <div class="nav-section">
            <h3 class="nav-title">创建的歌单</h3>
            <ul class="nav-list">
              <li class="nav-item">
                <router-link to="/playlist/1" class="nav-link" @click="closeDrawer">
                  <span class="nav-icon">🎶</span>
                  <span class="nav-text">我的收藏</span>
                </router-link>
              </li>
              <li class="nav-item">
                <router-link to="/playlist/3" class="nav-link" @click="closeDrawer">
                  <span class="nav-icon">🎹</span>
                  <span class="nav-text">轻音乐</span>
                </router-link>
              </li>
            </ul>
          </div>
        </nav>

        <!-- 用户信息区域 -->
        <div class="drawer-footer">
          <div v-if="!userStore.isLoggedIn" class="login-section">
            <el-button 
              type="primary" 
              @click="goToLogin" 
              class="login-btn"
              block
            >
              登录
            </el-button>
          </div>
          <div v-else class="user-info">
            <div class="user-avatar">
              <img 
                :src="userStore.currentUser?.avatar || 'https://picsum.photos/40/40?random=1'" 
                :alt="userStore.currentUser?.nickname"
              />
            </div>
            <div class="user-details">
              <div class="user-nickname">{{ userStore.currentUser?.nickname || '用户' }}</div>
              <div class="user-email">{{ userStore.currentUser?.email || '' }}</div>
            </div>
          </div>
        </div>
      </div>
    </el-drawer>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useUserStore } from '../stores/user'

const router = useRouter()
const userStore = useUserStore()

const isDrawerOpen = ref(false)

const toggleDrawer = () => {
  isDrawerOpen.value = !isDrawerOpen.value
}

const closeDrawer = () => {
  isDrawerOpen.value = false
}

const goToLogin = () => {
  closeDrawer()
  router.push('/login')
}
</script>

<style scoped>
.mobile-nav {
  display: none;
}

.hamburger-btn {
  padding: 8px;
  color: #333;
  font-size: 18px;
}

.hamburger-icon {
  display: flex;
  flex-direction: column;
  width: 20px;
  height: 16px;
  position: relative;
  transition: all 0.3s ease;
}

.hamburger-icon span {
  display: block;
  height: 2px;
  width: 100%;
  background: #333;
  border-radius: 1px;
  position: absolute;
  transition: all 0.3s ease;
}

.hamburger-icon span:nth-child(1) {
  top: 0;
}

.hamburger-icon span:nth-child(2) {
  top: 50%;
  transform: translateY(-50%);
}

.hamburger-icon span:nth-child(3) {
  bottom: 0;
}

.hamburger-icon.active span:nth-child(1) {
  top: 50%;
  transform: translateY(-50%) rotate(45deg);
}

.hamburger-icon.active span:nth-child(2) {
  opacity: 0;
}

.hamburger-icon.active span:nth-child(3) {
  bottom: 50%;
  transform: translateY(50%) rotate(-45deg);
}

/* 抽屉样式 */
.mobile-drawer {
  --el-drawer-bg-color: #fff;
}

.drawer-content {
  height: 100%;
  display: flex;
  flex-direction: column;
}

.drawer-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 20px;
  border-bottom: 1px solid #f0f0f0;
}

.logo {
  display: flex;
  align-items: center;
  gap: 8px;
}

.logo-icon {
  font-size: 24px;
}

.logo-text {
  font-size: 20px;
  font-weight: bold;
  color: #667eea;
}

.close-btn {
  font-size: 18px;
  color: #666;
  padding: 4px;
}

.drawer-nav {
  flex: 1;
  padding: 20px 0;
  overflow-y: auto;
}

.nav-section {
  margin-bottom: 30px;
}

.nav-title {
  font-size: 14px;
  color: #999;
  margin: 0 0 15px 20px;
  font-weight: 500;
  text-transform: uppercase;
  letter-spacing: 1px;
}

.nav-list {
  list-style: none;
  margin: 0;
  padding: 0;
}

.nav-item {
  margin: 0;
}

.nav-link {
  display: flex;
  align-items: center;
  padding: 16px 20px;
  color: #666;
  text-decoration: none;
  transition: all 0.3s ease;
  border-left: 3px solid transparent;
}

.nav-link:hover {
  background: #f8f9fa;
  color: #333;
}

.nav-link.active {
  background: linear-gradient(90deg, rgba(102, 126, 234, 0.1), transparent);
  color: #667eea;
  border-left-color: #667eea;
  font-weight: 500;
}

.nav-icon {
  font-size: 18px;
  margin-right: 12px;
  width: 20px;
  text-align: center;
}

.nav-text {
  font-size: 16px;
}

.drawer-footer {
  padding: 20px;
  border-top: 1px solid #f0f0f0;
}

.login-btn {
  background: linear-gradient(45deg, #667eea, #764ba2);
  border: none;
  border-radius: 8px;
  padding: 12px;
  font-weight: 500;
}

.user-info {
  display: flex;
  align-items: center;
  gap: 12px;
}

.user-avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  overflow: hidden;
}

.user-avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.user-details {
  flex: 1;
}

.user-nickname {
  font-size: 16px;
  font-weight: 500;
  color: #333;
  margin-bottom: 2px;
}

.user-email {
  font-size: 14px;
  color: #666;
}

/* 移动端显示 */
@media (max-width: 768px) {
  .mobile-nav {
    display: block;
  }
}

/* 滚动条样式 */
.drawer-nav::-webkit-scrollbar {
  width: 4px;
}

.drawer-nav::-webkit-scrollbar-track {
  background: #f1f1f1;
}

.drawer-nav::-webkit-scrollbar-thumb {
  background: #c1c1c1;
  border-radius: 2px;
}

.drawer-nav::-webkit-scrollbar-thumb:hover {
  background: #a8a8a8;
}
</style>
