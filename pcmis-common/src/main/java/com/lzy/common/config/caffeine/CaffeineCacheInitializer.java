package com.lzy.common.config.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.caffeine.CaffeineCache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * CaffeineCache初始化器
 * 该类负责初始化和配置Caffeine缓存，以满足不同场景下的缓存需求
 */
public class CaffeineCacheInitializer {

    /**
     * 初始化Caffeine缓存列表
     * 根据不同的缓存需求，创建并配置多个Caffeine缓存，然后添加到列表中
     *
     * @return List<CaffeineCache> 初始化后的Caffeine缓存列表
     */
    public static List<CaffeineCache> initCaffeineCache() {
        List<CaffeineCache> caffeineCacheList = new ArrayList<>();

        // 用户缓存，配置较小的初始容量和最大容量，以及较短的过期时间
        CaffeineCache userCache = new CaffeineCache(CacheKey.USER_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.USER_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(10)
                .maximumSize(100)
                .build());
        caffeineCacheList.add(userCache);

        // 用例缓存，配置适中的初始容量和最大容量，以及适当的过期时间
        CaffeineCache caseCache = new CaffeineCache(CacheKey.CASE_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.CASE_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(50)
                .maximumSize(250)
                .build());
        caffeineCacheList.add(caseCache);

        // 项目缓存，配置较大的初始容量和最大容量，以适应更多数据的缓存需求
        CaffeineCache projectCache = new CaffeineCache(CacheKey.PROJECT_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.PROJECT_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(250)
                .maximumSize(1250)
                .build());
        caffeineCacheList.add(projectCache);

        // 风险缓存，配置较大的初始容量和最大容量，以及较长的过期时间
        CaffeineCache riskCache = new CaffeineCache(CacheKey.RISK_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.RISK_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(500)
                .maximumSize(1000)
                .build());
        caffeineCacheList.add(riskCache);

        // 安全缓存，配置很大的初始容量和最大容量，以应对大量的安全相关数据
        CaffeineCache securityCache = new CaffeineCache(CacheKey.SECURITY_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.SECURITY_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(1000)
                .maximumSize(2000)
                .build());
        caffeineCacheList.add(securityCache);

        // 可视化缓存，配置适中的初始容量和最大容量，用于缓存可视化相关的数据
        CaffeineCache visualCache = new CaffeineCache(CacheKey.VISUAL_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.VISUAL_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(100)
                .maximumSize(500)
                .build());
        caffeineCacheList.add(visualCache);

        // 文件缓存，配置与可视化缓存相似的容量，用于缓存文件相关的数据
        CaffeineCache fileCache = new CaffeineCache(CacheKey.FILE_CACHE_KEY, Caffeine.newBuilder().recordStats()
                .expireAfterWrite(CacheExpire.FILE_CACHE_EXPIRE, TimeUnit.SECONDS)
                .initialCapacity(100)
                .maximumSize(500)
                .build());
        caffeineCacheList.add(fileCache);

        // 返回初始化后的Caffeine缓存列表
        return caffeineCacheList;
    }
}
