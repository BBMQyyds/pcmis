package com.lzy.common.util;

public class StringUtils {

    // 私有构造函数，防止外部实例化该类
    private StringUtils() {
        // 防止反射机制实例化
        throw new UnsupportedOperationException("这是一个工具类，禁止实例化！");
    }

    //判断字符串是否不为空
    public static boolean isNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }
}
