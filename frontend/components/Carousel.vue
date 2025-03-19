<template>
  <div class="carousel-container">
    <div
      class="carousel"
      :style="{ transform: `translateX(-${currentIndex * 100}%)` }"
    >
      <a
        class="game-card"
        v-for="game in games"
        :href="`/game/${game.name}`"
        :key="game.name"
      >
        <div class="game-card-content">
          <p>{{ game.name }}</p>
        </div>
      </a>
    </div>
    <button
      @click="prevSlide"
      :disabled="currentIndex === 0"
      class="carousel-nav prev"
    >
      <i class="fa fa-chevron-left"></i>
    </button>
    <button
      @click="nextSlide"
      :disabled="currentIndex === games.length - 1"
      class="carousel-nav next"
    >
      <i class="fa fa-chevron-right"></i>
    </button>
  </div>
</template>

<script setup>
const props = defineProps({
  games: {
    type: Array,
    default: () => [],
  },
});

const currentIndex = ref(0);

const prevSlide = () => {
  if (currentIndex.value > 0) {
    currentIndex.value--;
  }
};

const nextSlide = () => {
  if (currentIndex.value < props.games.length - 1) {
    currentIndex.value++;
  }
};
</script>

<style scoped>
.carousel-container {
  width: 80%;
  max-width: 600px;
  margin: 50px auto;
  position: relative;
  perspective: 1000px;
  overflow: hidden;
}

.carousel {
  display: flex;
  transition: transform 0.6s cubic-bezier(0.25, 0.46, 0.45, 0.94);
  transform-style: preserve-3d;
}

.game-card {
  min-width: 100%;
  height: 300px;
  text-decoration: none;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 1rem;
  background-color: rgba(255, 255, 255, 0.1);
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
  transition: all 0.3s ease;
  position: relative;
  overflow: hidden;
  transform-style: preserve-3d;
}

.game-card::before {
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
  z-index: 1;
}

.game-card:hover {
  transform: translateY(-10px) rotateX(5deg) rotateY(5deg);
  box-shadow: 0 15px 30px rgba(0, 0, 0, 0.7);
  background-color: rgba(255, 255, 255, 0.2);
}

.game-card:hover::before {
  transform: scaleX(1);
}

.game-card-content {
  z-index: 2;
  color: white;
  text-align: center;
  transform: translateZ(20px);
}

.carousel-nav {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background-color: rgba(255, 255, 255, 0.3);
  border: none;
  color: white;
  padding: 10px;
  border-radius: 50%;
  cursor: pointer;
  transition: background-color 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
}

.carousel-nav.prev {
  left: 10px;
}

.carousel-nav.next {
  right: 10px;
}

.carousel-nav:hover {
  background-color: rgba(255, 255, 255, 0.5);
}

.carousel-nav:disabled {
  background-color: rgba(255, 255, 255, 0.1);
  cursor: not-allowed;
}
</style>
