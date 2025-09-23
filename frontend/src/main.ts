import***REMOVED***{***REMOVED***createApp***REMOVED***}***REMOVED***from***REMOVED***'vue'
import***REMOVED***{***REMOVED***createPinia***REMOVED***}***REMOVED***from***REMOVED***'pinia'
import***REMOVED***ElementPlus***REMOVED***from***REMOVED***'element-plus'
import***REMOVED***'element-plus/dist/index.css'
import***REMOVED*******REMOVED***as***REMOVED***ElementPlusIconsVue***REMOVED***from***REMOVED***'@element-plus/icons-vue'
import***REMOVED***router***REMOVED***from***REMOVED***'./router'
import***REMOVED***App***REMOVED***from***REMOVED***'./App.vue'
import***REMOVED***'./style.css'
import***REMOVED***{***REMOVED***useMusicStore***REMOVED***}***REMOVED***from***REMOVED***'./stores/music'
import***REMOVED***{***REMOVED***useUserStore***REMOVED***}***REMOVED***from***REMOVED***'./stores/user'

const***REMOVED***app***REMOVED***=***REMOVED***createApp(App)

//***REMOVED***注册Element***REMOVED***Plus图标
for***REMOVED***(const***REMOVED***[key,***REMOVED***component]***REMOVED***of***REMOVED***Object.entries(ElementPlusIconsVue))***REMOVED***{
***REMOVED******REMOVED***app.component(key,***REMOVED***component)
}

const***REMOVED***pinia***REMOVED***=***REMOVED***createPinia()
app.use(pinia)
app.use(router)
app.use(ElementPlus)

app.mount('#app')

//***REMOVED***全局唯一初始化播放器与用户数据
const***REMOVED***musicStore***REMOVED***=***REMOVED***useMusicStore(pinia)
const***REMOVED***userStore***REMOVED***=***REMOVED***useUserStore(pinia)
musicStore.initAudio()
userStore.initUserInfo()
