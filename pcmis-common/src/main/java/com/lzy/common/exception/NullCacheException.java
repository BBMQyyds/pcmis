package com.lzy.common.exception;

public class NullCacheException extends Exception {
    private final String cacheName;

    public NullCacheException(String cacheName) {
        super("Cache '" + cacheName + "' is null.");
        this.cacheName = cacheName;
    }

    public NullCacheException(String cacheName, String message) {
        super("Cache '" + cacheName + "' is null. " + message);
        this.cacheName = cacheName;
    }

    public NullCacheException(String cacheName, String message, Throwable cause) {
        super("Cache '" + cacheName + "' is null. " + message, cause);
        this.cacheName = cacheName;
    }

    public NullCacheException(String cacheName, Throwable cause) {
        super("Cache '" + cacheName + "' is null.", cause);
        this.cacheName = cacheName;
    }

    public String getCacheName() {
        return cacheName;
    }
}
