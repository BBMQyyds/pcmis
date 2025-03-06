package com.lzy.common.entity.http;

import com.lzy.common.util.AESUtils;
import lombok.*;

/**
 * HTTP响应实体类，用于封装HTTP请求的响应信息
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponseEntity {
    private int code; // 响应码
    private String data; // 响应数据
    private String message; // 响应消息

    /**
     * 创建一个404响应实体
     *
     * @return 包含404响应码和消息的实体
     */
    public static HttpResponseEntity code404() {
        return new HttpResponseEntity(404, null, AESUtils.encode("请求的资源不存在", AESUtils.KEY));
    }

    /**
     * 创建一个200响应实体
     *
     * @return 包含200响应码和消息的实体
     */
    public static HttpResponseEntity code200() {
        return new HttpResponseEntity(200, null, AESUtils.encode("请求成功", AESUtils.KEY));
    }

    /**
     * 创建一个400响应实体
     *
     * @return 包含400响应码和消息的实体
     */
    public static HttpResponseEntity code400() {
        return new HttpResponseEntity(400, null, AESUtils.encode("请求参数错误", AESUtils.KEY));
    }

    /**
     * 创建一个500响应实体
     *
     * @return 包含500响应码和消息的实体
     */
    public static HttpResponseEntity code500() {
        return new HttpResponseEntity(500, null, AESUtils.encode("服务器内部错误", AESUtils.KEY));
    }

    /**
     * 创建一个401响应实体
     *
     * @return 包含401响应码和消息的实体
     */
    public static HttpResponseEntity code401() {
        return new HttpResponseEntity(401, null, AESUtils.encode("用户未登录或登录已过期", AESUtils.KEY));
    }

    /**
     * 创建一个403响应实体
     *
     * @return 包含403响应码和消息的实体
     */
    public static HttpResponseEntity code403() {
        return new HttpResponseEntity(403, null, AESUtils.encode("用户没有权限", AESUtils.KEY));
    }

    /**
     * 创建一个409响应实体
     *
     * @return 包含409响应码和消息的实体
     */
    public static HttpResponseEntity code409() {
        return new HttpResponseEntity(409, null, AESUtils.encode("请求的资源已存在", AESUtils.KEY));
    }

    /**
     * 创建一个410响应实体
     *
     * @return 包含410响应码和消息的实体
     */
    public static HttpResponseEntity code410() {
        return new HttpResponseEntity(410, null, AESUtils.encode("验证码错误", AESUtils.KEY));
    }

    /**
     * 创建一个429响应实体
     *
     * @return 包含429响应码和消息的实体
     */
    public static HttpResponseEntity code429() {
        return new HttpResponseEntity(429, null, AESUtils.encode("请求过于频繁，接口被限流", AESUtils.KEY));
    }
}
