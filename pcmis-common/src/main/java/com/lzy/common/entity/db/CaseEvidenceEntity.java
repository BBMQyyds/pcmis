package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * 案件证据实体类
 * 该类用于映射案件证据相关的数据，连接案件和证据信息
 */
@Data
@TableName("case_evidence")
public class CaseEvidenceEntity {
    /**
     * 证据ID
     * 该字段为主键，自动增长，用于唯一标识每条证据记录
     */
    @TableId(type = IdType.AUTO)
    private Long evidenceId;

    /**
     * 案件ID
     * 该字段用于标识证据所属的案件
     */
    private Long caseId;

    /**
     * 证据类型
     * 该字段描述了证据的种类，如物证、书证等
     */
    private String evidenceType;

    /**
     * 证据描述
     * 该字段对证据的具体内容或特征进行描述，以便于理解和识别证据
     */
    private String description;
}
