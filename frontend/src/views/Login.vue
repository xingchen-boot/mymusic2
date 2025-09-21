<template>
***REMOVED******REMOVED***<div***REMOVED***class="login-container">
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="login-box">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="login-header">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h2>登录***REMOVED***MyMusic</h2>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>欢迎回来，开始你的音乐之旅</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***ref="loginFormRef"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:model="loginForm"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:rules="loginRules"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="login-form"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@submit.prevent="handleLogin"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form-item***REMOVED***prop="username">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-input
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="loginForm.username"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***placeholder="请输入用户名"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="large"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***prefix-icon="User"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***clearable
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form-item***REMOVED***prop="password">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-input
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="loginForm.password"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="password"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***placeholder="请输入密码"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="large"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***prefix-icon="Lock"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***show-password
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***clearable
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@keyup.enter="handleLogin"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="primary"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="large"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="login-btn"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:loading="loading"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="handleLogin"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***loading***REMOVED***?***REMOVED***'登录中...'***REMOVED***:***REMOVED***'登录'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="login-footer">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>还没有账号？<router-link***REMOVED***to="/register"***REMOVED***class="register-link">立即注册</router-link></p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED***</div>
</template>

<script***REMOVED***setup***REMOVED***lang="ts">
import***REMOVED***{***REMOVED***ref,***REMOVED***reactive***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useRouter***REMOVED***}***REMOVED***from***REMOVED***'vue-router'
import***REMOVED***{***REMOVED***ElMessage,***REMOVED***type***REMOVED***FormInstance,***REMOVED***type***REMOVED***FormRules***REMOVED***}***REMOVED***from***REMOVED***'element-plus'
import***REMOVED***{***REMOVED***useUserStore***REMOVED***}***REMOVED***from***REMOVED***'@/stores/user'

const***REMOVED***router***REMOVED***=***REMOVED***useRouter()
const***REMOVED***userStore***REMOVED***=***REMOVED***useUserStore()

//***REMOVED***表单引用
const***REMOVED***loginFormRef***REMOVED***=***REMOVED***ref<FormInstance>()

//***REMOVED***加载状态
const***REMOVED***loading***REMOVED***=***REMOVED***ref(false)

//***REMOVED***登录表单数据
const***REMOVED***loginForm***REMOVED***=***REMOVED***reactive({
***REMOVED******REMOVED***username:***REMOVED***'',
***REMOVED******REMOVED***password:***REMOVED***''
})

//***REMOVED***表单验证规则
const***REMOVED***loginRules:***REMOVED***FormRules***REMOVED***=***REMOVED***{
***REMOVED******REMOVED***username:***REMOVED***[
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***required:***REMOVED***true,***REMOVED***message:***REMOVED***'请输入用户名',***REMOVED***trigger:***REMOVED***'blur'***REMOVED***},
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***min:***REMOVED***3,***REMOVED***max:***REMOVED***20,***REMOVED***message:***REMOVED***'用户名长度在***REMOVED***3***REMOVED***到***REMOVED***20***REMOVED***个字符',***REMOVED***trigger:***REMOVED***'blur'***REMOVED***}
***REMOVED******REMOVED***],
***REMOVED******REMOVED***password:***REMOVED***[
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***required:***REMOVED***true,***REMOVED***message:***REMOVED***'请输入密码',***REMOVED***trigger:***REMOVED***'blur'***REMOVED***},
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***min:***REMOVED***6,***REMOVED***max:***REMOVED***20,***REMOVED***message:***REMOVED***'密码长度在***REMOVED***6***REMOVED***到***REMOVED***20***REMOVED***个字符',***REMOVED***trigger:***REMOVED***'blur'***REMOVED***}
***REMOVED******REMOVED***]
}

//***REMOVED***处理登录
const***REMOVED***handleLogin***REMOVED***=***REMOVED***async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!loginFormRef.value)***REMOVED***return
***REMOVED******REMOVED***
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***valid***REMOVED***=***REMOVED***await***REMOVED***loginFormRef.value.validate()
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(!valid)***REMOVED***return
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***loading.value***REMOVED***=***REMOVED***true
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***success***REMOVED***=***REMOVED***await***REMOVED***userStore.login(loginForm.username,***REMOVED***loginForm.password)
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(success)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.success('登录成功')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***登录成功后跳转到首页
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***router.push('/')
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error:***REMOVED***any)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.error(error.message***REMOVED***||***REMOVED***'登录失败')
***REMOVED******REMOVED***}***REMOVED***finally***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***loading.value***REMOVED***=***REMOVED***false
***REMOVED******REMOVED***}
}
</script>

<style***REMOVED***scoped>
.login-container***REMOVED***{
***REMOVED******REMOVED***min-height:***REMOVED***100vh;
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***justify-content:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***20px;
}

.login-box***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***100%;
***REMOVED******REMOVED***max-width:***REMOVED***400px;
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***border-radius:***REMOVED***16px;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***20px***REMOVED***40px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.1);
***REMOVED******REMOVED***padding:***REMOVED***40px;
}

.login-header***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***margin-bottom:***REMOVED***30px;
}

.login-header***REMOVED***h2***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***font-size:***REMOVED***28px;
***REMOVED******REMOVED***font-weight:***REMOVED***600;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***8px***REMOVED***0;
}

.login-header***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***margin:***REMOVED***0;
}

.login-form***REMOVED***{
***REMOVED******REMOVED***margin-bottom:***REMOVED***20px;
}

.login-btn***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***100%;
***REMOVED******REMOVED***height:***REMOVED***48px;
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***border:***REMOVED***none;
***REMOVED******REMOVED***border-radius:***REMOVED***8px;
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***font-weight:***REMOVED***500;
}

.login-btn:hover***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#764ba2,***REMOVED***#667eea);
}

.login-footer***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
}

.login-footer***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***margin:***REMOVED***0;
}

.register-link***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#667eea;
***REMOVED******REMOVED***text-decoration:***REMOVED***none;
***REMOVED******REMOVED***font-weight:***REMOVED***500;
}

.register-link:hover***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#764ba2;
***REMOVED******REMOVED***text-decoration:***REMOVED***underline;
}

/****REMOVED***Element***REMOVED***Plus***REMOVED***样式覆盖***REMOVED****/
:deep(.el-input__wrapper)***REMOVED***{
***REMOVED******REMOVED***border-radius:***REMOVED***8px;
***REMOVED******REMOVED***border:***REMOVED***1px***REMOVED***solid***REMOVED***#e0e0e0;
***REMOVED******REMOVED***box-shadow:***REMOVED***none;
***REMOVED******REMOVED***height:***REMOVED***48px;
}

:deep(.el-input__wrapper:hover)***REMOVED***{
***REMOVED******REMOVED***border-color:***REMOVED***#667eea;
}

:deep(.el-input__wrapper.is-focus)***REMOVED***{
***REMOVED******REMOVED***border-color:***REMOVED***#667eea;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***0***REMOVED***0***REMOVED***2px***REMOVED***rgba(102,***REMOVED***126,***REMOVED***234,***REMOVED***0.2);
}

:deep(.el-form-item)***REMOVED***{
***REMOVED******REMOVED***margin-bottom:***REMOVED***20px;
}

:deep(.el-form-item__error)***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***12px;
}
</style>
