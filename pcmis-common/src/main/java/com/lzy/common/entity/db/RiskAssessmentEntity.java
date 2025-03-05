package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("risk_assessment")
public class RiskAssessmentEntity {
    @TableId(type = IdType.AUTO)
    private Long assessmentId;

    private Long projectId;

    private String riskLevel;

    private LocalDateTime assessmentDate;

    private Long assessmentBy;

    private String riskFactors;

    private String preventiveMeasures;
}

