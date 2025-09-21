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

onMounted(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***//***REMOVED***初始化音乐播放器
***REMOVED******REMOVED***musicStore.initAudio()
***REMOVED******REMOVED***//***REMOVED***初始化用户信息
***REMOVED******REMOVED***userStore.initUserInfo()
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
</style>
