package ru.skillbox.spring_jwt_auth_example.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skillbox.spring_jwt_auth_example.entity.RefreshToken;

import java.util.Optional;

public interface JavaRefreshTokenRepository extends CrudRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

    void deleteByUserId(Long userId);
}
