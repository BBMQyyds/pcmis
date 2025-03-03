package com.lzy.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_permission")
public class SysPermissionEntity {
    @TableId(type = IdType.AUTO)
    private Integer permId;

    private String permName;

    private String permKey;

    private String menuIcon;

    private String component;
}

