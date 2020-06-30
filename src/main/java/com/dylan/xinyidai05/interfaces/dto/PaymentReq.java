package com.dylan.xinyidai05.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author baoxiang
 * @create 2020-06-28 16:00
 */
public class PaymentReq implements Serializable {
    public interface idView{}
    public interface payCodeView{}
    public interface payCodeAndIdView extends payCodeView{}

    @JsonView(idView.class)
    private Long id;
    // 支付号
    @JsonView(payCodeView.class)
    private String payCode;
    // 收付费流水号

    @JsonView(payCodeAndIdView.class)
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
 