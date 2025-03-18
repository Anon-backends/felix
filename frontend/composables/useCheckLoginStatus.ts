import { ref, onBeforeMount, onUnmounted } from "vue";
import { useRouter } from "#imports";

export function useCheckLoginStatus() {
  const router = useRouter();
  const isLoading = ref(true);
  const isLoggedIn = ref(false);

  onBeforeMount(async () => {
    try {
      await new Promise((resolve) => setTimeout(resolve, 1000));
      if (!isLoggedIn.value) {
        router.push("/Login");
      }
    } catch (error) {
      console.error("检查登录状态出错:", error);
    } finally {
      isLoading.value = false;
    }
  });

  return {
    isLoading,
    isLoggedIn,
  };
}
