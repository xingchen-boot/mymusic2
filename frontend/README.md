#***REMOVED***MyMusic***REMOVED***音乐播放器

一个功能完整的现代化音乐播放器，支持用户注册登录、音乐搜索播放、播放队列管理、个人收藏等功能。

##***REMOVED***🚀***REMOVED***快速开始

###***REMOVED***环境要求
-***REMOVED***Node.js***REMOVED***16+
-***REMOVED***Java***REMOVED***8+
-***REMOVED***MySQL***REMOVED***5.7+

###***REMOVED***安装依赖
```bash
cd***REMOVED***frontend
npm***REMOVED***install
```

###***REMOVED***启动开发服务器
```bash
npm***REMOVED***run***REMOVED***dev
```

###***REMOVED***构建生产版本
```bash
npm***REMOVED***run***REMOVED***build
```

##***REMOVED***📁***REMOVED***项目结构

```
mymusic/
├──***REMOVED***frontend/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***Vue3***REMOVED***前端项目
│***REMOVED******REMOVED******REMOVED***├──***REMOVED***src/
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***views/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***页面组件
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***Home.vue***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***首页
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***Search.vue***REMOVED******REMOVED******REMOVED***#***REMOVED***搜索页面
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***Favorites.vue***REMOVED***#***REMOVED***我的收藏
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***MyMusic.vue***REMOVED******REMOVED***#***REMOVED***我的音乐
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***Playlist.vue***REMOVED***#***REMOVED***播放列表
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***Discover.vue***REMOVED***#***REMOVED***发现音乐
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***Rank.vue***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***排行榜
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***Recent.vue***REMOVED******REMOVED******REMOVED***#***REMOVED***最近播放
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***Login.vue***REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***登录页面
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***└──***REMOVED***Register.vue***REMOVED***#***REMOVED***注册页面
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***components/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***公共组件
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***Header.vue***REMOVED******REMOVED******REMOVED***#***REMOVED***顶部导航
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***Footer.vue***REMOVED******REMOVED******REMOVED***#***REMOVED***底部播放器
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***Sidebar.vue***REMOVED******REMOVED***#***REMOVED***侧边栏
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***└──***REMOVED***Container.vue***REMOVED***#***REMOVED***容器组件
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***layouts/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***布局组件
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***MainLayout.vue***REMOVED***#***REMOVED***主布局
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***└──***REMOVED***AuthLayout.vue***REMOVED***#***REMOVED***认证布局
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***stores/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***Pinia状态管理
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***music.ts***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***音乐相关状态
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***└──***REMOVED***user.ts***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***用户相关状态
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***router/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***路由配置
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***└──***REMOVED***App.vue***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***根组件
│***REMOVED******REMOVED******REMOVED***└──***REMOVED***package.json
├──***REMOVED***springboot/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***Spring***REMOVED***Boot***REMOVED***后端项目
│***REMOVED******REMOVED******REMOVED***├──***REMOVED***src/main/java/org/example/
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***controller/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***控制器
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***service/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***服务层
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***mapper/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***数据访问层
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***├──***REMOVED***entity/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***实体类
│***REMOVED******REMOVED******REMOVED***│***REMOVED******REMOVED******REMOVED***└──***REMOVED***config/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***配置类
│***REMOVED******REMOVED******REMOVED***└──***REMOVED***src/main/resources/
│***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***├──***REMOVED***application.yml***REMOVED******REMOVED***#***REMOVED***应用配置
│***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***└──***REMOVED***sql/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***数据库脚本
└──***REMOVED***logs/***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***#***REMOVED***日志文件
```

##***REMOVED***🎵***REMOVED***功能特性

###***REMOVED***🔐***REMOVED***用户系统
-***REMOVED***✅***REMOVED***用户注册/登录
-***REMOVED***✅***REMOVED***用户信息管理
-***REMOVED***✅***REMOVED***登录状态持久化
-***REMOVED***✅***REMOVED***自动登录功能

###***REMOVED***🎶***REMOVED***音乐播放
-***REMOVED***✅***REMOVED***音乐搜索（支持歌名、歌手、专辑）
-***REMOVED***✅***REMOVED***音乐播放/暂停
-***REMOVED***✅***REMOVED***播放进度控制
-***REMOVED***✅***REMOVED***上一首/下一首
-***REMOVED***✅***REMOVED***播放模式切换（列表循环、单曲循环、随机播放）
-***REMOVED***✅***REMOVED***音量控制（静音/取消静音、音量调节）
-***REMOVED***✅***REMOVED***播放状态同步到数据库

###***REMOVED***📋***REMOVED***播放队列管理
-***REMOVED***✅***REMOVED***播放队列持久化存储
-***REMOVED***✅***REMOVED***添加/删除队列中的音乐
-***REMOVED***✅***REMOVED***队列重排序
-***REMOVED***✅***REMOVED***播放队列面板显示
-***REMOVED***✅***REMOVED***临时播放模式（播放我喜欢的）

###***REMOVED***❤️***REMOVED***收藏功能
-***REMOVED***✅***REMOVED***收藏/取消收藏音乐
-***REMOVED***✅***REMOVED***我的收藏页面
-***REMOVED***✅***REMOVED***收藏状态实时更新
-***REMOVED***✅***REMOVED***从收藏列表播放音乐

###***REMOVED***📱***REMOVED***用户界面
-***REMOVED***✅***REMOVED***现代化响应式设计
-***REMOVED***✅***REMOVED***深色主题支持
-***REMOVED***✅***REMOVED***移动端适配
-***REMOVED***✅***REMOVED***播放器控制面板
-***REMOVED***✅***REMOVED***音乐信息显示

###***REMOVED***💾***REMOVED***数据持久化
-***REMOVED***✅***REMOVED***播放队列数据库存储
-***REMOVED***✅***REMOVED***播放设置数据库存储
-***REMOVED***✅***REMOVED***收藏列表数据库存储
-***REMOVED***✅***REMOVED***用户播放历史记录

##***REMOVED***🔧***REMOVED***技术栈

###***REMOVED***前端
-***REMOVED*****Vue***REMOVED***3*****REMOVED***-***REMOVED***渐进式JavaScript框架
-***REMOVED*****TypeScript*****REMOVED***-***REMOVED***JavaScript的超集
-***REMOVED*****Element***REMOVED***Plus*****REMOVED***-***REMOVED***Vue***REMOVED***3组件库
-***REMOVED*****Pinia*****REMOVED***-***REMOVED***Vue状态管理
-***REMOVED*****Vite*****REMOVED***-***REMOVED***构建工具
-***REMOVED*****Vue***REMOVED***Router*****REMOVED***-***REMOVED***路由管理

###***REMOVED***后端
-***REMOVED*****Spring***REMOVED***Boot*****REMOVED***-***REMOVED***Java应用框架
-***REMOVED*****MyBatis*****REMOVED***-***REMOVED***数据持久化框架
-***REMOVED*****MySQL*****REMOVED***-***REMOVED***关系型数据库
-***REMOVED*****Maven*****REMOVED***-***REMOVED***项目构建工具

##***REMOVED***🌐***REMOVED***API集成

前端已配置代理，会自动将***REMOVED***`/api`***REMOVED***请求转发到后端服务器***REMOVED***`http://localhost:9092`

###***REMOVED***主要API端点
-***REMOVED***`POST***REMOVED***/api/user/register`***REMOVED***-***REMOVED***用户注册
-***REMOVED***`POST***REMOVED***/api/user/login`***REMOVED***-***REMOVED***用户登录
-***REMOVED***`GET***REMOVED***/api/music/search`***REMOVED***-***REMOVED***搜索音乐
-***REMOVED***`GET***REMOVED***/api/music/url`***REMOVED***-***REMOVED***获取音乐播放URL
-***REMOVED***`POST***REMOVED***/api/music/download`***REMOVED***-***REMOVED***下载音乐
-***REMOVED***`GET***REMOVED***/api/playlist/user/{userId}`***REMOVED***-***REMOVED***获取用户播放列表
-***REMOVED***`POST***REMOVED***/api/playlist/add`***REMOVED***-***REMOVED***添加音乐到播放列表
-***REMOVED***`DELETE***REMOVED***/api/playlist/remove`***REMOVED***-***REMOVED***从播放列表移除音乐
-***REMOVED***`GET***REMOVED***/api/favorites/user/{userId}`***REMOVED***-***REMOVED***获取用户收藏
-***REMOVED***`POST***REMOVED***/api/favorites/add`***REMOVED***-***REMOVED***添加收藏
-***REMOVED***`DELETE***REMOVED***/api/favorites/remove`***REMOVED***-***REMOVED***取消收藏

##***REMOVED***🗄️***REMOVED***数据库设计

###***REMOVED***主要数据表
-***REMOVED***`user`***REMOVED***-***REMOVED***用户表
-***REMOVED***`user_playlist`***REMOVED***-***REMOVED***用户播放列表
-***REMOVED***`playlist_music`***REMOVED***-***REMOVED***播放列表音乐关联
-***REMOVED***`user_play_queue`***REMOVED***-***REMOVED***用户播放队列
-***REMOVED***`user_play_settings`***REMOVED***-***REMOVED***用户播放设置
-***REMOVED***`user_favorites`***REMOVED***-***REMOVED***用户收藏

##***REMOVED***🚀***REMOVED***部署说明

###***REMOVED***后端部署
1.***REMOVED***确保MySQL服务运行
2.***REMOVED***执行数据库脚本（在***REMOVED***`springboot/src/main/resources/sql/`***REMOVED***目录下）
3.***REMOVED***修改***REMOVED***`application.yml`***REMOVED***中的数据库配置
4.***REMOVED***运行***REMOVED***`mvn***REMOVED***spring-boot:run`

###***REMOVED***前端部署
1.***REMOVED***执行***REMOVED***`npm***REMOVED***run***REMOVED***build`
2.***REMOVED***将***REMOVED***`dist`***REMOVED***目录部署到Web服务器

##***REMOVED***📱***REMOVED***响应式设计

支持桌面端和移动端，自适应不同屏幕尺寸：
-***REMOVED***桌面端：完整功能展示
-***REMOVED***平板端：适配中等屏幕
-***REMOVED***移动端：优化触摸操作

##***REMOVED***🔄***REMOVED***状态管理

使用Pinia进行状态管理：
-***REMOVED***`useUserStore`***REMOVED***-***REMOVED***用户登录状态、用户信息
-***REMOVED***`useMusicStore`***REMOVED***-***REMOVED***音乐播放状态、播放队列、播放设置

##***REMOVED***🎯***REMOVED***核心功能实现

###***REMOVED***播放队列持久化
-***REMOVED***播放队列数据自动同步到数据库
-***REMOVED***页面刷新后自动恢复播放状态
-***REMOVED***支持跨设备同步（同一用户）

###***REMOVED***临时播放模式
-***REMOVED***切换到"播放我喜欢的"时，临时替换播放队列
-***REMOVED***原始播放队列保存在内存中
-***REMOVED***切换回来时自动恢复原始队列

###***REMOVED***实时状态同步
-***REMOVED***播放进度实时同步到数据库
-***REMOVED***收藏状态实时更新
-***REMOVED***播放设置自动保存

##***REMOVED***📝***REMOVED***开发日志

-***REMOVED***✅***REMOVED***基础音乐播放功能
-***REMOVED***✅***REMOVED***用户注册登录系统
-***REMOVED***✅***REMOVED***播放队列管理
-***REMOVED***✅***REMOVED***收藏功能
-***REMOVED***✅***REMOVED***播放设置持久化
-***REMOVED***✅***REMOVED***临时播放模式
-***REMOVED***✅***REMOVED***响应式UI优化

##***REMOVED***🤝***REMOVED***贡献指南

1.***REMOVED***Fork***REMOVED***项目
2.***REMOVED***创建功能分支
3.***REMOVED***提交更改
4.***REMOVED***推送到分支
5.***REMOVED***创建***REMOVED***Pull***REMOVED***Request

##***REMOVED***📄***REMOVED***许可证

MIT***REMOVED***License