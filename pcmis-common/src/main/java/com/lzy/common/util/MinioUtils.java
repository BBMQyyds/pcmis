package com.lzy.common.util;

import com.lzy.common.config.minio.MinioClientConfig;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * minio工具类
 * 提供了一系列操作minio的方法，包括上传、下载、压缩等
 */
@Slf4j
@Component
public class MinioUtils {

    // 使用slf4j日志工厂获取日志对象
    private static final Logger logger = LoggerFactory.getLogger(MinioUtils.class);

    /**
     * 上传文件到Minio服务器
     *
     * @param file       要上传的文件
     * @param fileName   文件名
     * @param bucketName 存储桶名称
     * @return 上传成功返回true，上传失败返回false
     */
    public static boolean minioUpload(MultipartFile file, String fileName, String bucketName) {
        try {
            MinioClient minioClient = MinioClientConfig.getMinioClient();
            // 如果fileName为空，则使用源文件名上传
            if (fileName == null) {
                fileName = file.getOriginalFilename();
                if (fileName != null) {
                    fileName = fileName.replaceAll(" ", "_");
                }
            }
            InputStream inputStream = file.getInputStream();
            PutObjectArgs objectArgs = PutObjectArgs.builder().bucket(bucketName).object(fileName)
                    .stream(inputStream, file.getSize(), -1).contentType(file.getContentType()).build();
            // 文件名称相同会覆盖
            minioClient.putObject(objectArgs);
            return true; // 返回true表示上传成功
        } catch (Exception e) {
            logger.error("Exception: ", e);
            return false; // 返回false表示上传失败
        }
    }

    /**
     * 从Minio服务器下载文件
     *
     * @param fileName   文件名
     * @param bucketName 存储桶名称
     * @return 下载的文件内容的字节数组，下载失败返回null
     */
    public static byte[] minioDownload(String fileName, String bucketName) {
        try {
            MinioClient minioClient = MinioClientConfig.getMinioClient();
            InputStream inputStream = minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .build()
            );
            // 使用 ByteArrayOutputStream 读取输入流数据
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            // 获取读取的字节数组
            byte[] bytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bytes;
        } catch (Exception e) {
            logger.error("Exception: ", e);
            return null;
        }
    }

    /**
     * 指定大小进行缩放
     *
     * @param bytes     图片文件二进制流
     * @param imageType 图片类型
     * @param quality   图片质量
     * @return 缩放后的图片文件二进制流
     */
    public static byte[] compressImage(byte[] bytes, int width, int height, String imageType, float quality) {
        InputStream in = null;
        ByteArrayOutputStream bout = null;
        try {
            in = new ByteArrayInputStream(bytes);
            bout = new ByteArrayOutputStream(1024);

            // 图片尺寸不变，压缩图片文件大小outputQuality实现，参数1为最高质量
            Thumbnails.of(in).forceSize(width, height).outputQuality(quality).outputFormat(imageType).toOutputStream(bout);

            return bout.toByteArray();
        } catch (Exception ex) {
            logger.error("Exception: ", ex);
            throw new RuntimeException(ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (bout != null) {
                    bout.close();
                }
            } catch (Exception ex) {
                logger.error("Exception: ", ex);
            }
        }
    }
}