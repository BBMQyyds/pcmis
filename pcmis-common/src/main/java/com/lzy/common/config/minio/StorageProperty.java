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
    private String url;
    private String accessKey;
    private String secretKey;
//    private long callTimeOut = 60000;
//    private long readTimeOut = 300000;
}
