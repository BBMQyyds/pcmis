package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 短信验证码实体类
 * 该类用于表示短信验证码的相关信息，包括验证码的ID、手机号、验证码值、业务类型、过期时间和创建时间
 */
@Data
@TableName("sms_code")
public class SmsCodeEntity {
    /**
     * 主键ID
     * 使用自动增长策略生成ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 手机号
     * 存储接收验证码的手机号码
     */
    private String mobile;

    /**
     * 验证码
     * 存储生成的验证码值
     */
    private String code;

    /**
     * 业务类型
     * 用于区分验证码的用途或所属业务线
     */
    private String bizType;

    /**
     * 过期时间
     * 存储验证码的过期时间，用于验证验证码是否有效
     */
    private LocalDateTime expireTime;

    /**
     * 创建时间
     * 记录验证码的创建时间，用于审计和追踪
     */
    private LocalDateTime createTime;
}

