package com.lzy.common.config;

import com.lzy.common.util.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，用于定义和初始化Redis工具类的Bean
 */
@Configuration
public class RedisUtilsConfig {
    /**
     * 创建并初始化RedisUtils的Bean
     *
     * @return RedisUtils实例，用于执行与Redis相关的操作
     */
    @Bean
    public RedisUtils redisUtils() {
        return new RedisUtils();
    }
}

