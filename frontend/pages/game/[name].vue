<template>
  <div class="game-detail-container">
    <h1>{{ $route.params.name }}</h1>
    <div class="button-container">
      <button class="custom-button" @click="handleHumanVsLLMsClick">人类 vs LLMs</button>
      <button class="custom-button" @click="handleLLMsVsLLMsClick">LLMs vs LLMs</button>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from '#app';

const router = useRouter();

const handleHumanVsLLMsClick = () => {
  // 这里的路径需要根据你的实际路由配置修改
  router.push('/human-vs-llms');
};

const handleLLMsVsLLMsClick = () => {
  // 这里的路径需要根据你的实际路由配置修改
  router.push('/llms-vs-llms');
};
</script>

<style scoped>
.game-detail-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  background-color: #f4f4f9;
}

h1 {
  font-size: 2.5rem;
  color: #333;
  margin-bottom: 2rem;
}

.button-container {
  display: flex;
  gap: 1.5rem;
}

.custom-button {
  padding: 1rem 2rem;
  font-size: 1.2rem;
  font-weight: bold;
  border: none;
  border-radius: 0.5rem;
  background-color: #007BFF;
  color: white;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.custom-button:hover {
  background-color: #0056b3;
}
</style>    