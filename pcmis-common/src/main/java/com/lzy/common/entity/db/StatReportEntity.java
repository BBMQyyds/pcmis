package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("stat_report")
public class StatReportEntity {
    @TableId(type = IdType.AUTO)
    private Long reportId;

    private String reportType;

    private String reportPeriod;

    private String reportData;

    private LocalDateTime generateTime;

    private Long generatedBy;
}

