package com.lzy.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalDateUtils {

    private static final Logger log = LoggerFactory.getLogger(LocalDateUtils.class);

    // 私有构造函数，防止外部实例化该类
    private LocalDateUtils() {
        // 防止反射机制实例化
        throw new UnsupportedOperationException("这是一个工具类，禁止实例化！");
    }

    //将日期转换为字符串
    public static String dateToString(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    //将字符串转换为日期
    public static Date stringToDate(String dateStr, String pattern) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateStr);
        } catch (Exception e) {
            log.error("日期转换异常", e);
        }
        return null;
    }
}
