package com.lzy.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("stat_report")
public class StatReportEntity {
    @TableId(type = IdType.AUTO)
    private Long reportId;

    private String reportType;

    private String reportPeriod;

    private String reportData;

    private Date generateTime;

    private Long generatedBy;
}

