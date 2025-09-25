<template>
    <div class="login-container">
      <div class="login-box">
        <div class="login-header">
          <h2>登录MyMusic</h2>
          <p>欢迎回来，开始你的音乐之旅</p>
        </div>
  
        <el-form
          ref="loginFormRef"
          :model="loginForm"
          :rules="loginRules"
          class="login-form"
          @submit.prevent="handleLogin"
        >
          <el-form-item prop="username">
            <el-input
              v-model="loginForm.username"
              placeholder="请输入用户名"
              size="large"
              prefix-icon="User"
              clearable
            />
          </el-form-item>
  
          <el-form-item prop="password">
            <el-input
              v-model="loginForm.password"
              type="password"
              placeholder="请输入密码"
              size="large"
              prefix-icon="Lock"
              show-password
              clearable
              @keyup.enter="handleLogin"
            />
          </el-form-item>
  
          <el-form-item>
            <el-button
              type="primary"
              size="large"
              class="login-btn"
              :loading="loading"
              @click="handleLogin"
            >
              {{ loading ? '登录中...' : '登录' }}
            </el-button>
          </el-form-item>
        </el-form>
  
        <div class="login-footer">
          <p>还没有账号？<router-link to="/register" class="register-link">立即注册</router-link></p>
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
  const loginFormRef = ref<FormInstance>()
  
  // 加载状态
  const loading = ref(false)
  
  // 登录表单数据
  const loginForm = reactive({
    username: '',
    password: ''
  })
  
  // 表单验证规则
  const loginRules: FormRules = {
    username: [
      { required: true, message: '请输入用户名', trigger: 'blur' },
      { min: 3, max: 20, message: '用户名长度在3到20个字符', trigger: 'blur' }
    ],
    password: [
      { required: true, message: '请输入密码', trigger: 'blur' },
      { min: 6, max: 20, message: '密码长度在6到20个字符', trigger: 'blur' }
    ]
  }
  
  // 处理登录
  const handleLogin = async () => {
    if (!loginFormRef.value) return
  
    try {
      const valid = await loginFormRef.value.validate()
      if (!valid) return
  
      loading.value = true
  
      const success = await userStore.login(loginForm.username, loginForm.password)
  
      if (success) {
        ElMessage.success('登录成功')
        // 登录成功后跳转到首页
        router.push('/')
      }
    } catch (error: any) {
      ElMessage.error(error.message || '登录失败')
    } finally {
      loading.value = false
    }
  }
  </script>
  
  <style scoped>
  .login-container {
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 20px;
  }
  
  .login-box {
    width: 100%;
    max-width: 400px;
    background: white;
    border-radius: 16px;
    box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
    padding: 40px;
  }
  
  .login-header {
    text-align: center;
    margin-bottom: 30px;
  }
  
  .login-header h2 {
    color: #333;
    font-size: 28px;
    font-weight: 600;
    margin: 0 0 8px 0;
  }
  
  .login-header p {
    color: #666;
    font-size: 14px;
    margin: 0;
  }
  
  .login-form {
    margin-bottom: 20px;
  }
  
  .login-btn {
    width: 100%;
    height: 48px;
    background: linear-gradient(45deg, #667eea, #764ba2);
    border: none;
    border-radius: 8px;
    font-size: 16px;
    font-weight: 500;
  }
  
  .login-btn:hover {
    background: linear-gradient(45deg, #764ba2, #667eea);
  }
  
  .login-footer {
    text-align: center;
  }
  
  .login-footer p {
    color: #666;
    font-size: 14px;
    margin: 0;
  }
  
  .register-link {
    color: #667eea;
    text-decoration: none;
    font-weight: 500;
  }
  
  .register-link:hover {
    color: #764ba2;
    text-decoration: underline;
  }
  
  /* Element Plus 样式覆盖 */
  :deep(.el-input__wrapper) {
    border-radius: 8px;
    border: 1px solid #e0e0e0;
    box-shadow: none;
    height: 48px;
  }
  
  :deep(.el-input__wrapper:hover) {
    border-color: #667eea;
  }
  
  :deep(.el-input__wrapper.is-focus) {
    border-color: #667eea;
    box-shadow: 0 0 0 2px rgba(102, 126, 234, 0.2);
  }
  
  :deep(.el-form-item) {
    margin-bottom: 20px;
  }
  
  :deep(.el-form-item__error) {
    font-size: 12px;
  }
  </style>
  