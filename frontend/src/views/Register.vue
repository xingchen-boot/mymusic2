<template>
  <div class="register-container">
    <div class="register-box">
      <div class="register-header">
        <h2>注册MyMusic</h2>
        <p>创建账号，开启你的音乐之旅</p>
      </div>

      <el-form
        ref="registerFormRef"
        :model="registerForm"
        :rules="registerRules"
        class="register-form"
        @submit.prevent="handleRegister"
      >
        <el-form-item prop="username">
          <el-input
            v-model="registerForm.username"
            placeholder="请输入用户名"
            size="large"
            prefix-icon="User"
            clearable
          />
        </el-form-item>

        <el-form-item prop="nickname">
          <el-input
            v-model="registerForm.nickname"
            placeholder="请输入昵称"
            size="large"
            prefix-icon="Avatar"
            clearable
          />
        </el-form-item>

        <el-form-item prop="password">
          <el-input
            v-model="registerForm.password"
            type="password"
            placeholder="请输入密码"
            size="large"
            prefix-icon="Lock"
            show-password
            clearable
          />
        </el-form-item>

        <el-form-item prop="confirmPassword">
          <el-input
            v-model="registerForm.confirmPassword"
            type="password"
            placeholder="请确认密码"
            size="large"
            prefix-icon="Lock"
            show-password
            clearable
            @keyup.enter="handleRegister"
          />
        </el-form-item>

        <el-form-item>
          <el-button
            type="primary"
            size="large"
            class="register-btn"
            :loading="loading"
            @click="handleRegister"
          >
            {{ loading ? '注册中...' : '注册' }}
          </el-button>
        </el-form-item>
      </el-form>

      <div class="register-footer">
        <p>已有账号？<router-link to="/login" class="login-link">立即登录</router-link></p>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage, type FormInstance, type FormRules } from 'element-plus'
import { useUserStore } from '@/stores/user'

const router = useRouter()
const userStore = useUserStore()

// 表单引用
const registerFormRef = ref<FormInstance>()

// 加载状态
const loading = ref(false)

// 注册表单数据
const registerForm = reactive({
  username: '',
  nickname: '',
  password: '',
  confirmPassword: ''
})

// 自定义验证器
const validateConfirmPassword = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('请再次输入密码'))
  } else if (value !== registerForm.password) {
    callback(new Error('两次输入密码不一致'))
  } else {
    callback()
  }
}

// 表单验证规则
const registerRules: FormRules = {
  username: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { min: 3, max: 20, message: '用户名长度在3到20个字符', trigger: 'blur' },
    { pattern: /^[a-zA-Z0-9_]+$/, message: '用户名只能包含字母、数字和下划线', trigger: 'blur' }
  ],
  nickname: [
    { required: true, message: '请输入昵称', trigger: 'blur' },
    { min: 2, max: 20, message: '昵称长度在2到20个字符', trigger: 'blur' }
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { min: 6, max: 20, message: '密码长度在6到20个字符', trigger: 'blur' }
  ],
  confirmPassword: [
    { required: true, message: '请确认密码', trigger: 'blur' },
    { validator: validateConfirmPassword, trigger: 'blur' }
  ]
}

// 处理注册
const handleRegister = async () => {
  if (!registerFormRef.value) return

  try {
    const valid = await registerFormRef.value.validate()
    if (!valid) return

    loading.value = true

    const success = await userStore.register(
      registerForm.username,
      registerForm.password,
      registerForm.nickname
    )

    if (success) {
      ElMessage.success('注册成功，请登录')
      // 注册成功后跳转到登录页面
      router.push('/login')
    }
  } catch (error: any) {
    ElMessage.error(error.message || '注册失败')
  } finally {
    loading.value = false
  }
}
</script>

<style scoped>
.register-container {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
}

.register-box {
  width: 100%;
  max-width: 400px;
  background: white;
  border-radius: 16px;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
  padding: 40px;
}

.register-header {
  text-align: center;
  margin-bottom: 30px;
}

.register-header h2 {
  color: #333;
  font-size: 28px;
  font-weight: 600;
  margin: 0 0 8px 0;
}

.register-header p {
  color: #666;
  font-size: 14px;
  margin: 0;
}

.register-form {
  margin-bottom: 20px;
}

.register-btn {
  width: 100%;
  height: 48px;
  background: linear-gradient(45deg, #667eea, #764ba2);
  border: none;
  border-radius: 8px;
  font-size: 16px;
  font-weight: 500;
}

.register-btn:hover {
  background: linear-gradient(45deg, #764ba2, #667eea);
}

.register-footer {
  text-align: center;
}

.register-footer p {
  color: #666;
  font-size: 14px;
  margin: 0;
}

.login-link {
  color: #667eea;
  text-decoration: none;
  font-weight: 500;
}

.login-link:hover {
  color: #764ba2;
  text-decoration: underline;
}

/* Element Plus 样式覆盖 */
::v-deep(.el-input__wrapper) {
  border-radius: 8px;
  border: 1px solid #e0e0e0;
  box-shadow: none;
  height: 48px;
}

::v-deep(.el-input__wrapper:hover) {
  border-color: #667eea;
}

::v-deep(.el-input__wrapper.is-focus) {
  border-color: #667eea;
  box-shadow: 0 0 0 2px rgba(102, 126, 234, 0.2);
}

::v-deep(.el-form-item) {
  margin-bottom: 20px;
}

::v-deep(.el-form-item__error) {
  font-size: 12px;
}
</style>
