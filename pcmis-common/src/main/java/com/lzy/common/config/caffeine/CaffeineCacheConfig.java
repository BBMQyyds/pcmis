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
 */
@Configuration
@EnableCaching
public class CaffeineCacheConfig {

    @Bean
    @Primary
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<CaffeineCache> caches = CaffeineCacheInitializer.initCaffeineCache();
        if (CollectionUtils.isEmpty(caches)) {
            return cacheManager;
        }
        cacheManager.setCaches(caches);
        return cacheManager;
    }

}
