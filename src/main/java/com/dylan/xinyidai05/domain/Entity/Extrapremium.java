package com.dylan.xinyidai05.domain.Entity;

import com.dylan.xinyidai05.domain.common.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Aouthor: yixingheng
 * @name: 加费
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
public class Extrapremium extends Entity {

    // 投保单号
    private String applicationformNo;
    // 产品号码
    private Long productId;
    // 加费类型
    private String extraPremiumType;
    // 加费金额
    private BigDecimal extraPremium;
    // 交费计划编码
    private String payPlanCode;
    // 起交日期
    private Date payStartDate;
    // 终交日期
    private Date payEndDate;
    // 交至日期
    private Date payToDate;
    // 交费间隔
    private int payIntv;
    // 加费评点
    private BigDecimal suppRiskScore;
    // 状态
    private String status;
    // 加费指向标记
    private String addFeeDirect;
    // 下发标记
    private String sendFlag;

}
