<template>
  <div class="register-container">
    <h1 class="register-title">用户注册</h1>
    <form @submit.prevent="register">
      <div class="input-group">
        <input type="text" v-model="name" required placeholder="请输入用户名" />
      </div>
      <div class="input-group">
        <input
          type="password"
          v-model="password"
          required
          placeholder="请输入密码"
        />
      </div>
      <button type="submit" class="register-button">注册</button>
    </form>
    <div v-if="registerMessage" class="message">{{ registerMessage }}</div>
  </div>
</template>

<script setup>
const emits = defineEmits(["register"]);
const props = defineProps({
  registerMessage: {
    type: String,
    default: "",
  },
});

const name = ref("");
const password = ref("");

const register = () => {
  emits("register");
};
</script>

<style scoped>
.register-container {
  width: 350px;
  background-color: rgba(255, 255, 255, 0.1);
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 255, 255, 0.5);
  backdrop-filter: blur(10px);
}

.register-title {
  text-align: center;
  margin-bottom: 20px;
  color: #00f0ff;
  font-size: 24px;
  text-shadow: 0 0 10px rgba(0, 255, 255, 0.5);
}

.input-group {
  margin-bottom: 20px;
}

.input-group input {
  width: 100%;
  padding: 10px;
  border: none;
  border-bottom: 2px solid #00f0ff;
  background-color: transparent;
  color: white;
  font-size: 14px;
  transition: border-bottom 0.3s ease;
}

.input-group input:focus {
  outline: none;
  border-bottom: 2px solid #00ff8c;
}

.register-button {
  width: 100%;
  padding: 12px;
  background: linear-gradient(to right, #00f0ff, #00ff8c);
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
  transition: background 0.3s ease;
}

.register-button:hover {
  background: linear-gradient(to right, #00ff8c, #00f0ff);
}

.message {
  margin-top: 15px;
  color: #ff4d4d;
  text-align: center;
  font-size: 14px;
}
</style>
