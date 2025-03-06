package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户实体类
 * 该类用于映射用户表中的数据，每个字段都对应用户表中的一个列
 */
@Data
@TableName("user")
public class UserEntity {
    /**
     * 用户ID
     * 该字段是用户表的主键，使用自动增长的方式生成ID
     */
    @TableId(type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     * 该字段用于存储用户的用户名
     */
    private String username;

    /**
     * 密码
     * 该字段用于存储用户的密码
     */
    private String password;

    /**
     * 手机号
     * 该字段用于存储用户的手机号码
     */
    private String mobile;

    /**
     * 邮箱
     * 该字段用于存储用户的电子邮件地址
     */
    private String email;

    /**
     * 真实姓名
     * 该字段用于存储用户的真实姓名
     */
    private String realName;

    /**
     * 角色ID
     * 该字段用于存储用户的角色ID，表示用户的角色权限
     */
    private Integer roleId;

    /**
     * 部门
     * 该字段用于存储用户所在的部门
     */
    private String department;

    /**
     * 职位
     * 该字段用于存储用户的职位信息
     */
    private String position;

    /**
     * 创建时间
     * 该字段用于记录用户实体创建的时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     * 该字段用于记录用户实体最后一次更新的时间
     */
    private LocalDateTime updateTime;
}

