<template>
***REMOVED******REMOVED***<div***REMOVED***class="main-layout">
***REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***顶部导航栏***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED***<Header***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="content-wrapper">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***侧边栏***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<Sidebar***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***主内容区域***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="content-area">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<Container***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***底部播放器***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED***<Footer***REMOVED***/>
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
import***REMOVED***{***REMOVED***onMounted***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useMusicStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/music'
import***REMOVED***{***REMOVED***useUserStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/user'
import***REMOVED***Header***REMOVED***from***REMOVED***'@/components/Header.vue'
import***REMOVED***Sidebar***REMOVED***from***REMOVED***'@/components/Sidebar.vue'
import***REMOVED***Container***REMOVED***from***REMOVED***'@/components/Container.vue'
import***REMOVED***Footer***REMOVED***from***REMOVED***'@/components/Footer.vue'

const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore()
const***REMOVED***userStore***REMOVED***=***REMOVED***useUserStore()

onMounted(async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***//***REMOVED***初始化用户信息（全局唯一初始化迁移至***REMOVED***main.ts）
***REMOVED******REMOVED***await***REMOVED***userStore.initUserInfo()
})
</script>

<style***REMOVED***scoped>
.main-layout***REMOVED***{
***REMOVED******REMOVED***height:***REMOVED***100vh;
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***flex-direction:***REMOVED***column;
}

.content-wrapper***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***flex:***REMOVED***1;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
}

.content-area***REMOVED***{
***REMOVED******REMOVED***flex:***REMOVED***1;
***REMOVED******REMOVED***overflow-y:***REMOVED***auto;
***REMOVED******REMOVED***padding:***REMOVED***20px;
***REMOVED******REMOVED***background:***REMOVED***#f5f5f5;
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
***REMOVED******REMOVED***font-weight:***REMOVED***500;
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

.play-btn,
.remove-btn***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***4px***REMOVED***8px;
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
</style>
