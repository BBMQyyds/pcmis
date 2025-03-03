package com.lzy.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_notice")
public class SysNoticeEntity {
    @TableId(type = IdType.AUTO)
    private Long noticeId;

    private String title;

    private String content;

    private Long publisherId;

    private Date publishTime;

    private Date expireTime;
}

