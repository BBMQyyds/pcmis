package com.lzy.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sms_code")
public class SmsCodeEntity {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String mobile;

    private String code;

    private String bizType;

    private Date expireTime;

    private Date createTime;
}

