package com.lzy.gateway.util;

import com.lzy.gateway.config.ResponseBean;

/**
 * The ResponseBeanUtils class is a utility class for creating response beans.
 * Provides a static method to create a ResponseBean object based on an ErrorCode.
 */
public class ResponseBeanUtils {

    /**
     * Creates a ResponseBean object based on the specified error code.
     * This method simplifies the process of creating response beans, making the code more readable and maintainable.
     *
     * @param errorCode The error code, containing the error code and message.
     * @return Returns a ResponseBean object containing the error code and message.
     */
    public static ResponseBean getResponseBean(ErrorCode errorCode) {
        // You can add more logic if needed
        return new ResponseBean(errorCode.getCode(), errorCode.getMessage());
    }
}


