package com.lzy.common.config.caffeine;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/*
 * 自定义缓存key生成策略
 * 用于在缓存中生成唯一的键，以便在存储和检索缓存数据时使用
 * 此类实现了KeyGenerator接口，以提供自定义的键生成逻辑
 */
@Component("selfKeyGenerate")
public class SelfKeyGenerate implements KeyGenerator {
    /*
     * 生成缓存键的方法
     * 此方法根据目标类的简单名称、方法名称和参数生成一个唯一的缓存键
     * 它使用Gson将参数序列化为JSON字符串，以确保即使在参数复杂的情况下也能生成唯一的键
     *
     * @param target 目标对象，即正在执行的方法所属的类的实例
     * @param method 正在执行的方法
     * @param params 方法参数
     * @return 生成的缓存键
     */
    @NotNull
    @Override
    public Object generate(Object target, Method method, @NotNull Object... params) {
        // 将目标类的简单名称、方法名称和参数序列化为JSON字符串后拼接起来，作为缓存键
        return target.getClass().getSimpleName() + "#" + method.getName() +
                "(" + new Gson().toJson(params) + ")";
    }
}

