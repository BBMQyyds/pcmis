package com.lzy.gateway.config;

import lombok.Getter;
import lombok.Setter;

// ResponseBean.java
@Setter
@Getter
public class ResponseBean {
    // Getters and Setters
    private String code;
    private String message;

    // Constructor, getters and setters
    public ResponseBean(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
