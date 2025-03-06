package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 统计报表实体类
 * 该类用于表示统计报表的相关信息，包括报表ID、报表类型、报表周期、报表数据、生成时间和生成者ID
 */
@Data
@TableName("stat_report")
public class StatReportEntity {
    /**
     * 报表ID
     * 该字段是统计报表的唯一标识，使用自动增长策略
     */
    @TableId(type = IdType.AUTO)
    private Long reportId;

    /**
     * 报表类型
     * 该字段表示统计报表的类型，如财务报表、销售报表等
     */
    private String reportType;

    /**
     * 报表周期
     * 该字段表示统计报表的时间周期，如月报、季报、年报等
     */
    private String reportPeriod;

    /**
     * 报表数据
     * 该字段存储统计报表的具体数据，可以是JSON或其他格式的字符串
     */
    private String reportData;

    /**
     * 生成时间
     * 该字段记录统计报表生成的时间，使用LocalDateTime类型以精确到分钟
     */
    private LocalDateTime generateTime;

    /**
     * 生成者ID
     * 该字段表示生成统计报表的用户ID或系统ID
     */
    private Long generatedBy;
}


