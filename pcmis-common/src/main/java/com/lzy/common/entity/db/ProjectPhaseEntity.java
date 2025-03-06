package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 项目阶段实体类
 * 该类映射到"project_phase"表，用于表示项目的一个阶段，包括阶段ID、项目ID、阶段类型、开始日期、结束日期和阶段状态
 */
@Data
@TableName("project_phase")
public class ProjectPhaseEntity {
    /**
     * 阶段ID
     * 该字段是表的主键，使用自动增长策略生成ID
     */
    @TableId(type = IdType.AUTO)
    private Long phaseId;

    /**
     * 项目ID
     * 该字段表示所属项目的ID，用于关联项目信息
     */
    private Long projectId;

    /**
     * 阶段类型
     * 该字段描述了项目阶段的类型，例如设计、开发、测试等
     */
    private String phaseType;

    /**
     * 开始日期
     * 该字段记录了项目阶段的开始日期和时间
     */
    private LocalDateTime startDate;

    /**
     * 结束日期
     * 该字段记录了项目阶段的结束日期和时间
     */
    private LocalDateTime endDate;

    /**
     * 阶段状态
     * 该字段表示项目阶段的当前状态，例如进行中、已完成、已暂停等
     */
    private String phaseStatus;
}


