package com.blur.notificationservice.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RedisService{
    RedisTemplate<String, String> redisTemplate;
    public boolean isOnline(String userId){
        return Boolean.TRUE.equals(redisTemplate.hasKey("online " + userId));
    }
}
