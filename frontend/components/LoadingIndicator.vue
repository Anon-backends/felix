<template>
  <div class="loading-container">
    <div class="loading-text">加载中...</div>
    <div class="progress-bar">
      <div class="progress"></div>
    </div>
  </div>
</template>

<script setup>
// 移除进度值相关逻辑
</script>

<style scoped>
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
  background-color: rgba(255, 255, 255, 0.1);
  border-radius: 20px;
  overflow: hidden;
  box-shadow: 0 0 10px rgba(0, 255, 255, 0.5);
}

.progress {
  height: 30px;
  background: linear-gradient(to right, #00f0ff, #00ff8c);
  width: 0;
  animation: progressAnimation 3s infinite linear;
  border-radius: 20px;
}

@keyframes progressAnimation {
  0% {
    width: 0;
  }
  100% {
    width: 100%;
  }
}
</style>
