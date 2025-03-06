package com.lzy.common.config.caffeine;

/**
 * 缓存过期时间常量类
 * 提供各种资源的缓存过期时间常量，用于统一管理缓存策略
 */
public class CacheExpire {
    // 用户缓存过期时间，12小时
    public static final long USER_CACHE_EXPIRE = 60 * 60 * 12;// 12小时

    // 用例缓存过期时间，6小时
    public static final long CASE_CACHE_EXPIRE = 60 * 60 * 6;// 6小时

    // 项目缓存过期时间，6小时
    public static final long PROJECT_CACHE_EXPIRE = 60 * 60 * 6;// 6小时

    // 风险缓存过期时间，6小时
    public static final long RISK_CACHE_EXPIRE = 60 * 60 * 6;// 6小时

    // 安全缓存过期时间，6小时
    public static final long SECURITY_CACHE_EXPIRE = 60 * 60 * 6;// 6小时

    // 可视化缓存过期时间，6小时
    public static final long VISUAL_CACHE_EXPIRE = 60 * 60 * 6;// 6小时

    // 文件缓存过期时间，24小时
    public static final long FILE_CACHE_EXPIRE = 60 * 60 * 24;// 24小时
}
