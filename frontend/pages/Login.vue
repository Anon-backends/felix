<template>
  <div class="login-container">
    <h1>用户登录</h1>
    <form @submit.prevent="login">
      <label for="name">用户名:</label>
      <input type="text" id="name" v-model="name" required />
      <label for="password">密码:</label>
      <input type="password" id="password" v-model="password" required />
      <button type="submit">登录</button>
    </form>
    <!-- 显示登录结果信息 -->
    <div v-if="loginMessage" class="message">{{ loginMessage }}</div>
    <button @click="goToRegister">注册</button>
  </div>
</template>

<script setup>
import { ref } from "#imports";
import { useRouter } from "#imports";

const name = ref("");
const password = ref("");
const router = useRouter();
const loginMessage = ref("");

// 登录函数
const login = async () => {
  try {
    const response = await fetch("http://localhost:8080/api/user/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: name.value,
        password: password.value,
      }),
    });

    const data = await response.json();

    if (response.ok) {
      if (data.success) {
        loginMessage.value = "登录成功！";
        // 短暂延迟后跳转到主页面
        setTimeout(() => {
          router.push("/");
        }, 1000);
      } else {
        loginMessage.value = data.message || "登录失败，请检查用户名和密码。";
      }
    } else {
      loginMessage.value = "登录失败，请稍后重试。";
    }
  } catch (error) {
    loginMessage.value = "请求出错，请检查网络连接。";
    console.error("请求出错:", error);
  }
};

// 跳转到注册页面
const goToRegister = () => {
  router.push("/register");
};
</script>

<style scoped>
.login-container {
  width: 300px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
  text-align: center;
  margin-bottom: 20px;
}

form label {
  display: block;
  margin-bottom: 5px;
}

form input {
  width: 100%;
  padding: 8px;
  margin-bottom: 15px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

form button {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

form button:hover {
  background-color: #0056b3;
}

.message {
  margin-top: 10px;
  color: red;
  text-align: center;
}

button {
  width: 100%;
  padding: 10px;
  margin-top: 10px;
  background-color: #28a745;
  color: white;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

button:hover {
  background-color: #218838;
}
</style>
