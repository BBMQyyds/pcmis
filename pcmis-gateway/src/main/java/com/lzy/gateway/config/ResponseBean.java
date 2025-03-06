package com.lzy.gateway.config;

import lombok.Getter;
import lombok.Setter;
// ResponseBean.java
@Setter
@Getter
/**
 * ResponseBean类用于封装响应信息，包括响应码和响应消息
 * 它可以被用作API响应的统一格式，使得响应信息的管理和解析更为方便
 */
public class ResponseBean {
    // Getters and Setters
    /**
     * 响应码，用于标识响应的状态
     */
    private String code;
    /**
     * 响应消息，提供更详细的响应信息
     */
    private String message;

    // Constructor, getters and setters
    /**
     * 构造一个新的ResponseBean实例
     *
     * @param code   响应码
     * @param message 响应消息
     */
    public ResponseBean(String code, String message) {
        this.code = code;
        this.message = message;
    }

}

