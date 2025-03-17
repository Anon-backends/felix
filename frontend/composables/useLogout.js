import { useRouter } from "#imports";

export const useLogout = () => {
  const router = useRouter();

  const logout = async () => {
    try {
      const authorization = localStorage.getItem("authorization");
      if (!authorization) {
        console.error("未找到 authorization");
        router.push("/Login");
        return;
      }
      const response = await fetch("http://localhost:8080/api/user/logout", {
        method: "POST",
        headers: {
          Authorization: `Bearer ${authorization}`,
        },
      });

      const data = await response.json();
      if (response.ok && data.success) {
        localStorage.removeItem("authorization");
        router.push("/Login");
      } else {
        console.error("登出失败:", data.message);
      }
    } catch (error) {
      console.error("请求出错:", error);
    }
  };

  return {
    logout,
  };
};
