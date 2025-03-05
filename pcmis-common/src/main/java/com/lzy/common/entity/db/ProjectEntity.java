package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("project")
public class ProjectEntity {
    @TableId(type = IdType.AUTO)
    private Long projectId;

    private String projectName;

    private String constructionUnit;

    private String contractor;

    private BigDecimal contractPrice;

    private String projectLocation;

    private LocalDateTime signDate;

    private LocalDateTime startDate;

    private String status;

    private BigDecimal depositAmount;

    private String depositStatus;

    private String depositType;

    private Integer specialAccount;

    private Long createBy;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}

