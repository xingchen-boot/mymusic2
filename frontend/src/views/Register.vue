<template>
***REMOVED******REMOVED***<div***REMOVED***class="register-container">
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="register-box">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="register-header">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h2>注册***REMOVED***MyMusic</h2>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>创建账号，开启你的音乐之旅</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***ref="registerFormRef"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:model="registerForm"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:rules="registerRules"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="register-form"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@submit.prevent="handleRegister"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form-item***REMOVED***prop="username">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-input
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="registerForm.username"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***placeholder="请输入用户名"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="large"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***prefix-icon="User"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***clearable
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form-item***REMOVED***prop="nickname">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-input
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="registerForm.nickname"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***placeholder="请输入昵称"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="large"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***prefix-icon="Avatar"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***clearable
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form-item***REMOVED***prop="password">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-input
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="registerForm.password"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="password"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***placeholder="请输入密码"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="large"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***prefix-icon="Lock"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***show-password
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***clearable
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form-item***REMOVED***prop="confirmPassword">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-input
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="registerForm.confirmPassword"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="password"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***placeholder="请确认密码"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="large"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***prefix-icon="Lock"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***show-password
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***clearable
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@keyup.enter="handleRegister"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="primary"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="large"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="register-btn"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:loading="loading"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="handleRegister"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{{***REMOVED***loading***REMOVED***?***REMOVED***'注册中...'***REMOVED***:***REMOVED***'注册'***REMOVED***}}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="register-footer">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>已有账号？<router-link***REMOVED***to="/login"***REMOVED***class="login-link">立即登录</router-link></p>
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
const***REMOVED***registerFormRef***REMOVED***=***REMOVED***ref<FormInstance>()

//***REMOVED***加载状态
const***REMOVED***loading***REMOVED***=***REMOVED***ref(false)

//***REMOVED***注册表单数据
const***REMOVED***registerForm***REMOVED***=***REMOVED***reactive({
***REMOVED******REMOVED***username:***REMOVED***'',
***REMOVED******REMOVED***nickname:***REMOVED***'',
***REMOVED******REMOVED***password:***REMOVED***'',
***REMOVED******REMOVED***confirmPassword:***REMOVED***''
})

//***REMOVED***自定义验证器
const***REMOVED***validateConfirmPassword***REMOVED***=***REMOVED***(rule:***REMOVED***any,***REMOVED***value:***REMOVED***any,***REMOVED***callback:***REMOVED***any)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(value***REMOVED***===***REMOVED***'')***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***callback(new***REMOVED***Error('请再次输入密码'))
***REMOVED******REMOVED***}***REMOVED***else***REMOVED***if***REMOVED***(value***REMOVED***!==***REMOVED***registerForm.password)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***callback(new***REMOVED***Error('两次输入密码不一致'))
***REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***callback()
***REMOVED******REMOVED***}
}


//***REMOVED***表单验证规则
const***REMOVED***registerRules:***REMOVED***FormRules***REMOVED***=***REMOVED***{
***REMOVED******REMOVED***username:***REMOVED***[
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***required:***REMOVED***true,***REMOVED***message:***REMOVED***'请输入用户名',***REMOVED***trigger:***REMOVED***'blur'***REMOVED***},
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***min:***REMOVED***3,***REMOVED***max:***REMOVED***20,***REMOVED***message:***REMOVED***'用户名长度在***REMOVED***3***REMOVED***到***REMOVED***20***REMOVED***个字符',***REMOVED***trigger:***REMOVED***'blur'***REMOVED***},
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***pattern:***REMOVED***/^[a-zA-Z0-9_]+$/,***REMOVED***message:***REMOVED***'用户名只能包含字母、数字和下划线',***REMOVED***trigger:***REMOVED***'blur'***REMOVED***}
***REMOVED******REMOVED***],
***REMOVED******REMOVED***nickname:***REMOVED***[
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***required:***REMOVED***true,***REMOVED***message:***REMOVED***'请输入昵称',***REMOVED***trigger:***REMOVED***'blur'***REMOVED***},
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***min:***REMOVED***2,***REMOVED***max:***REMOVED***20,***REMOVED***message:***REMOVED***'昵称长度在***REMOVED***2***REMOVED***到***REMOVED***20***REMOVED***个字符',***REMOVED***trigger:***REMOVED***'blur'***REMOVED***}
***REMOVED******REMOVED***],
***REMOVED******REMOVED***password:***REMOVED***[
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***required:***REMOVED***true,***REMOVED***message:***REMOVED***'请输入密码',***REMOVED***trigger:***REMOVED***'blur'***REMOVED***},
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***min:***REMOVED***6,***REMOVED***max:***REMOVED***20,***REMOVED***message:***REMOVED***'密码长度在***REMOVED***6***REMOVED***到***REMOVED***20***REMOVED***个字符',***REMOVED***trigger:***REMOVED***'blur'***REMOVED***}
***REMOVED******REMOVED***],
***REMOVED******REMOVED***confirmPassword:***REMOVED***[
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***required:***REMOVED***true,***REMOVED***message:***REMOVED***'请确认密码',***REMOVED***trigger:***REMOVED***'blur'***REMOVED***},
***REMOVED******REMOVED******REMOVED******REMOVED***{***REMOVED***validator:***REMOVED***validateConfirmPassword,***REMOVED***trigger:***REMOVED***'blur'***REMOVED***}
***REMOVED******REMOVED***]
}

//***REMOVED***处理注册
const***REMOVED***handleRegister***REMOVED***=***REMOVED***async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!registerFormRef.value)***REMOVED***return
***REMOVED******REMOVED***
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***valid***REMOVED***=***REMOVED***await***REMOVED***registerFormRef.value.validate()
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(!valid)***REMOVED***return
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***loading.value***REMOVED***=***REMOVED***true
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***success***REMOVED***=***REMOVED***await***REMOVED***userStore.register(
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***registerForm.username,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***registerForm.password,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***registerForm.nickname
***REMOVED******REMOVED******REMOVED******REMOVED***)
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(success)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.success('注册成功，请登录')
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***注册成功后跳转到登录页面
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***router.push('/login')
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error:***REMOVED***any)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.error(error.message***REMOVED***||***REMOVED***'注册失败')
***REMOVED******REMOVED***}***REMOVED***finally***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***loading.value***REMOVED***=***REMOVED***false
***REMOVED******REMOVED***}
}
</script>

<style***REMOVED***scoped>
.register-container***REMOVED***{
***REMOVED******REMOVED***min-height:***REMOVED***100vh;
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***justify-content:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***20px;
}

.register-box***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***100%;
***REMOVED******REMOVED***max-width:***REMOVED***400px;
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***border-radius:***REMOVED***16px;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***20px***REMOVED***40px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.1);
***REMOVED******REMOVED***padding:***REMOVED***40px;
}

.register-header***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***margin-bottom:***REMOVED***30px;
}

.register-header***REMOVED***h2***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***font-size:***REMOVED***28px;
***REMOVED******REMOVED***font-weight:***REMOVED***600;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***8px***REMOVED***0;
}

.register-header***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***margin:***REMOVED***0;
}

.register-form***REMOVED***{
***REMOVED******REMOVED***margin-bottom:***REMOVED***20px;
}

.register-btn***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***100%;
***REMOVED******REMOVED***height:***REMOVED***48px;
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***border:***REMOVED***none;
***REMOVED******REMOVED***border-radius:***REMOVED***8px;
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***font-weight:***REMOVED***500;
}

.register-btn:hover***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#764ba2,***REMOVED***#667eea);
}

.register-footer***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
}

.register-footer***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***margin:***REMOVED***0;
}

.login-link***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#667eea;
***REMOVED******REMOVED***text-decoration:***REMOVED***none;
***REMOVED******REMOVED***font-weight:***REMOVED***500;
}

.login-link:hover***REMOVED***{
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
