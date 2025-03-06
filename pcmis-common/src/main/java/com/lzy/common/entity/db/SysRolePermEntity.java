package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 角色权限实体类
 * 该类用于表示系统中的角色与权限之间的关系，每个实例代表一个角色拥有的特定权限
 * 在数据库中，该类对应于sys_role_perm表，通过roleId和permId来记录角色和权限的关联
 */
@Data
@TableName("sys_role_perm")
public class SysRolePermEntity {
    /**
     * 角色ID
     * 该字段用于标识角色在系统中的唯一ID，与sys_role表中的角色ID相对应
     */
    private Integer roleId;

    /**
     * 权限ID
     * 该字段用于标识权限在系统中的唯一ID，与sys_perm表中的权限ID相对应
     */
    private Integer permId;
}

