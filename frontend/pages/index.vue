<template>
  <div class="root">
    <!-- 游戏列表区域 -->
    <div class="game-list">
      <!-- 遍历游戏列表生成游戏卡片 -->
      <a
        class="game-card"
        v-for="game in games"
        :href="`/game/${game.name}`"
        :key="game.name"
      >
        <p>{{ game.name }}</p>
      </a>
    </div>

    <!-- 底部导航栏 -->
    <div class="bottom-bar">
      <!-- 这里假设已全局导入 FontAwesomeIcon 组件 -->
      <font-awesome-icon style="color: blue" :icon="['fa', 'user-secret']" />
      <p>游戏</p>
      <p>创意工坊</p>
      <p>我的</p>
    </div>
  </div>
</template>

<script setup>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faUserSecret } from '@fortawesome/free-solid-svg-icons';

// 将 FontAwesome 图标添加到库中
library.add(faUserSecret);

// 定义游戏列表
const games = [
  { name: "谁是卧底" },
  ...Array(30).fill({ name: "狼人杀" })
];
</script>

<style scoped>
.root {
  width: 100vw;
  height: 100vh;
  display: flex;
  flex-direction: column;
  background-color: #f4f4f4; /* 页面背景色 */
}

.game-list {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
  justify-content: space-evenly;
  overflow-x: hidden;
  overflow-y: scroll;
  flex-grow: 1;
  padding: 1rem; /* 增加内边距 */
}

.game-card {
  width: 10rem;
  height: 10rem;
  font-weight: bold;
  font-size: x-large;
  text-decoration: none;
  color: #333; /* 文字颜色 */
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  border: 0.1rem solid #ccc; /* 边框颜色 */
  border-radius: 1rem;
  margin: 1rem;
  padding: 0.5rem 1rem;
  background-color: #fff; /* 卡片背景色 */
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 卡片阴影 */
  transition: all 0.3s ease; /* 过渡效果 */
}

.game-card:hover {
  transform: translateY(-5px); /* 悬停时向上移动 */
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* 悬停时阴影加深 */
  background-color: #e9f7ff; /* 悬停时背景色变化 */
}

.bottom-bar {
  flex-grow: 0;
  flex-shrink: 0;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
  padding: 0.5rem 1rem;
  border-top: 0.1rem solid #ccc; /* 顶部边框颜色 */
  background-color: #fff; /* 底部导航栏背景色 */
  box-shadow: 0 -4px 8px rgba(0, 0, 0, 0.1); /* 底部导航栏阴影 */
}

.bottom-bar p {
  margin: 0;
  color: #333; /* 底部导航栏文字颜色 */
  cursor: pointer; /* 鼠标指针样式 */
  transition: color 0.3s ease; /* 文字颜色过渡效果 */
}

.bottom-bar p:hover {
  color: blue; /* 悬停时文字颜色变化 */
}
</style>    