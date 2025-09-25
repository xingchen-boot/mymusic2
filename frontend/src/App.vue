<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script setup lang="ts">
// App.vue 现在只负责渲染路由视图
// 具体的布局由各个路由组件自己处理
</script>

<style>
#app {
  font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', '微软雅黑', Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin: 0;
  padding: 0;
}

* {
  box-sizing: border-box;
}

body {
  margin: 0;
  padding: 0;
  background: #f5f5f5;
  min-height: 100vh;
}
</style>
