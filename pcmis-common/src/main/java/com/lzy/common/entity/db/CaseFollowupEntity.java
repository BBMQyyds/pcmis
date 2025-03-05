package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("case_followup")
public class CaseFollowupEntity {
    @TableId(type = IdType.AUTO)
    private Long followId;

    private Long caseId;

    private LocalDateTime visitTime;

    private String visitResult;

    private Long visitorId;
}

