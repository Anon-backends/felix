<template>
  <button class="back-button" @click="goBack">
    <font-awesome-icon icon="arrow-left" />
  </button>
</template>

<script setup>
import { useRouter } from "#app";

const router = useRouter();

const goBack = () => {
  router.back();
};
</script>

<style scoped>
.back-button {
  position: absolute;
  top: 1rem;
  left: 1rem;
  background-color: rgba(0, 255, 255, 0.3);
  border: none;
  color: white;
  padding: 0.8rem;
  border-radius: 50%;
  cursor: pointer;
  transition: background-color 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
  box-shadow: 0 0 10px rgba(0, 255, 255, 0.5);
}

.back-button:hover {
  background-color: rgba(0, 255, 255, 0.5);
  box-shadow: 0 0 15px rgba(0, 255, 255, 0.7);
}
</style>
