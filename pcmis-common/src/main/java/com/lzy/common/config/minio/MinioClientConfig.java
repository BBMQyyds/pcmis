package com.lzy.common.config.minio;

import io.minio.BucketExistsArgs;
import io.minio.MinioClient;
import io.minio.messages.Bucket;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
@Configuration
public class MinioClientConfig {

    private static final Logger logger = LoggerFactory.getLogger(MinioClientConfig.class);
    private static MinioClient minioClient;

    @Autowired
    private StorageProperty storageProperty;

    /**
     * 获取Minio客户端
     *
     * @return Minio客户端实例
     */
    public static MinioClient getMinioClient() {
        return minioClient;
    }

    /**
     * 判断Bucket是否存在
     *
     * @param bucketName Bucket名称
     * @return 如果Bucket存在，则返回true；否则返回false
     */
    @SneakyThrows(Exception.class)
    public static boolean bucketExists(String bucketName) {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    /**
     * 获取所有的Bucket
     *
     * @return Bucket列表
     */
    @SneakyThrows(Exception.class)
    public static List<Bucket> getAllBuckets() {
        return minioClient.listBuckets();
    }

    /**
     * 初始化MinioClient
     */
    @PostConstruct
    public void init() {
        try {
            minioClient = MinioClient.builder()
                    .endpoint(storageProperty.getUrl())
                    .credentials(storageProperty.getAccessKey(), storageProperty.getSecretKey())
                    .build();
        } catch (Exception e) {
            logger.error("Exception: ", e);
        }
    }
}