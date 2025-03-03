package com.lzy.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("project_phase")
public class ProjectPhaseEntity {
    @TableId(type = IdType.AUTO)
    private Long phaseId;

    private Long projectId;

    private String phaseType;

    private Date startDate;

    private Date endDate;

    private String phaseStatus;
}

