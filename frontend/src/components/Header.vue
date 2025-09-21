<template>
***REMOVED******REMOVED***<header***REMOVED***class="header">
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="header-content">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***Logo***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="logo">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<router-link***REMOVED***to="/"***REMOVED***class="logo-link">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="logo-icon">🎵</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="logo-text">MyMusic</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</router-link>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***搜索框***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="search-container">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-input
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="searchKeyword"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***placeholder="搜索歌曲、歌手、专辑..."
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="large"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@keyup.enter="handleSearch"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***clearable
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="search-input"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<template***REMOVED***#suffix>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="search-icon"***REMOVED***@click="handleSearch">🔍</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</template>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-input>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***用户区域***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="user-area">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="!userStore.isLoggedIn"***REMOVED***class="login-section">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="primary"***REMOVED***@click="goToLogin"***REMOVED***class="login-btn">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***登录
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-else***REMOVED***class="user-info">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-dropdown***REMOVED***@command="handleUserCommand">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="user-avatar">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<img***REMOVED***:src="userStore.currentUser?.avatar***REMOVED***||***REMOVED***'https://picsum.photos/40/40?random=1'"***REMOVED***:alt="userStore.currentUser?.nickname"***REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<template***REMOVED***#dropdown>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-dropdown-menu>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-dropdown-item***REMOVED***command="profile">个人中心</el-dropdown-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-dropdown-item***REMOVED***command="playlist">我的歌单</el-dropdown-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-dropdown-item***REMOVED***command="settings">设置</el-dropdown-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-dropdown-item***REMOVED***command="logout"***REMOVED***divided>退出登录</el-dropdown-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-dropdown-menu>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</template>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-dropdown>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED***</header>
</template>

<script***REMOVED***setup***REMOVED***lang="ts">
import***REMOVED***{***REMOVED***ref,***REMOVED***onMounted***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useRouter***REMOVED***}***REMOVED***from***REMOVED***'vue-router'
import***REMOVED***{***REMOVED***useMusicStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/music'
import***REMOVED***{***REMOVED***useUserStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/user'

const***REMOVED***router***REMOVED***=***REMOVED***useRouter()
const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore()
const***REMOVED***userStore***REMOVED***=***REMOVED***useUserStore()

//***REMOVED***响应式数据
const***REMOVED***searchKeyword***REMOVED***=***REMOVED***ref('')

//***REMOVED***方法
const***REMOVED***handleSearch***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(searchKeyword.value.trim())***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.log(searchKeyword.value.trim())
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***跳转到搜索结果页面
***REMOVED******REMOVED******REMOVED******REMOVED***router.push({
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***name:***REMOVED***'search',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***query:***REMOVED***{***REMOVED***keyword:***REMOVED***searchKeyword.value.trim()***REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***})
***REMOVED******REMOVED***}
}

const***REMOVED***goToLogin***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***router.push('/login')
}

const***REMOVED***handleUserCommand***REMOVED***=***REMOVED***(command:***REMOVED***string)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***switch***REMOVED***(command)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***case***REMOVED***'profile':
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***router.push('/profile')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***break
***REMOVED******REMOVED******REMOVED******REMOVED***case***REMOVED***'playlist':
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***router.push('/playlist')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***break
***REMOVED******REMOVED******REMOVED******REMOVED***case***REMOVED***'settings':
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***router.push('/settings')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***break
***REMOVED******REMOVED******REMOVED******REMOVED***case***REMOVED***'logout':
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***userStore.logout()
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***break
***REMOVED******REMOVED***}
}

//***REMOVED***初始化用户信息
onMounted(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***userStore.initUserInfo()
})
</script>

<style***REMOVED***scoped>
.header***REMOVED***{
***REMOVED******REMOVED***height:***REMOVED***60px;
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***border-bottom:***REMOVED***1px***REMOVED***solid***REMOVED***#e0e0e0;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***2px***REMOVED***8px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.1);
***REMOVED******REMOVED***position:***REMOVED***sticky;
***REMOVED******REMOVED***top:***REMOVED***0;
***REMOVED******REMOVED***z-index:***REMOVED***1000;
}

.header-content***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***height:***REMOVED***100%;
***REMOVED******REMOVED***max-width:***REMOVED***1200px;
***REMOVED******REMOVED***padding:***REMOVED***0***REMOVED***20px;
***REMOVED******REMOVED***justify-content:space-between;
}

.logo***REMOVED***{
***REMOVED******REMOVED***flex-shrink:***REMOVED***0;
***REMOVED******REMOVED***margin-right:***REMOVED***30px;
}

.logo-link***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***text-decoration:***REMOVED***none;
***REMOVED******REMOVED***color:***REMOVED***#333;
}

.logo-icon***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***24px;
***REMOVED******REMOVED***margin-right:***REMOVED***8px;
}

.logo-text***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***20px;
***REMOVED******REMOVED***font-weight:***REMOVED***bold;
***REMOVED******REMOVED***color:***REMOVED***#667eea;
}

.search-container***REMOVED***{
***REMOVED******REMOVED***flex:***REMOVED***1;
***REMOVED******REMOVED***max-width:***REMOVED***500px;
***REMOVED******REMOVED***margin-right:***REMOVED***30px;
}

.search-input***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***100%;
}

.search-icon***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#999;
***REMOVED******REMOVED***cursor:***REMOVED***pointer;
***REMOVED******REMOVED***padding:***REMOVED***4px;
***REMOVED******REMOVED***border-radius:***REMOVED***4px;
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.3s***REMOVED***ease;
***REMOVED******REMOVED***display:***REMOVED***inline-block;
}

.search-icon:hover***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#667eea;
***REMOVED******REMOVED***background:***REMOVED***rgba(102,***REMOVED***126,***REMOVED***234,***REMOVED***0.1);
}

.user-area***REMOVED***{
***REMOVED******REMOVED***flex-shrink:***REMOVED***0;
}

.login-btn***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***border:***REMOVED***none;
***REMOVED******REMOVED***border-radius:***REMOVED***20px;
***REMOVED******REMOVED***padding:***REMOVED***8px***REMOVED***20px;
}

.user-avatar***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***40px;
***REMOVED******REMOVED***height:***REMOVED***40px;
***REMOVED******REMOVED***border-radius:***REMOVED***50%;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***cursor:***REMOVED***pointer;
***REMOVED******REMOVED***border:***REMOVED***2px***REMOVED***solid***REMOVED***#e0e0e0;
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.3s***REMOVED***ease;
}

.user-avatar:hover***REMOVED***{
***REMOVED******REMOVED***border-color:***REMOVED***#667eea;
}

.user-avatar***REMOVED***img***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***100%;
***REMOVED******REMOVED***height:***REMOVED***100%;
***REMOVED******REMOVED***object-fit:***REMOVED***cover;
}

/****REMOVED***Element***REMOVED***Plus***REMOVED***样式覆盖***REMOVED****/
:deep(.el-input__wrapper)***REMOVED***{
***REMOVED******REMOVED***border-radius:***REMOVED***20px;
***REMOVED******REMOVED***border:***REMOVED***1px***REMOVED***solid***REMOVED***#e0e0e0;
}

:deep(.el-input__wrapper:hover)***REMOVED***{
***REMOVED******REMOVED***border-color:***REMOVED***#667eea;
}

:deep(.el-input__wrapper.is-focus)***REMOVED***{
***REMOVED******REMOVED***border-color:***REMOVED***#667eea;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***0***REMOVED***0***REMOVED***2px***REMOVED***rgba(102,***REMOVED***126,***REMOVED***234,***REMOVED***0.2);
}

:deep(.el-input__inner)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#333;
}

:deep(.el-input__inner::placeholder)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#999;
}

:deep(.el-input__suffix)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#999;
}

:deep(.el-input__suffix:hover)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#667eea;
}

:deep(.el-button--primary)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***border:***REMOVED***none;
}

:deep(.el-button--primary:hover)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#764ba2,***REMOVED***#667eea);
}
</style>
