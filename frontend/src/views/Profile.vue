<template>
    <div class="profile">
      <div class="card">
        <div class="card-header">
          <h1>个人中心</h1>
          <div class="sub">管理你的头像与昵称信息</div>
        </div>
        
        <el-form :model="form" label-width="90px" class="profile-form">
          <!-- 头像上传区域 -->
          <el-form-item label="头像">
            <div class="avatar-row">
              <div class="avatar-shadow">
                <img :src="avatarSrc" class="avatar" alt="用户头像" />
              </div>
              <div class="avatar-actions">
                <el-upload
                  :show-file-list="false"
                  :before-upload="beforeUpload"
                  :http-request="customUpload"
                  accept="image/*"
                >
                  <el-button type="primary" plain>上传头像</el-button>
                </el-upload>
                <div class="tip">支持JPG/PNG，≤2MB</div>
              </div>
            </div>
          </el-form-item>
          
          <!-- 昵称输入区域 -->
          <el-form-item label="昵称">
            <el-input 
              v-model.trim="form.nickname" 
              maxlength="20" 
              show-word-limit 
              placeholder="请输入昵称" 
            />
          </el-form-item>
          
          <!-- 操作按钮区域 -->
          <el-form-item>
            <el-button 
              type="primary" 
              :loading="saving" 
              :disabled="!canSave" 
              @click="save"
            >
              保存
            </el-button>
            <el-button @click="reset">重置</el-button>
            <div class="tip">可以单独修改头像或昵称，也可以同时修改</div>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, computed, onMounted, watch } from 'vue'
  import { useUserStore } from '@/stores/user'
  import { ElMessage } from 'element-plus'
  
  // 用户状态管理
  const userStore = useUserStore()
  const defaultAvatar = 'https://picsum.photos/80/80?random=3'
  
  // 表单数据
  const form = ref({
    avatar: '',       // 可为File对象或字符串(URL/Base64)
    nickname: ''      // 用户昵称
  })
  
  // 预览URL（用于头像本地预览）
  const previewUrl = ref<string>(defaultAvatar)
  
  // 原始数据（用于判断是否有修改）
  const origin = ref({
    avatar: '',
    nickname: ''
  })
  
  /**
   * 初始化表单数据
   */
  const initForm = () => {
    if (userStore.currentUser) {
      form.value = {
        avatar: (userStore.currentUser.avatar as any) || '',
        nickname: userStore.currentUser.nickname || ''
      }
      previewUrl.value = userStore.currentUser.avatar || defaultAvatar
      origin.value = {
        avatar: typeof form.value.avatar === 'string' ? (form.value.avatar as string) : '',
        nickname: form.value.nickname
      }
    }
  }
  
  // 监听用户信息变化，重新初始化表单
  watch(
    () => userStore.currentUser,
    (newUser) => {
      if (newUser) {
        initForm()
      }
    },
    { immediate: true }
  )
  
  // 组件挂载时初始化
  onMounted(() => {
    if (userStore.currentUser) {
      initForm()
    }
  })
  
  /**
   * 计算当前显示的头像URL
   */
  const avatarSrc = computed(() => {
    // 如果是字符串类型的头像（URL或Base64）
    if (typeof form.value.avatar === 'string' && form.value.avatar) {
      return form.value.avatar
    }
    
    // 如果是File对象，使用预览URL
    if (typeof form.value.avatar === 'object' && form.value.avatar) {
      return previewUrl.value || defaultAvatar
    }
    
    // 默认情况
    return userStore.currentUser?.avatar || defaultAvatar
  })
  
  // 保存状态
  const saving = ref(false)
  
  /**
   * 判断是否可以保存（检测数据是否有变化）
   */
  const canSave = computed(() => {
    return form.value.nickname !== origin.value.nickname || 
           form.value.avatar !== origin.value.avatar
  })
  
  /**
   * 上传前校验
   * @param file 上传的文件
   * @returns 是否允许上传
   */
  const beforeUpload = (file: File) => {
    const isImage = file.type.startsWith('image/')
    const isLt2M = file.size / 1024 / 1024 < 2
    
    if (!isImage) ElMessage.error('请上传图片文件')
    if (!isLt2M) ElMessage.error('图片大小需小于2MB')
    
    return isImage && isLt2M
  }
  
  /**
   * 自定义上传处理（仅本地预览）
   * @param options 上传选项
   */
  const customUpload = async (options: any) => {
    const file = options.file as File
    
    // 释放之前的blob URL，避免内存泄漏
    if (previewUrl.value && previewUrl.value.startsWith('blob:')) {
      URL.revokeObjectURL(previewUrl.value)
    }
    
    // 创建新的预览URL
    previewUrl.value = URL.createObjectURL(file)
    form.value.avatar = file as any
    
    // 通知上传成功
    options.onSuccess && options.onSuccess({}, file)
  }
  
  /**
   * 保存用户信息
   */
  const save = async () => {
    try {
      // 验证昵称
      if (!form.value.nickname) {
        ElMessage.warning('请输入昵称')
        return
      }
      
      saving.value = true
      let avatarUrl: string | undefined
      
      // 处理头像（如果是File对象则压缩）
      if (form.value.avatar && typeof form.value.avatar !== 'string') {
        const file = form.value.avatar as File
        
        // 检查文件大小
        if (file.size > 1024 * 1024) {
          ElMessage.error('头像文件大小不能超过1MB')
          saving.value = false
          return
        }
        
        // 压缩图片并转换为Base64
        avatarUrl = await compressImage(file)
      }
      
      // 构建请求参数（只包含有变化的字段）
      const payload: any = {}
      if (form.value.nickname !== origin.value.nickname) {
        payload.nickname = form.value.nickname
      }
      if (avatarUrl) {
        payload.avatar = avatarUrl
      } else if (typeof form.value.avatar === 'string' && form.value.avatar !== origin.value.avatar) {
        payload.avatar = form.value.avatar
      }
      
      // 发送请求
      const resp = await fetch(`/api/user/info/${userStore.currentUser?.id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(Object.keys(payload).length ? payload : { nickname: null, avatar: null })
      })
      
      const result = await resp.json()
      
      if (result.code === 200) {
        // 更新本地用户信息
        if (userStore.currentUser) {
          if (payload.nickname !== undefined) {
            userStore.currentUser.nickname = form.value.nickname
          }
          if (payload.avatar !== undefined) {
            userStore.currentUser.avatar = payload.avatar
          }
          // 同步到本地存储
          localStorage.setItem('userInfo', JSON.stringify(userStore.currentUser))
        }
        
        // 更新本地状态
        if (payload.avatar) {
          form.value.avatar = payload.avatar
          // 清理blob URL
          if (previewUrl.value && previewUrl.value.startsWith('blob:')) {
            URL.revokeObjectURL(previewUrl.value)
          }
          previewUrl.value = payload.avatar
        }
        
        // 更新原始状态
        origin.value = {
          avatar: payload.avatar || form.value.avatar,
          nickname: form.value.nickname
        }
        
        ElMessage.success('保存成功')
      } else {
        ElMessage.error(result.message || '保存失败')
      }
    } catch (e) {
      console.error('保存失败:', e)
      ElMessage.error('网络异常')
    } finally {
      saving.value = false
    }
  }
  
  /**
   * 压缩图片并转换为Base64
   * @param file 图片文件
   * @returns 压缩后的Base64字符串
   */
  const compressImage = (file: File): Promise<string> => {
    return new Promise((resolve, reject) => {
      const canvas = document.createElement('canvas')
      const ctx = canvas.getContext('2d')
      const img = new Image()
      
      img.onload = () => {
        // 计算保持比例的尺寸
        const maxSize = 200
        let { width, height } = img
        
        // 如果图片尺寸小于最大限制，保持原尺寸
        if (width <= maxSize && height <= maxSize) {
          canvas.width = width
          canvas.height = height
        } else {
          // 按比例缩放到最大尺寸
          const ratio = Math.min(maxSize / width, maxSize / height)
          canvas.width = Math.round(width * ratio)
          canvas.height = Math.round(height * ratio)
        }
        
        // 绘制图片
        ctx?.drawImage(img, 0, 0, canvas.width, canvas.height)
        
        // 转换为Base64，质量0.7
        const compressedBase64 = canvas.toDataURL('image/jpeg', 0.7)
        resolve(compressedBase64)
      }
      
      img.onerror = reject
      img.src = URL.createObjectURL(file)
    })
  }
  
  /**
   * 重置表单
   */
  const reset = () => {
    form.value = { ...origin.value }
  }
  </script>
  
  <style scoped>
  .profile {
    max-width: 840px;
    margin: 24px auto;
    padding: 0 16px;
  }
  
  .card {
    background: #fff;
    border-radius: 16px;
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.06);
    overflow: hidden;
  }
  
  .card-header {
    padding: 20px 24px 0 24px;
  }
  
  .card-header h1 {
    margin: 0;
    color: #1f2328;
    font-size: 28px;
  }
  
  .card-header .sub {
    color: #8a919f;
    font-size: 13px;
    margin-top: 6px;
  }
  
  .profile-form {
    padding: 16px 24px 24px;
  }
  
  .avatar-row {
    display: flex;
    align-items: center;
    gap: 16px;
  }
  
  .avatar-shadow {
    width: 96px;
    height: 96px;
    border-radius: 50%;
    padding: 2px;
    background: linear-gradient(135deg, #e3e8ef, #f5f7fb);
    box-shadow: 0 6px 16px rgba(0, 0, 0, 0.08);
  }
  
  .avatar {
    width: 92px;
    height: 92px;
    border-radius: 50%;
    object-fit: cover;
    display: block;
  }
  
  .avatar-actions {
    display: flex;
    flex-direction: column;
    gap: 6px;
  }
  
  .tip {
    font-size: 12px;
    color: #9aa5b1;
    margin-top: 8px;
  }
  
  /* 按钮样式调整 */
  :deep(.el-button) + .el-button {
    margin-left: 12px;
  }
  </style>
      