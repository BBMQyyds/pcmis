package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 案例处理实体类，用于映射案例处理过程表
 * 该实体类包含了案例处理过程中的关键信息，如处理步骤、处理内容、处理人等
 */
@Data
@TableName("case_process")
public class CaseProcessEntity {
    /**
     * 处理ID，主键，自动增长
     * 用于唯一标识每一个处理步骤
     */
    @TableId(type = IdType.AUTO)
    private Long processId;

    /**
     * 案例ID
     * 用于标识该处理步骤属于哪个案例
     */
    private Long caseId;

    /**
     * 步骤类型
     * 描述了处理步骤的性质或类别
     */
    private String stepType;

    /**
     * 处理内容
     * 记录了该处理步骤的具体内容或描述
     */
    private String content;

    /**
     * 处理人ID
     * 标识执行该处理步骤的人员
     */
    private Long handlerId;

    /**
     * 处理时间
     * 记录了该处理步骤执行的时间
     */
    private LocalDateTime handleTime;

}


