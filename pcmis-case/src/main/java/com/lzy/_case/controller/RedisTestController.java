package com.lzy._case.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RedisTestController类用于测试Redis数据库的操作
 * 该类提供了两个API：一个用于设置Redis中的键值对，另一个用于获取Redis中的值
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController {

    /**
     * 自动注入RedisTemplate，用于操作Redis数据库
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 测试设置Redis中的键值对
     *
     * @param key 键
     * @param value 值
     * @return 总是返回"success"，表示操作成功
     */
    @RequestMapping("/testSet")
    public String testSet(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return "success";
    }

    /**
     * 测试从Redis中获取值
     *
     * @param key 要查询的键
     * @return 返回指定键的值，如果没有找到键，则返回null
     */
    @RequestMapping("/testGet")
    public String testGet(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }
}
