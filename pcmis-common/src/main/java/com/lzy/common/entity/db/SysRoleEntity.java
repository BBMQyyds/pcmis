package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 系统角色实体类
 * 该类映射到数据库的sys_role表，用于表示系统中的角色信息
 */
@Data
@TableName("sys_role")
public class SysRoleEntity {
    /**
     * 角色ID
     * 该字段是数据库表的主键，使用自动增长策略生成ID
     */
    @TableId(type = IdType.AUTO)
    private Integer roleId;

    /**
     * 角色名称
     * 该字段用于存储角色的名称，便于用户理解角色的功能和权限
     */
    private String roleName;

    /**
     * 角色键
     * 该字段用于存储角色的唯一标识键，通常用于程序内部或API的调用
     */
    private String roleKey;

    /**
     * 描述
     * 该字段用于存储角色的详细描述信息，可以让用户更全面地了解角色的用途和权限范围
     */
    private String description;
}


