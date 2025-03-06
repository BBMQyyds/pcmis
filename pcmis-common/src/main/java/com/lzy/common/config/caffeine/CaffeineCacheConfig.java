package com.lzy.common.config.caffeine;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * CaffeineCache配置类
 * 用于配置Caffeine缓存管理器
 */
@Configuration
@EnableCaching
public class CaffeineCacheConfig {

    /**
     * 创建Caffeine缓存管理器
     *
     * @return CacheManager 缓存管理器实例
     */
    @Bean
    @Primary
    public CacheManager caffeineCacheManager() {
        // 创建缓存管理器实例
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        // 初始化Caffeine缓存列表
        List<CaffeineCache> caches = CaffeineCacheInitializer.initCaffeineCache();
        // 检查缓存列表是否为空，如果为空则直接返回缓存管理器实例
        if (CollectionUtils.isEmpty(caches)) {
            return cacheManager;
        }
        // 设置缓存管理器的缓存列表
        cacheManager.setCaches(caches);
        // 返回缓存管理器实例
        return cacheManager;
    }

}
