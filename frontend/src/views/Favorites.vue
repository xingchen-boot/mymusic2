<template>
***REMOVED******REMOVED***<div***REMOVED***class="favorites">
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="favorites-header">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h1>❤️***REMOVED***我喜欢的</h1>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***v-if="favorites.length***REMOVED***>***REMOVED***0">共***REMOVED***{{***REMOVED***favorites.length***REMOVED***}}***REMOVED***首音乐</p>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="isLoading"***REMOVED***class="loading">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-loading-directive***REMOVED***v-loading="true"***REMOVED***element-loading-text="加载中...">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***style="height:***REMOVED***200px;"></div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-loading-directive>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else-if="favorites.length***REMOVED***===***REMOVED***0"***REMOVED***class="empty-state">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="empty-icon">🎵</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h3>还没有喜欢的音乐</h3>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>去发现一些好听的音乐吧！</p>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else***REMOVED***class="favorites-list">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-for="(favorite,***REMOVED***index)***REMOVED***in***REMOVED***favorites"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:key="favorite.id"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="favorite-item"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:class="{***REMOVED***'current-playing':***REMOVED***currentMusic?.id***REMOVED***===***REMOVED***parseInt(favorite.musicId)***REMOVED***}"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="item-number">{{***REMOVED***index***REMOVED***+***REMOVED***1***REMOVED***}}</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="item-cover">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<img***REMOVED***:src="favorite.musicCover"***REMOVED***:alt="favorite.musicSong"***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="play-overlay"***REMOVED***@click="playFavorite(favorite)">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="play-icon">{{***REMOVED***currentMusic?.id***REMOVED***===***REMOVED***parseInt(favorite.musicId)***REMOVED***&&***REMOVED***isPlaying***REMOVED***?***REMOVED***'⏸️'***REMOVED***:***REMOVED***'▶️'***REMOVED***}}</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="item-info">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h4***REMOVED***class="song-title">{{***REMOVED***favorite.musicSong***REMOVED***}}</h4>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***class="artist-name">{{***REMOVED***favorite.musicSinger***REMOVED***}}</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="item-actions">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="text"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="removeFavorite(favorite)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="remove-btn"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***title="取消收藏"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***❤️
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="text"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="downloadFavorite(favorite)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="download-btn"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***title="下载"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***⬇️
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED***</div>
</template>

<script***REMOVED***setup***REMOVED***lang="ts">
import***REMOVED***{***REMOVED***ref,***REMOVED***computed,***REMOVED***onMounted***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useMusicStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/music'
import***REMOVED***{***REMOVED***useUserStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/user'

const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore()
const***REMOVED***userStore***REMOVED***=***REMOVED***useUserStore()

//***REMOVED***响应式数据
const***REMOVED***favorites***REMOVED***=***REMOVED***ref<any[]>([])
const***REMOVED***isLoading***REMOVED***=***REMOVED***ref(false)

//***REMOVED***计算属性
const***REMOVED***currentMusic***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.currentMusic)
const***REMOVED***isPlaying***REMOVED***=***REMOVED***computed(()***REMOVED***=>***REMOVED***musicStore.isPlaying)

//***REMOVED***方法
const***REMOVED***loadFavorites***REMOVED***=***REMOVED***async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!userStore.isLoggedIn***REMOVED***||***REMOVED***!userStore.currentUser)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.log('❌***REMOVED***用户未登录，无法加载收藏列表')
***REMOVED******REMOVED******REMOVED******REMOVED***return
***REMOVED******REMOVED***}

***REMOVED******REMOVED***isLoading.value***REMOVED***=***REMOVED***true
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***response***REMOVED***=***REMOVED***await***REMOVED***fetch(`http://localhost:9092/api/user-favorites/user/${userStore.currentUser.id}`)
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***result***REMOVED***=***REMOVED***await***REMOVED***response.json()
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(response.ok***REMOVED***&&***REMOVED***result.code***REMOVED***===***REMOVED***200)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***favorites.value***REMOVED***=***REMOVED***result.data
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.log('✅***REMOVED***收藏列表加载成功，共',***REMOVED***result.data.length,***REMOVED***'首音乐')
***REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.error('❌***REMOVED***收藏列表加载失败:',***REMOVED***result.message)
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***favorites.value***REMOVED***=***REMOVED***[]
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.error('❌***REMOVED***收藏列表加载错误:',***REMOVED***error)
***REMOVED******REMOVED******REMOVED******REMOVED***favorites.value***REMOVED***=***REMOVED***[]
***REMOVED******REMOVED***}***REMOVED***finally***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***isLoading.value***REMOVED***=***REMOVED***false
***REMOVED******REMOVED***}
}

const***REMOVED***playFavorite***REMOVED***=***REMOVED***async***REMOVED***(favorite:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***music***REMOVED***=***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***parseInt(favorite.musicId),
***REMOVED******REMOVED******REMOVED******REMOVED***mid:***REMOVED***favorite.musicMid,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***favorite.musicSong,
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***favorite.musicSinger,
***REMOVED******REMOVED******REMOVED******REMOVED***album:***REMOVED***favorite.musicAlbum***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***favorite.musicCover***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***time:***REMOVED***favorite.musicTime***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***pay:***REMOVED***favorite.musicPay***REMOVED***||***REMOVED***''
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***await***REMOVED***musicStore.playMusic(music)
}

const***REMOVED***removeFavorite***REMOVED***=***REMOVED***async***REMOVED***(favorite:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!userStore.isLoggedIn***REMOVED***||***REMOVED***!userStore.currentUser)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.log('❌***REMOVED***用户未登录，无法取消收藏')
***REMOVED******REMOVED******REMOVED******REMOVED***return
***REMOVED******REMOVED***}

***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***response***REMOVED***=***REMOVED***await***REMOVED***fetch(`http://localhost:9092/api/user-favorites/remove?userId=${userStore.currentUser.id}&musicId=${favorite.musicId}`,***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***method:***REMOVED***'DELETE'
***REMOVED******REMOVED******REMOVED******REMOVED***})
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***result***REMOVED***=***REMOVED***await***REMOVED***response.json()
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(response.ok***REMOVED***&&***REMOVED***result.code***REMOVED***===***REMOVED***200)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***从本地列表中移除
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***index***REMOVED***=***REMOVED***favorites.value.findIndex(item***REMOVED***=>***REMOVED***item.id***REMOVED***===***REMOVED***favorite.id)
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(index***REMOVED***>***REMOVED***-1)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***favorites.value.splice(index,***REMOVED***1)
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***如果当前播放的音乐被取消收藏，更新收藏状态
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(currentMusic.value?.id***REMOVED***===***REMOVED***parseInt(favorite.musicId))***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.checkCurrentMusicFavoriteStatus()
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.log('✅***REMOVED***取消收藏成功')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***显示提示
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***{***REMOVED***ElMessage***REMOVED***}***REMOVED***=***REMOVED***await***REMOVED***import('element-plus')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.success('已取消收藏')
***REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.error('❌***REMOVED***取消收藏失败:',***REMOVED***result.message)
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.error('❌***REMOVED***取消收藏错误:',***REMOVED***error)
***REMOVED******REMOVED***}
}

const***REMOVED***downloadFavorite***REMOVED***=***REMOVED***async***REMOVED***(favorite:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***music***REMOVED***=***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***parseInt(favorite.musicId),
***REMOVED******REMOVED******REMOVED******REMOVED***mid:***REMOVED***favorite.musicMid,
***REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***favorite.musicSong,
***REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***favorite.musicSinger,
***REMOVED******REMOVED******REMOVED******REMOVED***album:***REMOVED***favorite.musicAlbum***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***favorite.musicCover***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***time:***REMOVED***favorite.musicTime***REMOVED***||***REMOVED***'',
***REMOVED******REMOVED******REMOVED******REMOVED***pay:***REMOVED***favorite.musicPay***REMOVED***||***REMOVED***''
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.downloadMusic(music)
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.error('下载失败:',***REMOVED***error)
***REMOVED******REMOVED***}
}

//***REMOVED***生命周期
onMounted(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***loadFavorites()
})
</script>

<style***REMOVED***scoped>
.favorites***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***20px;
***REMOVED******REMOVED***max-width:***REMOVED***1200px;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***auto;
}

.favorites-header***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***margin-bottom:***REMOVED***30px;
}

.favorites-header***REMOVED***h1***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***margin-bottom:***REMOVED***10px;
***REMOVED******REMOVED***font-size:***REMOVED***28px;
}

.favorites-header***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
}

.loading***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***40px;
}

.empty-state***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***60px***REMOVED***20px;
***REMOVED******REMOVED***color:***REMOVED***#999;
}

.empty-icon***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***64px;
***REMOVED******REMOVED***margin-bottom:***REMOVED***20px;
}

.empty-state***REMOVED***h3***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***10px***REMOVED***0;
***REMOVED******REMOVED***color:***REMOVED***#666;
}

.empty-state***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
}

.favorites-list***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***flex-direction:***REMOVED***column;
***REMOVED******REMOVED***gap:***REMOVED***12px;
}

.favorite-item***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***12px***REMOVED***16px;
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***border-radius:***REMOVED***8px;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***2px***REMOVED***8px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.1);
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.2s***REMOVED***ease;
***REMOVED******REMOVED***border:***REMOVED***2px***REMOVED***solid***REMOVED***transparent;
}

.favorite-item:hover***REMOVED***{
***REMOVED******REMOVED***transform:***REMOVED***translateY(-2px);
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***4px***REMOVED***16px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.15);
}

.favorite-item.current-playing***REMOVED***{
***REMOVED******REMOVED***border-color:***REMOVED***#667eea;
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(135deg,***REMOVED***#f8f9ff***REMOVED***0%,***REMOVED***#e3f2fd***REMOVED***100%);
}

.item-number***REMOVED***{
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
***REMOVED******REMOVED***margin-right:***REMOVED***16px;
}

.favorite-item.current-playing***REMOVED***.item-number***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***#667eea;
***REMOVED******REMOVED***color:***REMOVED***white;
}

.item-cover***REMOVED***{
***REMOVED******REMOVED***position:***REMOVED***relative;
***REMOVED******REMOVED***width:***REMOVED***50px;
***REMOVED******REMOVED***height:***REMOVED***50px;
***REMOVED******REMOVED***margin-right:***REMOVED***16px;
***REMOVED******REMOVED***border-radius:***REMOVED***8px;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
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
***REMOVED******REMOVED***transition:***REMOVED***opacity***REMOVED***0.2s***REMOVED***ease;
***REMOVED******REMOVED***cursor:***REMOVED***pointer;
}

.item-cover:hover***REMOVED***.play-overlay***REMOVED***{
***REMOVED******REMOVED***opacity:***REMOVED***1;
}

.play-icon***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***18px;
***REMOVED******REMOVED***color:***REMOVED***white;
}

.item-info***REMOVED***{
***REMOVED******REMOVED***flex:***REMOVED***1;
***REMOVED******REMOVED***min-width:***REMOVED***0;
***REMOVED******REMOVED***text-align:***REMOVED***left;
}

.song-title***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***font-weight:***REMOVED***500;
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***4px***REMOVED***0;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
}

.artist-name***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
}

.item-actions***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***gap:***REMOVED***8px;
***REMOVED******REMOVED***align-items:***REMOVED***center;
}

.remove-btn,***REMOVED***.download-btn***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***8px;
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***justify-content:***REMOVED***center;
***REMOVED******REMOVED***border-radius:***REMOVED***6px;
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.2s***REMOVED***ease;
}

.remove-btn:hover***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#ff4757;
***REMOVED******REMOVED***background-color:***REMOVED***rgba(255,***REMOVED***71,***REMOVED***87,***REMOVED***0.1);
}

.download-btn:hover***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#667eea;
***REMOVED******REMOVED***background-color:***REMOVED***rgba(102,***REMOVED***126,***REMOVED***234,***REMOVED***0.1);
}

/****REMOVED***Element***REMOVED***Plus***REMOVED***样式覆盖***REMOVED****/
:deep(.el-button--text)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#666;
}

:deep(.el-button--text:hover)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#333;
}

/****REMOVED***响应式设计***REMOVED****/
@media***REMOVED***(max-width:***REMOVED***768px)***REMOVED***{
***REMOVED******REMOVED***.favorites***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***padding:***REMOVED***15px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.favorite-item***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***padding:***REMOVED***10px***REMOVED***12px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.item-cover***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***width:***REMOVED***40px;
***REMOVED******REMOVED******REMOVED******REMOVED***height:***REMOVED***40px;
***REMOVED******REMOVED******REMOVED******REMOVED***margin-right:***REMOVED***12px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.song-title***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.artist-name***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***font-size:***REMOVED***12px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.item-actions***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***gap:***REMOVED***4px;
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***.remove-btn,***REMOVED***.download-btn***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***padding:***REMOVED***6px;
***REMOVED******REMOVED******REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***}
}
</style>
