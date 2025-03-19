<template>
  <div class="login-background">
    <LoginForm
      :loginMessage="loginMessage"
      @login="handleLogin"
      @goToRegister="goToRegister"
    />
  </div>
</template>

<script setup>
import { ref } from "#imports";
import { useRouter } from "#imports";
import { apiRequest } from "~/composables/useApiRequest";
import LoginForm from "~/components/LoginForm.vue";

const name = ref("");
const password = ref("");
const router = useRouter();
const loginMessage = ref("");

const handleLogin = async () => {
  try {
    const response = await apiRequest(
      "api/user/login",
      "POST",
      { name: name.value, password: password.value },
      false,
    );

    if (!response.ok) {
      loginMessage.value = "登录失败，请稍后重试。";
      return;
    }

    const data = await response.json();
    if (data.success) {
      const authorization = data.data;
      if (authorization) localStorage.setItem("authorization", authorization);
      loginMessage.value = "登录成功！";
      setTimeout(() => router.push("/"), 1000);
    } else {
      loginMessage.value = data.message || "登录失败，请检查用户名和密码。";
    }
  } catch (error) {
    loginMessage.value = "请求出错，请检查网络连接。";
    console.error("请求出错:", error);
  }
};

const goToRegister = () => {
  router.push("/register");
};
</script>

<style scoped>
.login-background {
  background-image: url("~/assets/background.webp");
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  animation: gradientAnimation 15s ease infinite;
}

@keyframes gradientAnimation {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}
</style>
