<template>
  <div class="light-effect-container">
    <slot></slot>
  </div>
</template>

<script setup></script>

<style scoped>
.light-effect-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  background: linear-gradient(45deg, #000, #222);
  color: white;
  position: relative;
  padding: 2rem;
  box-shadow: inset 0 0 50px rgba(0, 255, 255, 0.1);
  animation: lightEffect 8s ease infinite;
}

@keyframes lightEffect {
  0% {
    background: linear-gradient(45deg, #000, #222);
    box-shadow: inset 0 0 50px rgba(0, 255, 255, 0.1);
  }
  25% {
    background: linear-gradient(45deg, #001, #223);
    box-shadow: inset 0 0 70px rgba(0, 255, 255, 0.3);
  }
  50% {
    background: linear-gradient(45deg, #002, #224);
    box-shadow: inset 0 0 90px rgba(0, 255, 255, 0.5);
  }
  75% {
    background: linear-gradient(45deg, #001, #223);
    box-shadow: inset 0 0 70px rgba(0, 255, 255, 0.3);
  }
  100% {
    background: linear-gradient(45deg, #000, #222);
    box-shadow: inset 0 0 50px rgba(0, 255, 255, 0.1);
  }
}
</style>
