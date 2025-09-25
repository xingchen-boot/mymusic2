<template>
    <!-- 认证页面布局容器：包裹所有认证相关页面（如登录、注册） -->
    <div class="auth-layout">
      <!-- 路由出口：渲染当前匹配的认证页面组件 -->
      <router-view />
    </div>
  </template>
  
  <script setup lang="ts">
  /**
   * 认证页面布局组件
   * 功能：为所有认证相关页面（登录、注册等）提供统一的背景样式和布局容器
   * 特性：全屏渐变背景，确保子页面在统一视觉风格下展示
   */
  // 此处无需额外逻辑，仅作为布局容器承载路由内容
  </script>
  
  <style scoped>
  /* 认证布局容器样式：全屏高度 + 渐变背景 */
  .auth-layout {
    min-height: 100vh; /* 确保容器占满整个视口高度 */
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); /* 紫色系渐变背景，与播放器风格统一 */
    padding: 20px; /* 可选：添加内边距，避免子组件贴边 */
    box-sizing: border-box; /* 确保内边距不影响整体高度计算 */
  }
  </style>