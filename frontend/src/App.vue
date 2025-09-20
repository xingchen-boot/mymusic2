<template>
***REMOVED******REMOVED***<div***REMOVED***id="app">
***REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***顶部导航栏***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED***<Header***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="main-layout">
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
***REMOVED******REMOVED***</div>
</template>

<script***REMOVED***setup***REMOVED***lang="ts">
import***REMOVED***{***REMOVED***onMounted***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useMusicStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/music'
import***REMOVED***Header***REMOVED***from***REMOVED***'@/components/Header.vue'
import***REMOVED***Sidebar***REMOVED***from***REMOVED***'@/components/Sidebar.vue'
import***REMOVED***Container***REMOVED***from***REMOVED***'@/components/Container.vue'
import***REMOVED***Footer***REMOVED***from***REMOVED***'@/components/Footer.vue'

const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore()

onMounted(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***//***REMOVED***初始化音乐播放器
***REMOVED******REMOVED***musicStore.initAudio()
})
</script>

<style>
#app***REMOVED***{
***REMOVED******REMOVED***font-family:***REMOVED***'Helvetica***REMOVED***Neue',***REMOVED***Helvetica,***REMOVED***'PingFang***REMOVED***SC',***REMOVED***'Hiragino***REMOVED***Sans***REMOVED***GB',***REMOVED***'Microsoft***REMOVED***YaHei',***REMOVED***'微软雅黑',***REMOVED***Arial,***REMOVED***sans-serif;
***REMOVED******REMOVED***-webkit-font-smoothing:***REMOVED***antialiased;
***REMOVED******REMOVED***-moz-osx-font-smoothing:***REMOVED***grayscale;
***REMOVED******REMOVED***color:***REMOVED***#2c3e50;
***REMOVED******REMOVED***height:***REMOVED***100vh;
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***padding:***REMOVED***0;
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***flex-direction:***REMOVED***column;
}

****REMOVED***{
***REMOVED******REMOVED***box-sizing:***REMOVED***border-box;
}

body***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***padding:***REMOVED***0;
***REMOVED******REMOVED***background:***REMOVED***#f5f5f5;
***REMOVED******REMOVED***min-height:***REMOVED***100vh;
}

.main-layout***REMOVED***{
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
</style>
