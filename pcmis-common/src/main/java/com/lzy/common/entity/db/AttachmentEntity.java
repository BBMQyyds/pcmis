package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
/**
 * 文件实体类
 * 该类用于表示和操作文件相关信息，映射到数据库中的attachment表
 */
@Data
@TableName("attachment")
public class AttachmentEntity {
    /**
     * 文件ID
     * 该字段是数据库中的主键，使用自动增长策略
     */
    @TableId(type = IdType.AUTO)
    private Long fileId;

    /**
     * 业务类型
     * 用于表示文件所属的业务类型，如用户头像、商品图片等
     */
    private String bizType;

    /**
     * 业务ID
     * 用于表示文件所属的具体业务对象的ID
     */
    private Long bizId;

    /**
     * 文件名
     * 存储文件的原始名称
     */
    private String fileName;

    /**
     * 文件路径
     * 存储文件在服务器上的保存路径
     */
    private String filePath;

    /**
     * 文件大小
     * 记录文件的大小，通常以字节为单位
     */
    private Long fileSize;

    /**
     * 上传用户
     * 表示上传文件的用户ID
     */
    private Long uploadUser;

    /**
     * 上传时间
     * 记录文件上传的时间，精确到毫秒
     */
    private LocalDateTime uploadTime;
}


