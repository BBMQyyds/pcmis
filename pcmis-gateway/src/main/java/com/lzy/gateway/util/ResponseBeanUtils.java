package com.lzy.gateway.util;

import com.lzy.gateway.config.ResponseBean;

// ResponseBeanUtils.java
public class ResponseBeanUtils {
    public static ResponseBean getResponseBean(ErrorCode errorCode) {
        // You can add more logic if needed
        return new ResponseBean(errorCode.getCode(), errorCode.getMessage());
    }
}

