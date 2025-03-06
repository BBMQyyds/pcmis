package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 项目公司实体类
 * 该类用于表示项目与公司之间的关联关系，映射到"project_company"数据库表
 */
@Data
@TableName("project_company")
public class ProjectCompanyEntity {
    /**
     * 关联关系的唯一标识符
     * 该字段是数据库表的主键，使用自动增长策略生成ID
     */
    @TableId(type = IdType.AUTO)
    private Long relationId;

    /**
     * 项目ID
     * 该字段用于表示与公司相关联的项目的唯一标识符
     */
    private Long projectId;

    /**
     * 公司类型
     * 该字段用于表示公司在项目中的角色或类型（例如：合作方、供应商等）
     */
    private String companyType;

    /**
     * 公司名称
     * 该字段用于表示与项目相关联的公司的名称
     */
    private String companyName;

    /**
     * 联系人
     * 该字段用于表示公司的主要联系人的姓名
     */
    private String contactPerson;

    /**
     * 联系电话
     * 该字段用于表示公司的主要联系人的联系电话
     */
    private String contactPhone;
}


