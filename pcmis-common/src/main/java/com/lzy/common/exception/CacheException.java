package com.lzy.common.exception;

/**
 * CacheException类用于缓存操作中异常情况的处理
 * 它继承自RuntimeException，用于表示在缓存操作过程中发生的错误
 * 主要用于在运行时捕获和处理与缓存相关的错误情况
 */
public class CacheException extends RuntimeException {

    /**
     * 构造一个CacheException对象，包含一个简单的错误信息
     *
     * @param message 错误信息，描述缓存异常的情况
     */
    public CacheException(String message) {
        super(message);
    }

    /**
     * 构造一个CacheException对象，包含错误信息和原始异常
     *
     * @param message 错误信息，描述缓存异常的情况
     * @param cause   异常的原因，通常是一个Throwable对象
     */
    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }
}
