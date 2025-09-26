<template>
    <aside class="sidebar">
      <nav class="nav-menu">
        <div class="nav-section">
          <!-- 去掉分组标题“发现音乐” -->
          <ul class="nav-list">
            <li class="nav-item">
              <router-link 
                to="/" 
                class="nav-link" 
                :class="{ active: $route.name === 'home' }"
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
              >
                <span class="nav-icon">🏆</span>
                <span class="nav-text">排行榜</span>
              </router-link>
            </li>
          </ul>
        </div>
  
        <div class="nav-section">
          <!-- 去掉分组标题“我的音乐” -->
          <ul class="nav-list">
            <li class="nav-item">
              <router-link 
                to="/favorites" 
                class="nav-link" 
                :class="{ active: $route.name === 'favorites' }"
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
              <router-link to="/playlist/1" class="nav-link">
                <span class="nav-icon">🎶</span>
                <span class="nav-text">我的收藏</span>
              </router-link>
            </li>
            <li class="nav-item">
              <router-link to="/playlist/3" class="nav-link">
                <span class="nav-icon">🎹</span>
                <span class="nav-text">轻音乐</span>
              </router-link>
            </li>
          </ul>
        </div>
      </nav>
    </aside>
  </template>
  
  <script setup lang="ts">
  // 可以在这里添加逻辑，例如：
  // 1. 从状态管理中获取用户创建的歌单
  // 2. 处理动态导航逻辑
  // 3. 实现权限控制等功能
  </script>
  
  <style scoped>
  .sidebar {
    width: 240px;
    background: white;
    border-right: 1px solid #e0e0e0;
    height: 100%;
    overflow-y: auto;
    flex-shrink: 0;
  }
  
  .nav-menu {
    padding: 20px 0;
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
    padding: 12px 20px;
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
    font-size: 14px;
  }
  
  /* 滚动条样式 */
  .sidebar::-webkit-scrollbar {
    width: 6px;
  }
  
  .sidebar::-webkit-scrollbar-track {
    background: #f1f1f1;
  }
  
  .sidebar::-webkit-scrollbar-thumb {
    background: #c1c1c1;
    border-radius: 3px;
  }
  
  .sidebar::-webkit-scrollbar-thumb:hover {
    background: #a8a8a8;
  }
  
  /* 响应式设计 */
  @media (max-width: 768px) {
    .sidebar {
      width: 200px;
    }
  
    .nav-text {
      font-size: 13px;
    }
  
    .nav-icon {
      font-size: 16px;
      margin-right: 10px;
    }
  }
  </style>