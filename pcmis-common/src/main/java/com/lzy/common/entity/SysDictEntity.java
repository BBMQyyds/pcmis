package com.lzy.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_dict")
public class SysDictEntity {
    @TableId(type = IdType.AUTO)
    private Integer dictId;

    private String dictType;

    private String dictCode;

    private String dictValue;

    private Integer sortOrder;
}
