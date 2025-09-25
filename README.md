# MyMusic 全栈项目

一个包含前端（Vue 3 + Vite + Pinia + TypeScript + Element Plus）与后端（Spring Boot + Maven + MyBatis + MySQL）的音乐应用示例项目。

## 目录结构

```
mymusic/
  frontend/           # 前端代码（Vite 项目）
  springboot/         # 后端代码（Spring Boot）
  logs/               # 运行日志（已通过 .gitignore 忽略）
  .gitignore
  .gitattributes
```

## 环境要求

- Node.js ≥ 18（建议 18 LTS 或 20 LTS）
- npm ≥ 9（或使用 pnpm ≥ 8）
- JDK 17（建议 AdoptOpenJDK/Temurin 发行版）
- Maven ≥ 3.8
- MySQL ≥ 8（或兼容版本）

> Windows 用户请确保在「系统环境变量」中正确配置 `JAVA_HOME`、`MAVEN_HOME` 并把 `bin` 加入 `PATH`。

## 后端（Spring Boot）

1) 配置数据库

- 编辑 `springboot/src/main/resources/application.yml`，设置你的 MySQL 连接、用户名、密码。
- 初始化数据库：使用 `springboot/src/main/resources/sql/` 下的脚本创建表（如 `user.sql`、`playlist.sql` 等）。

2) 运行

```bash
# 进入后端目录
cd springboot

# 开发运行（跳过测试）
mvn -DskipTests spring-boot:run

# 或打包运行
mvn -DskipTests clean package
java -jar target/*.jar
```

默认端口通常为 `8080`。如需跨域，已在 `org/example/config/CorsConfig.java` 开启基本 CORS 配置。

## 前端（Vite + Vue 3）

1) 安装依赖

```bash
cd frontend

# 使用 npm（与本项目脚本兼容）
npm install

# 如遇 node_modules 损坏，可先删除后重装
# rmdir /s /q node_modules  (Windows CMD)
# rm -rf node_modules       (Git Bash/PowerShell)
```

2) 开发运行

```bash
npm run dev
```

Vite 默认使用 `3000` 端口，如被占用会自动改用下一个空闲端口（见终端输出）。

3) 构建与预览

```bash
npm run build
npm run preview
```

## 常见问题（FAQ）

- 端口占用（如 3000 或 8080）
  - Windows 查看端口占用：`netstat -ano | findstr :3000`
  - 结束进程：`taskkill /PID <PID> /F`

- Vite/依赖报错或 `'vite' 不是内部或外部命令`
  - 删除 `node_modules` 后重新 `npm install`
  - 确认本地 Node 版本满足要求

- Java `非法字符: '\ufeff'` 或语法紧凑导致的编译错误
  - 已清除 BOM 并修复大部分紧凑语法。如仍报错，请用 UTF-8 无 BOM 保存并检查是否存在被「挤在一起」的关键字/注解。

- Git 远程仓库 URL 变更
  - 查看：`git remote -v`
  - 修改：`git remote set-url origin <new-url>`
  - 若已存在同名远程且需保留历史：`git remote rename origin origin-old && git remote add origin <new-url>`

## 开发约定

- 代码风格：推荐使用 Prettier/ESLint（前端）与 IDE 的 Java 格式化（后端）。
- 提交前请确保无编译错误，避免提交 `node_modules/`、`dist/`、`target/`、`logs/`。

## 脚本速查

```bash
# 后端
cd springboot && mvn -DskipTests spring-boot:run

# 前端
cd frontend && npm run dev
```

## 许可证

本项目仅用作学习与演示用途。


