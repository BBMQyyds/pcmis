package com.lzy.gateway.util;

import lombok.Getter;

// ErrorCode.java
@Getter
public enum ErrorCode {
    REQUEST_QPS_LIMIT_ERROR("10001", "Request QPS limit exceeded");

    private final String code;
    private final String message;

    // Constructor, getters and setters
    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
