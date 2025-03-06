package com.lzy.gateway.util;

import lombok.Getter;

/**
 * ErrorCode枚举类，用于定义错误代码和错误信息
 */
@Getter
public enum ErrorCode {
    // 定义了一个错误码为10001的错误类型，表示请求的QPS限制错误
    REQUEST_QPS_LIMIT_ERROR("10001", "Request QPS limit exceeded");

    // 错误码
    private final String code;
    // 错误信息
    private final String message;

    // 构造函数，初始化错误码和错误信息
    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

