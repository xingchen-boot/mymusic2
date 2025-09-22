<template>
***REMOVED******REMOVED***<div***REMOVED***class="recent">
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="recent-header">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h1>🕒***REMOVED***最近播放</h1>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="header-actions">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="danger"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="small"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="clearRecentPlays"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:disabled="recentPlays.length***REMOVED***===***REMOVED***0"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***清空记录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="loading"***REMOVED***class="loading-container">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-loading***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-loading="loading"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***element-loading-text="加载中..."
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***element-loading-spinner="el-icon-loading"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else-if="recentPlays.length***REMOVED***===***REMOVED***0"***REMOVED***class="empty-state">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="empty-icon">🎵</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h3>暂无播放记录</h3>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>开始播放音乐，这里会显示你的播放历史</p>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else***REMOVED***class="recent-list">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-for="(play,***REMOVED***index)***REMOVED***in***REMOVED***recentPlays"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:key="play.id"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="recent-item"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:class="{***REMOVED***'playing':***REMOVED***currentMusic?.id***REMOVED***===***REMOVED***parseInt(play.musicId)***REMOVED***&&***REMOVED***isPlaying***REMOVED***}"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="item-index">{{***REMOVED***index***REMOVED***+***REMOVED***1***REMOVED***}}</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="item-cover">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<img***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:src="play.musicCover***REMOVED***||***REMOVED***'/default-cover.png'"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:alt="play.musicSong"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@error="handleImageError"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="play-overlay"***REMOVED***@click="playRecentMusic(play)">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<i***REMOVED***:class="currentMusic?.id***REMOVED***===***REMOVED***parseInt(play.musicId)***REMOVED***&&***REMOVED***isPlaying***REMOVED***?***REMOVED***'el-icon-video-pause'***REMOVED***:***REMOVED***'el-icon-video-play'"></i>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="item-info">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="song-title"***REMOVED***:title="play.musicSong">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***play.musicSong***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="song-artist"***REMOVED***:title="play.musicSinger">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***play.musicSinger***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="play-info">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="play-time">{{***REMOVED***formatPlayTime(play.playTime)***REMOVED***}}</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***v-if="play.playDuration***REMOVED***>***REMOVED***0"***REMOVED***class="play-duration">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***播放了***REMOVED***{{***REMOVED***formatDuration(play.playDuration)***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***v-if="play.playProgress***REMOVED***>***REMOVED***0"***REMOVED***class="play-progress">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***进度***REMOVED***{{***REMOVED***play.playProgress.toFixed(1)***REMOVED***}}%
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="item-actions">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="primary"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***circle***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="small"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="playRecentMusic(play)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:title="currentMusic?.id***REMOVED***===***REMOVED***parseInt(play.musicId)***REMOVED***&&***REMOVED***isPlaying***REMOVED***?***REMOVED***'暂停'***REMOVED***:***REMOVED***'播放'"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***currentMusic?.id***REMOVED***===***REMOVED***parseInt(play.musicId)***REMOVED***&&***REMOVED***isPlaying***REMOVED***?***REMOVED***'⏸️'***REMOVED***:***REMOVED***'▶️'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:type="isMusicInQueue(parseInt(play.musicId))***REMOVED***?***REMOVED***'success'***REMOVED***:***REMOVED***'warning'"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***circle
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="small"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="handleAddToQueueFromRecent(play)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***style="margin-left:***REMOVED***8px;"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:title="isMusicInQueue(parseInt(play.musicId))***REMOVED***?***REMOVED***'已在队列中，点击移到当前播放歌曲下面'***REMOVED***:***REMOVED***'加入播放队列'"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***isMusicInQueue(parseInt(play.musicId))***REMOVED***?***REMOVED***'🔄'***REMOVED***:***REMOVED***'➕'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="success"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***circle
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="small"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="downloadRecentMusic(play)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***style="margin-left:***REMOVED***8px;"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***title="下载"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***⬇️
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="danger"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***circle
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="small"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="removeFromRecent(play)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***style="margin-left:***REMOVED***8px;"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***title="移除"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***🗑️
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED***</div>
</template>

<script***REMOVED***setup***REMOVED***lang="ts">
import***REMOVED***{***REMOVED***ref,***REMOVED***onMounted,***REMOVED***onUnmounted,***REMOVED***computed***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useUserStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/user'
import***REMOVED***{***REMOVED***useMusicStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/music'

const***REMOVED***userStore***REMOVED***=***REMOVED***useUserStore()
const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore()

//***REMOVED***响应式数据
const***REMOVED***recentPlays***REMOVED***=***REMOVED***ref<any[]>([])
const***REMOVED***loading***REMOVED***=***REMOVED***ref(false)

//***REMOVED***计算属性
const***REMOVED***currentMusic***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.currentMusic)
const***REMOVED***isPlaying***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.isPlaying)
const***REMOVED***playQueue***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.playQueue)

//***REMOVED***加载最近播放记录
const***REMOVED***loadRecentPlays***REMOVED***=***REMOVED***async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!userStore.isLoggedIn***REMOVED***||***REMOVED***!userStore.currentUser)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.log('❌***REMOVED***用户未登录，无法加载最近播放记录')
***REMOVED******REMOVED******REMOVED******REMOVED***return
***REMOVED******REMOVED***}

***REMOVED******REMOVED***loading.value***REMOVED***=***REMOVED***true
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***response***REMOVED***=***REMOVED***await***REMOVED***fetch(`/api/recent-play/user/${userStore.currentUser.id}?limit=100`)
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(!response.ok)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***throw***REMOVED***new***REMOVED***Error(`HTTP***REMOVED***error!***REMOVED***status:***REMOVED***${response.status}`)
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***result***REMOVED***=***REMOVED***await***REMOVED***response.json()
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(result.code***REMOVED***===***REMOVED***200)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***recentPlays.value***REMOVED***=***REMOVED***result.data***REMOVED***||***REMOVED***[]
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.log('✅***REMOVED***最近播放记录加载成功，共',***REMOVED***recentPlays.value.length,***REMOVED***'条')
***REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.error('❌***REMOVED***加载最近播放记录失败:',***REMOVED***result.message)
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.error('❌***REMOVED***加载最近播放记录失败:',***REMOVED***error)
***REMOVED******REMOVED***}***REMOVED***finally***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***loading.value***REMOVED***=***REMOVED***false
***REMOVED******REMOVED***}
}

//***REMOVED***订阅最近播放更新（增量更新）
const***REMOVED***handleRecentChange***REMOVED***=***REMOVED***async***REMOVED***(event:***REMOVED***{***REMOVED***type:***REMOVED***'record'***REMOVED***|***REMOVED***'progress';***REMOVED***music?:***REMOVED***any;***REMOVED***playDuration?:***REMOVED***number;***REMOVED***playProgress?:***REMOVED***number***REMOVED***})***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(event.type***REMOVED***===***REMOVED***'record'***REMOVED***&&***REMOVED***event.music)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***将新记录插入到列表顶部（如果已存在，先移除再插入，保持最新在最上）
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***musicId***REMOVED***=***REMOVED***event.music.id?.toString?.()***REMOVED***||***REMOVED***event.music.musicId?.toString?.()
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***existIdx***REMOVED***=***REMOVED***recentPlays.value.findIndex(item***REMOVED***=>***REMOVED***item.musicId?.toString?.()***REMOVED***===***REMOVED***musicId)
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(existIdx***REMOVED***>***REMOVED***-1)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***exist***REMOVED***=***REMOVED***recentPlays.value.splice(existIdx,***REMOVED***1)[0]
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***更新播放时间为当前
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***exist.playTime***REMOVED***=***REMOVED***new***REMOVED***Date().toISOString()
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***recentPlays.value.unshift(exist)
***REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***recentPlays.value.unshift({
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***Date.now(),
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userId:***REMOVED***userStore.currentUser?.id,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicId:***REMOVED***musicId,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicMid:***REMOVED***event.music.mid,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicSong:***REMOVED***event.music.song,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicSinger:***REMOVED***event.music.singer,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicAlbum:***REMOVED***event.music.album***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicCover:***REMOVED***event.music.cover***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicTime:***REMOVED***event.music.time***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***musicPay:***REMOVED***event.music.pay***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***playTime:***REMOVED***new***REMOVED***Date().toISOString(),
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***playDuration:***REMOVED***0,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***playProgress:***REMOVED***0
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***})
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}***REMOVED***else***REMOVED***if***REMOVED***(event.type***REMOVED***===***REMOVED***'progress'***REMOVED***&&***REMOVED***currentMusic.value)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***musicId***REMOVED***=***REMOVED***(event.music?.id***REMOVED***??***REMOVED***currentMusic.value.id).toString()
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***idx***REMOVED***=***REMOVED***recentPlays.value.findIndex(item***REMOVED***=>***REMOVED***item.musicId?.toString?.()***REMOVED***===***REMOVED***musicId)
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(idx***REMOVED***>***REMOVED***-1)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***item***REMOVED***=***REMOVED***recentPlays.value[idx]
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(typeof***REMOVED***event.playDuration***REMOVED***===***REMOVED***'number')***REMOVED***item.playDuration***REMOVED***=***REMOVED***event.playDuration
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(typeof***REMOVED***event.playProgress***REMOVED***===***REMOVED***'number')***REMOVED***item.playProgress***REMOVED***=***REMOVED***event.playProgress
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***item.playTime***REMOVED***=***REMOVED***new***REMOVED***Date().toISOString()
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***将该项移动到顶部，保持“最近”顺序
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***moved***REMOVED***=***REMOVED***recentPlays.value.splice(idx,***REMOVED***1)[0]
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***recentPlays.value.unshift(moved)
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}
}

onMounted(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***loadRecentPlays()
***REMOVED******REMOVED***musicStore.addRecentPlayListener(handleRecentChange***REMOVED***as***REMOVED***any)
})

onUnmounted(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***musicStore.removeRecentPlayListener(handleRecentChange***REMOVED***as***REMOVED***any)
})

//***REMOVED***播放最近播放的音乐
const***REMOVED***playRecentMusic***REMOVED***=***REMOVED***async***REMOVED***(play:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***music***REMOVED***=***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***parseInt(play.musicId),
***REMOVED******REMOVED******REMOVED******REMOVED***mid:***REMOVED***play.musicMid,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***play.musicSong,
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***play.musicSinger,
***REMOVED******REMOVED******REMOVED******REMOVED***album:***REMOVED***play.musicAlbum***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***play.musicCover***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***time:***REMOVED***play.musicTime***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***pay:***REMOVED***play.musicPay***REMOVED***||***REMOVED***''
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***await***REMOVED***musicStore.playMusic(music)
}

//***REMOVED***添加到播放队列
const***REMOVED***addToQueue***REMOVED***=***REMOVED***async***REMOVED***(play:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***music***REMOVED***=***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***parseInt(play.musicId),
***REMOVED******REMOVED******REMOVED******REMOVED***mid:***REMOVED***play.musicMid,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***play.musicSong,
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***play.musicSinger,
***REMOVED******REMOVED******REMOVED******REMOVED***album:***REMOVED***play.musicAlbum***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***play.musicCover***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***time:***REMOVED***play.musicTime***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***pay:***REMOVED***play.musicPay***REMOVED***||***REMOVED***''
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***await***REMOVED***musicStore.addToPlayQueueWithSync(music)
***REMOVED******REMOVED***
***REMOVED******REMOVED***const***REMOVED***{***REMOVED***ElMessage***REMOVED***}***REMOVED***=***REMOVED***await***REMOVED***import('element-plus')
***REMOVED******REMOVED***ElMessage.success('已添加到播放队列')
}

//***REMOVED***Search页的同款逻辑：判断是否在队列中并移动到当前歌曲下面
const***REMOVED***isMusicInQueue***REMOVED***=***REMOVED***(musicId:***REMOVED***number)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***return***REMOVED***playQueue.value.some(item***REMOVED***=>***REMOVED***item.id***REMOVED***===***REMOVED***musicId)
}

const***REMOVED***handleAddToQueueFromRecent***REMOVED***=***REMOVED***async***REMOVED***(play:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***music***REMOVED***=***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***parseInt(play.musicId),
***REMOVED******REMOVED******REMOVED******REMOVED***mid:***REMOVED***play.musicMid,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***play.musicSong,
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***play.musicSinger,
***REMOVED******REMOVED******REMOVED******REMOVED***album:***REMOVED***play.musicAlbum***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***play.musicCover***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***time:***REMOVED***play.musicTime***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***pay:***REMOVED***play.musicPay***REMOVED***||***REMOVED***''
***REMOVED******REMOVED***}
***REMOVED******REMOVED***const***REMOVED***already***REMOVED***=***REMOVED***isMusicInQueue(music.id)
***REMOVED******REMOVED***await***REMOVED***musicStore.moveToCurrentPosition(music)
***REMOVED******REMOVED***const***REMOVED***{***REMOVED***ElMessage***REMOVED***}***REMOVED***=***REMOVED***await***REMOVED***import('element-plus')
***REMOVED******REMOVED***ElMessage.success(already***REMOVED***?***REMOVED***`已移到当前播放歌曲下面:***REMOVED***${music.song}`***REMOVED***:***REMOVED***`已添加到当前播放歌曲下面:***REMOVED***${music.song}`)
}

//***REMOVED***下载音乐
const***REMOVED***downloadRecentMusic***REMOVED***=***REMOVED***async***REMOVED***(play:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***music***REMOVED***=***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***parseInt(play.musicId),
***REMOVED******REMOVED******REMOVED******REMOVED***mid:***REMOVED***play.musicMid,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***play.musicSong,
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***play.musicSinger,
***REMOVED******REMOVED******REMOVED******REMOVED***album:***REMOVED***play.musicAlbum***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***play.musicCover***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***time:***REMOVED***play.musicTime***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***pay:***REMOVED***play.musicPay***REMOVED***||***REMOVED***''
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.downloadMusic(music)
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.error('下载失败:',***REMOVED***error)
***REMOVED******REMOVED***}
}

//***REMOVED***从最近播放中移除
const***REMOVED***removeFromRecent***REMOVED***=***REMOVED***async***REMOVED***(play:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!userStore.isLoggedIn***REMOVED***||***REMOVED***!userStore.currentUser)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***return
***REMOVED******REMOVED***}

***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***response***REMOVED***=***REMOVED***await***REMOVED***fetch(`/api/recent-play/user/${userStore.currentUser.id}/music/${play.musicId}`,***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***method:***REMOVED***'DELETE'
***REMOVED******REMOVED******REMOVED******REMOVED***})

***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(!response.ok)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***throw***REMOVED***new***REMOVED***Error(`HTTP***REMOVED***error!***REMOVED***status:***REMOVED***${response.status}`)
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***result***REMOVED***=***REMOVED***await***REMOVED***response.json()
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(result.code***REMOVED***===***REMOVED***200)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***从列表中移除
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***index***REMOVED***=***REMOVED***recentPlays.value.findIndex(item***REMOVED***=>***REMOVED***item.id***REMOVED***===***REMOVED***play.id)
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(index***REMOVED***>***REMOVED***-1)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***recentPlays.value.splice(index,***REMOVED***1)
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***{***REMOVED***ElMessage***REMOVED***}***REMOVED***=***REMOVED***await***REMOVED***import('element-plus')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.success('已从最近播放中移除')
***REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***throw***REMOVED***new***REMOVED***Error(result.message)
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.error('❌***REMOVED***移除最近播放记录失败:',***REMOVED***error)
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***{***REMOVED***ElMessage***REMOVED***}***REMOVED***=***REMOVED***await***REMOVED***import('element-plus')
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.error('移除失败')
***REMOVED******REMOVED***}
}

//***REMOVED***清空最近播放记录
const***REMOVED***clearRecentPlays***REMOVED***=***REMOVED***async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!userStore.isLoggedIn***REMOVED***||***REMOVED***!userStore.currentUser)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***return
***REMOVED******REMOVED***}

***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***{***REMOVED***ElMessageBox***REMOVED***}***REMOVED***=***REMOVED***await***REMOVED***import('element-plus')
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***ElMessageBox.confirm(
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***'确定要清空所有最近播放记录吗？此操作不可恢复。',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***'确认清空',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***confirmButtonText:***REMOVED***'确定',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***cancelButtonText:***REMOVED***'取消',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type:***REMOVED***'warning'
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***)

***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***response***REMOVED***=***REMOVED***await***REMOVED***fetch(`/api/recent-play/user/${userStore.currentUser.id}/clear`,***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***method:***REMOVED***'DELETE'
***REMOVED******REMOVED******REMOVED******REMOVED***})

***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(!response.ok)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***throw***REMOVED***new***REMOVED***Error(`HTTP***REMOVED***error!***REMOVED***status:***REMOVED***${response.status}`)
***REMOVED******REMOVED******REMOVED******REMOVED***}

***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***result***REMOVED***=***REMOVED***await***REMOVED***response.json()
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(result.code***REMOVED***===***REMOVED***200)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***recentPlays.value***REMOVED***=***REMOVED***[]
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***{***REMOVED***ElMessage***REMOVED***}***REMOVED***=***REMOVED***await***REMOVED***import('element-plus')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.success('已清空最近播放记录')
***REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***throw***REMOVED***new***REMOVED***Error(result.message)
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(error***REMOVED***!==***REMOVED***'cancel')***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.error('❌***REMOVED***清空最近播放记录失败:',***REMOVED***error)
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***{***REMOVED***ElMessage***REMOVED***}***REMOVED***=***REMOVED***await***REMOVED***import('element-plus')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.error('清空失败')
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}
}

//***REMOVED***格式化播放时间
const***REMOVED***formatPlayTime***REMOVED***=***REMOVED***(playTime:***REMOVED***string)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***date***REMOVED***=***REMOVED***new***REMOVED***Date(playTime)
***REMOVED******REMOVED***const***REMOVED***now***REMOVED***=***REMOVED***new***REMOVED***Date()
***REMOVED******REMOVED***const***REMOVED***diff***REMOVED***=***REMOVED***now.getTime()***REMOVED***-***REMOVED***date.getTime()
***REMOVED******REMOVED***
***REMOVED******REMOVED***const***REMOVED***minutes***REMOVED***=***REMOVED***Math.floor(diff***REMOVED***/***REMOVED***(1000***REMOVED*******REMOVED***60))
***REMOVED******REMOVED***const***REMOVED***hours***REMOVED***=***REMOVED***Math.floor(diff***REMOVED***/***REMOVED***(1000***REMOVED*******REMOVED***60***REMOVED*******REMOVED***60))
***REMOVED******REMOVED***const***REMOVED***days***REMOVED***=***REMOVED***Math.floor(diff***REMOVED***/***REMOVED***(1000***REMOVED*******REMOVED***60***REMOVED*******REMOVED***60***REMOVED*******REMOVED***24))
***REMOVED******REMOVED***
***REMOVED******REMOVED***if***REMOVED***(days***REMOVED***>***REMOVED***0)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***`${days}天前`
***REMOVED******REMOVED***}***REMOVED***else***REMOVED***if***REMOVED***(hours***REMOVED***>***REMOVED***0)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***`${hours}小时前`
***REMOVED******REMOVED***}***REMOVED***else***REMOVED***if***REMOVED***(minutes***REMOVED***>***REMOVED***0)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***`${minutes}分钟前`
***REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***'刚刚'
***REMOVED******REMOVED***}
}

//***REMOVED***格式化时长
const***REMOVED***formatDuration***REMOVED***=***REMOVED***(seconds:***REMOVED***number)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***minutes***REMOVED***=***REMOVED***Math.floor(seconds***REMOVED***/***REMOVED***60)
***REMOVED******REMOVED***const***REMOVED***remainingSeconds***REMOVED***=***REMOVED***seconds***REMOVED***%***REMOVED***60
***REMOVED******REMOVED***return***REMOVED***`${minutes}:${remainingSeconds.toString().padStart(2,***REMOVED***'0')}`
}

//***REMOVED***处理图片加载错误
const***REMOVED***handleImageError***REMOVED***=***REMOVED***(event:***REMOVED***Event)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***img***REMOVED***=***REMOVED***event.target***REMOVED***as***REMOVED***HTMLImageElement
***REMOVED******REMOVED***img.src***REMOVED***=***REMOVED***'/default-cover.png'
}

//***REMOVED***组件挂载时加载数据
</script>

<style***REMOVED***scoped>
.recent***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***20px;
***REMOVED******REMOVED***max-width:***REMOVED***1200px;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***auto;
}

.recent-header***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***justify-content:***REMOVED***space-between;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***margin-bottom:***REMOVED***30px;
***REMOVED******REMOVED***padding-bottom:***REMOVED***20px;
***REMOVED******REMOVED***border-bottom:***REMOVED***1px***REMOVED***solid***REMOVED***#e0e0e0;
}

.recent-header***REMOVED***h1***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***font-size:***REMOVED***28px;
}

.header-actions***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***gap:***REMOVED***10px;
}

.loading-container***REMOVED***{
***REMOVED******REMOVED***height:***REMOVED***200px;
***REMOVED******REMOVED***position:***REMOVED***relative;
}

.empty-state***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***60px***REMOVED***20px;
***REMOVED******REMOVED***color:***REMOVED***#666;
}

.empty-icon***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***64px;
***REMOVED******REMOVED***margin-bottom:***REMOVED***20px;
}

.empty-state***REMOVED***h3***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***margin-bottom:***REMOVED***10px;
}

.empty-state***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#999;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
}

.recent-list***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***flex-direction:***REMOVED***column;
***REMOVED******REMOVED***gap:***REMOVED***12px;
}

.recent-item***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***15px;
***REMOVED******REMOVED***background:***REMOVED***#fff;
***REMOVED******REMOVED***border-radius:***REMOVED***12px;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***2px***REMOVED***8px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.1);
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.3s***REMOVED***ease;
***REMOVED******REMOVED***border:***REMOVED***2px***REMOVED***solid***REMOVED***transparent;
}

.recent-item:hover***REMOVED***{
***REMOVED******REMOVED***transform:***REMOVED***translateY(-2px);
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***4px***REMOVED***16px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.15);
}

.recent-item.playing***REMOVED***{
***REMOVED******REMOVED***border-color:***REMOVED***#409eff;
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(135deg,***REMOVED***#f0f9ff***REMOVED***0%,***REMOVED***#e6f7ff***REMOVED***100%);
}

.item-index***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***30px;
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***color:***REMOVED***#999;
***REMOVED******REMOVED***font-weight:***REMOVED***bold;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
}

.item-cover***REMOVED***{
***REMOVED******REMOVED***position:***REMOVED***relative;
***REMOVED******REMOVED***width:***REMOVED***60px;
***REMOVED******REMOVED***height:***REMOVED***60px;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***15px;
***REMOVED******REMOVED***border-radius:***REMOVED***8px;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***cursor:***REMOVED***pointer;
}

.item-cover***REMOVED***img***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***100%;
***REMOVED******REMOVED***height:***REMOVED***100%;
***REMOVED******REMOVED***object-fit:***REMOVED***cover;
}

.play-overlay***REMOVED***{
***REMOVED******REMOVED***position:***REMOVED***absolute;
***REMOVED******REMOVED***top:***REMOVED***0;
***REMOVED******REMOVED***left:***REMOVED***0;
***REMOVED******REMOVED***right:***REMOVED***0;
***REMOVED******REMOVED***bottom:***REMOVED***0;
***REMOVED******REMOVED***background:***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.5);
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***justify-content:***REMOVED***center;
***REMOVED******REMOVED***opacity:***REMOVED***0;
***REMOVED******REMOVED***transition:***REMOVED***opacity***REMOVED***0.3s***REMOVED***ease;
}

.item-cover:hover***REMOVED***.play-overlay***REMOVED***{
***REMOVED******REMOVED***opacity:***REMOVED***1;
}

.play-overlay***REMOVED***i***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***white;
***REMOVED******REMOVED***font-size:***REMOVED***24px;
}

.item-info***REMOVED***{
***REMOVED******REMOVED***flex:***REMOVED***1;
***REMOVED******REMOVED***min-width:***REMOVED***0;
***REMOVED******REMOVED***margin-right:***REMOVED***15px;
}

.song-title***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***font-weight:***REMOVED***600;
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***margin-bottom:***REMOVED***4px;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
}

.song-artist***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***margin-bottom:***REMOVED***6px;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
}

.play-info***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***gap:***REMOVED***12px;
***REMOVED******REMOVED***font-size:***REMOVED***12px;
***REMOVED******REMOVED***color:***REMOVED***#999;
}

.play-time***REMOVED***{
***REMOVED******REMOVED***font-weight:***REMOVED***500;
}

.play-duration***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#409eff;
}

.play-progress***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#67c23a;
}

.item-actions***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***gap:***REMOVED***8px;
}

.item-actions***REMOVED***.round-btn***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***40px;
***REMOVED******REMOVED***height:***REMOVED***40px;
***REMOVED******REMOVED***border:***REMOVED***none;
***REMOVED******REMOVED***color:***REMOVED***#fff;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***4px***REMOVED***10px***REMOVED***rgba(0,0,0,0.12);
}

.round-btn***REMOVED***i***REMOVED***{***REMOVED***font-size:***REMOVED***18px;***REMOVED***}

.round-btn.play***REMOVED***{***REMOVED***background:***REMOVED***linear-gradient(135deg,***REMOVED***#7a5cff,***REMOVED***#4db6ff);***REMOVED***}
.round-btn.add***REMOVED***{***REMOVED***background:***REMOVED***linear-gradient(135deg,***REMOVED***#f4a261,***REMOVED***#f4c361);***REMOVED***}
.round-btn.download***REMOVED***{***REMOVED***background:***REMOVED***linear-gradient(135deg,***REMOVED***#56ab2f,***REMOVED***#a8e063);***REMOVED***}
.round-btn.remove***REMOVED***{***REMOVED***background:***REMOVED***linear-gradient(135deg,***REMOVED***#ff6b6b,***REMOVED***#ff8e8e);***REMOVED***}

.round-btn:hover***REMOVED***{***REMOVED***filter:***REMOVED***brightness(1.05);***REMOVED***}
.round-btn:active***REMOVED***{***REMOVED***transform:***REMOVED***scale(0.96);***REMOVED***}

/****REMOVED***响应式设计***REMOVED****/
@media***REMOVED***(max-width:***REMOVED***768px)***REMOVED***{
***REMOVED******REMOVED***.recent***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***padding:***REMOVED***15px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.recent-header***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***flex-direction:***REMOVED***column;
***REMOVED******REMOVED******REMOVED******REMOVED***gap:***REMOVED***15px;
***REMOVED******REMOVED******REMOVED******REMOVED***align-items:***REMOVED***flex-start;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.recent-item***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***padding:***REMOVED***12px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.item-cover***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***width:***REMOVED***50px;
***REMOVED******REMOVED******REMOVED******REMOVED***height:***REMOVED***50px;
***REMOVED******REMOVED******REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***10px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.item-info***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***margin-right:***REMOVED***10px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.song-title***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.song-artist***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***font-size:***REMOVED***12px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.play-info***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***flex-direction:***REMOVED***column;
***REMOVED******REMOVED******REMOVED******REMOVED***gap:***REMOVED***4px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.item-actions***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***flex-direction:***REMOVED***column;
***REMOVED******REMOVED******REMOVED******REMOVED***gap:***REMOVED***4px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.item-actions***REMOVED***.round-btn***REMOVED***{***REMOVED***width:***REMOVED***36px;***REMOVED***height:***REMOVED***36px;***REMOVED***}
}
</style>