<template>
  <div class="register-container">
    <h1>用户注册</h1>
    <form @submit.prevent="register">
      <label for="name">用户名:</label>
      <input type="text" id="name" v-model="name" required />
      <label for="password">密码:</label>
      <input type="password" id="password" v-model="password" required />
      <button type="submit">注册</button>
    </form>
    <!-- 显示注册结果信息 -->
    <div v-if="registerMessage" class="message">{{ registerMessage }}</div>
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
.register-container {
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
</style>
