<template>
  <div class="root">
    <!-- 轮播图容器 -->
    <div class="carousel-container">
      <div
        class="carousel"
        :style="{ transform: `translateX(-${currentIndex * 100}%)` }"
      >
        <!-- 遍历游戏列表生成游戏卡片 -->
        <a
          class="game-card"
          v-for="game in games"
          :href="`/game/${game.name}`"
          :key="game.name"
        >
          <div class="game-card-content">
            <p>{{ game.name }}</p>
          </div>
        </a>
      </div>
      <!-- 轮播图导航按钮 -->
      <button
        @click="prevSlide"
        :disabled="currentIndex === 0"
        class="carousel-nav prev"
      >
        <i class="fa fa-chevron-left"></i>
      </button>
      <button
        @click="nextSlide"
        :disabled="currentIndex === games.length - 1"
        class="carousel-nav next"
      >
        <i class="fa fa-chevron-right"></i>
      </button>
    </div>

    <!-- 底部导航栏 -->
    <div class="bottom-bar">
      <!-- 这里假设已全局导入 FontAwesomeIcon 组件 -->
      <font-awesome-icon
        class="nav-icon"
        style="color: white"
        :icon="['fa', 'user-secret']"
      />
      <NuxtLink
        v-for="(nav, index) in navs"
        :to="nav.path"
        :key="index"
        class="nav-button"
        :class="{ active: isActive(nav.path) }"
      >
        {{ nav.label }}
      </NuxtLink>
    </div>
  </div>
</template>

<script setup>
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faUserSecret } from "@fortawesome/free-solid-svg-icons";
import { useRoute, ref } from "#imports";

// 将 FontAwesome 图标添加到库中
library.add(faUserSecret);

// 定义游戏列表
const games = [
  { name: "谁是卧底" },
  { name: "狼人杀" },
  { name: "骗子酒馆" },
  { name: "谁是卧底" },
  { name: "狼人杀" },
  { name: "骗子酒馆" },
];

// 定义导航栏数据
const navs = [
  { label: "游戏", path: "/" },
  { label: "创意工坊", path: "/workshop" },
  { label: "我的", path: "/user" },
];

// 获取当前路由
const route = useRoute();

// 判断当前路由是否激活
const isActive = (path) => {
  return (
    (path === "/" && route.path === "/") ||
    (path === "/workshop" && route.path === "/workshop") ||
    (path === "/user" && route.path === "/user")
  );
};

// 轮播图当前索引
const currentIndex = ref(0);

// 上一张
const prevSlide = () => {
  if (currentIndex.value > 0) {
    currentIndex.value--;
  }
};

// 下一张
const nextSlide = () => {
  if (currentIndex.value < games.length - 1) {
    currentIndex.value++;
  }
};
</script>

<style scoped>
.root {
  width: 100vw;
  height: 100vh;
  display: flex;
  flex-direction: column;
  background: url("~/assets/background.png") no-repeat center center fixed;
  background-size: cover;
  padding-bottom: 3rem;
  box-sizing: border-box;
}

.carousel-container {
  width: 80%;
  max-width: 600px;
  margin: 50px auto;
  position: relative;
  perspective: 1000px;
  overflow: hidden;
}

.carousel {
  display: flex;
  transition: transform 0.6s cubic-bezier(0.25, 0.46, 0.45, 0.94);
  transform-style: preserve-3d;
}

.game-card {
  min-width: 100%;
  height: 300px;
  text-decoration: none;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 1rem;
  background-color: rgba(255, 255, 255, 0.1);
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
  transition: all 0.3s ease;
  position: relative;
  overflow: hidden;
  transform-style: preserve-3d;
}

.game-card::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(
    45deg,
    rgba(255, 255, 255, 0.1),
    rgba(255, 255, 255, 0.3)
  );
  transform: scaleX(0);
  transform-origin: left;
  transition: transform 0.3s ease;
  z-index: 1;
}

.game-card:hover {
  transform: translateY(-10px) rotateX(5deg) rotateY(5deg);
  box-shadow: 0 15px 30px rgba(0, 0, 0, 0.7);
  background-color: rgba(255, 255, 255, 0.2);
}

.game-card:hover::before {
  transform: scaleX(1);
}

.game-card-content {
  z-index: 2;
  color: white;
  text-align: center;
  transform: translateZ(20px);
}

.carousel-nav {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background-color: rgba(255, 255, 255, 0.3);
  border: none;
  color: white;
  padding: 10px;
  border-radius: 50%;
  cursor: pointer;
  transition: background-color 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
}

.carousel-nav.prev {
  left: 10px;
}

.carousel-nav.next {
  right: 10px;
}

.carousel-nav:hover {
  background-color: rgba(255, 255, 255, 0.5);
}

.carousel-nav:disabled {
  background-color: rgba(255, 255, 255, 0.1);
  cursor: not-allowed;
}

.bottom-bar {
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
  flex-grow: 0;
  flex-shrink: 0;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
  padding: 0.5rem 1rem;
  border-top: 0.1rem solid #ccc;
  background-color: rgba(0, 0, 0, 0.8);
  box-shadow: 0 -4px 8px rgba(0, 0, 0, 0.1);
  box-sizing: border-box;
  animation: fadeIn 0.5s ease-out;
}

@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(100%);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.nav-icon {
  transition: transform 0.3s ease;
}

.nav-icon:hover {
  transform: rotate(360deg);
}

.nav-button {
  background-color: transparent;
  border: none;
  color: #fff;
  font-size: 1rem;
  font-weight: bold;
  padding: 0.5rem 1rem;
  cursor: pointer;
  transition: all 0.3s ease;
  border-radius: 0.5rem;
  position: relative;
  overflow: hidden;
  text-decoration: none;
}

.nav-button::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(
    45deg,
    rgba(255, 255, 255, 0.1),
    rgba(255, 255, 255, 0.3)
  );
  transform: scaleX(0);
  transform-origin: left;
  transition: transform 0.3s ease;
  z-index: -1;
}

.nav-button:hover {
  background-color: #444;
  transform: scale(1.1);
}

.nav-button:hover::before {
  transform: scaleX(1);
}

.active {
  background-color: #007bff;
  color: white;
}
</style>
