package com.lzy.common.config.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 存储属性类，用于存储S3存储的相关属性
 */
@Data
@Component
@ConfigurationProperties(prefix = "s3")
public class StorageProperty {
    /**
     * S3存储服务的URL
     */
    private String url;
    /**
     * 访问S3存储服务的密钥ID
     */
    private String accessKey;
    /**
     * 访问S3存储服务的密钥
     */
    private String secretKey;
    // 原代码中这两个属性被注释掉了，可能是暂时不需要或者为了避免编译错误
//    private long callTimeOut = 60000;
//    private long readTimeOut = 300000;
}

