import { authorizedFetch } from "./useAuthorizedFetch";

const baseUrl = "http://localhost:8080";

export function apiRequest(endpoint, options = {}, requireAuth = true) {
  const url = `${baseUrl}/api/${endpoint}`;
  return authorizedFetch(url, options, requireAuth);
}
