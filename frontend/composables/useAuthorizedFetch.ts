export function authorizedFetch(
  url: string,
  options: RequestInit = {},
  requireAuth: boolean = true,
) {
  const headers: Record<string, string> = { ...options.headers } as Record<
    string,
    string
  >;
  if (requireAuth) {
    const authorization = localStorage.getItem("authorization");
    if (authorization) {
      headers["Authorization"] = `Bearer ${authorization}`;
    }
  }
  const newOptions = { ...options, headers };
  return fetch(url, newOptions);
}
