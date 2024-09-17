package ru.skillbox.spring_jwt_auth_example.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisKeyExpiredEvent;
import org.springframework.stereotype.Component;
import ru.skillbox.spring_jwt_auth_example.entity.RefreshToken;

@Component
@Slf4j
public class RedisExpirationEvent {

    @EventListener
    public void handleRedisKeyExpiredEvent(RedisKeyExpiredEvent<RefreshToken> event) {
        RefreshToken expiredRefreshToken = (RefreshToken) event.getValue();

        if (expiredRefreshToken == null) {
            log.info("Refresh token expired");
            throw new RuntimeException("Refresh token is null in handleRedisKeyExpired function");
        }
        log.info("Refresh token with key= {} has expired. Refresh token is {}", expiredRefreshToken.getId(),
                expiredRefreshToken.getToken());
    }
}
