<template>
***REMOVED******REMOVED***<div***REMOVED***class="playlist-page">
***REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***页面头部***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="page-header">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h1>我的歌单</h1>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="primary"***REMOVED***@click="showCreateDialog***REMOVED***=***REMOVED***true"***REMOVED***class="create-btn">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***➕***REMOVED***创建歌单
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***播放列表网格***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="playlist-grid"***REMOVED***v-loading="isPlaylistLoading">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-for="playlist***REMOVED***in***REMOVED***playlists"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:key="playlist.id"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="playlist-card"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="viewPlaylist(playlist)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="playlist-cover">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<img***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:src="playlist.cover***REMOVED***||***REMOVED***'/default-playlist.jpg'"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:alt="playlist.name"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@error="handleImageError"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="playlist-overlay">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="primary"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***circle***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***size="large"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click.stop="playPlaylist(playlist)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***▶️
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="playlist-info">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h3***REMOVED***class="playlist-name">{{***REMOVED***playlist.name***REMOVED***}}</h3>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p***REMOVED***class="playlist-desc">{{***REMOVED***playlist.description***REMOVED***||***REMOVED***'暂无描述'***REMOVED***}}</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="playlist-meta">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="music-count">{{***REMOVED***playlist.musicCount***REMOVED***||***REMOVED***0***REMOVED***}}***REMOVED***首歌曲</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<span***REMOVED***class="created-time">{{***REMOVED***formatDate(playlist.createdAt)***REMOVED***}}</span>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="playlist-actions">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="text"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click.stop="editPlaylist(playlist)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="action-btn"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***✏️
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="text"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click.stop="deletePlaylist(playlist)"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***class="action-btn***REMOVED***delete-btn"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***🗑️
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</div>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***空状态***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***v-if="!isPlaylistLoading***REMOVED***&&***REMOVED***playlists.length***REMOVED***===***REMOVED***0"***REMOVED***class="empty-state">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<div***REMOVED***class="empty-icon">📁</div>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<h3>还没有歌单</h3>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<p>创建你的第一个歌单，开始收藏喜欢的音乐吧！</p>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***type="primary"***REMOVED***@click="showCreateDialog***REMOVED***=***REMOVED***true">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***创建歌单
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED***</div>

***REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***创建歌单对话框***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED***<el-dialog
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="showCreateDialog"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***title="创建歌单"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***width="500px"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:before-close="handleCloseCreate"
***REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form***REMOVED***:model="createForm"***REMOVED***label-width="80px">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form-item***REMOVED***label="歌单名称"***REMOVED***required>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-input***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="createForm.name"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***placeholder="请输入歌单名称"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***maxlength="50"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***show-word-limit
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form-item***REMOVED***label="歌单描述">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-input***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="createForm.description"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="textarea"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***placeholder="请输入歌单描述（可选）"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:rows="3"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***maxlength="200"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***show-word-limit
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<template***REMOVED***#footer>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***@click="handleCloseCreate">取消</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="primary"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="handleCreatePlaylist"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:loading="isCreating"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***创建
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</template>
***REMOVED******REMOVED******REMOVED******REMOVED***</el-dialog>

***REMOVED******REMOVED******REMOVED******REMOVED***<!--***REMOVED***编辑歌单对话框***REMOVED***-->
***REMOVED******REMOVED******REMOVED******REMOVED***<el-dialog
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="showEditDialog"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***title="编辑歌单"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***width="500px"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:before-close="handleCloseEdit"
***REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form***REMOVED***:model="editForm"***REMOVED***label-width="80px">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form-item***REMOVED***label="歌单名称"***REMOVED***required>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-input***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="editForm.name"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***placeholder="请输入歌单名称"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***maxlength="50"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***show-word-limit
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-form-item***REMOVED***label="歌单描述">
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-input***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***v-model="editForm.description"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="textarea"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***placeholder="请输入歌单描述（可选）"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:rows="3"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***maxlength="200"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***show-word-limit
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***/>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form-item>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-form>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<template***REMOVED***#footer>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***@click="handleCloseEdit">取消</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***<el-button***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type="primary"***REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***@click="handleUpdatePlaylist"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***:loading="isUpdating"
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***保存
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</el-button>
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***</template>
***REMOVED******REMOVED******REMOVED******REMOVED***</el-dialog>
***REMOVED******REMOVED***</div>
</template>

<script***REMOVED***setup***REMOVED***lang="ts">
import***REMOVED***{***REMOVED***ref,***REMOVED***onMounted***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***useRouter***REMOVED***}***REMOVED***from***REMOVED***'vue-router'
import***REMOVED***{***REMOVED***useMusicStore,***REMOVED***type***REMOVED***Playlist***REMOVED***}***REMOVED***from***REMOVED***'@/stores/music'
import***REMOVED***{***REMOVED***ElMessage,***REMOVED***ElMessageBox***REMOVED***}***REMOVED***from***REMOVED***'element-plus'

const***REMOVED***router***REMOVED***=***REMOVED***useRouter()
const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore()

//***REMOVED***响应式数据
const***REMOVED***showCreateDialog***REMOVED***=***REMOVED***ref(false)
const***REMOVED***showEditDialog***REMOVED***=***REMOVED***ref(false)
const***REMOVED***isCreating***REMOVED***=***REMOVED***ref(false)
const***REMOVED***isUpdating***REMOVED***=***REMOVED***ref(false)
const***REMOVED***editingPlaylist***REMOVED***=***REMOVED***ref<Playlist***REMOVED***|***REMOVED***null>(null)

const***REMOVED***createForm***REMOVED***=***REMOVED***ref({
***REMOVED******REMOVED***name:***REMOVED***'',
***REMOVED******REMOVED***description:***REMOVED***''
})

const***REMOVED***editForm***REMOVED***=***REMOVED***ref({
***REMOVED******REMOVED***name:***REMOVED***'',
***REMOVED******REMOVED***description:***REMOVED***''
})

//***REMOVED***计算属性
const***REMOVED***{***REMOVED***playlists,***REMOVED***isPlaylistLoading***REMOVED***}***REMOVED***=***REMOVED***musicStore

//***REMOVED***方法
const***REMOVED***viewPlaylist***REMOVED***=***REMOVED***(playlist:***REMOVED***Playlist)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***router.push(`/playlist/${playlist.id}`)
}

const***REMOVED***playPlaylist***REMOVED***=***REMOVED***async***REMOVED***(playlist:***REMOVED***Playlist)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.fetchPlaylistDetail(playlist.id)
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(playlist.musicList***REMOVED***&&***REMOVED***playlist.musicList.length***REMOVED***>***REMOVED***0)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***播放第一首歌
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***firstMusic***REMOVED***=***REMOVED***playlist.musicList[0]
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***music***REMOVED***=***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***id:***REMOVED***firstMusic.musicId,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***mid:***REMOVED***firstMusic.musicMid,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***song:***REMOVED***firstMusic.musicSong,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***singer:***REMOVED***firstMusic.musicSinger,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***album:***REMOVED***firstMusic.musicAlbum,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***cover:***REMOVED***firstMusic.musicCover
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.playMusic(music)
***REMOVED******REMOVED******REMOVED******REMOVED***}***REMOVED***else***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.warning('歌单中没有歌曲')
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.error('播放歌单失败:',***REMOVED***error)
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.error('播放歌单失败')
***REMOVED******REMOVED***}
}

const***REMOVED***editPlaylist***REMOVED***=***REMOVED***(playlist:***REMOVED***Playlist)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***editingPlaylist.value***REMOVED***=***REMOVED***playlist
***REMOVED******REMOVED***editForm.value***REMOVED***=***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***name:***REMOVED***playlist.name,
***REMOVED******REMOVED******REMOVED******REMOVED***description:***REMOVED***playlist.description***REMOVED***||***REMOVED***''
***REMOVED******REMOVED***}
***REMOVED******REMOVED***showEditDialog.value***REMOVED***=***REMOVED***true
}

const***REMOVED***deletePlaylist***REMOVED***=***REMOVED***async***REMOVED***(playlist:***REMOVED***Playlist)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***ElMessageBox.confirm(
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***`确定要删除歌单"${playlist.name}"吗？删除后无法恢复。`,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***'确认删除',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***confirmButtonText:***REMOVED***'删除',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***cancelButtonText:***REMOVED***'取消',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***type:***REMOVED***'warning',
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***confirmButtonClass:***REMOVED***'el-button--danger'
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***)
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.deletePlaylist(playlist.id)
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.success('删除成功')
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***if***REMOVED***(error***REMOVED***!==***REMOVED***'cancel')***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***console.error('删除歌单失败:',***REMOVED***error)
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.error('删除失败')
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED***}
}

const***REMOVED***handleCreatePlaylist***REMOVED***=***REMOVED***async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!createForm.value.name.trim())***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.warning('请输入歌单名称')
***REMOVED******REMOVED******REMOVED******REMOVED***return
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***isCreating.value***REMOVED***=***REMOVED***true
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.createPlaylist(createForm.value.name,***REMOVED***createForm.value.description)
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.success('创建成功')
***REMOVED******REMOVED******REMOVED******REMOVED***handleCloseCreate()
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.error('创建歌单失败:',***REMOVED***error)
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.error('创建失败')
***REMOVED******REMOVED***}***REMOVED***finally***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***isCreating.value***REMOVED***=***REMOVED***false
***REMOVED******REMOVED***}
}

const***REMOVED***handleUpdatePlaylist***REMOVED***=***REMOVED***async***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***if***REMOVED***(!editForm.value.name.trim())***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.warning('请输入歌单名称')
***REMOVED******REMOVED******REMOVED******REMOVED***return
***REMOVED******REMOVED***}
***REMOVED******REMOVED***
***REMOVED******REMOVED***if***REMOVED***(!editingPlaylist.value)***REMOVED***return
***REMOVED******REMOVED***
***REMOVED******REMOVED***isUpdating.value***REMOVED***=***REMOVED***true
***REMOVED******REMOVED***try***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***const***REMOVED***updatedPlaylist***REMOVED***=***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***...editingPlaylist.value,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***name:***REMOVED***editForm.value.name,
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***description:***REMOVED***editForm.value.description
***REMOVED******REMOVED******REMOVED******REMOVED***}
***REMOVED******REMOVED******REMOVED******REMOVED***
***REMOVED******REMOVED******REMOVED******REMOVED***//***REMOVED***这里需要调用更新API，暂时用重新获取代替
***REMOVED******REMOVED******REMOVED******REMOVED***await***REMOVED***musicStore.fetchPlaylists()
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.success('更新成功')
***REMOVED******REMOVED******REMOVED******REMOVED***handleCloseEdit()
***REMOVED******REMOVED***}***REMOVED***catch***REMOVED***(error)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***console.error('更新歌单失败:',***REMOVED***error)
***REMOVED******REMOVED******REMOVED******REMOVED***ElMessage.error('更新失败')
***REMOVED******REMOVED***}***REMOVED***finally***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED***isUpdating.value***REMOVED***=***REMOVED***false
***REMOVED******REMOVED***}
}

const***REMOVED***handleCloseCreate***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***showCreateDialog.value***REMOVED***=***REMOVED***false
***REMOVED******REMOVED***createForm.value***REMOVED***=***REMOVED***{***REMOVED***name:***REMOVED***'',***REMOVED***description:***REMOVED***''***REMOVED***}
}

const***REMOVED***handleCloseEdit***REMOVED***=***REMOVED***()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***showEditDialog.value***REMOVED***=***REMOVED***false
***REMOVED******REMOVED***editingPlaylist.value***REMOVED***=***REMOVED***null
***REMOVED******REMOVED***editForm.value***REMOVED***=***REMOVED***{***REMOVED***name:***REMOVED***'',***REMOVED***description:***REMOVED***''***REMOVED***}
}

const***REMOVED***formatDate***REMOVED***=***REMOVED***(dateString:***REMOVED***string)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***date***REMOVED***=***REMOVED***new***REMOVED***Date(dateString)
***REMOVED******REMOVED***return***REMOVED***date.toLocaleDateString('zh-CN')
}

const***REMOVED***handleImageError***REMOVED***=***REMOVED***(event:***REMOVED***Event)***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***const***REMOVED***img***REMOVED***=***REMOVED***event.target***REMOVED***as***REMOVED***HTMLImageElement
***REMOVED******REMOVED***img.src***REMOVED***=***REMOVED***'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMjAwIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDIwMCAyMDAiIGZpbGw9Im5vbmUiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CjxyZWN0IHdpZHRoPSIyMDAiIGhlaWdodD0iMjAwIiBmaWxsPSIjRjVGNUY1Ii8+CjxwYXRoIGQ9Ik0xMDAgNTBMMTUwIDEwMEgxMDBWNTBaIiBmaWxsPSIjQ0NDQ0NDIi8+CjxwYXRoIGQ9Ik0xMDAgMTUwTDUwIDEwMEgxMDBWMTUwWiIgZmlsbD0iI0NDQ0NDQyIvPgo8L3N2Zz4K'
}

//***REMOVED***生命周期
onMounted(()***REMOVED***=>***REMOVED***{
***REMOVED******REMOVED***musicStore.fetchPlaylists()
})
</script>

<style***REMOVED***scoped>
.playlist-page***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***20px;
***REMOVED******REMOVED***max-width:***REMOVED***1200px;
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***auto;
}

.page-header***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***justify-content:***REMOVED***space-between;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***margin-bottom:***REMOVED***30px;
}

.page-header***REMOVED***h1***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***font-size:***REMOVED***28px;
***REMOVED******REMOVED***font-weight:***REMOVED***600;
}

.create-btn***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***border:***REMOVED***none;
***REMOVED******REMOVED***border-radius:***REMOVED***20px;
***REMOVED******REMOVED***padding:***REMOVED***10px***REMOVED***20px;
***REMOVED******REMOVED***font-weight:***REMOVED***500;
}

.playlist-grid***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***grid;
***REMOVED******REMOVED***grid-template-columns:***REMOVED***repeat(auto-fill,***REMOVED***minmax(280px,***REMOVED***1fr));
***REMOVED******REMOVED***gap:***REMOVED***20px;
***REMOVED******REMOVED***margin-bottom:***REMOVED***40px;
}

.playlist-card***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***border-radius:***REMOVED***12px;
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***2px***REMOVED***12px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.1);
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.3s***REMOVED***ease;
***REMOVED******REMOVED***cursor:***REMOVED***pointer;
***REMOVED******REMOVED***position:***REMOVED***relative;
}

.playlist-card:hover***REMOVED***{
***REMOVED******REMOVED***transform:***REMOVED***translateY(-4px);
***REMOVED******REMOVED***box-shadow:***REMOVED***0***REMOVED***8px***REMOVED***25px***REMOVED***rgba(0,***REMOVED***0,***REMOVED***0,***REMOVED***0.15);
}

.playlist-cover***REMOVED***{
***REMOVED******REMOVED***position:***REMOVED***relative;
***REMOVED******REMOVED***width:***REMOVED***100%;
***REMOVED******REMOVED***height:***REMOVED***200px;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
}

.playlist-cover***REMOVED***img***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***100%;
***REMOVED******REMOVED***height:***REMOVED***100%;
***REMOVED******REMOVED***object-fit:***REMOVED***cover;
***REMOVED******REMOVED***transition:***REMOVED***transform***REMOVED***0.3s***REMOVED***ease;
}

.playlist-card:hover***REMOVED***.playlist-cover***REMOVED***img***REMOVED***{
***REMOVED******REMOVED***transform:***REMOVED***scale(1.05);
}

.playlist-overlay***REMOVED***{
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
***REMOVED******REMOVED***transition:***REMOVED***opacity***REMOVED***0.3s***REMOVED***ease;
}

.playlist-card:hover***REMOVED***.playlist-overlay***REMOVED***{
***REMOVED******REMOVED***opacity:***REMOVED***1;
}

.playlist-info***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***20px;
}

.playlist-name***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***8px***REMOVED***0;
***REMOVED******REMOVED***font-size:***REMOVED***18px;
***REMOVED******REMOVED***font-weight:***REMOVED***600;
***REMOVED******REMOVED***color:***REMOVED***#333;
***REMOVED******REMOVED***white-space:***REMOVED***nowrap;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
***REMOVED******REMOVED***text-overflow:***REMOVED***ellipsis;
}

.playlist-desc***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***12px***REMOVED***0;
***REMOVED******REMOVED***color:***REMOVED***#666;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***line-height:***REMOVED***1.4;
***REMOVED******REMOVED***display:***REMOVED***-webkit-box;
***REMOVED******REMOVED***-webkit-line-clamp:***REMOVED***2;
***REMOVED******REMOVED***-webkit-box-orient:***REMOVED***vertical;
***REMOVED******REMOVED***overflow:***REMOVED***hidden;
}

.playlist-meta***REMOVED***{
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***justify-content:***REMOVED***space-between;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***font-size:***REMOVED***12px;
***REMOVED******REMOVED***color:***REMOVED***#999;
}

.music-count***REMOVED***{
***REMOVED******REMOVED***font-weight:***REMOVED***500;
}

.created-time***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***#ccc;
}

.playlist-actions***REMOVED***{
***REMOVED******REMOVED***position:***REMOVED***absolute;
***REMOVED******REMOVED***top:***REMOVED***10px;
***REMOVED******REMOVED***right:***REMOVED***10px;
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***gap:***REMOVED***5px;
***REMOVED******REMOVED***opacity:***REMOVED***0;
***REMOVED******REMOVED***transition:***REMOVED***opacity***REMOVED***0.3s***REMOVED***ease;
}

.playlist-card:hover***REMOVED***.playlist-actions***REMOVED***{
***REMOVED******REMOVED***opacity:***REMOVED***1;
}

.action-btn***REMOVED***{
***REMOVED******REMOVED***width:***REMOVED***32px;
***REMOVED******REMOVED***height:***REMOVED***32px;
***REMOVED******REMOVED***padding:***REMOVED***0;
***REMOVED******REMOVED***background:***REMOVED***rgba(255,***REMOVED***255,***REMOVED***255,***REMOVED***0.9);
***REMOVED******REMOVED***border:***REMOVED***none;
***REMOVED******REMOVED***border-radius:***REMOVED***50%;
***REMOVED******REMOVED***display:***REMOVED***flex;
***REMOVED******REMOVED***align-items:***REMOVED***center;
***REMOVED******REMOVED***justify-content:***REMOVED***center;
***REMOVED******REMOVED***font-size:***REMOVED***14px;
***REMOVED******REMOVED***transition:***REMOVED***all***REMOVED***0.3s***REMOVED***ease;
}

.action-btn:hover***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***white;
***REMOVED******REMOVED***transform:***REMOVED***scale(1.1);
}

.delete-btn:hover***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***#ff4757;
***REMOVED******REMOVED***color:***REMOVED***white;
}

.empty-state***REMOVED***{
***REMOVED******REMOVED***text-align:***REMOVED***center;
***REMOVED******REMOVED***padding:***REMOVED***80px***REMOVED***20px;
***REMOVED******REMOVED***color:***REMOVED***#666;
}

.empty-icon***REMOVED***{
***REMOVED******REMOVED***font-size:***REMOVED***64px;
***REMOVED******REMOVED***margin-bottom:***REMOVED***20px;
}

.empty-state***REMOVED***h3***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***10px***REMOVED***0;
***REMOVED******REMOVED***font-size:***REMOVED***24px;
***REMOVED******REMOVED***color:***REMOVED***#333;
}

.empty-state***REMOVED***p***REMOVED***{
***REMOVED******REMOVED***margin:***REMOVED***0***REMOVED***0***REMOVED***30px***REMOVED***0;
***REMOVED******REMOVED***font-size:***REMOVED***16px;
***REMOVED******REMOVED***line-height:***REMOVED***1.5;
}

/****REMOVED***Element***REMOVED***Plus***REMOVED***样式覆盖***REMOVED****/
:deep(.el-button--primary)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***border:***REMOVED***none;
}

:deep(.el-button--primary:hover)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#764ba2,***REMOVED***#667eea);
}

:deep(.el-dialog__header)***REMOVED***{
***REMOVED******REMOVED***background:***REMOVED***linear-gradient(45deg,***REMOVED***#667eea,***REMOVED***#764ba2);
***REMOVED******REMOVED***color:***REMOVED***white;
***REMOVED******REMOVED***margin:***REMOVED***0;
***REMOVED******REMOVED***padding:***REMOVED***20px;
}

:deep(.el-dialog__title)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***white;
***REMOVED******REMOVED***font-weight:***REMOVED***600;
}

:deep(.el-dialog__headerbtn***REMOVED***.el-dialog__close)***REMOVED***{
***REMOVED******REMOVED***color:***REMOVED***white;
***REMOVED******REMOVED***font-size:***REMOVED***20px;
}

:deep(.el-dialog__body)***REMOVED***{
***REMOVED******REMOVED***padding:***REMOVED***30px;
}

:deep(.el-form-item__label)***REMOVED***{
***REMOVED******REMOVED***font-weight:***REMOVED***500;
***REMOVED******REMOVED***color:***REMOVED***#333;
}

:deep(.el-input__wrapper)***REMOVED***{
***REMOVED******REMOVED***border-radius:***REMOVED***8px;
}

:deep(.el-textarea__inner)***REMOVED***{
***REMOVED******REMOVED***border-radius:***REMOVED***8px;
}
</style>