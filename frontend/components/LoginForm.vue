<template>
  <div class="login-container">
    <h1 class="login-title">用户登录</h1>
    <form @submit.prevent="login">
      <div class="input-group">
        <label for="name">用户名:</label>
        <input
          type="text"
          id="name"
          v-model="name"
          required
          placeholder="请输入用户名"
        />
      </div>
      <div class="input-group">
        <label for="password">密码:</label>
        <input
          type="password"
          id="password"
          v-model="password"
          required
          placeholder="请输入密码"
        />
      </div>
      <button type="submit" class="login-button">登录</button>
    </form>
    <!-- 显示登录结果信息 -->
    <div v-if="loginMessage" class="message">{{ loginMessage }}</div>
    <button @click="goToRegister" class="register-button">注册</button>
  </div>
</template>

<script setup>
const emits = defineEmits(["login", "goToRegister"]);
const props = defineProps({
  loginMessage: {
    type: String,
    default: "",
  },
});

const name = ref("");
const password = ref("");

const login = () => {
  emits("login");
};

const goToRegister = () => {
  emits("goToRegister");
};
</script>

<style scoped>
.login-container {
  width: 350px;
  background-color: rgba(255, 255, 255, 0.9);
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
}

.login-title {
  text-align: center;
  margin-bottom: 20px;
  color: #333;
  font-size: 24px;
}

.input-group {
  margin-bottom: 20px;
}

.input-group label {
  display: block;
  margin-bottom: 5px;
  color: #666;
  font-size: 14px;
}

.input-group input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 14px;
  transition: border-color 0.3s ease;
}

.input-group input:focus {
  outline: none;
  border-color: #007bff;
}

.login-button {
  width: 100%;
  padding: 12px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
  transition: background-color 0.3s ease;
}

.login-button:hover {
  background-color: #0056b3;
}

.message {
  margin-top: 15px;
  color: red;
  text-align: center;
  font-size: 14px;
}

.register-button {
  width: 100%;
  padding: 12px;
  margin-top: 15px;
  background-color: #28a745;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
  transition: background-color 0.3s ease;
}

.register-button:hover {
  background-color: #218838;
}
</style>
