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
 * @name: 收付费
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
@TableName("trade_premium_payment")
public class PaymentPremiumDO extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    // 支付号
    private String payCode;
    // 服务申请单ID
    private String transactionNo;
    // 交费类型
    private String type;
    // 交费次数
    private Integer nums;
    // 交费渠道
    private String channel;
    // 银行编码
    private String bankCode;
    // 银行账号
    private String bankAccno;
    //银行户名
    private String bankAccname;
    //交费币种
    private String currency;
    //交费金额
    private BigDecimal amount;
    // 交费状态
    private String status;
    // 交费到账时间
    private Date payMadeDate;
    //付款账号所在省
    private String bankProvince;
    //付款账号所在市
    private String bankCity;
    //保单所属机构
    private String organizationCode;

}
