package com.lzy.common.exception;
/**
 * 自定义异常类，用于处理缓存为空的情况
 * 当尝试访问或操作一个空缓存时，该异常会被抛出
 */
public class NullCacheException extends Exception {
    // 记录引发异常的缓存名称
    private final String cacheName;

    /**
     * 构造函数，用于创建没有详细消息的异常对象
     *
     * @param cacheName 缓存名称，用于标识发生异常的缓存
     */
    public NullCacheException(String cacheName) {
        super("Cache '" + cacheName + "' is null.");
        this.cacheName = cacheName;
    }

    /**
     * 构造函数，用于创建带有详细消息的异常对象
     *
     * @param cacheName 缓存名称，用于标识发生异常的缓存
     * @param message   详细消息，提供更多关于异常原因的信息
     */
    public NullCacheException(String cacheName, String message) {
        super("Cache '" + cacheName + "' is null. " + message);
        this.cacheName = cacheName;
    }

    /**
     * 构造函数，用于创建带有详细消息和原因的异常对象
     *
     * @param cacheName 缓存名称，用于标识发生异常的缓存
     * @param message   详细消息，提供更多关于异常原因的信息
     * @param cause     异常的原因，通常是一个底层异常
     */
    public NullCacheException(String cacheName, String message, Throwable cause) {
        super("Cache '" + cacheName + "' is null. " + message, cause);
        this.cacheName = cacheName;
    }

    /**
     * 构造函数，用于创建带有原因的异常对象
     *
     * @param cacheName 缓存名称，用于标识发生异常的缓存
     * @param cause     异常的原因，通常是一个底层异常
     */
    public NullCacheException(String cacheName, Throwable cause) {
        super("Cache '" + cacheName + "' is null.", cause);
        this.cacheName = cacheName;
    }

    /**
     * 获取引发异常的缓存名称
     *
     * @return 缓存名称
     */
    public String getCacheName() {
        return cacheName;
    }
}
