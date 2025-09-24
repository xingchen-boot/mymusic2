<template>
***REMOVED******REMOVED***<header***REMOVED***class="header">
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="header-content">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***Logo***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="logo">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<router-link***REMOVED***to="/"***REMOVED***class="logo-link">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="logo-icon">🎵</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="logo-text">MyMusic</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</router-link>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***搜索框***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="search-container">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-input
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="searchKeyword"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***placeholder="搜索歌曲、歌手、专辑..."
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="large"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@keyup.enter="handleSearch"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@input="handleInput"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@focus="showSuggestions***REMOVED***=***REMOVED***true"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@blur="hideSuggestions"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***clearable
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="search-input"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***ref="searchInputRef"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<template***REMOVED***#suffix>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="search-icon"***REMOVED***@click="handleSearch">🔍</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</template>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-input>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***搜索建议下拉框***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="showSuggestions***REMOVED***&&***REMOVED***(suggestions.length***REMOVED***>***REMOVED***0***REMOVED***||***REMOVED***searchHistory.length***REMOVED***>***REMOVED***0)"***REMOVED***class="suggestions-dropdown">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***搜索历史***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="searchHistory.length***REMOVED***>***REMOVED***0***REMOVED***&&***REMOVED***!searchKeyword"***REMOVED***class="suggestions-section">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="suggestions-header">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="suggestions-title">搜索历史</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***size="small"***REMOVED***@click="clearHistory">清除</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="suggestions-list">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-for="(item,***REMOVED***index)***REMOVED***in***REMOVED***searchHistory"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:key="`history-${index}`"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="suggestion-item"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="selectSuggestion(item)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="suggestion-icon">🕒</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="suggestion-text">{{***REMOVED***item***REMOVED***}}</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***搜索建议***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="suggestions.length***REMOVED***>***REMOVED***0"***REMOVED***class="suggestions-section">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="suggestions-header">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="suggestions-title">搜索建议</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="suggestions-list">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-for="(suggestion,***REMOVED***index)***REMOVED***in***REMOVED***suggestions"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:key="`suggestion-${index}`"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="suggestion-item"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="selectSuggestion(suggestion.text)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="suggestion-icon">{{***REMOVED***suggestion.icon***REMOVED***}}</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="suggestion-text">{{***REMOVED***suggestion.text***REMOVED***}}</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="suggestion-type">{{***REMOVED***suggestion.type***REMOVED***}}</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***用户区域***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="user-area">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="!userStore.isLoggedIn"***REMOVED***class="login-section">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="primary"***REMOVED***@click="goToLogin"***REMOVED***class="login-btn">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***登录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else***REMOVED***class="user-info">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-dropdown***REMOVED***trigger="hover"***REMOVED***@command="handleUserCommand">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="user-trigger">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="user-avatar">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<img***REMOVED***:src="userStore.currentUser?.avatar***REMOVED***||***REMOVED***'https://picsum.photos/40/40?random=1'"***REMOVED***:alt="userStore.currentUser?.nickname"***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="user-nickname">{{***REMOVED***userStore.currentUser?.nickname***REMOVED***||***REMOVED***'用户'***REMOVED***}}</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<template***REMOVED***#dropdown>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-dropdown-menu>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-dropdown-item***REMOVED***command="profile">个人中心</el-dropdown-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-dropdown-item***REMOVED***command="playlist">我的歌单</el-dropdown-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-dropdown-item***REMOVED***command="settings">设置</el-dropdown-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-dropdown-item***REMOVED***command="logout"***REMOVED***divided>退出登录</el-dropdown-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-dropdown-menu>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</template>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-dropdown>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***播放队列按钮***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="play-queue-btn">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="text"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="togglePlayQueue"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="queue-button"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:class="{***REMOVED***'has-queue':***REMOVED***musicStore.queueCount***REMOVED***>***REMOVED***0***REMOVED***}"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="queue-icon">📋</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="queue-text">播放队列</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***v-if="musicStore.queueCount***REMOVED***>***REMOVED***0"***REMOVED***class="queue-count">({{***REMOVED***musicStore.queueCount***REMOVED***}})</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED***</header>
</template>

<script***REMOVED***setup***REMOVED***lang="ts">
import***REMOVED***{***REMOVED***ref,***REMOVED***computed,***REMOVED***onMounted,***REMOVED***nextTick***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useRouter***REMOVED***}***REMOVED***from***REMOVED***'vue-router'
import***REMOVED***{***REMOVED***useMusicStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/music'
import***REMOVED***{***REMOVED***useUserStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/user'

const***REMOVED***router***REMOVED***=***REMOVED***useRouter()
const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore()
const***REMOVED***userStore***REMOVED***=***REMOVED***useUserStore()

//***REMOVED***响应式数据
const***REMOVED***searchKeyword***REMOVED***=***REMOVED***ref('')
const***REMOVED***showSuggestions***REMOVED***=***REMOVED***ref(false)
const***REMOVED***searchInputRef***REMOVED***=***REMOVED***ref()
let***REMOVED***inputTimer:***REMOVED***NodeJS.Timeout***REMOVED***|***REMOVED***null***REMOVED***=***REMOVED***null

//***REMOVED***计算属性
const***REMOVED***searchHistory***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.searchHistory)
const***REMOVED***suggestions***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!musicStore.searchSuggestions)***REMOVED***return***REMOVED***[]
***REMOVED******REMOVED***
***REMOVED******REMOVED***const***REMOVED***result:***REMOVED***Array<{***REMOVED***text:***REMOVED***string;***REMOVED***icon:***REMOVED***string;***REMOVED***type:***REMOVED***string***REMOVED***}>***REMOVED***=***REMOVED***[]
***REMOVED******REMOVED***
***REMOVED******REMOVED***//***REMOVED***处理歌曲建议
***REMOVED******REMOVED***if***REMOVED***(musicStore.searchSuggestions.song?.itemlist)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***musicStore.searchSuggestions.song.itemlist.forEach((item:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***result.push({
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***text:***REMOVED***`${item.name}***REMOVED***-***REMOVED***${item.singer}`,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***icon:***REMOVED***'🎵',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type:***REMOVED***'歌曲'
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***})
***REMOVED******REMOVED******REMOVED******REMOVED***})
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***//***REMOVED***处理歌手建议
***REMOVED******REMOVED***if***REMOVED***(musicStore.searchSuggestions.singer?.itemlist)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***musicStore.searchSuggestions.singer.itemlist.forEach((item:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***result.push({
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***text:***REMOVED***item.name,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***icon:***REMOVED***'👤',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type:***REMOVED***'歌手'
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***})
***REMOVED******REMOVED******REMOVED******REMOVED***})
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***//***REMOVED***处理专辑建议
***REMOVED******REMOVED***if***REMOVED***(musicStore.searchSuggestions.album?.itemlist)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***musicStore.searchSuggestions.album.itemlist.forEach((item:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***result.push({
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***text:***REMOVED***`${item.name}***REMOVED***-***REMOVED***${item.singer}`,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***icon:***REMOVED***'💿',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type:***REMOVED***'专辑'
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***})
***REMOVED******REMOVED******REMOVED******REMOVED***})
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***return***REMOVED***result.slice(0,***REMOVED***8)***REMOVED***//***REMOVED***限制显示数量
})

//***REMOVED***方法
const***REMOVED***handleSearch***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(searchKeyword.value.trim())***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***添加到搜索历史
***REMOVED******REMOVED******REMOVED******REMOVED***musicStore.addSearchHistory(searchKeyword.value.trim())
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***跳转到搜索结果页面
***REMOVED******REMOVED******REMOVED******REMOVED***router.push({
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***name:***REMOVED***'search',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***query:***REMOVED***{***REMOVED***keyword:***REMOVED***searchKeyword.value.trim()***REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***})
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***隐藏建议框
***REMOVED******REMOVED******REMOVED******REMOVED***showSuggestions.value***REMOVED***=***REMOVED***false
***REMOVED******REMOVED***}
}

const***REMOVED***handleInput***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***//***REMOVED***防抖处理
***REMOVED******REMOVED***if***REMOVED***(inputTimer)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***clearTimeout(inputTimer)
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***inputTimer***REMOVED***=***REMOVED***setTimeout(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(searchKeyword.value.trim())***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicStore.getSearchSuggestions(searchKeyword.value.trim())
***REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicStore.searchSuggestions***REMOVED***=***REMOVED***null
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***},***REMOVED***300)
}

const***REMOVED***selectSuggestion***REMOVED***=***REMOVED***(text:***REMOVED***string)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***searchKeyword.value***REMOVED***=***REMOVED***text
***REMOVED******REMOVED***showSuggestions.value***REMOVED***=***REMOVED***false
***REMOVED******REMOVED***handleSearch()
}

const***REMOVED***hideSuggestions***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***//***REMOVED***延迟隐藏，让点击事件先执行
***REMOVED******REMOVED***setTimeout(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***showSuggestions.value***REMOVED***=***REMOVED***false
***REMOVED******REMOVED***},***REMOVED***200)
}

const***REMOVED***clearHistory***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***musicStore.clearSearchHistory()
}

const***REMOVED***goToLogin***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***router.push('/login')
}

//***REMOVED***切换播放队列显示
const***REMOVED***togglePlayQueue***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***musicStore.togglePlayQueue()
}

const***REMOVED***handleUserCommand***REMOVED***=***REMOVED***(command:***REMOVED***string)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***switch***REMOVED***(command)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***case***REMOVED***'profile':
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***router.push('/profile')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***break
***REMOVED******REMOVED******REMOVED******REMOVED***case***REMOVED***'playlist':
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***router.push('/playlist')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***break
***REMOVED******REMOVED******REMOVED******REMOVED***case***REMOVED***'settings':
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***router.push('/settings')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***break
***REMOVED******REMOVED******REMOVED******REMOVED***case***REMOVED***'logout':
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userStore.logout()
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***break
***REMOVED******REMOVED***}
}

//***REMOVED***初始化用户信息和搜索历史
onMounted(async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***await***REMOVED***userStore.initUserInfo()
***REMOVED******REMOVED***musicStore.loadSearchHistory()
})
</script>

<style***REMOVED***scoped>
.header***REMOVED***{
***REMOVED******REMOVED***height:***REMOVED***60px;
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***border-bottom:***REMOVED***1px***REMOVED***solid***REMOVED***#e0e0e0;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***2px***REMOVED***8px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.1);
***REMOVED******REMOVED***position:***REMOVED***sticky;
***REMOVED******REMOVED***top:***REMOVED***0;
***REMOVED******REMOVED***z-index:***REMOVED***1000;
}

.header-content***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***height:***REMOVED***100%;
***REMOVED******REMOVED***max-width:***REMOVED***1200px;
***REMOVED******REMOVED***padding:***REMOVED***0***REMOVED***20px;
***REMOVED******REMOVED***justify-content:space-between;
}

.logo***REMOVED***{
***REMOVED******REMOVED***flex-shrink:***REMOVED***0;
***REMOVED******REMOVED***margin-right:***REMOVED***30px;
}

.logo-link***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***text-decoration:***REMOVED***none;
***REMOVED******REMOVED***color:***REMOVED***#333;
}

.logo-icon***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***24px;
***REMOVED******REMOVED***margin-right:***REMOVED***8px;
}

.logo-text***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***20px;
***REMOVED******REMOVED***font-weight:***REMOVED***bold;
***REMOVED******REMOVED***color:***REMOVED***#667eea;
}

.search-container***REMOVED***{
***REMOVED******REMOVED***flex:***REMOVED***1;
***REMOVED******REMOVED***max-width:***REMOVED***500px;
***REMOVED******REMOVED***margin-right:***REMOVED***30px;
***REMOVED******REMOVED***position:***REMOVED***relative;
}

.search-input***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***100%;
}

/****REMOVED***搜索建议下拉框样式***REMOVED****/
.suggestions-dropdown***REMOVED***{
***REMOVED******REMOVED***position:***REMOVED***absolute;
***REMOVED******REMOVED***top:***REMOVED***100%;
***REMOVED******REMOVED***left:***REMOVED***0;
***REMOVED******REMOVED***right:***REMOVED***0;
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***border:***REMOVED***1px***REMOVED***solid***REMOVED***#e0e0e0;
***REMOVED******REMOVED***border-radius:***REMOVED***8px;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***4px***REMOVED***12px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.15);
***REMOVED******REMOVED***z-index:***REMOVED***1000;
***REMOVED******REMOVED***max-height:***REMOVED***400px;
***REMOVED******REMOVED***overflow-y:***REMOVED***auto;
}

.suggestions-section***REMOVED***{
***REMOVED******REMOVED***border-bottom:***REMOVED***1px***REMOVED***solid***REMOVED***#f0f0f0;
}

.suggestions-section:last-child***REMOVED***{
***REMOVED******REMOVED***border-bottom:***REMOVED***none;
}

.suggestions-header***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***justify-content:***REMOVED***space-between;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***8px***REMOVED***12px;
***REMOVED******REMOVED***background:***REMOVED***#f8f9fa;
***REMOVED******REMOVED***border-bottom:***REMOVED***1px***REMOVED***solid***REMOVED***#e0e0e0;
}

.suggestions-title***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***12px;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***font-weight:***REMOVED***500;
}

.suggestions-list***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***4px***REMOVED***0;
}

.suggestion-item***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***8px***REMOVED***12px;
***REMOVED******REMOVED***cursor:***REMOVED***pointer;
***REMOVED******REMOVED***transition:***REMOVED***background-color***REMOVED***0.2s***REMOVED***ease;
}

.suggestion-item:hover***REMOVED***{
***REMOVED******REMOVED***background-color:***REMOVED***#f8f9fa;
}

.suggestion-icon***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***margin-right:***REMOVED***8px;
***REMOVED******REMOVED***width:***REMOVED***20px;
***REMOVED******REMOVED***text-align:***REMOVED***center;
}

.suggestion-text***REMOVED***{
***REMOVED******REMOVED***flex:***REMOVED***1;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
}

.suggestion-type***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***12px;
***REMOVED******REMOVED***color:***REMOVED***#999;
***REMOVED******REMOVED***margin-left:***REMOVED***8px;
***REMOVED******REMOVED***padding:***REMOVED***2px***REMOVED***6px;
***REMOVED******REMOVED***background:***REMOVED***#f0f0f0;
***REMOVED******REMOVED***border-radius:***REMOVED***4px;
}

.search-icon***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#999;
***REMOVED******REMOVED***cursor:***REMOVED***pointer;
***REMOVED******REMOVED***padding:***REMOVED***4px;
***REMOVED******REMOVED***border-radius:***REMOVED***4px;
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.3s***REMOVED***ease;
***REMOVED******REMOVED***display:***REMOVED***inline-block;
}

.search-icon:hover***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#667eea;
***REMOVED******REMOVED***background:***REMOVED***rgba(102,***REMOVED***126,***REMOVED***234,***REMOVED***0.1);
}

.user-area***REMOVED***{
***REMOVED******REMOVED***flex-shrink:***REMOVED***0;
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***gap:***REMOVED***12px;
}

.user-info***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***gap:***REMOVED***12px;
}

/****REMOVED***播放队列按钮样式***REMOVED****/
.play-queue-btn***REMOVED***{
***REMOVED******REMOVED***margin-right:***REMOVED***0;
}

.queue-button***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***gap:***REMOVED***6px;
***REMOVED******REMOVED***padding:***REMOVED***8px***REMOVED***12px;
***REMOVED******REMOVED***border-radius:***REMOVED***20px;
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.3s***REMOVED***ease;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
}

.queue-button:hover***REMOVED***{
***REMOVED******REMOVED***background-color:***REMOVED***#f5f5f5;
***REMOVED******REMOVED***color:***REMOVED***#333;
}

.queue-button.has-queue***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***color:***REMOVED***white;
}

.queue-button.has-queue:hover***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#5a6fd8,***REMOVED***#6a4190);
***REMOVED******REMOVED***color:***REMOVED***white;
}

.queue-icon***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***16px;
}

.queue-text***REMOVED***{
***REMOVED******REMOVED***font-weight:***REMOVED***500;
}

.queue-count***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***12px;
***REMOVED******REMOVED***opacity:***REMOVED***0.8;
}

.login-btn***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***border:***REMOVED***none;
***REMOVED******REMOVED***border-radius:***REMOVED***20px;
***REMOVED******REMOVED***padding:***REMOVED***8px***REMOVED***20px;
}

.user-avatar***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***40px;
***REMOVED******REMOVED***height:***REMOVED***40px;
***REMOVED******REMOVED***border-radius:***REMOVED***50%;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***cursor:***REMOVED***pointer;
***REMOVED******REMOVED***border:***REMOVED***none;
***REMOVED******REMOVED***box-shadow:***REMOVED***none;
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.3s***REMOVED***ease;
}

.user-trigger***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***gap:***REMOVED***8px;
***REMOVED******REMOVED***cursor:***REMOVED***pointer;
}

.user-nickname***REMOVED***{
***REMOVED******REMOVED***max-width:***REMOVED***140px;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***font-weight:***REMOVED***500;
}

/****REMOVED***取消***REMOVED***Element***REMOVED***Plus***REMOVED***下拉触发器的聚焦描边（可能看起来像边框）***REMOVED****/
:deep(.el-tooltip__trigger)***REMOVED***{
***REMOVED******REMOVED***outline:***REMOVED***none***REMOVED***!important;
}

:deep(.el-tooltip__trigger:focus),
:deep(.el-tooltip__trigger:focus-visible)***REMOVED***{
***REMOVED******REMOVED***outline:***REMOVED***none***REMOVED***!important;
}

.user-trigger:focus,
.user-trigger:focus-visible***REMOVED***{
***REMOVED******REMOVED***outline:***REMOVED***none;
}

.user-avatar:hover***REMOVED***{
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***0***REMOVED***0***REMOVED***2px***REMOVED***rgba(102,***REMOVED***126,***REMOVED***234,***REMOVED***0.25);
}

.user-avatar***REMOVED***img***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***100%;
***REMOVED******REMOVED***height:***REMOVED***100%;
***REMOVED******REMOVED***object-fit:***REMOVED***cover;
}

/****REMOVED***Element***REMOVED***Plus***REMOVED***样式覆盖***REMOVED****/
:deep(.el-input__wrapper)***REMOVED***{
***REMOVED******REMOVED***border-radius:***REMOVED***20px;
***REMOVED******REMOVED***border:***REMOVED***1px***REMOVED***solid***REMOVED***#e0e0e0;
}

:deep(.el-input__wrapper:hover)***REMOVED***{
***REMOVED******REMOVED***border-color:***REMOVED***#667eea;
}

:deep(.el-input__wrapper.is-focus)***REMOVED***{
***REMOVED******REMOVED***border-color:***REMOVED***#667eea;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***0***REMOVED***0***REMOVED***2px***REMOVED***rgba(102,***REMOVED***126,***REMOVED***234,***REMOVED***0.2);
}

:deep(.el-input__inner)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#333;
}

:deep(.el-input__inner::placeholder)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#999;
}

:deep(.el-input__suffix)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#999;
}

:deep(.el-input__suffix:hover)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#667eea;
}

:deep(.el-button--primary)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***border:***REMOVED***none;
}

:deep(.el-button--primary:hover)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#764ba2,***REMOVED***#667eea);
}
</style>
