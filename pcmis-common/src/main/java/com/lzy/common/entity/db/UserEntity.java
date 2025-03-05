package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("user")
public class UserEntity {
    @TableId(type = IdType.AUTO)
    private Long userId;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private String realName;

    private Integer roleId;

    private String department;

    private String position;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
