<template>
  <div class="container">
    <router-view />
  </div>
</template>

<script setup lang="ts">
// Container组件作为路由视图的容器
</script>

<style scoped>
.container {
  width: 100%;
  min-height: calc(100vh - 140px); /* 减去header和footer的高度 */
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}
</style>
