package com.lzy.common.config;

import com.lzy.common.util.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisUtilsConfig {
    @Bean
    public RedisUtils redisUtils() {
        return new RedisUtils();
    }
}
