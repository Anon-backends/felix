<template>
  <div class="login-background">
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
        // 后端返回 authorization
        const authorization = data.data;
        if (authorization) {
          // 将 authorization 存储到本地存储中
          localStorage.setItem("authorization", authorization);
        }
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
.login-background {
  background-image: url("~/assets/background.webp");
  background-size: cover;
  background-position: center;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

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
