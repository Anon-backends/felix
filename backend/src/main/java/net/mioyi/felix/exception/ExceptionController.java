package net.mioyi.felix.exception;

import lombok.extern.slf4j.Slf4j;
import net.mioyi.felix.entity.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Response<Object>> handle(Throwable e) {
        log.error(e.getMessage(), e);

        return Response.failure(e.getMessage());
    }

    @ExceptionHandler(WrongUserException.class)
    public ResponseEntity<Response<Object>> handleException(WrongUserException e) {
        log.info("用户名或密码错误");

        return Response.failure("用户名或密码错误");
    }
}
