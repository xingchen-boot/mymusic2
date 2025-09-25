<template>
    <div class="song-detail" v-if="music">
      <div class="header">
        <img :src="music.cover" alt="cover" class="cover" />
        <div class="meta">
          <h1 class="title">{{ music.song }}</h1>
          <p class="artist">{{ music.singer }}</p>
          <p class="album" v-if="music.album">专辑：{{ music.album }}</p>
          <p class="duration" v-if="music.time">时长：{{ formatTime(music.time) }}</p>
          <div class="actions">
            <el-button type="primary" @click="togglePlay">
              {{ isPlayingCurrent ? '⏸️暂停' : '▶️播放' }}
            </el-button>
            <el-button @click="toggleFavorite">
              {{ isLiked ? '❤️已收藏' : '🤍收藏' }}
            </el-button>
            <el-button @click="addToQueue">➕加入队列</el-button>
            <el-button @click="download">⬇️下载</el-button>
          </div>
        </div>
      </div>
  
      <div class="info">
        <h2>歌曲信息</h2>
        <ul>
          <li><strong>MID：</strong>{{ music.mid || '-' }}</li>
          <li><strong>ID：</strong>{{ music.id || '-' }}</li>
        </ul>
      </div>
    </div>
    <div v-else class="empty">暂无歌曲信息</div>
  </template>
  
  <script setup lang="ts">
  import { computed } from 'vue'
  import { useRoute } from 'vue-router'
  import { useMusicStore } from '../stores/music'
  
  const route = useRoute()
  const musicStore = useMusicStore()
  
  // 当前播放的歌曲
  const current = computed(() => musicStore.currentMusic)
  
  // 优先通过路由参数查找歌曲，否则使用当前播放的歌曲
  const music = computed(() => {
    const mid = route.params.mid as string | undefined
    if (mid) {
      // 在播放队列中查找匹配的歌曲
      const inQueue = (musicStore as any).playQueue?.find((m: any) => m.mid === mid)
      if (inQueue) return inQueue
    }
    return current.value
  })
  
  // 判断当前歌曲是否正在播放
  const isPlayingCurrent = computed(() => {
    return music.value 
      && current.value 
      && (music.value as any).mid === (current.value as any).mid 
      && musicStore.isPlaying
  })
  
  // 判断当前歌曲是否已收藏
  const isLiked = computed(() => {
    if (!music.value) return false
    const same = current.value && (music.value as any).mid === (current.value as any).mid
    return same ? (musicStore as any).isCurrentMusicLiked : false
  })
  
  // 切换播放/暂停状态
  const togglePlay = async () => {
    if (!music.value) return
    if (isPlayingCurrent.value) {
      musicStore.togglePlay()
    } else {
      await musicStore.playMusic(music.value as any)
    }
  }
  
  // 切换收藏状态
  const toggleFavorite = async () => {
    if (!music.value) return
    const same = current.value && (music.value as any).mid === (current.value as any).mid
    if (!same) {
      await musicStore.playMusic(music.value as any)
    }
    await (musicStore as any).toggleFavorite()
  }
  
  // 将歌曲加入播放队列
  const addToQueue = async () => {
    if (!music.value) return
    await musicStore.addToPlayQueueWithSync(music.value as any)
  }
  
  // 下载歌曲
  const download = async () => {
    if (!music.value) return
    await musicStore.downloadMusic(music.value as any)
  }
  
  // 格式化时长（秒 -> MM:SS）
  const formatTime = (seconds: number) => {
    if (!seconds && seconds !== 0) return '-'
    const mins = Math.floor(seconds / 60)
    const secs = Math.floor(seconds % 60)
    return `${mins.toString().padStart(2, '0')}:${secs.toString().padStart(2, '0')}`
  }
  </script>
  
  <style scoped>
  .song-detail {
    max-width: 980px;
    margin: 24px auto;
    padding: 0 16px;
  }
  
  .header {
    display: flex;
    gap: 20px;
  }
  
  .cover {
    width: 220px;
    height: 220px;
    border-radius: 12px;
    object-fit: cover;
    box-shadow: 0 8px 24px rgba(0, 0, 0, .15);
  }
  
  .meta {
    flex: 1;
  }
  
  .title {
    margin: 8px 0 6px;
    font-size: 28px;
    font-weight: 700;
    color: #1f2328;
  }
  
  .artist, .album, .duration {
    margin: 4px 0;
    color: #6b7280;
  }
  
  .actions {
    margin-top: 14px;
    display: flex;
    gap: 10px;
  }
  
  .info {
    margin-top: 30px;
  }
  
  .info h2 {
    margin: 0 0 10px;
    font-size: 18px;
  }
  
  .empty {
    max-width: 980px;
    margin: 48px auto;
    text-align: center;
    color: #9aa5b1;
  }
  </style>
  