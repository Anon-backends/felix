package net.mioyi.felix.respository;

import net.mioyi.felix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName(String name);

    Optional<User> findUserByName(String name);
}

