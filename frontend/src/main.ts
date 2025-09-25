import { createApp } from 'vue'
import { createPinia } from 'pinia'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import router from './router'
import App from './App.vue'
import './style.css'
import { useMusicStore } from './stores/music'
import { useUserStore } from './stores/user'

const app = createApp(App)

// 注册Element Plus图标
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

const pinia = createPinia()
app.use(pinia)
app.use(router)
app.use(ElementPlus)

app.mount('#app')

// 全局唯一初始化播放器与用户数据
const musicStore = useMusicStore(pinia)
const userStore = useUserStore(pinia)
musicStore.initAudio()
userStore.initUserInfo()
