package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
/**
 * 案件实体类
 * 该类映射数据库中的_case表，用于处理与案件相关的数据和操作
 */
@Data
@TableName("_case")
public class CaseEntity {
    /**
     * 案件ID
     * 该字段是数据库表中的主键，使用自动增长策略
     */
    @TableId(type = IdType.AUTO)
    private Long caseId;

    /**
     * 项目ID
     * 该字段表示案件所属的项目，关联到项目表
     */
    private Long projectId;

    /**
     * 投诉时间
     * 记录案件中投诉发生的时间
     */
    private LocalDateTime complainTime;

    /**
     * 投诉人
     * 记录案件中的投诉人信息
     */
    private String complainant;

    /**
     * 投诉金额
     * 记录案件中的投诉涉及金额
     */
    private BigDecimal complainAmount;

    /**
     * 投诉人数
     * 记录案件中的投诉人数
     */
    private Integer complainPeopleNum;

    /**
     * 被诉人
     * 记录案件中的被诉人信息
     */
    private String respondent;

    /**
     * 案件类型
     * 记录案件的类型，如民事、刑事等
     */
    private String caseType;

    /**
     * 当前状态
     * 记录案件的当前状态，如进行中、已结案等
     */
    private String currentStatus;

    /**
     * 处理人ID
     * 该字段表示负责处理案件的人员，关联到用户表
     */
    private Long handlerId;

    /**
     * 解决金额
     * 记录案件解决后的金额，可能与投诉金额不同
     */
    private BigDecimal resolveAmount;

    /**
     * 解决人数
     * 记录案件解决时涉及的人数，可能与投诉人数不同
     */
    private Integer resolvePeopleNum;

    /**
     * 创建时间
     * 记录案件记录创建的时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     * 记录案件记录最后更新的时间
     */
    private LocalDateTime updateTime;

}
