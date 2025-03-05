package com.lzy.common.config.caffeine;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/*
 * 自定义缓存key生成策略
 */
@Component("selfKeyGenerate")
public class SelfKeyGenerate implements KeyGenerator {
    @NotNull
    @Override
    public Object generate(Object target, Method method, @NotNull Object... params) {
        return target.getClass().getSimpleName() + "#" + method.getName() +
                "(" + new Gson().toJson(params) + ")";
    }
}
