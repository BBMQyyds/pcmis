package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 权限实体类
 * 该类用于映射数据库中的sys_permission表，表示系统中的权限信息
 * 使用@Data注解自动生成getter和setter方法，简化编码
 * 使用@TableName注解指定映射的数据库表名
 */
@Data
@TableName("sys_permission")
public class SysPermissionEntity {

    /**
     * 权限ID
     * 使用@TableId注解指定该字段为数据库表的主键
     * 类型为Integer，使用@IdType.AUTO策略自动生成主键值
     */
    @TableId(type = IdType.AUTO)
    private Integer permId;

    /**
     * 权限名称
     * 用于存储权限的名称，便于用户理解权限的功能
     */
    private String permName;

    /**
     * 权限键
     * 用于存储权限的唯一键，通常用于程序中判断权限
     */
    private String permKey;

    /**
     * 菜单图标
     * 用于存储权限对应菜单项的图标地址，美化界面显示
     */
    private String menuIcon;

    /**
     * 组件路径
     * 用于存储权限对应页面或组件的路径，指导前端路由
     */
    private String component;
}


