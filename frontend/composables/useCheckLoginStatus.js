import { ref, onBeforeMount, onUnmounted } from "vue";
import { useRouter } from "#imports";

export const useCheckLoginStatus = () => {
  const router = useRouter();
  const isLoading = ref(true);
  const isLoggedIn = ref(false);
  const progress = ref(0);

  let intervalId;

  onBeforeMount(async () => {
    intervalId = setInterval(() => {
      if (progress.value < 100) {
        progress.value += 10;
      }
    }, 100);
    try {
      await new Promise((resolve) => setTimeout(resolve, 1000));
      if (!isLoggedIn.value) {
        router.push("/Login");
      }
    } catch (error) {
      console.error("检查登录状态出错:", error);
    } finally {
      isLoading.value = false;
      clearInterval(intervalId);
    }
  });

  onUnmounted(() => {
    clearInterval(intervalId);
  });

  return {
    isLoading,
    isLoggedIn,
    progress,
  };
};
