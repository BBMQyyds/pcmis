package com.lzy.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_log")
public class SysLogEntity {
    @TableId(type = IdType.AUTO)
    private Long logId;

    private Long userId;

    private String module;

    private String operationType;

    private String operationDesc;

    private String ipAddress;

    private Date operationTime;
}
