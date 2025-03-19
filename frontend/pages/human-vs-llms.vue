<template>
  <div class="human-vs-llms-container">
    <h1>人类 vs LLMs 对战</h1>

    <div class="game-area">
      <!-- 实际的游戏内容区域 -->
    </div>

    <button class="exit-button" @click="exitGame">退出游戏</button>
  </div>
</template>

<script setup>
import { useRouter } from "#app";

const router = useRouter();

// 退出游戏函数
const exitGame = () => {
  router.back();
};
</script>

<style scoped>
.human-vs-llms-container {
  background: linear-gradient(45deg, #000, #222);
  color: white;
  min-height: 100vh;
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  position: relative;
  animation: gradientAnimation 15s ease infinite;
}

@keyframes gradientAnimation {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}

h1 {
  font-size: 3rem;
  text-align: center;
  text-shadow: 0 0 10px rgba(0, 255, 255, 0.5);
  margin-bottom: 20px;
}

.game-area {
  width: 90%;
  max-width: 1400px;
  height: 650px;
  background-color: rgba(0, 0, 0, 0.3);
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 255, 255, 0.5);
  margin-bottom: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.exit-button {
  padding: 10px 20px;
  background: linear-gradient(to right, #00f0ff, #00ff8c);
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background 0.3s ease;
  box-shadow: 0 0 10px rgba(0, 255, 255, 0.5);
}

.exit-button:hover {
  background: linear-gradient(to right, #00ff8c, #00f0ff);
  box-shadow: 0 0 15px rgba(0, 255, 255, 0.7);
}
</style>
