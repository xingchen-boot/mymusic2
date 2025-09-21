<template>
***REMOVED******REMOVED***<footer***REMOVED***class="footer"***REMOVED***v-if="hasCurrentMusic">
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="player-content">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***当前播放歌曲信息***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="player-info">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<img***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:src="currentMusic?.cover"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:alt="currentMusic?.song"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="player-cover"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="player-details">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h4***REMOVED***class="song-title">{{***REMOVED***currentMusic?.song***REMOVED***}}</h4>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***class="artist-name">{{***REMOVED***currentMusic?.singer***REMOVED***}}</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="player-actions">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="text"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="toggleLike"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="like-btn"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:class="{***REMOVED***liked:***REMOVED***isLiked***REMOVED***}"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***isLiked***REMOVED***?***REMOVED***'❤️'***REMOVED***:***REMOVED***'🤍'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***播放控制***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="player-controls">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="control-buttons">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***@click="playPrevious"***REMOVED***class="control-btn">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***⏮️
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="primary"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="togglePlay"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="play-btn"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***circle
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***isPlaying***REMOVED***?***REMOVED***'⏸️'***REMOVED***:***REMOVED***'▶️'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***@click="playNext"***REMOVED***class="control-btn">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***⏭️
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***进度条***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="progress-section">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="time">{{***REMOVED***formatTime(currentTime)***REMOVED***}}</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-slider
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:model-value="progress"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@input="setProgress"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:show-tooltip="false"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="progress-slider"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="time">{{***REMOVED***formatTime(duration)***REMOVED***}}</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***音量和其他控制***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="player-extra">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="volume-control">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***@click="toggleMute"***REMOVED***class="volume-btn">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***isMuted***REMOVED***?***REMOVED***'🔇'***REMOVED***:***REMOVED***'🔊'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-slider
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:model-value="volume"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@input="setVolume"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:show-tooltip="false"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="volume-slider"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="extra-controls">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***@click="togglePlayMode"***REMOVED***class="mode-btn">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***playModeIcon***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***@click="togglePlaylist"***REMOVED***class="playlist-btn">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***📋播放队列***REMOVED***({{***REMOVED***queueCount***REMOVED***}})
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED***</footer>
</template>

<script***REMOVED***setup***REMOVED***lang="ts">
import***REMOVED***{***REMOVED***ref,***REMOVED***computed***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useMusicStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/music'

const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore()

//***REMOVED***响应式数据
const***REMOVED***isLiked***REMOVED***=***REMOVED***ref(false)
const***REMOVED***isMuted***REMOVED***=***REMOVED***ref(false)
const***REMOVED***volume***REMOVED***=***REMOVED***ref(70)
const***REMOVED***playMode***REMOVED***=***REMOVED***ref('list')***REMOVED***//***REMOVED***list,***REMOVED***single,***REMOVED***random

//***REMOVED***计算属性
const***REMOVED***currentMusic***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.currentMusic)
const***REMOVED***isPlaying***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.isPlaying)
const***REMOVED***hasCurrentMusic***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.hasCurrentMusic)
const***REMOVED***currentTime***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.currentTime)
const***REMOVED***duration***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.duration)
const***REMOVED***progress***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.progress)
const***REMOVED***queueCount***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.queueCount)

const***REMOVED***playModeIcon***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***switch***REMOVED***(playMode.value)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***case***REMOVED***'list':***REMOVED***return***REMOVED***'🔁'
***REMOVED******REMOVED******REMOVED******REMOVED***case***REMOVED***'single':***REMOVED***return***REMOVED***'🔂'
***REMOVED******REMOVED******REMOVED******REMOVED***case***REMOVED***'random':***REMOVED***return***REMOVED***'🔀'
***REMOVED******REMOVED******REMOVED******REMOVED***default:***REMOVED***return***REMOVED***'🔁'
***REMOVED******REMOVED***}
})

//***REMOVED***方法
const***REMOVED***togglePlay***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***musicStore.togglePlay()
}

const***REMOVED***playPrevious***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***musicStore.playPrevious()
}

const***REMOVED***playNext***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***musicStore.playNext()
}

const***REMOVED***setProgress***REMOVED***=***REMOVED***(value:***REMOVED***number)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***musicStore.setProgress(value)
}

const***REMOVED***setVolume***REMOVED***=***REMOVED***(value:***REMOVED***number)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***volume.value***REMOVED***=***REMOVED***value
***REMOVED******REMOVED***//***REMOVED***这里可以设置音频音量
}

const***REMOVED***toggleMute***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***isMuted.value***REMOVED***=***REMOVED***!isMuted.value
***REMOVED******REMOVED***//***REMOVED***这里可以静音/取消静音
}

const***REMOVED***toggleLike***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***isLiked.value***REMOVED***=***REMOVED***!isLiked.value
}

const***REMOVED***togglePlayMode***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***modes***REMOVED***=***REMOVED***['list',***REMOVED***'single',***REMOVED***'random']
***REMOVED******REMOVED***const***REMOVED***currentIndex***REMOVED***=***REMOVED***modes.indexOf(playMode.value)
***REMOVED******REMOVED***playMode.value***REMOVED***=***REMOVED***modes[(currentIndex***REMOVED***+***REMOVED***1)***REMOVED***%***REMOVED***modes.length]
}

const***REMOVED***togglePlaylist***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***musicStore.togglePlayQueue()
}

const***REMOVED***playMusic***REMOVED***=***REMOVED***(music:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***musicStore.playMusicFromQueue(music)
}


const***REMOVED***formatTime***REMOVED***=***REMOVED***(seconds:***REMOVED***number)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***mins***REMOVED***=***REMOVED***Math.floor(seconds***REMOVED***/***REMOVED***60)
***REMOVED******REMOVED***const***REMOVED***secs***REMOVED***=***REMOVED***Math.floor(seconds***REMOVED***%***REMOVED***60)
***REMOVED******REMOVED***return***REMOVED***`${mins.toString().padStart(2,***REMOVED***'0')}:${secs.toString().padStart(2,***REMOVED***'0')}`
}
</script>

<style***REMOVED***scoped>
.footer***REMOVED***{
***REMOVED******REMOVED***height:***REMOVED***80px;
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***border-top:***REMOVED***1px***REMOVED***solid***REMOVED***#e0e0e0;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***-2px***REMOVED***8px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.1);
***REMOVED******REMOVED***position:***REMOVED***sticky;
***REMOVED******REMOVED***bottom:***REMOVED***0;
***REMOVED******REMOVED***z-index:***REMOVED***1000;
}

.player-content***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***height:***REMOVED***100%;
***REMOVED******REMOVED***max-width:***REMOVED***1200px;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***auto;
***REMOVED******REMOVED***padding:***REMOVED***0***REMOVED***20px;
***REMOVED******REMOVED***gap:***REMOVED***20px;
}

.player-info***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***min-width:***REMOVED***250px;
***REMOVED******REMOVED***gap:***REMOVED***12px;
}

.player-cover***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***50px;
***REMOVED******REMOVED***height:***REMOVED***50px;
***REMOVED******REMOVED***border-radius:***REMOVED***6px;
***REMOVED******REMOVED***object-fit:***REMOVED***cover;
}

.player-details***REMOVED***{
***REMOVED******REMOVED***flex:***REMOVED***1;
***REMOVED******REMOVED***min-width:***REMOVED***0;
}

.song-title***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***font-weight:***REMOVED***500;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***4px***REMOVED***0;
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
}

.artist-name***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***12px;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
}

.player-actions***REMOVED***{
***REMOVED******REMOVED***margin-left:***REMOVED***8px;
}

.like-btn***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***padding:***REMOVED***4px;
}

.like-btn.liked***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#ff4757;
}

.player-controls***REMOVED***{
***REMOVED******REMOVED***flex:***REMOVED***1;
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***flex-direction:***REMOVED***column;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***gap:***REMOVED***0px;
}

.control-buttons***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***gap:***REMOVED***8px;
}

.control-btn***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***18px;
***REMOVED******REMOVED***padding:***REMOVED***8px;
***REMOVED******REMOVED***color:***REMOVED***#666;
}

.play-btn***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***40px;
***REMOVED******REMOVED***height:***REMOVED***40px;
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***border:***REMOVED***none;
}

.play-btn:hover***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#764ba2,***REMOVED***#667eea);
}

.progress-section***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***gap:***REMOVED***12px;
***REMOVED******REMOVED***width:***REMOVED***100%;
***REMOVED******REMOVED***max-width:***REMOVED***400px;
}

.time***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***12px;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***min-width:***REMOVED***40px;
***REMOVED******REMOVED***text-align:***REMOVED***center;
}

.progress-slider***REMOVED***{
***REMOVED******REMOVED***flex:***REMOVED***1;
}

.player-extra***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***gap:***REMOVED***15px;
***REMOVED******REMOVED***min-width:***REMOVED***200px;
}

.volume-control***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***gap:***REMOVED***8px;
}

.volume-btn***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***padding:***REMOVED***4px;
***REMOVED******REMOVED***color:***REMOVED***#666;
}

.volume-slider***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***80px;
}

.extra-controls***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***gap:***REMOVED***8px;
}

.mode-btn,***REMOVED***.playlist-btn***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***padding:***REMOVED***4px;
***REMOVED******REMOVED***color:***REMOVED***#666;
}

/****REMOVED***Element***REMOVED***Plus***REMOVED***样式覆盖***REMOVED****/
:deep(.el-button--text)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#666;
}

:deep(.el-button--text:hover)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#333;
}

:deep(.el-button--primary)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***border:***REMOVED***none;
}

:deep(.el-button--primary:hover)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#764ba2,***REMOVED***#667eea);
}

/****REMOVED***播放队列面板样式***REMOVED****/
.play-queue-panel***REMOVED***{
***REMOVED******REMOVED***position:***REMOVED***fixed;
***REMOVED******REMOVED***bottom:***REMOVED***80px;
***REMOVED******REMOVED***right:***REMOVED***20px;
***REMOVED******REMOVED***width:***REMOVED***400px;
***REMOVED******REMOVED***max-height:***REMOVED***500px;
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***border-radius:***REMOVED***12px;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***8px***REMOVED***32px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.2);
***REMOVED******REMOVED***z-index:***REMOVED***1000;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
}

/****REMOVED***队列面板动画***REMOVED****/
.queue-panel-enter-active,
.queue-panel-leave-active***REMOVED***{
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.3s***REMOVED***ease;
}

.queue-panel-enter-from***REMOVED***{
***REMOVED******REMOVED***opacity:***REMOVED***0;
***REMOVED******REMOVED***transform:***REMOVED***translateY(20px)***REMOVED***scale(0.95);
}

.queue-panel-leave-to***REMOVED***{
***REMOVED******REMOVED***opacity:***REMOVED***0;
***REMOVED******REMOVED***transform:***REMOVED***translateY(20px)***REMOVED***scale(0.95);
}

.queue-header***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***justify-content:***REMOVED***space-between;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***16px***REMOVED***20px;
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***color:***REMOVED***white;
}

.queue-header***REMOVED***h3***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***font-weight:***REMOVED***600;
}

.queue-actions***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***gap:***REMOVED***8px;
}

.queue-actions***REMOVED***.el-button***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***white***REMOVED***!important;
***REMOVED******REMOVED***font-weight:***REMOVED***500;
}

.queue-actions***REMOVED***.el-button:hover***REMOVED***{
***REMOVED******REMOVED***background-color:***REMOVED***rgba(255,***REMOVED***255,***REMOVED***255,***REMOVED***0.2)***REMOVED***!important;
***REMOVED******REMOVED***color:***REMOVED***white***REMOVED***!important;
}

.queue-list***REMOVED***{
***REMOVED******REMOVED***max-height:***REMOVED***400px;
***REMOVED******REMOVED***overflow-y:***REMOVED***auto;
}

.queue-item***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***12px***REMOVED***20px;
***REMOVED******REMOVED***border-bottom:***REMOVED***1px***REMOVED***solid***REMOVED***#f0f0f0;
***REMOVED******REMOVED***transition:***REMOVED***background-color***REMOVED***0.2s***REMOVED***ease;
}

.queue-item:hover***REMOVED***{
***REMOVED******REMOVED***background-color:***REMOVED***#f8f9fa;
}

.queue-item.current***REMOVED***{
***REMOVED******REMOVED***background-color:***REMOVED***#e3f2fd;
***REMOVED******REMOVED***border-left:***REMOVED***3px***REMOVED***solid***REMOVED***#667eea;
}

.queue-number***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***24px;
***REMOVED******REMOVED***height:***REMOVED***24px;
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***justify-content:***REMOVED***center;
***REMOVED******REMOVED***background:***REMOVED***#f0f0f0;
***REMOVED******REMOVED***border-radius:***REMOVED***50%;
***REMOVED******REMOVED***font-size:***REMOVED***12px;
***REMOVED******REMOVED***font-weight:***REMOVED***600;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***margin-right:***REMOVED***12px;
}

.queue-item.current***REMOVED***.queue-number***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***#667eea;
***REMOVED******REMOVED***color:***REMOVED***white;
}

.queue-cover***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***40px;
***REMOVED******REMOVED***height:***REMOVED***40px;
***REMOVED******REMOVED***border-radius:***REMOVED***6px;
***REMOVED******REMOVED***object-fit:***REMOVED***cover;
***REMOVED******REMOVED***margin-right:***REMOVED***12px;
}

.queue-info***REMOVED***{
***REMOVED******REMOVED***flex:***REMOVED***1;
***REMOVED******REMOVED***min-width:***REMOVED***0;
}

.queue-title***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***font-weight:***REMOVED***500;
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
***REMOVED******REMOVED***margin-bottom:***REMOVED***2px;
}

.queue-artist***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***12px;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
}

.queue-actions***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***gap:***REMOVED***4px;
***REMOVED******REMOVED***align-items:***REMOVED***center;
}

.play-btn,***REMOVED***.remove-btn***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***4px;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***justify-content:***REMOVED***center;
}

.remove-btn***REMOVED***{
***REMOVED******REMOVED***margin-top:***REMOVED***2px;
}

.play-btn:hover***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#667eea;
***REMOVED******REMOVED***background-color:***REMOVED***rgba(102,***REMOVED***126,***REMOVED***234,***REMOVED***0.1);
***REMOVED******REMOVED***border-radius:***REMOVED***4px;
}

.remove-btn:hover***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#ff4757;
***REMOVED******REMOVED***background-color:***REMOVED***rgba(255,***REMOVED***71,***REMOVED***87,***REMOVED***0.1);
***REMOVED******REMOVED***border-radius:***REMOVED***4px;
}

.empty-queue***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***40px***REMOVED***20px;
***REMOVED******REMOVED***color:***REMOVED***#999;
}

.empty-queue***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
}

:deep(.el-slider__runway)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***#e0e0e0;
***REMOVED******REMOVED***height:***REMOVED***4px;
}

:deep(.el-slider__bar)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***height:***REMOVED***4px;
}

:deep(.el-slider__button)***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***12px;
***REMOVED******REMOVED***height:***REMOVED***12px;
***REMOVED******REMOVED***background:***REMOVED***#667eea;
***REMOVED******REMOVED***border:***REMOVED***2px***REMOVED***solid***REMOVED***white;
}

/****REMOVED***响应式设计***REMOVED****/
@media***REMOVED***(max-width:***REMOVED***768px)***REMOVED***{
***REMOVED******REMOVED***.player-content***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***padding:***REMOVED***0***REMOVED***10px;
***REMOVED******REMOVED******REMOVED******REMOVED***gap:***REMOVED***10px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.player-info***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***min-width:***REMOVED***180px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.player-extra***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***min-width:***REMOVED***120px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.volume-slider***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***width:***REMOVED***60px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.progress-section***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***max-width:***REMOVED***200px;
***REMOVED******REMOVED***}
}
</style>
