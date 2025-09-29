<template>
    <header class="header">
      <div class="header-content">
        <!-- 移动端汉堡菜单 -->
        <MobileNav />
        
        <!-- Logo -->
        <div class="logo">
          <router-link to="/" class="logo-link">
            <span class="logo-icon">🎵</span>
            <span class="logo-text">MyMusic</span>
          </router-link>
        </div>
  
        <!-- 搜索框 -->
        <div class="search-container">
          <!-- 桌面端搜索框 -->
          <el-input
            v-model="searchKeyword"
            placeholder="搜索歌曲、歌手、专辑..."
            size="large"
            @keyup.enter="handleSearch"
            @input="handleInput"
            @focus="showSuggestions = true"
            @blur="hideSuggestions"
            clearable
            class="search-input desktop-search"
            ref="searchInputRef"
          >
            <template #suffix>
              <span class="search-icon" @click="handleSearch">🔍</span>
            </template>
          </el-input>
          
          <!-- 移动端搜索按钮 -->
          <MobileSearch />
  
          <!-- 搜索建议下拉框 -->
          <div 
            v-if="showSuggestions && (suggestions.length > 0 || searchHistory.length > 0)" 
            class="suggestions-dropdown"
          >
            <!-- 搜索历史 -->
            <div v-if="searchHistory.length > 0 && !searchKeyword" class="suggestions-section">
              <div class="suggestions-header">
                <span class="suggestions-title">搜索历史</span>
                <el-button type="text" size="small" @click="clearHistory">清除</el-button>
              </div>
              <div class="suggestions-list">
                <div
                  v-for="(item, index) in searchHistory"
                  :key="`history-${index}`"
                  class="suggestion-item"
                  @click="selectSuggestion(item)"
                >
                  <span class="suggestion-icon">🕒</span>
                  <span class="suggestion-text">{{ item }}</span>
                </div>
              </div>
            </div>
  
            <!-- 搜索建议 -->
            <div v-if="suggestions.length > 0" class="suggestions-section">
              <div class="suggestions-header">
                <span class="suggestions-title">搜索建议</span>
              </div>
              <div class="suggestions-list">
                <div
                  v-for="(suggestion, index) in suggestions"
                  :key="`suggestion-${index}`"
                  class="suggestion-item"
                  @click="selectSuggestion(suggestion.text)"
                >
                  <span class="suggestion-icon">{{ suggestion.icon }}</span>
                  <span class="suggestion-text">{{ suggestion.text }}</span>
                  <span class="suggestion-type">{{ suggestion.type }}</span>
                </div>
              </div>
            </div>
          </div>
        </div>
  
        <!-- 用户区域 -->
        <div class="user-area">
          <div v-if="!userStore.isLoggedIn" class="login-section">
            <el-button type="primary" @click="goToLogin" class="login-btn">
              登录
            </el-button>
          </div>
  
          <div v-else class="user-info">
            <el-dropdown :trigger="dropdownTrigger" @command="handleUserCommand">
              <div class="user-trigger">
                <div class="user-avatar">
                  <img 
                    :src="userStore.currentUser?.avatar || 'https://picsum.photos/40/40?random=1'" 
                    :alt="userStore.currentUser?.nickname"
                  />
                </div>
                <span class="user-nickname">{{ userStore.currentUser?.nickname || '用户' }}</span>
              </div>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item command="profile">个人中心</el-dropdown-item>
                  <el-dropdown-item command="playlist">我的歌单</el-dropdown-item>
                  <el-dropdown-item command="settings">设置</el-dropdown-item>
                  <el-dropdown-item command="logout" divided>退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
  
            <!-- 播放队列按钮 -->
            <div class="play-queue-btn">
              <el-button
                type="text"
                @click="togglePlayQueue"
                class="queue-button"
                :class="{'has-queue': musicStore.queueCount > 0}"
              >
                <span class="queue-icon">📋</span>
                <span class="queue-text">播放队列</span>
                <span v-if="musicStore.queueCount > 0" class="queue-count">({{ musicStore.queueCount }})</span>
              </el-button>
            </div>
          </div>
        </div>
      </div>
    </header>
  </template>
  
  <script setup lang="ts">
  import { ref, computed, onMounted } from 'vue'
  import { useRouter } from 'vue-router'
  import { useMusicStore } from '@/stores/music'
  import { useUserStore } from '@/stores/user'
  import { getDeviceType } from '@/utils/mobile'
  import MobileNav from './MobileNav.vue'
  import MobileSearch from './MobileSearch.vue'
  
  const router = useRouter()
  const musicStore = useMusicStore()
  const userStore = useUserStore()
  // 根据设备类型切换下拉触发方式：移动端使用 click，桌面端使用 hover
  const dropdownTrigger = computed(() => (getDeviceType() === 'mobile' ? 'click' : 'hover'))
  
  // 响应式数据
  const searchKeyword = ref('')
  const showSuggestions = ref(false)
  const searchInputRef = ref<HTMLElement | null>(null)
  let inputTimer: NodeJS.Timeout | null = null
  
  // 计算属性
  const searchHistory = computed(() => musicStore.searchHistory)
  const suggestions = computed(() => {
    if (!musicStore.searchSuggestions) return []
  
    const result: Array<{ text: string; icon: string; type: string }> = []
  
    // 处理歌曲建议
    if (musicStore.searchSuggestions.song?.itemlist) {
      musicStore.searchSuggestions.song.itemlist.forEach((item: any) => {
        result.push({
          text: `${item.name}-${item.singer}`,
          icon: '🎵',
          type: '歌曲'
        })
      })
    }
  
    // 处理歌手建议
    if (musicStore.searchSuggestions.singer?.itemlist) {
      musicStore.searchSuggestions.singer.itemlist.forEach((item: any) => {
        result.push({
          text: item.name,
          icon: '👤',
          type: '歌手'
        })
      })
    }
  
    // 处理专辑建议
    if (musicStore.searchSuggestions.album?.itemlist) {
      musicStore.searchSuggestions.album.itemlist.forEach((item: any) => {
        result.push({
          text: `${item.name}-${item.singer}`,
          icon: '💿',
          type: '专辑'
        })
      })
    }
  
    return result.slice(0, 8) // 限制显示数量
  })
  
  // 方法
  const handleSearch = () => {
    const keyword = searchKeyword.value.trim()
    if (keyword) {
      // 添加到搜索历史
      musicStore.addSearchHistory(keyword)
  
      // 跳转到搜索结果页面
      router.push({
        name: 'search',
        query: { keyword }
      })
  
      // 隐藏建议框
      showSuggestions.value = false
    }
  }
  
  const handleInput = () => {
    // 防抖处理
    if (inputTimer) {
      clearTimeout(inputTimer)
    }
  
    inputTimer = setTimeout(() => {
      const keyword = searchKeyword.value.trim()
      if (keyword) {
        musicStore.getSearchSuggestions(keyword)
      } else {
        musicStore.searchSuggestions = null
      }
    }, 300)
  }
  
  const selectSuggestion = (text: string) => {
    searchKeyword.value = text
    showSuggestions.value = false
    handleSearch()
  }
  
  const hideSuggestions = () => {
    // 延迟隐藏，让点击事件先执行
    setTimeout(() => {
      showSuggestions.value = false
    }, 200)
  }
  
  const clearHistory = () => {
    musicStore.clearSearchHistory()
  }
  
  const goToLogin = () => {
    router.push('/login')
  }
  
  // 切换播放队列显示
  const togglePlayQueue = () => {
    musicStore.togglePlayQueue()
  }
  
  const handleUserCommand = (command: string) => {
    switch (command) {
      case 'profile':
        router.push('/profile')
        break
      case 'playlist':
        router.push('/playlist')
        break
      case 'settings':
        router.push('/settings')
        break
      case 'logout':
        userStore.logout()
        break
    }
  }
  
  // 初始化用户信息和搜索历史
  onMounted(async () => {
    await userStore.initUserInfo()
    musicStore.loadSearchHistory()
  })
  </script>
  
  <style scoped>
  .header {
    height: 60px;
    background: white;
    border-bottom: 1px solid #e0e0e0;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    position: sticky;
    top: 0;
    z-index: 1000;
  }
  
  .header-content {
    display: flex;
    align-items: center;
    height: 100%;
    max-width: 1200px;
    padding: 0 20px;
    /* margin: 0 auto; */
    justify-content: space-between;
  }
  
  /* 移动端布局调整 */
  @media (max-width: 768px) {
    .header-content {
      padding: 0 16px;
    }
    
    .logo {
      margin-right: 16px;
    }
    
    .search-container {
      flex: 1;
      max-width: none;
      margin-right: 16px;
    }
    
    .desktop-search {
      display: none;
    }
    
    .user-area {
      flex-shrink: 0;
    }

    /* 移动端不显示头像右侧的播放队列按钮 */
    .play-queue-btn {
      display: none !important;
    }
  }
  
  .logo {
    flex-shrink: 0;
    margin-right: 30px;
  }
  
  .logo-link {
    display: flex;
    align-items: center;
    text-decoration: none;
    color: #333;
  }
  
  .logo-icon {
    font-size: 24px;
    margin-right: 8px;
  }
  
  .logo-text {
    font-size: 20px;
    font-weight: bold;
    color: #667eea;
  }
  
  .search-container {
    flex: 1;
    max-width: 500px;
    margin-right: 30px;
    position: relative;
  }
  
  .search-input {
    width: 100%;
  }
  
  /* 搜索建议下拉框样式 */
  .suggestions-dropdown {
    position: absolute;
    top: 100%;
    left: 0;
    right: 0;
    background: white;
    border: 1px solid #e0e0e0;
    border-radius: 8px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
    z-index: 1000;
    max-height: 400px;
    overflow-y: auto;
  }
  
  .suggestions-section {
    border-bottom: 1px solid #f0f0f0;
  }
  
  .suggestions-section:last-child {
    border-bottom: none;
  }
  
  .suggestions-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 8px 12px;
    background: #f8f9fa;
    border-bottom: 1px solid #e0e0e0;
  }
  
  .suggestions-title {
    font-size: 12px;
    color: #666;
    font-weight: 500;
  }
  
  .suggestions-list {
    padding: 4px 0;
  }
  
  .suggestion-item {
    display: flex;
    align-items: center;
    padding: 8px 12px;
    cursor: pointer;
    transition: background-color 0.2s ease;
  }
  
  .suggestion-item:hover {
    background-color: #f8f9fa;
  }
  
  .suggestion-icon {
    font-size: 16px;
    margin-right: 8px;
    width: 20px;
    text-align: center;
  }
  
  .suggestion-text {
    flex: 1;
    font-size: 14px;
    color: #333;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  .suggestion-type {
    font-size: 12px;
    color: #999;
    margin-left: 8px;
    padding: 2px 6px;
    background: #f0f0f0;
    border-radius: 4px;
  }
  
  .search-icon {
    color: #999;
    cursor: pointer;
    padding: 4px;
    border-radius: 4px;
    transition: all 0.3s ease;
    display: inline-block;
  }
  
  .search-icon:hover {
    color: #667eea;
    background: rgba(102, 126, 234, 0.1);
  }
  
  .user-area {
    flex-shrink: 0;
    display: flex;
    align-items: center;
    gap: 12px;
  }
  
  .user-info {
    display: flex;
    align-items: center;
    gap: 12px;
  }
  
  /* 播放队列按钮样式 */
  .play-queue-btn {
    margin-right: 0;
  }
  
  .queue-button {
    display: flex;
    align-items: center;
    gap: 6px;
    padding: 8px 12px;
    border-radius: 20px;
    transition: all 0.3s ease;
    color: #666;
    font-size: 14px;
  }
  
  .queue-button:hover {
    background-color: #f5f5f5;
    color: #333;
  }
  
  .queue-button.has-queue {
    background: linear-gradient(45deg, #667eea, #764ba2);
    color: white;
  }
  
  .queue-button.has-queue:hover {
    background: linear-gradient(45deg, #5a6fd8, #6a4190);
    color: white;
  }
  
  .queue-icon {
    font-size: 16px;
  }
  
  .queue-text {
    font-weight: 500;
  }
  
  .queue-count {
    font-size: 12px;
    opacity: 0.8;
  }
  
  .login-btn {
    background: linear-gradient(45deg, #667eea, #764ba2);
    border: none;
    border-radius: 20px;
    padding: 8px 20px;
  }
  
  .user-avatar {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    overflow: hidden;
    cursor: pointer;
    border: none;
    box-shadow: none;
    transition: all 0.3s ease;
  }
  
  .user-trigger {
    display: flex;
    align-items: center;
    gap: 8px;
    cursor: pointer;
  }
  
  .user-nickname {
    max-width: 140px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    color: #333;
    font-weight: 500;
  }
  
  /* 取消ElementPlus下拉触发器的聚焦描边（可能看起来像边框） */
  :deep(.el-tooltip__trigger) {
    outline: none !important;
  }
  
  :deep(.el-tooltip__trigger:focus),
  :deep(.el-tooltip__trigger:focus-visible) {
    outline: none !important;
  }
  
  .user-trigger:focus,
  .user-trigger:focus-visible {
    outline: none;
  }
  
  .user-avatar:hover {
    box-shadow: 0 0 0 2px rgba(102, 126, 234, 0.25);
  }
  
  .user-avatar img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  
  /* ElementPlus样式覆盖 */
  :deep(.el-input__wrapper) {
    border-radius: 20px;
    border: 1px solid #e0e0e0;
  }
  
  :deep(.el-input__wrapper:hover) {
    border-color: #667eea;
  }
  
  :deep(.el-input__wrapper.is-focus) {
    border-color: #667eea;
    box-shadow: 0 0 0 2px rgba(102, 126, 234, 0.2);
  }
  
  :deep(.el-input__inner) {
    color: #333;
  }
  
  :deep(.el-input__inner::placeholder) {
    color: #999;
  }
  
  :deep(.el-input__suffix) {
    color: #999;
  }
  
  :deep(.el-input__suffix:hover) {
    color: #667eea;
  }
  
  :deep(.el-button--primary) {
    background: linear-gradient(45deg, #667eea, #764ba2);
    border: none;
  }
  
  :deep(.el-button--primary:hover) {
    background: linear-gradient(45deg, #764ba2, #667eea);
  }
  </style>
  