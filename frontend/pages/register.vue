<template>
  <div class="register-background">
    <div class="register-container">
      <h1 class="register-title">用户注册</h1>
      <form @submit.prevent="register">
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
        <button type="submit" class="register-button">注册</button>
      </form>
      <!-- 显示注册结果信息 -->
      <div v-if="registerMessage" class="message">{{ registerMessage }}</div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "#imports";
import { useRouter } from "#imports";

const name = ref("");
const password = ref("");
const router = useRouter();
const registerMessage = ref("");

const register = async () => {
  try {
    const response = await fetch("http://localhost:8080/api/user/register", {
      method: "POST",
      // 去除Content-Type，后端自动处理
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
        registerMessage.value = "注册成功，请登录。";
        // 短暂延迟后跳转到登录页面
        setTimeout(() => {
          router.push("/Login");
        }, 2000);
      } else {
        registerMessage.value = data.message || "注册失败，请稍后重试。";
      }
    } else {
      registerMessage.value = "注册失败，请稍后重试。";
    }
  } catch (error) {
    registerMessage.value = "请求出错，请检查网络连接。";
    console.error("请求出错:", error);
  }
};
</script>

<style scoped>
.register-background {
  background-image: url("~/assets/background.webp");
  background-size: cover;
  background-position: center;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

.register-container {
  width: 350px;
  background-color: rgba(255, 255, 255, 0.9);
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
}

.register-title {
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

.register-button {
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

.register-button:hover {
  background-color: #0056b3;
}

.message {
  margin-top: 15px;
  color: red;
  text-align: center;
  font-size: 14px;
}
</style>
