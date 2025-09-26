import { createRouter, createWebHistory } from 'vue-router'
import MainLayout from '@/layouts/MainLayout.vue'
import Home from '@/views/Home.vue'
import Search from '@/views/Search.vue'
import Discover from '@/views/Discover.vue'
import Playlist from '@/views/Playlist.vue'
import Rank from '@/views/Rank.vue'
import MyMusic from '@/views/MyMusic.vue'
import Favorites from '@/views/Favorites.vue'
import Recent from '@/views/Recent.vue'
import Profile from '@/views/Profile.vue'
import Login from '@/views/Login.vue'
import Register from '@/views/Register.vue'
import HotAll from '@/views/HotAll.vue'
// Player view (full-screen like detail)
// @ts-ignore
const Player = () => import('@/views/Player.vue')

const router = createRouter({
  history: createWebHistory(),
  routes: [
    // 认证相关路由（独立布局）
    {
      path: '/login',
      name: 'login',
      component: () => import('@/layouts/AuthLayout.vue'),
      children: [
        {
          path: '',
          component: Login
        }
      ]
    },
    // 播放器详情（独立顶级路由）
    {
      path: '/player',
      name: 'player',
      component: Player
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('@/layouts/AuthLayout.vue'),
      children: [
        {
          path: '',
          component: Register
        }
      ]
    },
    // 主应用路由（带完整布局）
    {
      path: '/',
      component: MainLayout,
      children: [
        {
          path: '',
          name: 'home',
          component: Home
        },
        {
          path: 'search',
          name: 'search',
          component: Search
        },
        {
          path: 'discover',
          name: 'discover',
          component: Discover
        },
        {
          path: 'playlist',
          name: 'playlist',
          component: Playlist
        },
        {
          path: 'playlist/:id',
          name: 'playlist-detail',
          component: Playlist
        },
        {
          path: 'rank',
          name: 'rank',
          component: Rank
        },
        {
          path: 'my-music',
          name: 'my-music',
          component: MyMusic
        },
        {
          path: 'favorites',
          name: 'favorites',
          component: Favorites
        },
        {
          path: 'recent',
          name: 'recent',
          component: Recent
        },
        {
          path: 'profile',
          name: 'profile',
          component: Profile
        },
        {
          path: 'hot',
          name: 'hot-all',
          component: HotAll
        }
      ]
    }
  ]
})

export default router