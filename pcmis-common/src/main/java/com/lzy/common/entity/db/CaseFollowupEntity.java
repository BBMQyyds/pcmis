package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 病例随访实体类
 * 该类用于映射病例随访记录表，记录了随访的相关信息
 */
@Data
@TableName("case_followup")
public class CaseFollowupEntity {
    /**
     * 随访记录ID
     * 该字段是表的主键，使用自动增长策略
     */
    @TableId(type = IdType.AUTO)
    private Long followId;

    /**
     * 病例ID
     * 该字段关联病例信息，标识是哪个病例的随访记录
     */
    private Long caseId;

    /**
     * 随访时间
     * 记录随访的具体时间，使用LocalDateTime类型精确到分钟
     */
    private LocalDateTime visitTime;

    /**
     * 随访结果
     * 该字段记录了随访的结果，以字符串形式存储
     */
    private String visitResult;

    /**
     * 随访人ID
     * 该字段标识进行随访的人员，通过ID进行关联
     */
    private Long visitorId;
}


