package com.lzy.common.config;

import com.lzy.common.util.JWTProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，用于定义和配置JWT相关的Bean
 */
@Configuration
public class JWTConfig {
    /**
     * 创建并提供JWTProvider实例的方法
     *
     * @return JWTProvider实例，用于处理JWT的生成和验证
     */
    @Bean
    public JWTProvider jwtProvider() {
        return new JWTProvider();
    }
}

