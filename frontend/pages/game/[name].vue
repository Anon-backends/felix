<template>
  <BackgroundLightEffect>
    <BackButton />
    <h1>{{ $route.params.name }}</h1>
    <GameDescription />
    <div class="button-container">
      <button class="custom-button" @click="handleHumanVsLLMsClick">
        人类 vs LLMs
      </button>
      <button class="custom-button" @click="handleLLMsVsLLMsClick">
        LLMs vs LLMs
      </button>
    </div>
    <GameFeatures />
  </BackgroundLightEffect>
</template>

<script setup>
import { useRouter } from "#app";
import BackButton from "~/components/BackButton.vue";
import GameDescription from "~/components/GameDescription.vue";
import GameFeatures from "~/components/GameFeatures.vue";
import BackgroundLightEffect from "~/components/BackgroundLightEffect.vue";

const router = useRouter();

const handleHumanVsLLMsClick = () => {
  router.push("/human-vs-llms");
};

const handleLLMsVsLLMsClick = () => {
  router.push("/llms-vs-llms");
};
</script>

<style scoped>
h1 {
  font-size: 3rem;
  margin-bottom: 1rem;
  text-shadow: 0 0 10px rgba(0, 255, 255, 0.5);
}

.button-container {
  display: flex;
  gap: 1.5rem;
  margin-bottom: 2rem;
}

.custom-button {
  padding: 1rem 2rem;
  font-size: 1.2rem;
  font-weight: bold;
  border: none;
  border-radius: 0.5rem;
  background: linear-gradient(to right, #00f0ff, #00ff8c);
  color: white;
  cursor: pointer;
  transition: background 0.3s ease;
  box-shadow: 0 0 10px rgba(0, 255, 255, 0.5);
}

.custom-button:hover {
  background: linear-gradient(to right, #00ff8c, #00f0ff);
  box-shadow: 0 0 15px rgba(0, 255, 255, 0.7);
}
</style>
