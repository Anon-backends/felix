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

// 登录函数
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
</style>
