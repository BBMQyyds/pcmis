package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 项目实体类
 * 该类映射到"project"表，用于表示和操作项目相关的数据和信息
 */
@Data
@TableName("project")
public class ProjectEntity {
    /**
     * 项目ID
     * 主键，自动增长，用于唯一标识每个项目
     */
    @TableId(type = IdType.AUTO)
    private Long projectId;

    /**
     * 项目名称
     * 用于记录项目的名称或标题
     */
    private String projectName;

    /**
     * 建设单位
     * 用于记录进行项目建设的单位名称
     */
    private String constructionUnit;

    /**
     * 承包商
     * 用于记录承接项目施工的公司或单位名称
     */
    private String contractor;

    /**
     * 合同价格
     * 用于记录项目合同约定的总金额
     */
    private BigDecimal contractPrice;

    /**
     * 项目地点
     * 用于记录项目实施的具体地理位置
     */
    private String projectLocation;

    /**
     * 签约日期
     * 用于记录项目合同签订的日期和时间
     */
    private LocalDateTime signDate;

    /**
     * 开工日期
     * 用于记录项目实际开始施工的日期和时间
     */
    private LocalDateTime startDate;

    /**
     * 项目状态
     * 用于记录项目当前的状态，如进行中、已完成等
     */
    private String status;

    /**
     * 定金金额
     * 用于记录项目合同中约定的定金金额
     */
    private BigDecimal depositAmount;

    /**
     * 定金状态
     * 用于记录定金的支付状态，如已支付、未支付等
     */
    private String depositStatus;

    /**
     * 定金类型
     * 用于记录定金的具体类型，如现金、支票等
     */
    private String depositType;

    /**
     * 特殊账户标志
     * 用于标识项目是否使用特殊账户进行资金管理
     */
    private Integer specialAccount;

    /**
     * 创建者ID
     * 用于记录创建该项目记录的用户ID
     */
    private Long createBy;

    /**
     * 创建时间
     * 用于记录项目记录创建的日期和时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     * 用于记录项目记录最后更新的日期和时间
     */
    private LocalDateTime updateTime;
}


