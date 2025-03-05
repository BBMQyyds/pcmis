package com.lzy.common.util;

import java.util.regex.Pattern;

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

    //判断字符串是否为空
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String getRegPath(String path) {
        char[] chars = path.toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        boolean preX = false;
        for (int i = 0; i < len; i++) {
            if (chars[i] == '*') {// 遇到*字符
                if (preX) {// 如果是第二次遇到*，则将**替换成.*
                    sb.append(".*");
                    preX = false;
                } else if (i + 1 == len) {// 如果是遇到单星，且单星是最后一个字符，则直接将*转成[^/]*
                    sb.append("[^/]*");
                } else {// 否则单星后面还有字符，则不做任何动作，下一把再做动作
                    preX = true;
                }
            } else {// 遇到非*字符
                if (preX) {// 如果上一把是*，则先把上一把的*对应的[^/]*添进来
                    sb.append("[^/]*");
                    preX = false;
                }
                if (chars[i] == '?') {// 接着判断当前字符是不是?，是的话替换成.
                    sb.append('.');
                } else {// 不是?的话，则就是普通字符，直接添进来
                    sb.append(chars[i]);
                }
            }
        }
        return sb.toString();
    }

    public static boolean checkSkipAuthUrls(String reqPath,String[] skipAuthUrls) {
        for (String skipAuthUrl:skipAuthUrls) {
            if(wildcardEquals(skipAuthUrl, reqPath)) {
                return true;
            }
        }
        return false;
    }

    public static boolean wildcardEquals(String skipAuthUrl, String reqPath) {
        String regPath = getRegPath(skipAuthUrl);
        return Pattern.compile(regPath).matcher(reqPath).matches();
    }

}
