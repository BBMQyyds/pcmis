package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 系统日志实体类
 * 该类用于表示系统日志的实体，记录了用户操作的相关信息
 */
@Data
@TableName("sys_log")
public class SysLogEntity {
    /**
     * 日志ID
     * 该字段是系统日志的唯一标识，使用自动增长策略
     */
    @TableId(type = IdType.AUTO)
    private Long logId;

    /**
     * 用户ID
     * 该字段表示执行操作的用户标识
     */
    private Long userId;

    /**
     * 模块名称
     * 该字段记录了操作涉及的系统模块
     */
    private String module;

    /**
     * 操作类型
     * 该字段描述了具体的操作类型，例如添加、删除等
     */
    private String operationType;

    /**
     * 操作描述
     * 该字段是对操作的详细描述，用于记录操作的内容和目的
     */
    private String operationDesc;

    /**
     * IP地址
     * 该字段记录了执行操作的用户IP地址
     */
    private String ipAddress;

    /**
     * 操作时间
     * 该字段表示操作的具体时间，使用LocalDateTime类型精确记录时间
     */
    private LocalDateTime operationTime;
}

