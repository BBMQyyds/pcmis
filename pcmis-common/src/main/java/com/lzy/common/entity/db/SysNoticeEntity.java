package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 系统公告实体类
 * 该类用于映射数据库中的sys_notice表，表示系统公告的相关信息
 */
@Data
@TableName("sys_notice")
public class SysNoticeEntity {
    /**
     * 公告ID
     * 该字段为主键，值由数据库自动生成
     */
    @TableId(type = IdType.AUTO)
    private Long noticeId;

    /**
     * 公告标题
     * 该字段用于存储公告的标题内容
     */
    private String title;

    /**
     * 公告内容
     * 该字段用于存储公告的具体内容
     */
    private String content;

    /**
     * 发布者ID
     * 该字段用于存储发布该公告的用户ID
     */
    private Long publisherId;

    /**
     * 发布时间
     * 该字段用于存储公告的发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 过期时间
     * 该字段用于存储公告的过期时间
     */
    private LocalDateTime expireTime;
}

