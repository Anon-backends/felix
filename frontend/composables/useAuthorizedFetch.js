export function authorizedFetch(url, options = {}, requireAuth = true) {
  const headers = { ...options.headers };
  if (requireAuth) {
    const authorization = localStorage.getItem("authorization");
    if (authorization) {
      headers["Authorization"] = `Bearer ${authorization}`;
    }
  }
  const newOptions = { ...options, headers };
  return fetch(url, newOptions);
}
