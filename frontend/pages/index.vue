<template>
  <div class="root">
    <button @click="logout" class="logout-button">
      <span class="logout-text">登出</span>
    </button>
    <div v-if="isLoading" class="loading-container">
      <div class="loading-text">加载中...</div>
      <div class="progress-bar">
        <div class="progress" :style="{ width: progress + '%' }"></div>
      </div>
    </div>
    <Carousel v-else :games="games" />
    <div class="bottom-bar">
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
import { useRoute } from "#imports";
import { useCheckLoginStatus } from "~/composables/useCheckLoginStatus";
import { useLogout } from "~/composables/useLogout";
import Carousel from "~/components/Carousel.vue";

// 注册图标库
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

// 定义导航栏列表
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

// 使用组合式函数
const { isLoading, progress } = useCheckLoginStatus();
const { logout } = useLogout();
</script>

<style scoped>
.root {
  width: 100vw;
  height: 100vh;
  display: flex;
  flex-direction: column;
  background: url("~/assets/background.webp") no-repeat center center fixed;
  background-size: cover;
  padding-bottom: 3rem;
  box-sizing: border-box;
  position: relative;
}

.logout-button {
  position: absolute;
  top: 20px;
  right: 20px;
  background-color: rgba(0, 0, 0, 0.5);
  border: none;
  color: white;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  transition: all 0.3s ease;
  overflow: hidden;
  z-index: 10;
}

.logout-button::before {
  content: "";
  position: absolute;
  top: 0;
  left: -100%;
  width: 100%;
  height: 100%;
  background: linear-gradient(
    90deg,
    transparent,
    rgba(255, 255, 255, 0.2),
    transparent
  );
  transition: all 0.6s ease;
}

.logout-button:hover {
  background-color: rgba(0, 0, 0, 0.7);
  transform: scale(1.1);
}

.logout-button:hover::before {
  left: 100%;
}

.loading-container {
  color: white;
  font-size: 30px;
  text-align: center;
  margin-top: 100px;
}

.loading-text {
  margin-bottom: 20px;
}

.progress-bar {
  width: 80%;
  max-width: 600px;
  margin: 0 auto;
  background-color: #f3f3f3;
  border-radius: 10px;
  overflow: hidden;
}

.progress {
  height: 30px;
  background-color: #007bff;
  width: 0;
  transition: width 0.3s ease;
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
