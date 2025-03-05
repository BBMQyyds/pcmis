package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_role")
public class SysRoleEntity {
    @TableId(type = IdType.AUTO)
    private Integer roleId;

    private String roleName;

    private String roleKey;

    private String description;
}

