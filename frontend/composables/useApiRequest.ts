import { authorizedFetch } from "./useAuthorizedFetch";

const BASE_URL = "http://localhost:8080";

export function apiRequest(
  endpoint: string,
  method: string = "GET",
  body?: any,
  requireAuth: boolean = true,
) {
  const url = `${BASE_URL}/${endpoint}`;
  return authorizedFetch(url, method, body, requireAuth);
}
