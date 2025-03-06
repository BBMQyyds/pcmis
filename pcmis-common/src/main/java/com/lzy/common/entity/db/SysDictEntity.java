package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * 系统字典实体类
 * 用于与数据库表sys_dict进行映射
 */
@Data
@TableName("sys_dict")
public class SysDictEntity {
    /**
     * 字典ID
     * 主键，采用自增策略
     */
    @TableId(type = IdType.AUTO)
    private Integer dictId;

    /**
     * 字典类型
     * 用于区分不同类型的字典数据
     */
    private String dictType;

    /**
     * 字典编码
     * 同一类型字典中的唯一标识
     */
    private String dictCode;

    /**
     * 字典值
     * 字典项的具体值
     */
    private String dictValue;

    /**
     * 排序号
     * 用于字典项的排序显示
     */
    private Integer sortOrder;
}

