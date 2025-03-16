package net.mioyi.felix.service;

import cn.dev33.satoken.stp.StpUtil;
import lombok.AllArgsConstructor;
import lombok.val;
import net.mioyi.felix.exception.UserNotFoundException;
import net.mioyi.felix.respository.UserRepository;
import net.mioyi.felix.entity.User;
import net.mioyi.felix.exception.RegisterException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private static final Pattern passwordValidateRegex = Pattern.compile("^[a-zA-Z0-9_-]{4,16}$");

    private boolean validateName(String name) {
        return StringUtils.hasText(name);
    }

    private boolean validatePassword(String password) {
        return StringUtils.hasText(password) && passwordValidateRegex.matcher(password).matches();
    }

    public void register(String name, String password) {
        if (!validateName(name)) {
            throw new RegisterException("用户名不合法");
        }

        if (!validatePassword(password)) {
            throw new RegisterException("密码不合法");
        }

        if (userRepository.existsByName(name)) {
            throw new RegisterException("用户名已存在");
        }

        userRepository.save(User.builder()
                .name(name)
                .password(password)
                .build());
    }

    public String login(String name, String password) {
        val user = userRepository.findUserByName(name);

        if (user.isEmpty()) {
            throw new UserNotFoundException("未找到用户");
        }

        if (!user.get().getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }

        StpUtil.login(name);

        return StpUtil.getTokenValue();
    }

    public void logout(String token) {
        StpUtil.logoutByTokenValue(token);
    }
}
