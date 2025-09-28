<template>
  <div class="mobile-bottom-nav">
    <div class="nav-item" :class="{ active: $route.name === 'home' }">
      <router-link to="/" class="nav-link">
        <span class="nav-icon">🏠</span>
        <span class="nav-text">首页</span>
      </router-link>
    </div>
    
    <div class="nav-item" :class="{ active: $route.name === 'playlist' }">
      <router-link to="/playlist" class="nav-link">
        <span class="nav-icon">📋</span>
        <span class="nav-text">歌单</span>
      </router-link>
    </div>
    
    <div class="nav-item" :class="{ active: $route.name === 'rank' }">
      <router-link to="/rank" class="nav-link">
        <span class="nav-icon">🏆</span>
        <span class="nav-text">排行榜</span>
      </router-link>
    </div>
    
    <div class="nav-item" :class="{ active: $route.name === 'favorites' }">
      <router-link to="/favorites" class="nav-link">
        <span class="nav-icon">❤️</span>
        <span class="nav-text">喜欢</span>
      </router-link>
    </div>
    
    <div class="nav-item" :class="{ active: $route.name === 'player' }">
      <router-link to="/player" class="nav-link">
        <span class="nav-icon">🎵</span>
        <span class="nav-text">播放</span>
      </router-link>
    </div>
  </div>
</template>

<script setup lang="ts">
// 移动端底部导航栏组件
</script>

<style scoped>
.mobile-bottom-nav {
  display: none;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  height: 60px;
  background: white;
  border-top: 1px solid #e0e0e0;
  box-shadow: 0 -2px 8px rgba(0, 0, 0, 0.1);
  z-index: 1001;
  padding-bottom: env(safe-area-inset-bottom);
}

.nav-item {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
}

.nav-link {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-decoration: none;
  color: #666;
  transition: all 0.3s ease;
  padding: 8px 4px;
  min-height: 44px;
  width: 100%;
}

.nav-link:hover {
  color: #667eea;
}

.nav-item.active .nav-link {
  color: #667eea;
}

.nav-icon {
  font-size: 20px;
  margin-bottom: 2px;
}

.nav-text {
  font-size: 10px;
  font-weight: 500;
}

/* 移动端显示 */
@media (max-width: 768px) {
  .mobile-bottom-nav {
    display: flex;
  }
}

/* 当有底部播放器时调整位置 - 已移除bottom属性 */
</style>

