package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("case_evidence")
public class CaseEvidenceEntity {
    @TableId(type = IdType.AUTO)
    private Long evidenceId;

    private Long caseId;

    private String evidenceType;

    private String description;
}
