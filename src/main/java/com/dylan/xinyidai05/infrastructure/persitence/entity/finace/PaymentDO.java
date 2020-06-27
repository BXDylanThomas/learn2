package com.dylan.xinyidai05.infrastructure.persitence.entity.finace;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Aouthor: yixingheng
 * @name: 收付费轨迹
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
@TableName("trade_payment")
public class PaymentDO extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    // 支付号
    private String payCode;
    // 收付费流水号
    private String serialNo;
    // 收付费类型
    private String type;
    // 收付费渠道
    private String channel;
    // 银行编码
    private String bankCode;
    // 银行账号
    private String bankAccNo;
    // 银行户名
    private String bankAccName;
    // 金额
    private BigDecimal amount;
    // 状态
    private String status;
    // 失败原因
    private String failReason;
}
