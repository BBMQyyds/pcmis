package com.lzy.common.util;

import java.util.regex.Pattern;

/**
 * 字符串工具类，提供字符串空检查、路径规范化等静态方法
 */
public class StringUtils {

    /**
     * 私有构造函数，防止外部实例化该类
     * 说明：工具类不需要实例化，通过静态方法提供功能
     */
    private StringUtils() {
        // 防止反射机制实例化
        throw new UnsupportedOperationException("这是一个工具类，禁止实例化！");
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str 待检查的字符串
     * @return 如果字符串非空且长度大于0，则返回true；否则返回false
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }

    /**
     * 判断字符串是否为空
     *
     * @param str 待检查的字符串
     * @return 如果字符串为空或长度等于0，则返回true；否则返回false
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * 将带有通配符的路径转换为正则表达式路径
     * 说明：该方法主要用于将路径中的通配符'*'和'?'转换为对应的正则表达式，以便进行更复杂的路径匹配
     *
     * @param path 带有通配符的路径
     * @return 转换后的正则表达式路径
     */
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

    /**
     * 检查请求路径是否匹配配置的无需认证的URL模式
     *
     * @param reqPath 请求路径
     * @param skipAuthUrls 无需认证的URL模式数组
     * @return 如果请求路径匹配到任何一个无需认证的URL模式，则返回true；否则返回false
     */
    public static boolean checkSkipAuthUrls(String reqPath,String[] skipAuthUrls) {
        for (String skipAuthUrl:skipAuthUrls) {
            if(wildcardEquals(skipAuthUrl, reqPath)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用通配符匹配路径和URL模式是否相等
     * 说明：该方法主要用于比较请求路径是否与配置的无需认证的URL模式相匹配，使用了正则表达式进行比较
     *
     * @param skipAuthUrl 无需认证的URL模式
     * @param reqPath 请求路径
     * @return 如果请求路径与URL模式匹配，则返回true；否则返回false
     */
    public static boolean wildcardEquals(String skipAuthUrl, String reqPath) {
        String regPath = getRegPath(skipAuthUrl);
        return Pattern.compile(regPath).matcher(reqPath).matches();
    }

}
