const AUTH_STORE_KEY = "authorization"; //将authorizaition存储为常量，便于使用

export function authorizedFetch(
  endpoint: string,
  method: string = "GET",
  body?: any,
  requireAuth: boolean = true,
) {
  const headers: Record<string, string> = {};
  if (requireAuth) {
    const authorization = localStorage.getItem(AUTH_STORE_KEY);
    if (authorization) {
      headers["Authorization"] = `Bearer ${authorization}`;
    }
  }
  const options: RequestInit = {
    method,
    headers,
    body: body ? JSON.stringify(body) : undefined,
  };
  return fetch(endpoint, options);
}
