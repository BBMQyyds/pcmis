package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 风险评估实体类
 * 该类用于映射风险评估相关的数据，与数据库中的风险评估表对应
 */
@Data
@TableName("risk_assessment")
public class RiskAssessmentEntity {
    /**
     * 评估ID
     * 该字段是风险评估表的主键，用于唯一标识一条风险评估记录
     */
    @TableId(type = IdType.AUTO)
    private Long assessmentId;

    /**
     * 项目ID
     * 该字段用于标识风险评估所属的项目，与项目管理表中的项目ID对应
     */
    private Long projectId;

    /**
     * 风险等级
     * 该字段用于描述项目当前的风险等级，例如高、中、低等
     */
    private String riskLevel;

    /**
     * 评估日期
     * 该字段记录了风险评估的日期和时间
     */
    private LocalDateTime assessmentDate;

    /**
     * 评估人ID
     * 该字段标识了进行风险评估的人员，通常与用户管理表中的用户ID对应
     */
    private Long assessmentBy;

    /**
     * 风险因素
     * 该字段详细描述了项目中可能存在的风险因素
     */
    private String riskFactors;

    /**
     * 预防措施
     * 该字段描述了针对已识别风险所采取的预防措施
     */
    private String preventiveMeasures;
}


