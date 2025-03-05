package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("attachment")
public class AttachmentEntity {
    @TableId(type = IdType.AUTO)
    private Long fileId;

    private String bizType;

    private Long bizId;

    private String fileName;

    private String filePath;

    private Long fileSize;

    private Long uploadUser;

    private LocalDateTime uploadTime;
}


