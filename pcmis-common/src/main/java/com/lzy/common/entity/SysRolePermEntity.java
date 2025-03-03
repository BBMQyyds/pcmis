package com.lzy.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_role_perm")
public class SysRolePermEntity {
    private Integer roleId;

    private Integer permId;
}

