<template>
  <div class="root">
    <LogoutButton />
    <LoadingIndicator v-if="isLoading" />
    <Carousel v-else :games="games" />
    <BottomNavBar />
  </div>
</template>

<script setup>
import { useCheckLoginStatus } from "~/composables/useCheckLoginStatus";
import Carousel from "~/components/Carousel.vue";
import LogoutButton from "~/components/LogoutButton.vue";
import LoadingIndicator from "~/components/LoadingIndicator.vue";
import BottomNavBar from "~/components/BottomNavBar.vue";

// 定义游戏列表
const games = [
  { name: "谁是卧底" },
  { name: "狼人杀" },
  { name: "骗子酒馆" },
  { name: "谁是卧底" },
  { name: "狼人杀" },
  { name: "骗子酒馆" },
];

// 使用组合式函数
const { isLoading } = useCheckLoginStatus();
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
</style>
