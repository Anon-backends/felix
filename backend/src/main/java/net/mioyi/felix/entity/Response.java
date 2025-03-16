package net.mioyi.felix.entity;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class Response<T> {
    public boolean success;
    public String message;
    public T data;

    public static <T> ResponseEntity<Response<T>> success(T data) {
        return ResponseEntity.ok(new Response<T>(true, null, data));
    }

    public static ResponseEntity<Response<Object>> failure(String message) {
        return ResponseEntity.ok(new Response<>(false, message, null));
    }
}