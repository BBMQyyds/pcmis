package com.lzy.common.config;

import com.lzy.common.util.JWTProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfig {
    @Bean
    public JWTProvider jwtProvider() {
        return new JWTProvider();
    }
}
