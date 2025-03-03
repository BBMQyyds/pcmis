package com.lzy.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("wage_payment")
public class WagePaymentEntity {
    @TableId(type = IdType.AUTO)
    private Long paymentId;

    private Long projectId;

    private String workerName;

    private String idCard;

    private BigDecimal paymentAmount;

    private Date paymentDate;

    private String paymentMethod;

    private Long paymentProof;
}

