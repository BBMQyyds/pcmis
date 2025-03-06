package com.lzy.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.Arrays;

/**
 * redis 配置
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    // 注入redisTemplate
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 配置String类型的RedisTemplate
     * @return 配置好字符串序列化器的RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> stringSerializerRedisTemplate() {
        // 使用StringRedisSerializer来序列化key和value
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        return redisTemplate;
    }

    /**
     * 配置key的序列化方式
     * @return String类型的Redis序列化器
     */
    private RedisSerializer<String> keySerializer() {
        return new StringRedisSerializer();
    }

    /**
     * 配置value的序列化方式
     * @return Object类型的Redis序列化器
     */
    private RedisSerializer<Object> valueSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }

    /**
     * 配置缓存管理器
     * @param redisConnectionFactory Redis连接工厂
     * @return 配置好的缓存管理器
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        //缓存配置对象
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        //设置缓存的默认超时时间：30分钟
        //如果是空值，不缓存
        //设置key序列化器
        //设置value序列化器
        redisCacheConfiguration = redisCacheConfiguration.entryTtl(Duration.ofMinutes(30L))
                .disableCachingNullValues()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer((valueSerializer())));
        //构建缓存管理器
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }

    /**
     * 初始化Redis消息监听器容器
     * @param redisConnectionFactory Redis连接工厂
     * @return 配置好的Redis消息监听器容器
     */
    @Bean
    public RedisMessageListenerContainer initRedisContainer(@Autowired RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        return container;
    }

    /**
     * 配置缓存的key生成策略
     * @return 自定义的key生成器
     */
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        // KeyGenerator用于生成缓存的key，这里使用类名+方法名+参数值的组合
        return (target, method, objects) -> target.getClass().getName() + "." + method.getName() + Arrays.toString(objects);
    }
}
