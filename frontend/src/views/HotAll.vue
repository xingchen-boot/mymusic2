<template>
  <div class="hot-all">
    <div class="header">
      <h1>热门音乐</h1>
    </div>
    <div class="music-grid">
      <div v-for="music in list" :key="music.id" class="music-card" @click="play(music)">
        <img class="music-cover" :src="music.cover" :alt="music.song" />
        <div class="music-info">
          <div class="title">{{ music.song }}</div>
          <div class="artist">{{ music.singer }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useMusicStore } from '@/stores/music'

const list = ref<any[]>([])
const musicStore = useMusicStore()

const play = (m: any) => musicStore.playMusic(m)

onMounted(async () => {
  try {
    const resp = await fetch('/api/music/hot?limit=100')
    const result = await resp.json()
    if (result && result.code === 200) list.value = result.data || []
  } catch (e) {
    console.error('加载全部热门失败', e)
  }
})
</script>

<style scoped>
.hot-all { padding: 20px; }
.header { display: flex; align-items: center; justify-content: space-between; margin-bottom: 16px; }
.music-grid { display: grid; grid-template-columns: repeat(5, 1fr); gap: 16px; }
.music-card { cursor: pointer; }
.music-cover { width: 100%; aspect-ratio: 1/1; height: auto; border-radius: 6px; object-fit: cover; }
.music-info { margin-top: 6px; text-align: center; }
.title { font-weight: 600; font-size: 14px; }
.artist { color: #666; font-size: 12px; }
@media (max-width: 768px) { .music-grid { grid-template-columns: repeat(3, 1fr); } }
</style>


