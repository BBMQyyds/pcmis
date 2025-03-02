package com.lzy.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;

import java.math.BigDecimal;
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

    private Date signDate;

    private Date startDate;

    private String status;

    private BigDecimal depositAmount;

    private String depositStatus;

    private String depositType;

    private Integer specialAccount;

    private Long createBy;

    private Date createTime;

    private Date updateTime;
}

