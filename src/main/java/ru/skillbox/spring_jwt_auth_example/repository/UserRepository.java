package ru.skillbox.spring_jwt_auth_example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skillbox.spring_jwt_auth_example.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
