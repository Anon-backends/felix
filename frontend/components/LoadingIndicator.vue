<template>
  <div class="loading-container">
    <div class="loading-text">加载中...</div>
    <div class="progress-bar">
      <div class="progress" :style="{ width: progress + '%' }"></div>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  progress: {
    type: Number,
    default: 0,
  },
});
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
</style>
