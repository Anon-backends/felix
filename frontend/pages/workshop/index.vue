<template>
  <p>Workshop</p>
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
</template>

<script setup>
import { useRoute } from "#imports";

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
</script>

<style scoped>
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
  background-color: #222;
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
