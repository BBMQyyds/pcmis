package com.lzy.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;

import java.util.Date;

@Data
@TableName("case_process")
public class CaseProcessEntity {
    @TableId(type = IdType.AUTO)
    private Long processId;

    private Long caseId;

    private String stepType;

    private String content;

    private Long handlerId;

    private Date handleTime;

}

