import { useRouter } from "#imports";
import { apiRequest } from "./useApiRequest";

export function useLogout() {
  const router = useRouter();

  async function logout() {
    try {
      const response = await apiRequest(
        "api/user/logout",
        "POST",
        undefined,
        true,
      );

      if (!response.ok) {
        const data = await response.json();
        console.error("登出失败:", data.message);
        return;
      }

      const data = await response.json();
      if (data.success) {
        localStorage.removeItem("authorization");
        router.push("/Login");
      } else {
        console.error("登出失败:", data.message);
      }
    } catch (error) {
      console.error("请求出错:", error);
    }
  }

  return {
    logout,
  };
}
