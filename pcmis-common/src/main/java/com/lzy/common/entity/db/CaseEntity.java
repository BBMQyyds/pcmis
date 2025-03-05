package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("_case")
public class CaseEntity {
    @TableId(type = IdType.AUTO)
    private Long caseId;

    private Long projectId;

    private LocalDateTime complainTime;

    private String complainant;

    private BigDecimal complainAmount;

    private Integer complainPeopleNum;

    private String respondent;

    private String caseType;

    private String currentStatus;

    private Long handlerId;

    private BigDecimal resolveAmount;

    private Integer resolvePeopleNum;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
