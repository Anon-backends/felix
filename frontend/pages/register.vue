<template>
  <div class="register-background">
    <RegisterForm
      :registerMessage="registerMessage"
      @register="handleRegister"
    />
  </div>
</template>

<script setup>
import { ref } from "#imports";
import { useRouter } from "#imports";
import { apiRequest } from "~/composables/useApiRequest";
import RegisterForm from "~/components/RegisterForm.vue";

const name = ref("");
const password = ref("");
const router = useRouter();
const registerMessage = ref("");

const handleRegister = async () => {
  try {
    const response = await apiRequest(
      "api/user/register",
      "POST",
      { name: name.value, password: password.value },
      false,
    );

    if (!response.ok) {
      registerMessage.value = "注册失败，请稍后重试。";
      return;
    }

    const data = await response.json();
    if (data.success) {
      const authorization = data.data;
      if (authorization) localStorage.setItem("authorization", authorization);
      registerMessage.value = "注册成功，请登录。";
      setTimeout(() => router.push("/Login"), 2000);
    } else {
      registerMessage.value = data.message || "注册失败，请稍后重试。";
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
</style>
