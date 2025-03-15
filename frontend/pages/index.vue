<script setup>
let games = [
  {
    name: "谁是卧底",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
  {
    name: "狼人杀",
  },
];
</script>

<template>
  <div class="root">
    <div class="game-list">
      <a
        class="game-card"
        v-for="game in games"
        v-bind:href="`/game/${game.name}`"
      >
        <p>{{ game.name }}</p>
      </a>
    </div>

    <div class="bottom-bar">
      <font-awesome-icon style="color: blue" icon="fa-solid fa-user-secret" />
      <p>游戏</p>
      <p>创意工坊</p>
      <p>我的</p>
    </div>
  </div>
</template>

<style scoped>
.root {
  width: 100vw;
  height: 100vh;

  display: flex;
  flex-direction: column;
}

.game-list {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
  justify-content: space-evenly;

  overflow-x: hidden;
  overflow-y: scroll;

  flex-grow: 1;
}

.game-card {
  width: 10rem;
  height: 10rem;
  font-weight: bold;
  font-size: x-large;
  text-decoration: none;
  color: black;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  border: 0.1rem solid black;
  border-radius: 1rem;
  margin: 1rem;
  padding: 0.5rem 1rem;
}

.bottom-bar {
  flex-grow: 0;
  flex-shrink: 0;

  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;

  /* margin: 1rem; */
  padding: 0.5rem 1rem;

  border-top: 0.1rem solid black;
}
</style>
