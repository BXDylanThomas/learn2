package com.dylan.xinyidai05.infrastructure.persitence.entity.tb;

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
 * @name: 加费
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
@Builder
@TableName("trade_extrapremium")
public class ExtrapremiumDO extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
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
