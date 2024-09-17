package ru.skillbox.spring_jwt_auth_example.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.skillbox.spring_jwt_auth_example.entity.RefreshToken;
import ru.skillbox.spring_jwt_auth_example.exception.RefreshTokenException;
import ru.skillbox.spring_jwt_auth_example.repository.JavaRefreshTokenRepository;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    @Value("${app.jwt.refreshTokenExpiration}")
    private Duration refreshTokenExpiration;

    private final JavaRefreshTokenRepository javaRefreshTokenRepository;

    public Optional<RefreshToken> findByRefreshToken(String refreshToken) {
        return javaRefreshTokenRepository.findByToken(refreshToken);
    }

    public RefreshToken createRefreshToken(Long userId) {
        var refreshToken = RefreshToken.builder()
                .userId(userId)
                .expiryDate(Instant.now().plusMillis(refreshTokenExpiration.toMillis()))
                .token(UUID.randomUUID().toString())
                .build();

        return javaRefreshTokenRepository.save(refreshToken);
    }

    public RefreshToken checkRefreshToken(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            javaRefreshTokenRepository.delete(token);
            throw new RefreshTokenException(token.getToken(), "Refresh token is expired. Repeat sign in action");
        }

        return token;
    }

    public void deleteByUserId(Long userId) {
        javaRefreshTokenRepository.deleteByUserId(userId);
    }
}
