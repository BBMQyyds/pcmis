package com.lzy.common.config.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.caffeine.CaffeineCache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * CaffeineCache初始化器
 */
public class CaffeineCacheInitializer {

    public static List<CaffeineCache> initCaffeineCache() {
        List<CaffeineCache> caffeineCacheList = new ArrayList<>();

        CaffeineCache userCache = new CaffeineCache(CacheKey.USER_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.USER_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(10)
                .maximumSize(100)
                .build());
        caffeineCacheList.add(userCache);

        CaffeineCache caseCache = new CaffeineCache(CacheKey.CASE_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.CASE_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(50)
                .maximumSize(250)
                .build());
        caffeineCacheList.add(caseCache);

        CaffeineCache projectCache = new CaffeineCache(CacheKey.PROJECT_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.PROJECT_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(250)
                .maximumSize(1250)
                .build());
        caffeineCacheList.add(projectCache);

        CaffeineCache riskCache = new CaffeineCache(CacheKey.RISK_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.RISK_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(500)
                .maximumSize(1000)
                .build());
        caffeineCacheList.add(riskCache);

        CaffeineCache securityCache = new CaffeineCache(CacheKey.SECURITY_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.SECURITY_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(1000)
                .maximumSize(2000)
                .build());
        caffeineCacheList.add(securityCache);

        CaffeineCache visualCache = new CaffeineCache(CacheKey.VISUAL_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.VISUAL_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(100)
                .maximumSize(500)
                .build());
        caffeineCacheList.add(visualCache);

        CaffeineCache fileCache = new CaffeineCache(CacheKey.FILE_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.FILE_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(100)
                .maximumSize(500)
                .build());
        caffeineCacheList.add(fileCache);

        return caffeineCacheList;
    }
}