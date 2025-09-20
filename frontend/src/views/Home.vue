<template>
***REMOVED******REMOVED***<div***REMOVED***class="home">
***REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***欢迎区域***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="welcome-section">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h1***REMOVED***class="welcome-title">🎵***REMOVED***欢迎来到***REMOVED***MyMusic</h1>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***class="welcome-subtitle">发现好音乐，享受美好时光</p>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***推荐内容***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="recommendations">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="section">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h2***REMOVED***class="section-title">🔥***REMOVED***热门推荐</h2>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="music-grid">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-for="music***REMOVED***in***REMOVED***hotMusic"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:key="music.id"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="music-card"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="handlePlayMusic(music)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<img***REMOVED***:src="music.cover"***REMOVED***:alt="music.song"***REMOVED***class="music-cover"***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="music-info">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h3***REMOVED***class="music-title">{{***REMOVED***music.song***REMOVED***}}</h3>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***class="music-artist">{{***REMOVED***music.singer***REMOVED***}}</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="play-overlay">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="primary"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***circle
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click.stop="handlePlayMusic(music)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***currentMusic?.id***REMOVED***===***REMOVED***music.id***REMOVED***&&***REMOVED***isPlaying***REMOVED***?***REMOVED***'⏸️'***REMOVED***:***REMOVED***'▶️'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="section">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h2***REMOVED***class="section-title">🎶***REMOVED***最新音乐</h2>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="music-grid">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-for="music***REMOVED***in***REMOVED***newMusic"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:key="music.id"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="music-card"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="handlePlayMusic(music)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<img***REMOVED***:src="music.cover"***REMOVED***:alt="music.song"***REMOVED***class="music-cover"***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="music-info">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h3***REMOVED***class="music-title">{{***REMOVED***music.song***REMOVED***}}</h3>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***class="music-artist">{{***REMOVED***music.singer***REMOVED***}}</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="play-overlay">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="primary"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***circle
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click.stop="handlePlayMusic(music)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***currentMusic?.id***REMOVED***===***REMOVED***music.id***REMOVED***&&***REMOVED***isPlaying***REMOVED***?***REMOVED***'⏸️'***REMOVED***:***REMOVED***'▶️'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED***</div>
</template>

<script***REMOVED***setup***REMOVED***lang="ts">
import***REMOVED***{***REMOVED***ref,***REMOVED***computed***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useMusicStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/music'

const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore()

//***REMOVED***模拟数据
const***REMOVED***hotMusic***REMOVED***=***REMOVED***ref([
***REMOVED******REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***1,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***'青花瓷',
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***'周杰伦',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***'https://picsum.photos/200/200?random=1'
***REMOVED******REMOVED***},
***REMOVED******REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***2,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***'稻香',
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***'周杰伦',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***'https://picsum.photos/200/200?random=2'
***REMOVED******REMOVED***},
***REMOVED******REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***3,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***'夜曲',
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***'周杰伦',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***'https://picsum.photos/200/200?random=3'
***REMOVED******REMOVED***},
***REMOVED******REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***4,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***'晴天',
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***'周杰伦',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***'https://picsum.photos/200/200?random=4'
***REMOVED******REMOVED***}
])

const***REMOVED***newMusic***REMOVED***=***REMOVED***ref([
***REMOVED******REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***5,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***'告白气球',
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***'周杰伦',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***'https://picsum.photos/200/200?random=5'
***REMOVED******REMOVED***},
***REMOVED******REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***6,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***'等你下课',
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***'周杰伦',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***'https://picsum.photos/200/200?random=6'
***REMOVED******REMOVED***},
***REMOVED******REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***7,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***'说好不哭',
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***'周杰伦',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***'https://picsum.photos/200/200?random=7'
***REMOVED******REMOVED***},
***REMOVED******REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***8,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***'Mojito',
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***'周杰伦',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***'https://picsum.photos/200/200?random=8'
***REMOVED******REMOVED***}
])

//***REMOVED***计算属性
const***REMOVED***currentMusic***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.currentMusic)
const***REMOVED***isPlaying***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.isPlaying)

//***REMOVED***方法
const***REMOVED***handlePlayMusic***REMOVED***=***REMOVED***(music:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***musicStore.playMusic(music)
}
</script>

<style***REMOVED***scoped>
.home***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***20px;
}

.welcome-section***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***40px***REMOVED***0;
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(135deg,***REMOVED***#667eea***REMOVED***0%,***REMOVED***#764ba2***REMOVED***100%);
***REMOVED******REMOVED***border-radius:***REMOVED***12px;
***REMOVED******REMOVED***margin-bottom:***REMOVED***30px;
***REMOVED******REMOVED***color:***REMOVED***white;
}

.welcome-title***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***2.5rem;
***REMOVED******REMOVED***font-weight:***REMOVED***700;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***10px***REMOVED***0;
}

.welcome-subtitle***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***1.2rem;
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***opacity:***REMOVED***0.9;
}

.recommendations***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***flex-direction:***REMOVED***column;
***REMOVED******REMOVED***gap:***REMOVED***30px;
}

.section***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***border-radius:***REMOVED***12px;
***REMOVED******REMOVED***padding:***REMOVED***20px;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***2px***REMOVED***12px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.1);
}

.section-title***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***1.5rem;
***REMOVED******REMOVED***font-weight:***REMOVED***600;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***20px***REMOVED***0;
***REMOVED******REMOVED***color:***REMOVED***#333;
}

.music-grid***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***grid;
***REMOVED******REMOVED***grid-template-columns:***REMOVED***repeat(auto-fill,***REMOVED***minmax(200px,***REMOVED***1fr));
***REMOVED******REMOVED***gap:***REMOVED***20px;
}

.music-card***REMOVED***{
***REMOVED******REMOVED***position:***REMOVED***relative;
***REMOVED******REMOVED***background:***REMOVED***#f8f9fa;
***REMOVED******REMOVED***border-radius:***REMOVED***12px;
***REMOVED******REMOVED***padding:***REMOVED***15px;
***REMOVED******REMOVED***cursor:***REMOVED***pointer;
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.3s***REMOVED***ease;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
}

.music-card:hover***REMOVED***{
***REMOVED******REMOVED***transform:***REMOVED***translateY(-5px);
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***8px***REMOVED***25px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.15);
}

.music-card:hover***REMOVED***.play-overlay***REMOVED***{
***REMOVED******REMOVED***opacity:***REMOVED***1;
}

.music-cover***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***100%;
***REMOVED******REMOVED***height:***REMOVED***150px;
***REMOVED******REMOVED***border-radius:***REMOVED***8px;
***REMOVED******REMOVED***object-fit:***REMOVED***cover;
***REMOVED******REMOVED***margin-bottom:***REMOVED***12px;
}

.music-info***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
}

.music-title***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***font-weight:***REMOVED***600;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***5px***REMOVED***0;
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
}

.music-artist***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
}

.play-overlay***REMOVED***{
***REMOVED******REMOVED***position:***REMOVED***absolute;
***REMOVED******REMOVED***top:***REMOVED***50%;
***REMOVED******REMOVED***left:***REMOVED***50%;
***REMOVED******REMOVED***transform:***REMOVED***translate(-50%,***REMOVED***-50%);
***REMOVED******REMOVED***opacity:***REMOVED***0;
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.3s***REMOVED***ease;
***REMOVED******REMOVED***background:***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.7);
***REMOVED******REMOVED***border-radius:***REMOVED***50%;
***REMOVED******REMOVED***padding:***REMOVED***10px;
}

/****REMOVED***Element***REMOVED***Plus***REMOVED***样式覆盖***REMOVED****/
:deep(.el-button--primary)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***border:***REMOVED***none;
}

:deep(.el-button--primary:hover)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#764ba2,***REMOVED***#667eea);
}

/****REMOVED***响应式设计***REMOVED****/
@media***REMOVED***(max-width:***REMOVED***768px)***REMOVED***{
***REMOVED******REMOVED***.music-grid***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***grid-template-columns:***REMOVED***repeat(auto-fill,***REMOVED***minmax(150px,***REMOVED***1fr));
***REMOVED******REMOVED******REMOVED******REMOVED***gap:***REMOVED***15px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.welcome-title***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***font-size:***REMOVED***2rem;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.welcome-subtitle***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***font-size:***REMOVED***1rem;
***REMOVED******REMOVED***}
}
</style>
