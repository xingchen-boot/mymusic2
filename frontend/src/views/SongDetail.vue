<template>
***REMOVED******REMOVED***<div***REMOVED***class="song-detail"***REMOVED***v-if="music">
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="header">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<img***REMOVED***:src="music.cover"***REMOVED***alt="cover"***REMOVED***class="cover"***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="meta">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h1***REMOVED***class="title">{{***REMOVED***music.song***REMOVED***}}</h1>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***class="artist">{{***REMOVED***music.singer***REMOVED***}}</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***class="album"***REMOVED***v-if="music.album">专辑：{{***REMOVED***music.album***REMOVED***}}</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***class="duration"***REMOVED***v-if="music.time">时长：{{***REMOVED***formatTime(music.time)***REMOVED***}}</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="actions">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="primary"***REMOVED***@click="togglePlay">{{***REMOVED***isPlayingCurrent***REMOVED***?***REMOVED***'⏸️***REMOVED***暂停'***REMOVED***:***REMOVED***'▶️***REMOVED***播放'***REMOVED***}}</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***@click="toggleFavorite">{{***REMOVED***isLiked***REMOVED***?***REMOVED***'❤️***REMOVED***已收藏'***REMOVED***:***REMOVED***'🤍***REMOVED***收藏'***REMOVED***}}</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***@click="addToQueue">➕***REMOVED***加入队列</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***@click="download">⬇️***REMOVED***下载</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="info">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h2>歌曲信息</h2>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<ul>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<li><strong>MID：</strong>{{***REMOVED***music.mid***REMOVED***||***REMOVED***'-'***REMOVED***}}</li>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<li><strong>ID：</strong>{{***REMOVED***music.id***REMOVED***||***REMOVED***'-'***REMOVED***}}</li>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</ul>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED***</div>
***REMOVED******REMOVED***<div***REMOVED***v-else***REMOVED***class="empty">暂无歌曲信息</div>
***REMOVED***</template>

<script***REMOVED***setup***REMOVED***lang="ts">
import***REMOVED***{***REMOVED***computed***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useRoute***REMOVED***}***REMOVED***from***REMOVED***'vue-router'
import***REMOVED***{***REMOVED***useMusicStore***REMOVED***}***REMOVED***from***REMOVED***'../stores/music'

const***REMOVED***route***REMOVED***=***REMOVED***useRoute()
const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore()

const***REMOVED***current***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.currentMusic)

//***REMOVED***优先通过路由参数查找（mid），否则使用当前播放的歌曲
const***REMOVED***music***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***mid***REMOVED***=***REMOVED***route.params.mid***REMOVED***as***REMOVED***string***REMOVED***|***REMOVED***undefined
***REMOVED******REMOVED***if***REMOVED***(mid)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***在队列或收藏中尝试找到该歌曲
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***inQueue***REMOVED***=***REMOVED***(musicStore***REMOVED***as***REMOVED***any).playQueue?.find((m:***REMOVED***any)***REMOVED***=>***REMOVED***m.mid***REMOVED***===***REMOVED***mid)
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(inQueue)***REMOVED***return***REMOVED***inQueue
***REMOVED******REMOVED***}
***REMOVED******REMOVED***return***REMOVED***current.value
})

const***REMOVED***isPlayingCurrent***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***return***REMOVED***music.value***REMOVED***&&***REMOVED***current.value***REMOVED***&&***REMOVED***(music.value***REMOVED***as***REMOVED***any).mid***REMOVED***===***REMOVED***(current.value***REMOVED***as***REMOVED***any).mid***REMOVED***&&***REMOVED***musicStore.isPlaying
})

//***REMOVED***仅当详情歌曲是当前播放时，采用全局的收藏状态；否则暂不显示已收藏（避免直接依赖***REMOVED***favorites***REMOVED***列表）
const***REMOVED***isLiked***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!music.value)***REMOVED***return***REMOVED***false
***REMOVED******REMOVED***const***REMOVED***same***REMOVED***=***REMOVED***current.value***REMOVED***&&***REMOVED***(music.value***REMOVED***as***REMOVED***any).mid***REMOVED***===***REMOVED***(current.value***REMOVED***as***REMOVED***any).mid
***REMOVED******REMOVED***return***REMOVED***same***REMOVED***?***REMOVED***(musicStore***REMOVED***as***REMOVED***any).isCurrentMusicLiked***REMOVED***:***REMOVED***false
})

const***REMOVED***togglePlay***REMOVED***=***REMOVED***async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!music.value)***REMOVED***return
***REMOVED******REMOVED***if***REMOVED***(isPlayingCurrent.value)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***musicStore.togglePlay()
***REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.playMusic(music.value***REMOVED***as***REMOVED***any)
***REMOVED******REMOVED***}
}

const***REMOVED***toggleFavorite***REMOVED***=***REMOVED***async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!music.value)***REMOVED***return
***REMOVED******REMOVED***const***REMOVED***same***REMOVED***=***REMOVED***current.value***REMOVED***&&***REMOVED***(music.value***REMOVED***as***REMOVED***any).mid***REMOVED***===***REMOVED***(current.value***REMOVED***as***REMOVED***any).mid
***REMOVED******REMOVED***if***REMOVED***(!same)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.playMusic(music.value***REMOVED***as***REMOVED***any)
***REMOVED******REMOVED***}
***REMOVED******REMOVED***await***REMOVED***(musicStore***REMOVED***as***REMOVED***any).toggleFavorite()
}

const***REMOVED***addToQueue***REMOVED***=***REMOVED***async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!music.value)***REMOVED***return
***REMOVED******REMOVED***await***REMOVED***musicStore.addToPlayQueueWithSync(music.value***REMOVED***as***REMOVED***any)
}

const***REMOVED***download***REMOVED***=***REMOVED***async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!music.value)***REMOVED***return
***REMOVED******REMOVED***await***REMOVED***musicStore.downloadMusic(music.value***REMOVED***as***REMOVED***any)
}

const***REMOVED***formatTime***REMOVED***=***REMOVED***(seconds:***REMOVED***number)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!seconds***REMOVED***&&***REMOVED***seconds***REMOVED***!==***REMOVED***0)***REMOVED***return***REMOVED***'-'
***REMOVED******REMOVED***const***REMOVED***mins***REMOVED***=***REMOVED***Math.floor(seconds***REMOVED***/***REMOVED***60)
***REMOVED******REMOVED***const***REMOVED***secs***REMOVED***=***REMOVED***Math.floor(seconds***REMOVED***%***REMOVED***60)
***REMOVED******REMOVED***return***REMOVED***`${mins.toString().padStart(2,***REMOVED***'0')}:${secs.toString().padStart(2,***REMOVED***'0')}`
}
</script>

<style***REMOVED***scoped>
.song-detail***REMOVED***{***REMOVED***max-width:***REMOVED***980px;***REMOVED***margin:***REMOVED***24px***REMOVED***auto;***REMOVED***padding:***REMOVED***0***REMOVED***16px;***REMOVED***}
.header***REMOVED***{***REMOVED***display:***REMOVED***flex;***REMOVED***gap:***REMOVED***20px;***REMOVED***}
.cover***REMOVED***{***REMOVED***width:***REMOVED***220px;***REMOVED***height:***REMOVED***220px;***REMOVED***border-radius:***REMOVED***12px;***REMOVED***object-fit:***REMOVED***cover;***REMOVED***box-shadow:***REMOVED***0***REMOVED***8px***REMOVED***24px***REMOVED***rgba(0,0,0,.15);***REMOVED***}
.meta***REMOVED***{***REMOVED***flex:***REMOVED***1;***REMOVED***}
.title***REMOVED***{***REMOVED***margin:***REMOVED***8px***REMOVED***0***REMOVED***6px;***REMOVED***font-size:***REMOVED***28px;***REMOVED***font-weight:***REMOVED***700;***REMOVED***color:***REMOVED***#1f2328;***REMOVED***}
.artist,***REMOVED***.album,***REMOVED***.duration***REMOVED***{***REMOVED***margin:***REMOVED***4px***REMOVED***0;***REMOVED***color:***REMOVED***#6b7280;***REMOVED***}
.actions***REMOVED***{***REMOVED***margin-top:***REMOVED***14px;***REMOVED***display:***REMOVED***flex;***REMOVED***gap:***REMOVED***10px;***REMOVED***}
.info***REMOVED***{***REMOVED***margin-top:***REMOVED***30px;***REMOVED***}
.info***REMOVED***h2***REMOVED***{***REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***10px;***REMOVED***font-size:***REMOVED***18px;***REMOVED***}
.empty***REMOVED***{***REMOVED***max-width:***REMOVED***980px;***REMOVED***margin:***REMOVED***48px***REMOVED***auto;***REMOVED***text-align:***REMOVED***center;***REMOVED***color:***REMOVED***#9aa5b1;***REMOVED***}
</style>

