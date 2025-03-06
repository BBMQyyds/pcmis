package com.lzy.common.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 工资支付实体类
 * 该类用于映射工资支付相关的数据，便于在数据库和程序之间进行数据交互
 */
@Data
@TableName("wage_payment")
public class WagePaymentEntity {
    /**
     * 支付ID
     * 该字段是工资支付记录的唯一标识，使用自动增长策略
     */
    @TableId(type = IdType.AUTO)
    private Long paymentId;

    /**
     * 项目ID
     * 该字段用于标识工资支付所属的项目
     */
    private Long projectId;

    /**
     * 工人姓名
     * 该字段记录了工人的姓名
     */
    private String workerName;

    /**
     * 身份证号
     * 该字段记录了工人的身份证号码，用于身份验证或信息核对
     */
    private String idCard;

    /**
     * 支付金额
     * 该字段记录了本次支付的工资金额
     */
    private BigDecimal paymentAmount;

    /**
     * 支付日期
     * 该字段记录了工资支付的具体日期和时间
     */
    private LocalDateTime paymentDate;

    /**
     * 支付方式
     * 该字段描述了工资的支付方式，例如现金、银行转账等
     */
    private String paymentMethod;

    /**
     * 支付证明
     * 该字段记录了支付证明的ID或编号，用于追踪支付的证据
     */
    private Long paymentProof;
}


