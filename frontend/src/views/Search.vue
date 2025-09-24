<template>
***REMOVED******REMOVED***<div***REMOVED***class="search">
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="search-header">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h1***REMOVED***class="search-title">🔍***REMOVED***搜索结果</h1>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***class="search-subtitle"***REMOVED***v-if="searchKeyword">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***搜索***REMOVED***"{{***REMOVED***searchKeyword***REMOVED***}}"***REMOVED***的结果
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</p>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="isLoading"***REMOVED***class="loading">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="loading-icon">⏳</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>正在搜索音乐...</p>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else-if="musicList.length***REMOVED***===***REMOVED***0***REMOVED***&&***REMOVED***searchKeyword"***REMOVED***class="empty">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="empty-icon">🔍</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>没有找到相关音乐</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***class="empty-tip">试试其他关键词吧</p>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else-if="musicList.length***REMOVED***===***REMOVED***0"***REMOVED***class="welcome">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="welcome-icon">🎵</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h3>开始搜索</h3>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>在顶部搜索框中输入歌曲名或歌手名</p>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else***REMOVED***class="search-results">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="results-header">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***<h2>找到***REMOVED***{{***REMOVED***musicList.length***REMOVED***}}***REMOVED***首歌曲</h2>***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="music-list"***REMOVED***ref="musicListRef">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-for="music***REMOVED***in***REMOVED***musicList"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:key="music.id"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="music-item"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:class="{***REMOVED***playing:***REMOVED***currentMusic?.id***REMOVED***===***REMOVED***music.id***REMOVED***&&***REMOVED***isPlaying***REMOVED***}"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="handlePlayMusic(music)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<img***REMOVED***:src="music.cover"***REMOVED***:alt="music.song"***REMOVED***class="music-cover"***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="music-info">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="music-title">{{***REMOVED***music.song***REMOVED***}}</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="music-artist">{{***REMOVED***music.singer***REMOVED***}}***REMOVED***·***REMOVED***{{***REMOVED***music.album***REMOVED***}}</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="music-actions">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="primary"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***circle
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="small"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click.stop="handlePlayMusic(music)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***currentMusic?.id***REMOVED***===***REMOVED***music.id***REMOVED***&&***REMOVED***isPlaying***REMOVED***?***REMOVED***'⏸️'***REMOVED***:***REMOVED***'▶️'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:type="isMusicInQueue(music.id)***REMOVED***?***REMOVED***'success'***REMOVED***:***REMOVED***'warning'"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***circle
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="small"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click.stop="handleAddToQueue(music)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***style="margin-left:***REMOVED***8px;"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:title="isMusicInQueue(music.id)***REMOVED***?***REMOVED***'已在队列中，点击移到当前播放歌曲下面'***REMOVED***:***REMOVED***'加入播放队列'"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***isMusicInQueue(music.id)***REMOVED***?***REMOVED***'🔄'***REMOVED***:***REMOVED***'➕'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="success"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***circle
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="small"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click.stop="handleDownloadMusic(music)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***style="margin-left:***REMOVED***8px;"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***⬇️
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***加载更多指示器***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="isLoadingMore"***REMOVED***class="loading-more">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="loading-spinner">⏳</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>正在加载更多音乐...</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***没有更多数据提示***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else-if="!hasMoreData***REMOVED***&&***REMOVED***musicList.length***REMOVED***>***REMOVED***0"***REMOVED***class="no-more-data">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>🎵***REMOVED***没有更多音乐了</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED***</div>
</template>

<script***REMOVED***setup***REMOVED***lang="ts">
import***REMOVED***{***REMOVED***ref,***REMOVED***computed,***REMOVED***onMounted,***REMOVED***onUnmounted,***REMOVED***watch,***REMOVED***nextTick***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useRoute***REMOVED***}***REMOVED***from***REMOVED***'vue-router'
import***REMOVED***{***REMOVED***useMusicStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/music'

const***REMOVED***route***REMOVED***=***REMOVED***useRoute()
const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore()

//***REMOVED***响应式数据
const***REMOVED***searchKeyword***REMOVED***=***REMOVED***ref('')
const***REMOVED***musicListRef***REMOVED***=***REMOVED***ref<HTMLElement***REMOVED***|***REMOVED***null>(null)

//***REMOVED***计算属性
const***REMOVED***currentMusic***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.currentMusic)
const***REMOVED***isPlaying***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.isPlaying)
const***REMOVED***isLoading***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.isLoading)
const***REMOVED***musicList***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.musicList)
const***REMOVED***hasMoreData***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.hasMoreData)
const***REMOVED***isLoadingMore***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.isLoadingMore)
const***REMOVED***playQueue***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.playQueue)

//***REMOVED***方法
const***REMOVED***handlePlayMusic***REMOVED***=***REMOVED***(music:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***musicStore.playMusic(music)
}

const***REMOVED***isMusicInQueue***REMOVED***=***REMOVED***(musicId:***REMOVED***number)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***return***REMOVED***playQueue.value.some(item***REMOVED***=>***REMOVED***item.id***REMOVED***===***REMOVED***musicId)
}

const***REMOVED***handleAddToQueue***REMOVED***=***REMOVED***async***REMOVED***(music:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***//***REMOVED***检查歌曲是否已经在队列中
***REMOVED******REMOVED***const***REMOVED***isAlreadyInQueue***REMOVED***=***REMOVED***isMusicInQueue(music.id)
***REMOVED******REMOVED***
***REMOVED******REMOVED***//***REMOVED***使用新的方法，无论是否在队列中都会移动到当前播放歌曲下面
***REMOVED******REMOVED***await***REMOVED***musicStore.moveToCurrentPosition(music)
***REMOVED******REMOVED***
***REMOVED******REMOVED***const***REMOVED***{***REMOVED***ElMessage***REMOVED***}***REMOVED***=***REMOVED***await***REMOVED***import('element-plus')
***REMOVED******REMOVED***if***REMOVED***(isAlreadyInQueue)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.success(`已移到当前播放歌曲下面:***REMOVED***${music.song}`)
***REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.success(`已添加到当前播放歌曲下面:***REMOVED***${music.song}`)
***REMOVED******REMOVED***}
}

const***REMOVED***handleDownloadMusic***REMOVED***=***REMOVED***async***REMOVED***(music:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***显示下载提示
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***{***REMOVED***ElMessage***REMOVED***}***REMOVED***=***REMOVED***await***REMOVED***import('element-plus')
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.info(`开始下载:***REMOVED***${music.song}***REMOVED***-***REMOVED***${music.singer}`)
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.downloadMusic(music)
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***下载成功提示
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.success(`下载完成:***REMOVED***${music.song}`)
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error:***REMOVED***any)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.error('下载音乐失败:',***REMOVED***error)
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***{***REMOVED***ElMessage***REMOVED***}***REMOVED***=***REMOVED***await***REMOVED***import('element-plus')
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.error(`下载失败:***REMOVED***${error.message***REMOVED***||***REMOVED***'未知错误'}`)
***REMOVED******REMOVED***}
}

const***REMOVED***performSearch***REMOVED***=***REMOVED***async***REMOVED***(keyword:***REMOVED***string)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!keyword.trim())***REMOVED***return
***REMOVED******REMOVED***
***REMOVED******REMOVED***searchKeyword.value***REMOVED***=***REMOVED***keyword
***REMOVED******REMOVED***await***REMOVED***musicStore.searchMusic(keyword)
}

//***REMOVED***滚动监听
const***REMOVED***handleScroll***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!musicListRef.value***REMOVED***||***REMOVED***!hasMoreData.value***REMOVED***||***REMOVED***isLoadingMore.value)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***return
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***const***REMOVED***element***REMOVED***=***REMOVED***musicListRef.value
***REMOVED******REMOVED***const***REMOVED***scrollTop***REMOVED***=***REMOVED***element.scrollTop
***REMOVED******REMOVED***const***REMOVED***scrollHeight***REMOVED***=***REMOVED***element.scrollHeight
***REMOVED******REMOVED***const***REMOVED***clientHeight***REMOVED***=***REMOVED***element.clientHeight
***REMOVED******REMOVED***
***REMOVED******REMOVED***//***REMOVED***当滚动到距离底部100px时触发加载更多
***REMOVED******REMOVED***const***REMOVED***threshold***REMOVED***=***REMOVED***100
***REMOVED******REMOVED***const***REMOVED***isNearBottom***REMOVED***=***REMOVED***scrollTop***REMOVED***+***REMOVED***clientHeight***REMOVED***>=***REMOVED***scrollHeight***REMOVED***-***REMOVED***threshold
***REMOVED******REMOVED***
***REMOVED******REMOVED***if***REMOVED***(isNearBottom)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.log('📜***REMOVED***滚动到底部附近，开始加载更多')
***REMOVED******REMOVED******REMOVED******REMOVED***musicStore.loadMoreMusic()
***REMOVED******REMOVED***}
}

//***REMOVED***添加滚动监听
const***REMOVED***addScrollListener***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(musicListRef.value)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***musicListRef.value.addEventListener('scroll',***REMOVED***handleScroll)
***REMOVED******REMOVED***}
}

//***REMOVED***移除滚动监听
const***REMOVED***removeScrollListener***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(musicListRef.value)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***musicListRef.value.removeEventListener('scroll',***REMOVED***handleScroll)
***REMOVED******REMOVED***}
}

//***REMOVED***监听路由变化
watch(()***REMOVED***=>***REMOVED***route.query.keyword,***REMOVED***(newKeyword)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(newKeyword***REMOVED***&&***REMOVED***typeof***REMOVED***newKeyword***REMOVED***===***REMOVED***'string')***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***检查是否已经有相同关键词的搜索结果，避免重复搜索
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(searchKeyword.value***REMOVED***!==***REMOVED***newKeyword)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***performSearch(newKeyword)
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}
},***REMOVED***{***REMOVED***immediate:***REMOVED***true***REMOVED***})

//***REMOVED***监听音乐列表变化，添加滚动监听
watch(()***REMOVED***=>***REMOVED***musicList.value.length,***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***nextTick(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***addScrollListener()
***REMOVED******REMOVED***})
})

//***REMOVED***生命周期
onMounted(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***keyword***REMOVED***=***REMOVED***route.query.keyword***REMOVED***as***REMOVED***string
***REMOVED******REMOVED***if***REMOVED***(keyword)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***检查是否已经有相同关键词的搜索结果，避免重复搜索
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(searchKeyword.value***REMOVED***!==***REMOVED***keyword)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***performSearch(keyword)
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***//***REMOVED***添加滚动监听
***REMOVED******REMOVED***nextTick(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***addScrollListener()
***REMOVED******REMOVED***})
})

onUnmounted(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***removeScrollListener()
})
</script>

<style***REMOVED***scoped>
.search***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***20px;
}

.search-header***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***margin-bottom:***REMOVED***30px;
}

.search-title***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***2rem;
***REMOVED******REMOVED***font-weight:***REMOVED***700;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***10px***REMOVED***0;
***REMOVED******REMOVED***color:***REMOVED***#333;
}

.search-subtitle***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***1rem;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***margin:***REMOVED***0;
}

.loading,***REMOVED***.empty,***REMOVED***.welcome***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***60px***REMOVED***20px;
***REMOVED******REMOVED***color:***REMOVED***#666;
}

.loading-icon,***REMOVED***.empty-icon,***REMOVED***.welcome-icon***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***4rem;
***REMOVED******REMOVED***margin-bottom:***REMOVED***20px;
***REMOVED******REMOVED***color:***REMOVED***#667eea;
}

.loading***REMOVED***p,***REMOVED***.empty***REMOVED***p,***REMOVED***.welcome***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***1.1rem;
***REMOVED******REMOVED***margin:***REMOVED***10px***REMOVED***0;
}

.empty-tip***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***0.9rem;
***REMOVED******REMOVED***color:***REMOVED***#999;
}

.welcome***REMOVED***h3***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***font-size:***REMOVED***1.8rem;
***REMOVED******REMOVED***margin-bottom:***REMOVED***15px;
}

.search-results***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***border-radius:***REMOVED***12px;
***REMOVED******REMOVED***padding:***REMOVED***20px;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***2px***REMOVED***12px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.1);
}

.results-header***REMOVED***{
***REMOVED******REMOVED***margin-bottom:***REMOVED***20px;
***REMOVED******REMOVED***padding-bottom:***REMOVED***15px;
***REMOVED******REMOVED***border-bottom:***REMOVED***1px***REMOVED***solid***REMOVED***#e0e0e0;
}

.results-header***REMOVED***h2***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***1.2rem;
***REMOVED******REMOVED***font-weight:***REMOVED***600;
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***color:***REMOVED***#333;
}

.music-list***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***flex-direction:***REMOVED***column;
***REMOVED******REMOVED***gap:***REMOVED***10px;
***REMOVED******REMOVED***max-height:***REMOVED***600px;
***REMOVED******REMOVED***overflow-y:***REMOVED***auto;
***REMOVED******REMOVED***padding-right:***REMOVED***10px;
}

.music-item***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***15px;
***REMOVED******REMOVED***background:***REMOVED***#f8f9fa;
***REMOVED******REMOVED***border-radius:***REMOVED***12px;
***REMOVED******REMOVED***cursor:***REMOVED***pointer;
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.3s***REMOVED***ease;
}

.music-item:hover***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***#e9ecef;
***REMOVED******REMOVED***transform:***REMOVED***translateX(5px);
}

.music-item.playing***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***color:***REMOVED***white;
}

.music-cover***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***50px;
***REMOVED******REMOVED***height:***REMOVED***50px;
***REMOVED******REMOVED***border-radius:***REMOVED***8px;
***REMOVED******REMOVED***margin-right:***REMOVED***15px;
***REMOVED******REMOVED***object-fit:***REMOVED***cover;
}

.music-info***REMOVED***{
***REMOVED******REMOVED***flex:***REMOVED***1;
}

.music-title***REMOVED***{
***REMOVED******REMOVED***font-weight:***REMOVED***600;
***REMOVED******REMOVED***margin-bottom:***REMOVED***5px;
***REMOVED******REMOVED***font-size:***REMOVED***16px;
}

.music-artist***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
}

.music-item.playing***REMOVED***.music-artist***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***rgba(255,***REMOVED***255,***REMOVED***255,***REMOVED***0.8);
}

.music-actions***REMOVED***{
***REMOVED******REMOVED***margin-left:***REMOVED***15px;
}

/****REMOVED***加载更多样式***REMOVED****/
.loading-more***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***flex-direction:***REMOVED***column;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***20px;
***REMOVED******REMOVED***color:***REMOVED***#666;
}

.loading-spinner***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***24px;
***REMOVED******REMOVED***margin-bottom:***REMOVED***10px;
***REMOVED******REMOVED***animation:***REMOVED***spin***REMOVED***1s***REMOVED***linear***REMOVED***infinite;
}

@keyframes***REMOVED***spin***REMOVED***{
***REMOVED******REMOVED***from***REMOVED***{***REMOVED***transform:***REMOVED***rotate(0deg);***REMOVED***}
***REMOVED******REMOVED***to***REMOVED***{***REMOVED***transform:***REMOVED***rotate(360deg);***REMOVED***}
}

.loading-more***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
}

/****REMOVED***没有更多数据样式***REMOVED****/
.no-more-data***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***20px;
***REMOVED******REMOVED***color:***REMOVED***#999;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
}

.no-more-data***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0;
}

/****REMOVED***滚动条样式***REMOVED****/
.music-list::-webkit-scrollbar***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***6px;
}

.music-list::-webkit-scrollbar-track***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***#f1f1f1;
***REMOVED******REMOVED***border-radius:***REMOVED***3px;
}

.music-list::-webkit-scrollbar-thumb***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***#c1c1c1;
***REMOVED******REMOVED***border-radius:***REMOVED***3px;
}

.music-list::-webkit-scrollbar-thumb:hover***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***#a8a8a8;
}

/****REMOVED***Element***REMOVED***Plus***REMOVED***样式覆盖***REMOVED****/
:deep(.el-button--primary)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***border:***REMOVED***none;
}

:deep(.el-button--primary:hover)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#764ba2,***REMOVED***#667eea);
}

:deep(.el-button--success)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#56ab2f,***REMOVED***#a8e6cf);
***REMOVED******REMOVED***border:***REMOVED***none;
}

:deep(.el-button--success:hover)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#a8e6cf,***REMOVED***#56ab2f);
}
</style>
