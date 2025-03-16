package net.mioyi.felix.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.mioyi.felix.entity.AuthRequest;
import net.mioyi.felix.entity.Response;
import net.mioyi.felix.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response<String>> register(@RequestBody AuthRequest request) {
        log.info("注册: {}", request);

        userService.register(request.getName(), request.getPassword());

        val token = userService.login(request.getName(), request.getPassword());

        return Response.success(token);
    }

    @PostMapping("/login")
    public ResponseEntity<Response<String>> login(@RequestBody AuthRequest request) {
        log.info("登录: {}", request);

        val token = userService.login(request.getName(), request.getPassword());

        return Response.success(token);
    }

    @PostMapping("/logout")
    public ResponseEntity<Response<Object>> logout(
            @RequestHeader("Authorization") String token
    ) {
        log.info("用户登出");

        userService.logout(token);

        return Response.success(null);
    }
}
