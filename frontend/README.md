#MyMusic音乐播放器

一个功能完整的现代化音乐播放器，支持用户注册登录、音乐搜索播放、播放队列管理、个人收藏、最近播放等功能。

##🚀快速开始

###环境要求
-Node.js16+
-Java8+
-MySQL5.7+

###安装依赖
```bash
cdfrontend
npminstall
```

###启动开发服务器
```bash
npmrundev
```

###构建生产版本
```bash
npmrunbuild
```

##📁项目结构

```
mymusic/
├──frontend/#Vue3前端项目
│├──src/
││├──views/#页面组件
│││├──Home.vue#首页
│││├──Search.vue#搜索页面
│││├──Favorites.vue#我的收藏
│││├──MyMusic.vue#我的音乐
│││├──Playlist.vue#播放列表
│││├──Discover.vue#发现音乐
│││├──Rank.vue#排行榜
│││├──Recent.vue#最近播放
│││├──Login.vue#登录页面
│││└──Register.vue#注册页面
││├──components/#公共组件
│││├──Header.vue#顶部导航
│││├──Footer.vue#底部播放器
│││├──Sidebar.vue#侧边栏
│││└──Container.vue#容器组件
││├──layouts/#布局组件
│││├──MainLayout.vue#主布局
│││└──AuthLayout.vue#认证布局
││├──stores/#Pinia状态管理
│││├──music.ts#音乐相关状态
│││└──user.ts#用户相关状态
││├──router/#路由配置
││└──App.vue#根组件
│└──package.json
├──springboot/#SpringBoot后端项目
│├──src/main/java/org/example/
││├──controller/#控制器
││├──service/#服务层
││├──mapper/#数据访问层
││├──entity/#实体类
││└──config/#配置类
│└──src/main/resources/
│├──application.yml#应用配置
│└──sql/#数据库脚本
└──logs/#日志文件
```

##🎵功能特性

###🔐用户系统
-✅用户注册/登录
-✅用户信息管理
-✅登录状态持久化
-✅自动登录功能

###👤个人中心（Profile）
-✅头像悬停展开菜单（Header）支持进入个人中心
-✅个人中心页面可独立修改昵称或头像（无需同时修改）
-✅头像上传走后端代理上传OSS，保存URL到数据库
-✅未设置头像时使用随机头像（`https://picsum.photos/...`）
-✅本地localStorage同步，刷新后立即显示头像与昵称

###🎶音乐播放
-✅音乐搜索（支持歌名、歌手、专辑）
-✅音乐播放/暂停
-✅播放进度控制
-✅上一首/下一首
-✅播放模式切换（列表循环、单曲循环、随机播放）
-✅音量控制（静音/取消静音、音量调节）
-✅播放状态同步到数据库

###📋播放队列管理
-✅播放队列持久化存储
-✅添加/删除队列中的音乐
-✅队列重排序
-✅播放队列面板显示
-✅临时播放模式（播放我喜欢的）

###❤️收藏功能
-✅收藏/取消收藏音乐
-✅我的收藏页面
-✅收藏状态实时更新
-✅从收藏列表播放音乐

###📱用户界面
-✅现代化响应式设计
-✅深色主题支持
-✅移动端适配
-✅播放器控制面板
-✅音乐信息显示
-✅个人中心资料卡片化布局、圆形头像预览

###💾数据持久化
-✅播放队列数据库存储
-✅播放设置数据库存储
-✅收藏列表数据库存储
-✅用户播放历史记录（最近播放）

##🔧技术栈

###前端
-**Vue3**-渐进式JavaScript框架
-**TypeScript**-JavaScript的超集
-**ElementPlus**-Vue3组件库
-**Pinia**-Vue状态管理
-**Vite**-构建工具
-**VueRouter**-路由管理

###后端
-**SpringBoot**-Java应用框架
-**MyBatis**-数据持久化框架
-**MySQL**-关系型数据库
-**Maven**-项目构建工具

##🌐API集成

前端已配置代理，会自动将`/api`请求转发到后端服务器`http://localhost:9092`

###主要API端点
-`POST/api/user/register`-用户注册
-`POST/api/user/login`-用户登录
-`PUT/api/user/info/{id}`-更新用户信息（昵称/头像，任意字段可选）
-`GET/api/music/search`-搜索音乐
-`GET/api/music/url`-获取音乐播放URL
-`POST/api/music/download`-下载音乐
-`GET/api/playlist/user/{userId}`-获取用户播放列表
-`POST/api/playlist/add`-添加音乐到播放列表
-`DELETE/api/playlist/remove`-从播放列表移除音乐
-`GET/api/favorites/user/{userId}`-获取用户收藏
-`POST/api/favorites/add`-添加收藏
-`DELETE/api/favorites/remove`-取消收藏
-`POST/api/oss/upload`-后端代理上传头像到OSS，返回公开URL
-`GET/api/oss/policy`-获取临时上传策略（如需直传）

##🗄️数据库设计

###主要数据表
-`user`-用户表
-`user_playlist`-用户播放列表
-`playlist_music`-播放列表音乐关联
-`user_play_queue`-用户播放队列
-`user_play_settings`-用户播放设置
-`user_favorites`-用户收藏

##🚀部署说明

###后端部署
1.确保MySQL服务运行
2.执行数据库脚本（在`springboot/src/main/resources/sql/`目录下）
3.修改`application.yml`中的数据库配置
4.运行`mvnspring-boot:run`

####OSS（头像上传）配置
1.在`springboot/src/main/resources/application.yml`设置：
-`oss.bucket`:你的OSS桶名（如`my-music-avatar`）
-`oss.region`:地域（如`oss-cn-beijing`）
-`oss.endpoint`:`https://<region>.aliyuncs.com`
2.通过环境变量提供密钥（不要写死在仓库）：
-WindowsCMD:`setOSS_ACCESS_KEY_ID=...`，`setOSS_ACCESS_KEY_SECRET=...`
3.OSS桶需设置：公共读、允许CORS（GET/POST/PUT，允许头*，暴露ETag）

###前端部署
1.执行`npmrunbuild`
2.将`dist`目录部署到Web服务器

##📱响应式设计

支持桌面端和移动端，自适应不同屏幕尺寸：
-桌面端：完整功能展示
-平板端：适配中等屏幕
-移动端：优化触摸操作

##🔄状态管理

使用Pinia进行状态管理：
-`useUserStore`-用户登录状态、用户信息
-`useMusicStore`-音乐播放状态、播放队列、播放设置

##🎯核心功能实现

###播放队列持久化
-播放队列数据自动同步到数据库
-页面刷新后自动恢复播放状态
-支持跨设备同步（同一用户）

###临时播放模式
-切换到"播放我喜欢的"时，临时替换播放队列
-原始播放队列保存在内存中
-切换回来时自动恢复原始队列

###实时状态同步
-播放进度实时同步到数据库
-收藏状态实时更新
-播放设置自动保存

###最近播放（New）
-后端表：`user_recent_play`，按`play_time`倒序，保留最新100条
-接口：
-`POST/api/recent-play/record`记录播放
-`PUT/api/recent-play/progress`更新进度
-`GET/api/recent-play/user/{userId}`拉取最近播放
-`DELETE/api/recent-play/user/{userId}/music/{musicId}`移除单条
-`DELETE/api/recent-play/user/{userId}/clear`清空
-前端：
-`music.ts`在`playMusic`成功后调用`recordRecentPlay`
-`syncPlayProgressToDatabase`成功后调用`updateRecentPlayProgress`
-通过`addRecentPlayListener/removeRecentPlayListener`事件总线，`Recent.vue`增量更新列表（插入/上移当前项），避免整页刷新

###个人中心与头像上传（New）
-前端：
-Header头像悬停展示下拉菜单，进入`/profile`
-`Profile.vue`支持独立修改昵称或头像；`canSave`仅依据字段是否变更
-头像选择后本地预览，限制≤2MB；压缩时保持原始宽高比（最长边200px）
-提交时：若头像有变更→先上传到OSS（后端代理），拿到URL后与昵称变更一起`PUT/api/user/info/{id}`
-保存成功后同步`userStore.currentUser`并写入`localStorage('userInfo')`
-后端：
-`PUT/api/user/info/{id}`使用`COALESCE`仅更新传入字段
-`/api/oss/upload`接收Multipart，上传到OSS并返回URL

说明：未设置自定义头像时，前端使用随机头像URL（`picsum.photos`）。

##📝开发日志

-✅基础音乐播放功能
-✅用户注册登录系统
-✅播放队列管理
-✅收藏功能
-✅播放设置持久化
-✅临时播放模式
-✅响应式UI优化
-✅个人中心与头像上传（独立修改、比例修复、OSS代理上传）

##🤝贡献指南

1.Fork项目
2.创建功能分支
3.提交更改
4.推送到分支
5.创建PullRequest

##📄许可证

MITLicense