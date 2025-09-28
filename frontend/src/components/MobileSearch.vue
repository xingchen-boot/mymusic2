<template>
  <div class="mobile-search">
    <!-- 搜索按钮 -->
    <el-button
      type="text"
      class="search-btn"
      @click="openSearch"
    >
      <span class="search-icon">🔍</span>
    </el-button>

    <!-- 全屏搜索模态框 -->
    <el-dialog
      v-model="isSearchOpen"
      :show-close="false"
      :close-on-click-modal="false"
      :close-on-press-escape="true"
      fullscreen
      class="search-dialog"
    >
      <div class="search-content">
        <!-- 搜索头部 -->
        <div class="search-header">
          <el-input
            v-model="searchKeyword"
            placeholder="搜索歌曲、歌手、专辑..."
            size="large"
            @keyup.enter="handleSearch"
            @input="handleInput"
            @focus="showSuggestions = true"
            clearable
            class="search-input"
            ref="searchInputRef"
            autofocus
          >
            <template #suffix>
              <span class="search-icon" @click="handleSearch">🔍</span>
            </template>
          </el-input>
          <el-button
            type="text"
            class="close-btn"
            @click="closeSearch"
          >
            取消
          </el-button>
        </div>

        <!-- 搜索建议 -->
        <div v-if="showSuggestions && (suggestions.length > 0 || searchHistory.length > 0)" class="suggestions">
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

        <!-- 搜索结果 -->
        <div v-else-if="searchResults.length > 0" class="search-results">
          <div class="results-header">
            <h3>搜索结果</h3>
            <span class="results-count">找到 {{ searchResults.length }} 个结果</span>
          </div>
          <div class="results-list">
            <div
              v-for="music in searchResults"
              :key="music.id"
              class="result-item"
              @click="handlePlayMusic(music)"
            >
              <img :src="music.cover" :alt="music.song" class="result-cover" />
              <div class="result-info">
                <div class="result-title">{{ music.song }}</div>
                <div class="result-artist">{{ music.singer }}</div>
              </div>
              <div class="result-actions">
                <el-button
                  type="text"
                  @click.stop="handlePlayMusic(music)"
                  class="play-btn"
                >
                  {{ currentMusic?.id === music.id && isPlaying ? '⏸️' : '▶️' }}
                </el-button>
              </div>
            </div>
          </div>
        </div>

        <!-- 空状态 -->
        <div v-else-if="searchKeyword && !isSearching" class="empty-state">
          <div class="empty-icon">🔍</div>
          <div class="empty-text">未找到相关结果</div>
          <div class="empty-tip">尝试其他关键词</div>
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { ref, computed, nextTick } from 'vue'
import { useRouter } from 'vue-router'
import { useMusicStore } from '../stores/music'

const router = useRouter()
const musicStore = useMusicStore()

const isSearchOpen = ref(false)
const searchKeyword = ref('')
const showSuggestions = ref(false)
const searchInputRef = ref<HTMLElement | null>(null)
const searchResults = ref<any[]>([])
const isSearching = ref(false)
let inputTimer: number | null = null

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

  return result.slice(0, 8)
})

const currentMusic = computed(() => musicStore.currentMusic)
const isPlaying = computed(() => musicStore.isPlaying)

// 方法
const openSearch = () => {
  isSearchOpen.value = true
  nextTick(() => {
    searchInputRef.value?.focus()
  })
}

const closeSearch = () => {
  isSearchOpen.value = false
  searchKeyword.value = ''
  showSuggestions.value = false
  searchResults.value = []
}

const handleSearch = async () => {
  const keyword = searchKeyword.value.trim()
  if (keyword) {
    // 添加到搜索历史
    musicStore.addSearchHistory(keyword)
    
    // 执行搜索
    isSearching.value = true
    try {
      const response = await fetch(`/api/music/search?keyword=${encodeURIComponent(keyword)}`)
      const result = await response.json()
      if (result && result.code === 200) {
        searchResults.value = result.data || []
      }
    } catch (error) {
      console.error('搜索失败:', error)
      searchResults.value = []
    } finally {
      isSearching.value = false
    }
    
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

const clearHistory = () => {
  musicStore.clearSearchHistory()
}

const handlePlayMusic = (music: any) => {
  musicStore.playMusic(music)
  closeSearch()
}
</script>

<style scoped>
.mobile-search {
  display: none;
}

.search-btn {
  padding: 8px;
  color: #666;
  font-size: 18px;
}

.search-dialog {
  --el-dialog-bg-color: #f5f5f5;
}

.search-content {
  height: 100vh;
  display: flex;
  flex-direction: column;
  background: #f5f5f5;
}

.search-header {
  display: flex;
  align-items: center;
  padding: 16px;
  background: white;
  border-bottom: 1px solid #e0e0e0;
  gap: 12px;
}

.search-input {
  flex: 1;
}

.close-btn {
  color: #667eea;
  font-weight: 500;
  padding: 8px 16px;
}

.suggestions,
.search-results {
  flex: 1;
  overflow-y: auto;
  -webkit-overflow-scrolling: touch;
}

.suggestions-section {
  background: white;
  margin-bottom: 8px;
}

.suggestions-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 12px 16px;
  background: #f8f9fa;
  border-bottom: 1px solid #e0e0e0;
}

.suggestions-title {
  font-size: 14px;
  color: #666;
  font-weight: 500;
}

.suggestions-list {
  padding: 8px 0;
}

.suggestion-item {
  display: flex;
  align-items: center;
  padding: 12px 16px;
  cursor: pointer;
  transition: background-color 0.2s ease;
}

.suggestion-item:hover {
  background-color: #f8f9fa;
}

.suggestion-icon {
  font-size: 18px;
  margin-right: 12px;
  width: 24px;
  text-align: center;
}

.suggestion-text {
  flex: 1;
  font-size: 16px;
  color: #333;
}

.suggestion-type {
  font-size: 12px;
  color: #999;
  background: #f0f0f0;
  padding: 2px 8px;
  border-radius: 4px;
}

.search-results {
  padding: 16px;
}

.results-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 16px;
}

.results-header h3 {
  margin: 0;
  font-size: 18px;
  color: #333;
}

.results-count {
  font-size: 14px;
  color: #666;
}

.results-list {
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.result-item {
  display: flex;
  align-items: center;
  padding: 12px;
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  cursor: pointer;
  transition: all 0.3s ease;
}

.result-item:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
}

.result-cover {
  width: 50px;
  height: 50px;
  border-radius: 6px;
  object-fit: cover;
  margin-right: 12px;
}

.result-info {
  flex: 1;
  min-width: 0;
}

.result-title {
  font-size: 16px;
  font-weight: 500;
  color: #333;
  margin-bottom: 4px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.result-artist {
  font-size: 14px;
  color: #666;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.result-actions {
  margin-left: 12px;
}

.play-btn {
  font-size: 18px;
  padding: 8px;
  color: #667eea;
}

.empty-state {
  flex: 1;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  color: #666;
}

.empty-icon {
  font-size: 48px;
  margin-bottom: 16px;
  opacity: 0.6;
}

.empty-text {
  font-size: 18px;
  margin-bottom: 8px;
  font-weight: 500;
}

.empty-tip {
  font-size: 14px;
  opacity: 0.8;
}

/* 移动端显示 */
@media (max-width: 768px) {
  .mobile-search {
    display: block;
  }
}
</style>
