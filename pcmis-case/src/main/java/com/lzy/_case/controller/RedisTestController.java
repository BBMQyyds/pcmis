package com.lzy._case.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/testSet")
    public String testSet(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return "success";
    }

    @RequestMapping("/testGet")
    public String testGet(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }
}
