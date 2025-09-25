import { defineStore } from 'pinia'
import { ref, computed } from 'vue'

export interface UserInfo {
  id: number
  username: string
  nickname: string
  avatar?: string
  createTime: string
}

export interface UserPlaylist {
  id: number
  userId: number
  name: string
  description?: string
  coverUrl?: string
  createTime: string
  updateTime: string
  status: number
  musicList?: PlaylistMusic[]
}

export interface PlaylistMusic {
  id?: number
  playlistId?: number
  musicId: string
  musicName: string
  artistName?: string
  albumName?: string
  duration?: number
  musicUrl?: string
  coverUrl?: string
  addTime?: string
  sortOrder?: number
}

export const useUserStore = defineStore('user', () => {
  // 状态
  const userInfo = ref<UserInfo | null>(null)
  const token = ref<string>('')
  const userPlaylists = ref<UserPlaylist[]>([])

  // 计算属性
  const isLoggedIn = computed(() => !!userInfo.value)
  const currentUser = computed(() => userInfo.value)

  // 登录
  const login = async (username: string, password: string): Promise<boolean> => {
    try {
      const response = await fetch('/api/user/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          username,
          password
        })
      })

      const result = await response.json()
      
      if (result.code === 200) {
        userInfo.value = result.data
        // 保存用户信息到localStorage
        localStorage.setItem('userInfo', JSON.stringify(result.data))
        // 登录成功后加载用户相关数据
        await loadUserPlaylists()
        await loadUserPlayQueue()
        await loadUserPlaySettings()
        return true
      } else {
        throw new Error(result.message || '登录失败')
      }
    } catch (error: any) {
      console.error('Login error:', error)
      throw error
    }
  }

  // 注册
  const register = async (username: string, password: string, nickname?: string): Promise<boolean> => {
    try {
      const response = await fetch('/api/user/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          username,
          password,
          nickname
        })
      })

      const result = await response.json()
      
      if (result.code === 200) {
        return true
      } else {
        throw new Error(result.message || '注册失败')
      }
    } catch (error: any) {
      console.error('Register error:', error)
      throw error
    }
  }

  // 登出
  const logout = () => {
    userInfo.value = null
    token.value = ''
    userPlaylists.value = []
    localStorage.removeItem('userInfo')
    localStorage.removeItem('token')
    localStorage.removeItem('userPlaylists')
  }

  // 初始化用户信息（从localStorage恢复）
  const initUserInfo = async () => {
    const savedUserInfo = localStorage.getItem('userInfo')
    if (savedUserInfo) {
      try {
        userInfo.value = JSON.parse(savedUserInfo)
        // 同时加载用户相关数据
        await loadUserPlaylists()
        await loadUserPlayQueue()
        await loadUserPlaySettings()
      } catch (error) {
        console.error('Failed to parse saved user info:', error)
        localStorage.removeItem('userInfo')
      }
    }
  }

  // 更新用户信息
  const updateUserInfo = async (nickname?: string, avatar?: string): Promise<boolean> => {
    if (!userInfo.value) {
      throw new Error('用户未登录')
    }

    try {
      const response = await fetch(`/api/user/info/${userInfo.value.id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          nickname,
          avatar
        })
      })

      const result = await response.json()

      if (result.code === 200) {
        // 更新本地用户信息
        if (userInfo.value) {
          if (nickname) userInfo.value.nickname = nickname
          if (avatar) userInfo.value.avatar = avatar
          localStorage.setItem('userInfo', JSON.stringify(userInfo.value))
        }
        return true
      } else {
        throw new Error(result.message || '更新失败')
      }
    } catch (error: any) {
      console.error('Update user info error:', error)
      throw error
    }
  }

  // 修改密码
  const changePassword = async (oldPassword: string, newPassword: string): Promise<boolean> => {
    if (!userInfo.value) {
      throw new Error('用户未登录')
    }

    try {
      const response = await fetch(`/api/user/password/${userInfo.value.id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          oldPassword,
          newPassword
        })
      })

      const result = await response.json()

      if (result.code === 200) {
        return true
      } else {
        throw new Error(result.message || '密码修改失败')
      }
    } catch (error: any) {
      console.error('Change password error:', error)
      throw error
    }
  }

  // 检查用户名是否存在
  const checkUsername = async (username: string): Promise<boolean> => {
    try {
      const response = await fetch(`/api/user/check-username?username=${encodeURIComponent(username)}`)
      const result = await response.json()

      if (result.code === 200) {
        return result.data.exists
      } else {
        throw new Error(result.message || '检查失败')
      }
    } catch (error: any) {
      console.error('Check username error:', error)
      throw error
    }
  }

  // 播放列表相关方法

  // 加载用户播放列表
  const loadUserPlaylists = async (): Promise<void> => {
    if (!userInfo.value) return

    try {
      const response = await fetch(`/api/user-playlist/user/${userInfo.value.id}`)
      const result = await response.json()

      if (result.code === 200) {
        userPlaylists.value = result.data
        localStorage.setItem('userPlaylists', JSON.stringify(result.data))
      }
    } catch (error) {
      console.error('Load user playlists error:', error)
    }
  }

  // 加载用户播放队列
  const loadUserPlayQueue = async (): Promise<void> => {
    if (!userInfo.value) return

    try {
      // 动态导入音乐store以避免循环依赖
      const { useMusicStore } = await import('./music')
      const musicStore = useMusicStore()
      await musicStore.loadPlayQueueFromDatabase()
    } catch (error) {
      console.error('Load user play queue error:', error)
    }
  }

  // 加载用户播放设置
  const loadUserPlaySettings = async (): Promise<void> => {
    if (!userInfo.value) return

    try {
      // 动态导入音乐store以避免循环依赖
      const { useMusicStore } = await import('./music')
      const musicStore = useMusicStore()
      await musicStore.loadPlaySettingsFromDatabase()
    } catch (error) {
      console.error('Load user play settings error:', error)
    }
  }

  // 创建播放列表
  const createPlaylist = async (name: string, description?: string): Promise<UserPlaylist|null> => {
    if (!userInfo.value) {
      throw new Error('用户未登录')
    }

    try {
      const response = await fetch('/api/user-playlist/create', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          userId: userInfo.value.id,
          name,
          description
        })
      })

      const result = await response.json()

      if (result.code === 200) {
        // 重新加载播放列表
        await loadUserPlaylists()
        return result.data
      } else {
        throw new Error(result.message || '创建失败')
      }
    } catch (error: any) {
      console.error('Create playlist error:', error)
      throw error
    }
  }

  // 添加音乐到播放列表
  const addMusicToPlaylist = async (playlistId: number, music: PlaylistMusic): Promise<boolean> => {
    try {
      const response = await fetch(`/api/user-playlist/${playlistId}/music`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(music)
      })

      const result = await response.json()

      if (result.code === 200) {
        // 重新加载播放列表
        await loadUserPlaylists()
        return true
      } else {
        throw new Error(result.message || '添加失败')
      }
    } catch (error: any) {
      console.error('Add music to playlist error:', error)
      throw error
    }
  }

  // 从播放列表移除音乐
  const removeMusicFromPlaylist = async (playlistId: number, musicId: string): Promise<boolean> => {
    try {
      const response = await fetch(`/api/user-playlist/${playlistId}/music/${musicId}`, {
        method: 'DELETE'
      })

      const result = await response.json()

      if (result.code === 200) {
        // 重新加载播放列表
        await loadUserPlaylists()
        return true
      } else {
        throw new Error(result.message || '移除失败')
      }
    } catch (error: any) {
      console.error('Remove music from playlist error:', error)
      throw error
    }
  }

  // 删除播放列表
  const deletePlaylist = async (playlistId: number): Promise<boolean> => {
    try {
      const response = await fetch(`/api/user-playlist/${playlistId}`, {
        method: 'DELETE'
      })

      const result = await response.json()

      if (result.code === 200) {
        // 重新加载播放列表
        await loadUserPlaylists()
        return true
      } else {
        throw new Error(result.message || '删除失败')
      }
    } catch (error: any) {
      console.error('Delete playlist error:', error)
      throw error
    }
  }

  return {
    // 状态
    userInfo,
    token,
    userPlaylists,

    // 计算属性
    isLoggedIn,
    currentUser,

    // 方法
    login,
    register,
    logout,
    initUserInfo,
    updateUserInfo,
    changePassword,
    checkUsername,

    // 播放列表方法
    loadUserPlaylists,
    createPlaylist,
    addMusicToPlaylist,
    removeMusicFromPlaylist,
    deletePlaylist,
    
    // 播放设置方法
    loadUserPlaySettings,
    
    // 播放队列方法
    loadUserPlayQueue
  }
})
