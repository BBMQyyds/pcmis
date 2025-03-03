package com.lzy.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("project_company")
public class ProjectCompanyEntity {
    @TableId(type = IdType.AUTO)
    private Long relationId;

    private Long projectId;

    private String companyType;

    private String companyName;

    private String contactPerson;

    private String contactPhone;
}

