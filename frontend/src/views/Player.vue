<template>
***REMOVED******REMOVED***<div***REMOVED***class="player-shell">
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="current"***REMOVED***class="player-page">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="left">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="disc-wrap">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="disc***REMOVED***spinning"***REMOVED***:class="{***REMOVED***paused:***REMOVED***!isPlaying***REMOVED***}"***REMOVED***@click="togglePlay">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<img***REMOVED***:src="current.cover"***REMOVED***alt="cover"***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="center-hole"></div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="tips">点击封面{{***REMOVED***isPlaying***REMOVED***?***REMOVED***'暂停'***REMOVED***:***REMOVED***'播放'***REMOVED***}}</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***歌名***REMOVED***/***REMOVED***歌手***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="under-meta">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h2***REMOVED***class="under-title">{{***REMOVED***current.song***REMOVED***}}</h2>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="under-artist">{{***REMOVED***current.singer***REMOVED***}}</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***进度条***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="under-progress">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="time">{{***REMOVED***formatTime(currentTime)***REMOVED***}}</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-slider***REMOVED***:model-value="progress"***REMOVED***@input="setProgress"***REMOVED***:show-tooltip="false"***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="time">{{***REMOVED***formatTime(duration)***REMOVED***}}</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***控制按钮行：队列***REMOVED***|***REMOVED***上一首***REMOVED***|***REMOVED***播放/暂停***REMOVED***|***REMOVED***下一首***REMOVED***|***REMOVED***模式***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="controls-line">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***class="ctl"***REMOVED***@click="musicStore.togglePlayQueue">📋</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***class="ctl"***REMOVED***@click="playPrevious">⏮️</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="primary"***REMOVED***circle***REMOVED***class="play"***REMOVED***@click="togglePlay">{{***REMOVED***isPlaying***REMOVED***?***REMOVED***'⏸️'***REMOVED***:***REMOVED***'▶️'***REMOVED***}}</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***class="ctl"***REMOVED***@click="playNext">⏭️</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***class="ctl"***REMOVED***@click="musicStore.togglePlayMode">{{***REMOVED***musicStore.playModeIcon***REMOVED***}}</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***音量行***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="volume-line">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***class="ctl"***REMOVED***@click="musicStore.toggleMute">{{***REMOVED***musicStore.isMuted***REMOVED***?***REMOVED***'🔇'***REMOVED***:***REMOVED***'🔊'***REMOVED***}}</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-slider***REMOVED***class="volume-slider"***REMOVED***:model-value="musicStore.volume"***REMOVED***@input="musicStore.setVolume"***REMOVED***:show-tooltip="false"***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="right">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="meta">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h1***REMOVED***class="title">{{***REMOVED***current.song***REMOVED***}}</h1>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***class="artist">{{***REMOVED***current.singer***REMOVED***}}</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="lyrics-controls">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="text"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="small"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="showTranslation***REMOVED***=***REMOVED***!showTranslation"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:class="{***REMOVED***active:***REMOVED***showTranslation***REMOVED***}"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***showTranslation***REMOVED***?***REMOVED***'🌐***REMOVED***隐藏翻译'***REMOVED***:***REMOVED***'🌐***REMOVED***显示翻译'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="lyrics"***REMOVED***v-if="lyricsLines.length">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-for="(line,***REMOVED***idx)***REMOVED***in***REMOVED***lyricsLines"***REMOVED***:key="idx"***REMOVED***:class="['line',***REMOVED***{***REMOVED***active:***REMOVED***idx***REMOVED***===***REMOVED***activeLineIndex***REMOVED***}]">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="lyric-text">{{***REMOVED***line.text***REMOVED***}}</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="showTranslation***REMOVED***&&***REMOVED***line.translation"***REMOVED***class="lyric-translation">{{***REMOVED***line.translation***REMOVED***}}</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else***REMOVED***class="lyrics***REMOVED***empty">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="isLoadingLyrics"***REMOVED***class="loading">正在加载歌词...</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else***REMOVED***class="no-lyrics">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="no-lyrics-icon">🎵</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="no-lyrics-text">该歌曲暂无歌词</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="no-lyrics-tip">请尝试播放其他歌曲</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else***REMOVED***class="empty">暂无正在播放的音乐</div>
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***播放队列面板***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED***<transition***REMOVED***name="queue-panel">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="musicStore.showPlayQueue"***REMOVED***class="play-queue-panel">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="queue-header">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h3>播放队列***REMOVED***({{***REMOVED***musicStore.queueCount***REMOVED***}})</h3>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="queue-actions">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***@click="musicStore.clearPlayQueueWithSync"***REMOVED***size="small">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***清空队列
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="text"***REMOVED***@click="musicStore.togglePlayQueue"***REMOVED***size="small">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***✕
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="queue-list">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-for="(music,***REMOVED***index)***REMOVED***in***REMOVED***musicStore.playQueue"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:key="music.id"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="queue-item"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:class="{***REMOVED***'current':***REMOVED***musicStore.currentMusic?.id***REMOVED***===***REMOVED***music.id***REMOVED***}"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="queue-number">{{***REMOVED***index***REMOVED***+***REMOVED***1***REMOVED***}}</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<img***REMOVED***:src="music.cover"***REMOVED***:alt="music.song"***REMOVED***class="queue-cover"***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="queue-info">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="queue-title">{{***REMOVED***music.song***REMOVED***}}</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="queue-artist">{{***REMOVED***music.singer***REMOVED***}}</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="queue-actions">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="text"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="musicStore.playMusic(music)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="small"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="play-btn"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***musicStore.currentMusic?.id***REMOVED***===***REMOVED***music.id***REMOVED***&&***REMOVED***musicStore.isPlaying***REMOVED***?***REMOVED***'⏸️'***REMOVED***:***REMOVED***'▶️'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="text"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="musicStore.removeFromPlayQueueWithSync(music.id)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="small"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="remove-btn"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***🗑️
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="musicStore.queueCount***REMOVED***===***REMOVED***0"***REMOVED***class="empty-queue">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>播放队列为空</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</transition>
***REMOVED******REMOVED***</div>
</template>

<script***REMOVED***setup***REMOVED***lang="ts">
import***REMOVED***{***REMOVED***computed,***REMOVED***ref,***REMOVED***watch,***REMOVED***onMounted***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useMusicStore***REMOVED***}***REMOVED***from***REMOVED***'../stores/music'
import***REMOVED***{***REMOVED***useUserStore***REMOVED***}***REMOVED***from***REMOVED***'../stores/user'

const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore()
const***REMOVED***userStore***REMOVED***=***REMOVED***useUserStore()

const***REMOVED***current***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.currentMusic)
const***REMOVED***isPlaying***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.isPlaying)
const***REMOVED***progress***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.progress)
const***REMOVED***currentTime***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.currentTime)
const***REMOVED***duration***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.duration)

const***REMOVED***togglePlay***REMOVED***=***REMOVED***async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***m***REMOVED***=***REMOVED***current.value***REMOVED***as***REMOVED***any
***REMOVED******REMOVED***if***REMOVED***(!m)***REMOVED***return
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***audioSrc***REMOVED***=***REMOVED***(musicStore***REMOVED***as***REMOVED***any).audio?.src***REMOVED***as***REMOVED***string***REMOVED***|***REMOVED***undefined
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***如果没有可用的音频源，则通过***REMOVED***playMusic***REMOVED***拉取并播放
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(!audioSrc)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.playMusic(m)
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***已有音源：统一走***REMOVED***store***REMOVED***的***REMOVED***togglePlay，确保***REMOVED***isPlaying***REMOVED***状态与按钮/动画同步
***REMOVED******REMOVED******REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.togglePlay()
***REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***catch***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***如遇播放失败，回退到重新拉取***REMOVED***URL
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.playMusic(m)
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(e)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***静默失败，避免中断***REMOVED***UI；实际错误处理在***REMOVED***store***REMOVED***内完成
***REMOVED******REMOVED***}
}
const***REMOVED***playPrevious***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***musicStore.playPrevious()
const***REMOVED***playNext***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***musicStore.playNext()
const***REMOVED***setProgress***REMOVED***=***REMOVED***async***REMOVED***(v:***REMOVED***number)***REMOVED***=>***REMOVED***{***REMOVED***await***REMOVED***musicStore.setProgress(v)***REMOVED***}

//***REMOVED***歌词相关状态
const***REMOVED***lyricsLines***REMOVED***=***REMOVED***ref<Array<{***REMOVED***time:***REMOVED***number;***REMOVED***text:***REMOVED***string;***REMOVED***translation?:***REMOVED***string***REMOVED***}>>([])
const***REMOVED***activeLineIndex***REMOVED***=***REMOVED***ref<number>(-1)
const***REMOVED***isLoadingLyrics***REMOVED***=***REMOVED***ref(false)
const***REMOVED***showTranslation***REMOVED***=***REMOVED***ref(true)***REMOVED***//***REMOVED***是否显示翻译

//***REMOVED***加载歌词
const***REMOVED***loadLyrics***REMOVED***=***REMOVED***async***REMOVED***(music:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!music)***REMOVED***return
***REMOVED******REMOVED***
***REMOVED******REMOVED***console.log('🎵***REMOVED***开始加载歌词:',***REMOVED***music.song,***REMOVED***music.id,***REMOVED***music.mid)
***REMOVED******REMOVED***
***REMOVED******REMOVED***isLoadingLyrics.value***REMOVED***=***REMOVED***true
***REMOVED******REMOVED***lyricsLines.value***REMOVED***=***REMOVED***[]
***REMOVED******REMOVED***activeLineIndex.value***REMOVED***=***REMOVED***-1
***REMOVED******REMOVED***
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***lyricsData***REMOVED***=***REMOVED***await***REMOVED***musicStore.getLyrics(music)
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(lyricsData)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.log('📝***REMOVED***歌词数据:',***REMOVED***lyricsData)
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***解析主歌词
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***mainLyrics***REMOVED***=***REMOVED***musicStore.parseLrc(lyricsData.lrc)
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.log('📝***REMOVED***主歌词解析结果:',***REMOVED***mainLyrics.length,***REMOVED***'行')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***解析翻译歌词
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***transLyrics***REMOVED***=***REMOVED***musicStore.parseLrc(lyricsData.trans)
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.log('🌐***REMOVED***翻译歌词解析结果:',***REMOVED***transLyrics.length,***REMOVED***'行')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***合并歌词和翻译
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***combinedLyrics***REMOVED***=***REMOVED***mainLyrics.map(line***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***查找对应的翻译
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***translation***REMOVED***=***REMOVED***transLyrics.find(trans***REMOVED***=>***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***Math.abs(trans.time***REMOVED***-***REMOVED***line.time)***REMOVED***<***REMOVED***0.5***REMOVED***//***REMOVED***时间差小于0.5秒
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***)
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***return***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***time:***REMOVED***line.time,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***text:***REMOVED***line.text,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***translation:***REMOVED***translation?.text
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***})
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***lyricsLines.value***REMOVED***=***REMOVED***combinedLyrics
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.log('✅***REMOVED***歌词加载完成，共',***REMOVED***combinedLyrics.length,***REMOVED***'行')
***REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.log('ℹ️***REMOVED***该歌曲暂无歌词数据')
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.error('加载歌词失败:',***REMOVED***error)
***REMOVED******REMOVED***}***REMOVED***finally***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***isLoadingLyrics.value***REMOVED***=***REMOVED***false
***REMOVED******REMOVED***}
}

//***REMOVED***监听当前歌曲变化
watch(current,***REMOVED***async***REMOVED***(m)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(m)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***loadLyrics(m)
***REMOVED******REMOVED***}
},***REMOVED***{***REMOVED***immediate:***REMOVED***true***REMOVED***})

//***REMOVED***监听播放时间，高亮当前歌词
watch(currentTime,***REMOVED***(t)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(lyricsLines.value.length***REMOVED***===***REMOVED***0)***REMOVED***return
***REMOVED******REMOVED***
***REMOVED******REMOVED***const***REMOVED***idx***REMOVED***=***REMOVED***lyricsLines.value.findIndex((l,***REMOVED***i)***REMOVED***=>***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***t***REMOVED***>=***REMOVED***l.time***REMOVED***&&***REMOVED***(i***REMOVED***===***REMOVED***lyricsLines.value.length***REMOVED***-***REMOVED***1***REMOVED***||***REMOVED***t***REMOVED***<***REMOVED***lyricsLines.value[i***REMOVED***+***REMOVED***1].time)
***REMOVED******REMOVED***)
***REMOVED******REMOVED***activeLineIndex.value***REMOVED***=***REMOVED***idx
***REMOVED******REMOVED***
***REMOVED******REMOVED***//***REMOVED***自动滚动到当前歌词
***REMOVED******REMOVED***if***REMOVED***(idx***REMOVED***>=***REMOVED***0)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***lyricsContainer***REMOVED***=***REMOVED***document.querySelector('.lyrics')
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(lyricsContainer)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***activeLine***REMOVED***=***REMOVED***lyricsContainer.querySelector('.line.active')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(activeLine)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***activeLine.scrollIntoView({***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***behavior:***REMOVED***'smooth',***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***block:***REMOVED***'center'***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***})
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}
})

const***REMOVED***formatTime***REMOVED***=***REMOVED***(seconds:***REMOVED***number)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***mins***REMOVED***=***REMOVED***Math.floor(seconds***REMOVED***/***REMOVED***60)
***REMOVED******REMOVED***const***REMOVED***secs***REMOVED***=***REMOVED***Math.floor(seconds***REMOVED***%***REMOVED***60)
***REMOVED******REMOVED***return***REMOVED***`${mins.toString().padStart(2,***REMOVED***'0')}:${secs.toString().padStart(2,***REMOVED***'0')}`
}

onMounted(async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***//***REMOVED***直接进入***REMOVED***/player***REMOVED***时，确保音频已初始化即可；避免在此恢复设置导致进度回退
***REMOVED******REMOVED***if***REMOVED***(!(musicStore***REMOVED***as***REMOVED***any).audio)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***musicStore.initAudio()
***REMOVED******REMOVED***}
***REMOVED******REMOVED***if***REMOVED***(!userStore.currentUser)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***userStore.initUserInfo?.()
***REMOVED******REMOVED***}
})
</script>

<style***REMOVED***scoped>
.player-shell***REMOVED***{***REMOVED***min-height:***REMOVED***calc(100vh***REMOVED***-***REMOVED***80px);***REMOVED***background:***REMOVED***radial-gradient(1200px***REMOVED***600px***REMOVED***at***REMOVED***20%***REMOVED***10%,***REMOVED***#7c83ff***REMOVED***0%,***REMOVED***#6c5ce7***REMOVED***25%,***REMOVED***#6f42c1***REMOVED***55%,***REMOVED***#51327a***REMOVED***100%);***REMOVED***padding:***REMOVED***24px***REMOVED***0;***REMOVED***}
.player-page***REMOVED***{***REMOVED***max-width:***REMOVED***1280px;***REMOVED***margin:***REMOVED***0***REMOVED***auto;***REMOVED***padding:***REMOVED***0***REMOVED***24px;***REMOVED***display:***REMOVED***grid;***REMOVED***grid-template-columns:***REMOVED***560px***REMOVED***1fr;***REMOVED***gap:***REMOVED***28px;***REMOVED***}
.left***REMOVED***{***REMOVED***display:***REMOVED***flex;***REMOVED***flex-direction:***REMOVED***column;***REMOVED***align-items:***REMOVED***center;***REMOVED***margin-top:***REMOVED***12px;***REMOVED***}
.disc-wrap***REMOVED***{***REMOVED***display:***REMOVED***grid;***REMOVED***place-items:***REMOVED***center;***REMOVED***}
.disc***REMOVED***{***REMOVED***width:***REMOVED***440px;***REMOVED***height:***REMOVED***440px;***REMOVED***border-radius:***REMOVED***50%;***REMOVED***background:***REMOVED***radial-gradient(#2b2f36***REMOVED***0%,***REMOVED***#151922***REMOVED***60%,***REMOVED***#0f1220***REMOVED***100%);***REMOVED***position:***REMOVED***relative;***REMOVED***box-shadow:***REMOVED***0***REMOVED***24px***REMOVED***48px***REMOVED***rgba(0,0,0,.35);***REMOVED***display:***REMOVED***grid;***REMOVED***place-items:***REMOVED***center;***REMOVED***overflow:***REMOVED***hidden;***REMOVED***}
.disc***REMOVED***img***REMOVED***{***REMOVED***width:***REMOVED***88%;***REMOVED***height:***REMOVED***88%;***REMOVED***border-radius:***REMOVED***50%;***REMOVED***object-fit:***REMOVED***cover;***REMOVED***filter:***REMOVED***contrast(1.05)***REMOVED***brightness(.98);***REMOVED***}
.center-hole***REMOVED***{***REMOVED***position:***REMOVED***absolute;***REMOVED***width:***REMOVED***18px;***REMOVED***height:***REMOVED***18px;***REMOVED***background:***REMOVED***#c7cad1;***REMOVED***border-radius:***REMOVED***50%;***REMOVED***box-shadow:***REMOVED***inset***REMOVED***0***REMOVED***0***REMOVED***0***REMOVED***4px***REMOVED***#2d3140;***REMOVED***}
.spinning***REMOVED***{***REMOVED***animation:***REMOVED***spin***REMOVED***14s***REMOVED***linear***REMOVED***infinite;***REMOVED***animation-play-state:***REMOVED***running;***REMOVED***}
.paused***REMOVED***{***REMOVED***animation-play-state:***REMOVED***paused;***REMOVED***}
@keyframes***REMOVED***spin***REMOVED***{***REMOVED***from***REMOVED***{***REMOVED***transform:***REMOVED***rotate(0deg);}***REMOVED***to***REMOVED***{***REMOVED***transform:***REMOVED***rotate(360deg);}***REMOVED***}
.tips***REMOVED***{***REMOVED***margin-top:***REMOVED***10px;***REMOVED***color:***REMOVED***rgba(255,255,255,.75);***REMOVED***font-size:***REMOVED***12px;***REMOVED***}
.under-meta***REMOVED***{***REMOVED***margin-top:***REMOVED***14px;***REMOVED***text-align:***REMOVED***center;***REMOVED***}
.under-title***REMOVED***{***REMOVED***margin:***REMOVED***0;***REMOVED***color:***REMOVED***#fff;***REMOVED***font-size:***REMOVED***22px;***REMOVED***font-weight:***REMOVED***800;***REMOVED***}
.under-artist***REMOVED***{***REMOVED***margin-top:***REMOVED***6px;***REMOVED***color:***REMOVED***#e5e7eb;***REMOVED***font-size:***REMOVED***13px;***REMOVED***}
.under-progress***REMOVED***{***REMOVED***margin-top:***REMOVED***12px;***REMOVED***width:***REMOVED***100%;***REMOVED***display:***REMOVED***grid;***REMOVED***grid-template-columns:***REMOVED***54px***REMOVED***1fr***REMOVED***54px;***REMOVED***gap:***REMOVED***8px;***REMOVED***align-items:***REMOVED***center;***REMOVED***}
.ctl***REMOVED***{***REMOVED***color:***REMOVED***#e5e7eb;***REMOVED***font-size:***REMOVED***18px;***REMOVED***}
.play***REMOVED***{***REMOVED***width:***REMOVED***46px;***REMOVED***height:***REMOVED***46px;***REMOVED***border:***REMOVED***none;***REMOVED***background:***REMOVED***linear-gradient(45deg,#67c3ff,#7b7cff);***REMOVED***}
.controls-line***REMOVED***{***REMOVED***margin-top:***REMOVED***10px;***REMOVED***display:***REMOVED***grid;***REMOVED***grid-template-columns:***REMOVED***1fr***REMOVED***auto***REMOVED***auto***REMOVED***auto***REMOVED***1fr;***REMOVED***gap:***REMOVED***10px;***REMOVED***align-items:***REMOVED***center;***REMOVED***}
.volume-line***REMOVED***{***REMOVED***margin-top:***REMOVED***8px;***REMOVED***width:***REMOVED***100%;***REMOVED***display:***REMOVED***grid;***REMOVED***grid-template-columns:***REMOVED***auto***REMOVED***auto;***REMOVED***gap:***REMOVED***10px;***REMOVED***align-items:***REMOVED***center;***REMOVED***justify-content:***REMOVED***center;***REMOVED***}
.volume-slider***REMOVED***{***REMOVED***width:***REMOVED***200px;***REMOVED***}
.time***REMOVED***{***REMOVED***color:***REMOVED***#d1d5db;***REMOVED***font-size:***REMOVED***12px;***REMOVED***text-align:***REMOVED***center;***REMOVED***}
.right***REMOVED***{***REMOVED***display:***REMOVED***flex;***REMOVED***flex-direction:***REMOVED***column;***REMOVED***}
.meta***REMOVED***.title***REMOVED***{***REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***6px;***REMOVED***font-size:***REMOVED***28px;***REMOVED***font-weight:***REMOVED***800;***REMOVED***color:***REMOVED***#fff;***REMOVED***}
.meta***REMOVED***.artist***REMOVED***{***REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***8px;***REMOVED***color:***REMOVED***#e5e7eb;***REMOVED***}

.lyrics-controls***REMOVED***{
***REMOVED******REMOVED***margin-bottom:***REMOVED***12px;
}

.lyrics-controls***REMOVED***.el-button***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#a0a0a0***REMOVED***!important;
***REMOVED******REMOVED***font-size:***REMOVED***12px;
***REMOVED******REMOVED***padding:***REMOVED***4px***REMOVED***8px;
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.2s***REMOVED***ease;
}

.lyrics-controls***REMOVED***.el-button:hover***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#67c3ff***REMOVED***!important;
}

.lyrics-controls***REMOVED***.el-button.active***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#67c3ff***REMOVED***!important;
***REMOVED******REMOVED***background-color:***REMOVED***rgba(103,***REMOVED***195,***REMOVED***255,***REMOVED***0.1);
}
.lyrics***REMOVED***{***REMOVED***
***REMOVED******REMOVED***margin-top:***REMOVED***4px;***REMOVED***
***REMOVED******REMOVED***padding:***REMOVED***16px;***REMOVED***
***REMOVED******REMOVED***height:***REMOVED***560px;***REMOVED***
***REMOVED******REMOVED***overflow-y:***REMOVED***auto;***REMOVED***
***REMOVED******REMOVED***background:***REMOVED***rgba(6,10,25,.85);***REMOVED***
***REMOVED******REMOVED***border-radius:***REMOVED***14px;***REMOVED***
***REMOVED******REMOVED***color:***REMOVED***#e5e7eb;***REMOVED***
***REMOVED******REMOVED***box-shadow:***REMOVED***inset***REMOVED***0***REMOVED***8px***REMOVED***16px***REMOVED***rgba(0,0,0,.35);***REMOVED***
***REMOVED******REMOVED***backdrop-filter:***REMOVED***blur(2px);***REMOVED***
***REMOVED******REMOVED***scroll-behavior:***REMOVED***smooth;
}

.lyrics***REMOVED***.line***REMOVED***{***REMOVED***
***REMOVED******REMOVED***opacity:***REMOVED***.6;***REMOVED***
***REMOVED******REMOVED***padding:***REMOVED***8px***REMOVED***0;***REMOVED***
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***.3s***REMOVED***ease;***REMOVED***
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***line-height:***REMOVED***1.6;
}

.lyrics***REMOVED***.line.active***REMOVED***{***REMOVED***
***REMOVED******REMOVED***opacity:***REMOVED***1;***REMOVED***
***REMOVED******REMOVED***color:***REMOVED***#fff;***REMOVED***
***REMOVED******REMOVED***font-weight:***REMOVED***700;***REMOVED***
***REMOVED******REMOVED***transform:***REMOVED***scale(1.05);
***REMOVED******REMOVED***text-shadow:***REMOVED***0***REMOVED***0***REMOVED***10px***REMOVED***rgba(255,255,255,0.3);
}

.lyric-text***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***margin-bottom:***REMOVED***4px;
}

.lyric-translation***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***color:***REMOVED***#a0a0a0;
***REMOVED******REMOVED***opacity:***REMOVED***0.8;
}

.lyrics.empty***REMOVED***{***REMOVED***
***REMOVED******REMOVED***display:***REMOVED***grid;***REMOVED***
***REMOVED******REMOVED***place-items:***REMOVED***center;***REMOVED***
***REMOVED******REMOVED***color:***REMOVED***#b6bdc6;***REMOVED***
}

.lyrics***REMOVED***.loading***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#67c3ff;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***animation:***REMOVED***pulse***REMOVED***1.5s***REMOVED***ease-in-out***REMOVED***infinite;
}

.no-lyrics***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***40px***REMOVED***20px;
}

.no-lyrics-icon***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***48px;
***REMOVED******REMOVED***margin-bottom:***REMOVED***16px;
***REMOVED******REMOVED***opacity:***REMOVED***0.6;
}

.no-lyrics-text***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***color:***REMOVED***#e5e7eb;
***REMOVED******REMOVED***margin-bottom:***REMOVED***8px;
***REMOVED******REMOVED***font-weight:***REMOVED***500;
}

.no-lyrics-tip***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***color:***REMOVED***#a0a0a0;
***REMOVED******REMOVED***opacity:***REMOVED***0.8;
}

@keyframes***REMOVED***pulse***REMOVED***{
***REMOVED******REMOVED***0%,***REMOVED***100%***REMOVED***{***REMOVED***opacity:***REMOVED***0.6;***REMOVED***}
***REMOVED******REMOVED***50%***REMOVED***{***REMOVED***opacity:***REMOVED***1;***REMOVED***}
}
@media***REMOVED***(max-width:***REMOVED***1024px)***REMOVED***{
***REMOVED******REMOVED***.player-page***REMOVED***{***REMOVED***grid-template-columns:***REMOVED***1fr;***REMOVED***}
***REMOVED******REMOVED***.disc***REMOVED***{***REMOVED***width:***REMOVED***320px;***REMOVED***height:***REMOVED***320px;***REMOVED***}
***REMOVED******REMOVED***.lyrics***REMOVED***{***REMOVED***height:***REMOVED***380px;***REMOVED***}
}

/****REMOVED***播放队列面板样式***REMOVED****/
.play-queue-panel***REMOVED***{
***REMOVED******REMOVED***position:***REMOVED***fixed;
***REMOVED******REMOVED***bottom:***REMOVED***20px;
***REMOVED******REMOVED***right:***REMOVED***20px;
***REMOVED******REMOVED***width:***REMOVED***400px;
***REMOVED******REMOVED***max-height:***REMOVED***500px;
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***border-radius:***REMOVED***12px;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***8px***REMOVED***32px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.15);
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
***REMOVED******REMOVED***font-weight:***REMOVED***600;
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
}

.queue-actions***REMOVED***.el-button***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***4px***REMOVED***8px;
***REMOVED******REMOVED***font-size:***REMOVED***12px;
}

.play-btn***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#667eea***REMOVED***!important;
}

.remove-btn***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#f56565***REMOVED***!important;
}

.empty-queue***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***40px***REMOVED***20px;
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***color:***REMOVED***#999;
}

.empty-queue***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
}
</style>


