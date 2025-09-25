<template>
    <div class="home">
      <!-- 欢迎区域 -->
      <div class="welcome-section">
        <h1 class="welcome-title">🎵 欢迎来到 MyMusic</h1>
        <p class="welcome-subtitle">发现好音乐，享受美好时光</p>
      </div>
  
      <!-- 推荐内容 -->
      <div class="recommendations">
        <div class="section">
          <h2 class="section-title">🔥 热门推荐</h2>
          <div class="music-grid">
            <div
              v-for="music in hotMusic"
              :key="music.id"
              class="music-card"
              @click="handlePlayMusic(music)"
            >
              <img :src="music.cover" :alt="music.song" class="music-cover" />
              <div class="music-info">
                <h3 class="music-title">{{ music.song }}</h3>
                <p class="music-artist">{{ music.singer }}</p>
              </div>
              <div class="play-overlay">
                <el-button
                  type="primary"
                  circle
                  @click.stop="handlePlayMusic(music)"
                >
                  {{ currentMusic?.id === music.id && isPlaying ? '⏸️' : '▶️' }}
                </el-button>
              </div>
            </div>
          </div>
        </div>
  
        <div class="section">
          <h2 class="section-title">🎶 最新音乐</h2>
          <div class="music-grid">
            <div
              v-for="music in newMusic"
              :key="music.id"
              class="music-card"
              @click="handlePlayMusic(music)"
            >
              <img :src="music.cover" :alt="music.song" class="music-cover" />
              <div class="music-info">
                <h3 class="music-title">{{ music.song }}</h3>
                <p class="music-artist">{{ music.singer }}</p>
              </div>
              <div class="play-overlay">
                <el-button
                  type="primary"
                  circle
                  @click.stop="handlePlayMusic(music)"
                >
                  {{ currentMusic?.id === music.id && isPlaying ? '⏸️' : '▶️' }}
                </el-button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, computed } from 'vue'
  import { useMusicStore } from '@/stores/music'
  
  const musicStore = useMusicStore()
  
  // 模拟数据
  const hotMusic = ref([
    {
      id: 1,
      song: '青花瓷',
      singer: '周杰伦',
      cover: 'https://picsum.photos/200/200?random=1'
    },
    {
      id: 2,
      song: '稻香',
      singer: '周杰伦',
      cover: 'https://picsum.photos/200/200?random=2'
    },
    {
      id: 3,
      song: '夜曲',
      singer: '周杰伦',
      cover: 'https://picsum.photos/200/200?random=3'
    },
    {
      id: 4,
      song: '晴天',
      singer: '周杰伦',
      cover: 'https://picsum.photos/200/200?random=4'
    }
  ])
  
  const newMusic = ref([
    {
      id: 5,
      song: '告白气球',
      singer: '周杰伦',
      cover: 'https://picsum.photos/200/200?random=5'
    },
    {
      id: 6,
      song: '等你下课',
      singer: '周杰伦',
      cover: 'https://picsum.photos/200/200?random=6'
    },
    {
      id: 7,
      song: '说好不哭',
      singer: '周杰伦',
      cover: 'https://picsum.photos/200/200?random=7'
    },
    {
      id: 8,
      song: 'Mojito',
      singer: '周杰伦',
      cover: 'https://picsum.photos/200/200?random=8'
    }
  ])
  
  // 计算属性
  const currentMusic = computed(() => musicStore.currentMusic)
  const isPlaying = computed(() => musicStore.isPlaying)
  
  // 方法
  const handlePlayMusic = (music: any) => {
    musicStore.playMusic(music)
  }
  </script>
  
  <style scoped>
  .home {
    padding: 20px;
  }
  
  .welcome-section {
    text-align: center;
    padding: 40px 0;
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    border-radius: 12px;
    margin-bottom: 30px;
    color: white;
  }
  
  .welcome-title {
    font-size: 2.5rem;
    font-weight: 700;
    margin: 0 0 10px 0;
  }
  
  .welcome-subtitle {
    font-size: 1.2rem;
    margin: 0;
    opacity: 0.9;
  }
  
  .recommendations {
    display: flex;
    flex-direction: column;
    gap: 30px;
  }
  
  .section {
    background: white;
    border-radius: 12px;
    padding: 20px;
    box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
  }
  
  .section-title {
    font-size: 1.5rem;
    font-weight: 600;
    margin: 0 0 20px 0;
    color: #333;
  }
  
  .music-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
    gap: 20px;
  }
  
  .music-card {
    position: relative;
    background: #f8f9fa;
    border-radius: 12px;
    padding: 15px;
    cursor: pointer;
    transition: all 0.3s ease;
    overflow: hidden;
  }
  
  .music-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 8px 25px rgba(0, 0, 0, 0.15);
  }
  
  .music-card:hover .play-overlay {
    opacity: 1;
  }
  
  .music-cover {
    width: 100%;
    height: 150px;
    border-radius: 8px;
    object-fit: cover;
    margin-bottom: 12px;
  }
  
  .music-info {
    text-align: center;
  }
  
  .music-title {
    font-size: 16px;
    font-weight: 600;
    margin: 0 0 5px 0;
    color: #333;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  .music-artist {
    font-size: 14px;
    color: #666;
    margin: 0;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  
  .play-overlay {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    opacity: 0;
    transition: all 0.3s ease;
    background: rgba(0, 0, 0, 0.7);
    border-radius: 50%;
    padding: 10px;
  }
  
  /* Element Plus样式覆盖 */
  :deep(.el-button--primary) {
    background: linear-gradient(45deg, #667eea, #764ba2);
    border: none;
  }
  
  :deep(.el-button--primary:hover) {
    background: linear-gradient(45deg, #764ba2, #667eea);
  }
  
  /* 响应式设计 */
  @media (max-width: 768px) {
    .music-grid {
      grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
      gap: 15px;
    }
  
    .welcome-title {
      font-size: 2rem;
    }
  
    .welcome-subtitle {
      font-size: 1rem;
    }
  }
  </style>
  