<template>
    <div class="home">
      <!-- 欢迎区域 -->
      <div class="welcome-section">
        <el-carousel height="400px" :interval="4000" arrow="always" indicator-position="outside">
          <el-carousel-item v-for="(banner, idx) in banners" :key="idx">
            <a :href="banner.link || 'javascript:void(0)'" class="banner-link" @click.prevent="onBannerClick(banner)">
              <img class="banner-img" :src="banner.image" :alt="banner.title || 'banner'" />
            </a>
          </el-carousel-item>
        </el-carousel>
      </div>
  
      <!-- 推荐内容 -->
      <div class="recommendations">
        <div class="section">
          <div class="hot-header">
            <h2 class="section-title">热门推荐</h2>
            <a class="view-all" href="/hot">查看全部</a>
          </div>
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
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, computed, onMounted } from 'vue'
  import { useMusicStore } from '@/stores/music'
  import bannerImg1 from '@/img/image.png'
  import bannerImg2 from '@/img/AWlCeMpJJ2.jpg'
  import bannerImg3 from '@/img/6f6a026fcaeb5e673c9cef5b28d63cc1ed9be178.jpg'
  
  const musicStore = useMusicStore()
  
  const banners = ref([
    { image: bannerImg1, title: 'Banner 1', link: '' },
    { image: bannerImg2, title: 'Banner 2', link: '' },
    { image: bannerImg3, title: 'Banner 3', link: '' }
  ])

  const onBannerClick = (banner: any) => {
    // 可根据需要跳转或触发播放等动作
  }

  const hotMusic = ref<any[]>([])

  onMounted(async () => {
    try {
      const resp = await fetch('/api/music/hot?limit=20')
      const result = await resp.json()
      if (result && result.code === 200) {
        hotMusic.value = result.data || []
      }
    } catch (e) {
      console.error('加载热门推荐失败', e)
    }
  })
  
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
  
  /* 移动端主页面优化 */
  @media (max-width: 768px) {
    .home {
      padding: 16px;
    }
    
    .section-title {
      font-size: 1.25rem;
    }
    
    .view-all {
      font-size: 13px;
    }
  }
  
  .welcome-section {
    /* margin-bottom: 24px; */
  }
  
  /* 移动端轮播图优化 */
  @media (max-width: 768px) {
    .welcome-section {
      margin-bottom: 16px;
    }
    
    .banner-img {
      border-radius: 8px;
    }
  }

  .banner-link { display: block; width: 100%; height: 100%; }
  .banner-img {
    width: 100%; height: 100%; object-fit: cover; border-radius: 12px;
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
    background: transparent;
    border-radius: 6px;
    padding: 0;
    box-shadow: none;
  }
  
  .hot-header { display: flex; align-items: center; justify-content: space-between; margin-bottom: 16px; }
  .view-all { font-size: 14px; color: #666; text-decoration: none; }
  .view-all:hover { color: #000; }
  .section-title {
    font-size: 1.5rem;
    font-weight: 600;
    margin: 0;
    color: #333;
  }
  
  .music-grid {
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    gap: 20px;
  }
  
  /* 移动端网格优化 */
  @media (max-width: 1024px) {
    .music-grid {
      grid-template-columns: repeat(4, 1fr);
      gap: 16px;
    }
  }
  
  @media (max-width: 768px) {
    .music-grid {
      grid-template-columns: repeat(3, 1fr);
      gap: 12px;
    }
  }
  
  @media (max-width: 480px) {
    .music-grid {
      grid-template-columns: repeat(2, 1fr);
      gap: 10px;
    }
  }
  
  .music-card {
    position: relative;
    background: transparent;
    border-radius: 0;
    padding: 0;
    cursor: pointer;
    transition: none;
    overflow: hidden;
    border: none;
    box-shadow: none !important;
  }
  
  /* 移动端音乐卡片优化 */
  @media (max-width: 768px) {
    .music-card {
      border-radius: 8px;
      background: white;
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1) !important;
      transition: all 0.3s ease;
    }
    
    .music-card:hover {
      transform: translateY(-2px);
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15) !important;
    }
  }
  
  .music-card:hover { transform: none; box-shadow: none; }
  
  .music-card:hover .play-overlay { opacity: 1; }
  
  .music-cover {
    width: 100%;
    /* 让封面完整显示，保持比例裁剪为方形 */
    aspect-ratio: 1 / 1;
    height: auto;
    border-radius: 6px;
    object-fit: cover;
    margin-bottom: 0;
    border: none;
    box-shadow: none !important;
  }
  
  .music-info {
    text-align: center;
    margin-top: 8px;
  }
  
  /* 移动端音乐信息优化 */
  @media (max-width: 768px) {
    .music-info {
      padding: 8px;
      margin-top: 0;
    }
    
    .music-title {
      font-size: 14px;
      margin-bottom: 4px;
    }
    
    .music-artist {
      font-size: 12px;
    }
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
  
  .play-overlay { display: none; }
  
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
  