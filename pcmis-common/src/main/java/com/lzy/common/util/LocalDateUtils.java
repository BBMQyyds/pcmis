package com.lzy.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
public class LocalDateUtils {

    // 日志对象，用于记录日期转换过程中的信息
    private static final Logger log = LoggerFactory.getLogger(LocalDateUtils.class);

    // 私有构造函数，防止外部实例化该类
    private LocalDateUtils() {
        // 防止反射机制实例化
        throw new UnsupportedOperationException("这是一个工具类，禁止实例化！");
    }

    /**
     * 将Date对象转换为指定格式的字符串
     *
     * @param date    待转换的Date对象
     * @param pattern 日期格式模式
     * @return 转换后的日期字符串，如果输入为null则返回null
     */
    public static String dateToString(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 将日期字符串转换为Date对象
     *
     * @param dateStr 日期字符串
     * @param pattern 日期格式模式
     * @return 转换后的Date对象，如果输入为空字符串或null则返回null
     */
    public static Date stringToDate(String dateStr, String pattern) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateStr);
        } catch (Exception e) {
            // 记录日期转换过程中的异常信息
            log.error("日期转换异常", e);
        }
        return null;
    }
}

