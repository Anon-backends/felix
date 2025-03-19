<template>
  <button @click="logout" class="logout-button">
    <span class="logout-text">登出</span>
  </button>
</template>

<script setup>
import { useLogout } from "~/composables/useLogout";

const { logout } = useLogout();
</script>

<style scoped>
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
</style>
