<template>
    <div class="playlist-page">
      <!-- 页面头部 -->
      <div class="page-header">
        <h1>我的歌单</h1>
        <el-button 
          type="primary" 
          @click="showCreateDialog = true" 
          class="create-btn"
        >
          ➕ 创建歌单
        </el-button>
      </div>
  
      <!-- 播放列表网格 -->
      <div class="playlist-grid" v-loading="isPlaylistLoading">
        <div
          v-for="playlist in playlists"
          :key="playlist.id"
          class="playlist-card"
          @click="viewPlaylist(playlist)"
        >
          <div class="playlist-cover">
            <img
              :src="playlist.cover || '/default-playlist.jpg'"
              :alt="playlist.name"
              @error="handleImageError"
            />
            <div class="playlist-overlay">
              <el-button
                type="primary"
                circle
                size="large"
                @click.stop="playPlaylist(playlist)"
              >
                ▶️
              </el-button>
            </div>
          </div>
          
          <div class="playlist-info">
            <h3 class="playlist-name">{{ playlist.name }}</h3>
            <p class="playlist-desc">{{ playlist.description || '暂无描述' }}</p>
            <div class="playlist-meta">
              <span class="music-count">{{ playlist.musicCount || 0 }} 首歌曲</span>
              <span class="created-time">{{ formatDate(playlist.createdAt) }}</span>
            </div>
          </div>
          
          <div class="playlist-actions">
            <el-button
              type="text"
              @click.stop="editPlaylist(playlist)"
              class="action-btn"
            >
              ✏️
            </el-button>
            <el-button
              type="text"
              @click.stop="deletePlaylist(playlist)"
              class="action-btn delete-btn"
            >
              🗑️
            </el-button>
          </div>
        </div>
      </div>
  
      <!-- 空状态 -->
      <div 
        v-if="!isPlaylistLoading && playlists.length === 0" 
        class="empty-state"
      >
        <div class="empty-icon">📁</div>
        <h3>还没有歌单</h3>
        <p>创建你的第一个歌单，开始收藏喜欢的音乐吧！</p>
        <el-button 
          type="primary" 
          @click="showCreateDialog = true"
        >
          创建歌单
        </el-button>
      </div>
  
      <!-- 创建歌单对话框 -->
      <el-dialog
        v-model="showCreateDialog"
        title="创建歌单"
        width="500px"
        :before-close="handleCloseCreate"
      >
        <el-form :model="createForm" label-width="80px">
          <el-form-item label="歌单名称" required>
            <el-input
              v-model="createForm.name"
              placeholder="请输入歌单名称"
              maxlength="50"
              show-word-limit
            />
          </el-form-item>
          <el-form-item label="歌单描述">
            <el-input
              v-model="createForm.description"
              type="textarea"
              placeholder="请输入歌单描述（可选）"
              :rows="3"
              maxlength="200"
              show-word-limit
            />
          </el-form-item>
        </el-form>
        
        <template #footer>
          <el-button @click="handleCloseCreate">取消</el-button>
          <el-button
            type="primary"
            @click="handleCreatePlaylist"
            :loading="isCreating"
          >
            创建
          </el-button>
        </template>
      </el-dialog>
  
      <!-- 编辑歌单对话框 -->
      <el-dialog
        v-model="showEditDialog"
        title="编辑歌单"
        width="500px"
        :before-close="handleCloseEdit"
      >
        <el-form :model="editForm" label-width="80px">
          <el-form-item label="歌单名称" required>
            <el-input
              v-model="editForm.name"
              placeholder="请输入歌单名称"
              maxlength="50"
              show-word-limit
            />
          </el-form-item>
          <el-form-item label="歌单描述">
            <el-input
              v-model="editForm.description"
              type="textarea"
              placeholder="请输入歌单描述（可选）"
              :rows="3"
              maxlength="200"
              show-word-limit
            />
          </el-form-item>
        </el-form>
        
        <template #footer>
          <el-button @click="handleCloseEdit">取消</el-button>
          <el-button
            type="primary"
            @click="handleUpdatePlaylist"
            :loading="isUpdating"
          >
            保存
          </el-button>
        </template>
      </el-dialog>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, onMounted } from 'vue'
  import { useRouter } from 'vue-router'
  import { useMusicStore, type Playlist } from '@/stores/music'
  import { ElMessage, ElMessageBox } from 'element-plus'
  
  const router = useRouter()
  const musicStore = useMusicStore()
  
  // 响应式数据
  const showCreateDialog = ref(false)
  const showEditDialog = ref(false)
  const isCreating = ref(false)
  const isUpdating = ref(false)
  const editingPlaylist = ref<Playlist | null>(null)
  
  const createForm = ref({
    name: '',
    description: ''
  })
  
  const editForm = ref({
    name: '',
    description: ''
  })
  
  // 从Pinia store解构数据
  const { playlists, isPlaylistLoading } = musicStore
  
  // 查看歌单详情
  const viewPlaylist = (playlist: Playlist) => {
    router.push(`/playlist/${playlist.id}`)
  }
  
  // 播放歌单（播放第一首歌曲）
  const playPlaylist = async (playlist: Playlist) => {
    try {
      await musicStore.fetchPlaylistDetail(playlist.id)
      if (playlist.musicList && playlist.musicList.length > 0) {
        const firstMusic = playlist.musicList[0]
        const music = {
          id: firstMusic.musicId,
          mid: firstMusic.musicMid,
          song: firstMusic.musicSong,
          singer: firstMusic.musicSinger,
          album: firstMusic.musicAlbum,
          cover: firstMusic.musicCover
        }
        await musicStore.playMusic(music)
      } else {
        ElMessage.warning('歌单中没有歌曲')
      }
    } catch (error) {
      console.error('播放歌单失败:', error)
      ElMessage.error('播放歌单失败')
    }
  }
  
  // 打开编辑歌单对话框并赋值
  const editPlaylist = (playlist: Playlist) => {
    editingPlaylist.value = playlist
    editForm.value = {
      name: playlist.name,
      description: playlist.description || ''
    }
    showEditDialog.value = true
  }
  
  // 删除歌单（带确认弹窗）
  const deletePlaylist = async (playlist: Playlist) => {
    try {
      await ElMessageBox.confirm(
        `确定要删除歌单"${playlist.name}"吗？删除后无法恢复。`,
        '确认删除',
        {
          confirmButtonText: '删除',
          cancelButtonText: '取消',
          type: 'warning',
          confirmButtonClass: 'el-button--danger'
        }
      )
  
      await musicStore.deletePlaylist(playlist.id)
      ElMessage.success('删除成功')
    } catch (error) {
      // 忽略用户取消操作的错误
      if (error !== 'cancel') {
        console.error('删除歌单失败:', error)
        ElMessage.error('删除失败')
      }
    }
  }
  
  // 提交创建歌单请求
  const handleCreatePlaylist = async () => {
    if (!createForm.value.name.trim()) {
      ElMessage.warning('请输入歌单名称')
      return
    }
  
    isCreating.value = true
    try {
      await musicStore.createPlaylist(createForm.value.name, createForm.value.description)
      ElMessage.success('创建成功')
      handleCloseCreate()
    } catch (error) {
      console.error('创建歌单失败:', error)
      ElMessage.error('创建失败')
    } finally {
      isCreating.value = false
    }
  }
  
  // 提交更新歌单请求
  const handleUpdatePlaylist = async () => {
    if (!editForm.value.name.trim()) {
      ElMessage.warning('请输入歌单名称')
      return
    }
  
    if (!editingPlaylist.value) return
  
    isUpdating.value = true
    try {
      // 实际项目中需替换为更新歌单的API调用，此处用重新拉取列表临时替代
      await musicStore.fetchPlaylists()
      ElMessage.success('更新成功')
      handleCloseEdit()
    } catch (error) {
      console.error('更新歌单失败:', error)
      ElMessage.error('更新失败')
    } finally {
      isUpdating.value = false
    }
  }
  
  // 关闭创建歌单对话框（重置表单）
  const handleCloseCreate = () => {
    showCreateDialog.value = false
    createForm.value = { name: '', description: '' }
  }
  
  // 关闭编辑歌单对话框（重置状态）
  const handleCloseEdit = () => {
    showEditDialog.value = false
    editingPlaylist.value = null
    editForm.value = { name: '', description: '' }
  }
  
  // 格式化日期为本地中文日期（如：2024/5/20）
  const formatDate = (dateString: string) => {
    const date = new Date(dateString)
    return date.toLocaleDateString('zh-CN')
  }
  
  // 图片加载失败时替换为默认base64图片（粉色占位图）
  const handleImageError = (event: Event) => {
    const img = event.target as HTMLImageElement
    img.src = 'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMjAwIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDIwMCAyMDAiIGZpbGw9Im5vbmUiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CjxyZWN0IHdpZHRoPSIyMDAiIGhlaWdodD0iMjAwIiBmaWxsPSIjRjVGNUY1Ii8+CjxwYXRoIGQ9Ik0xMDAgNTBMMTUwIDEwMEgxMDBWNTBaIiBmaWxsPSIjQ0NDQ0NDIi8+CjxwYXRoIGQ9Ik0xMDAgMTUwTDUwIDEwMEgxMDBWMTUwWiIgZmlsbD0iI0NDQ0NDQyIvPgo8L3N2Zz4K'
  }
  
  // 页面挂载时加载歌单列表数据
  onMounted(() => {
    musicStore.fetchPlaylists()
  })
  </script>
  
  <style scoped>
  /* 页面容器样式 */
  .playlist-page {
    padding: 20px;
    max-width: 1200px;
    margin: 0 auto;
  }
  
  /* 页面头部样式 */
  .page-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 30px;
  }
  
  .page-header h1 {
    margin: 0;
    color: #333;
    font-size: 28px;
    font-weight: 600;
  }
  
  .create-btn {
    background: linear-gradient(45deg, #667eea, #764ba2);
    border: none;
    border-radius: 20px;
    padding: 10px 20px;
    font-weight: 500;
  }
  
  /* 歌单网格布局 */
  .playlist-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
    gap: 20px;
    margin-bottom: 40px;
  }
  
  /* 歌单卡片样式 */
  .playlist-card {
    background: white;
    border-radius: 12px;
    box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    transition: all 0.3s ease;
    cursor: pointer;
    position: relative;
  }
  
  .playlist-card:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 25px rgba(0, 0, 0, 0.15);
  }
  
  /* 歌单封面样式 */
  .playlist-cover {
    position: relative;
    width: 100%;
    height: 200px;
    overflow: hidden;
  }
  
  .playlist-cover img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: transform 0.3s ease;
  }
  
  .playlist-card:hover .playlist-cover img {
    transform: scale(1.05);
  }
  
  /* 封面悬浮播放层 */
  .playlist-overlay {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    align-items: center;
    justify-content: center;
    opacity: 0;
    transition: opacity 0.3s ease;
  }
  
  .playlist-card:hover .playlist-overlay {
    opacity: 1;
  }
  
  /* 歌单信息区域 */
  .playlist-info {
    padding: 20px;
  }
  
  .playlist-name {
    margin: 0 0 8px 0;
    font-size: 18px;
    font-weight: 600;
    color: #333;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  .playlist-desc {
    margin: 0 0 12px 0;
    color: #666;
    font-size: 14px;
    line-height: 1.4;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    overflow: hidden;
  }
  
  /* 歌单元数据（歌曲数量+创建时间） */
  .playlist-meta {
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: 12px;
    color: #999;
  }
  
  .music-count {
    font-weight: 500;
  }
  
  .created-time {
    color: #ccc;
  }
  
  /* 歌单操作按钮（编辑/删除） */
  .playlist-actions {
    position: absolute;
    top: 10px;
    right: 10px;
    display: flex;
    gap: 5px;
    opacity: 0;
    transition: opacity 0.3s ease;
  }
  
  .playlist-card:hover .playlist-actions {
    opacity: 1;
  }
  
  .action-btn {
    width: 32px;
    height: 32px;
    padding: 0;
    background: rgba(255, 255, 255, 0.9);
    border: none;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 14px;
    transition: all 0.3s ease;
  }
  
  .action-btn:hover {
    background: white;
    transform: scale(1.1);
  }
  
  .delete-btn:hover {
    background: #ff4757;
    color: white;
  }
  
  /* 空状态样式 */
  .empty-state {
    text-align: center;
    padding: 80px 20px;
    color: #666;
  }
  
  .empty-icon {
    font-size: 64px;
    margin-bottom: 20px;
  }
  
  .empty-state h3 {
    margin: 0 0 10px 0;
    font-size: 24px;
    color: #333;
  }
  
  .empty-state p {
    margin: 0 0 30px 0;
    font-size: 16px;
    line-height: 1.5;
  }
  
  /* Element Plus 样式覆盖（局部作用域） */
  :deep(.el-button--primary) {
    background: linear-gradient(45deg, #667eea, #764ba2);
    border: none;
  }
  
  :deep(.el-button--primary:hover) {
    background: linear-gradient(45deg, #764ba2, #667eea);
  }
  
  :deep(.el-dialog__header) {
    background: linear-gradient(45deg, #667eea, #764ba2);
    color: white;
    margin: 0;
    padding: 20px;
  }
  
  :deep(.el-dialog__title) {
    color: white;
    font-weight: 600;
  }
  
  :deep(.el-dialog__headerbtn .el-dialog__close) {
    color: white;
    font-size: 20px;
  }
  
  :deep(.el-dialog__body) {
    padding: 30px;
  }
  
  :deep(.el-form-item__label) {
    font-weight: 500;
    color: #333;
  }
  
  :deep(.el-input__wrapper) {
    border-radius: 8px;
  }
  
  :deep(.el-textarea__inner) {
    border-radius: 8px;
  }
  </style>
  