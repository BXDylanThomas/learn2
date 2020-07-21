package com.dylan.xinyidai05.domain.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dylan.xinyidai05.domain.common.Entity;
import com.dylan.xinyidai05.domain.tb.contract.info.ProductDutyInfo;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Aouthor: yixingheng
 * @name: 产品
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
@Builder
public class Product extends Entity {

    private Long productId;
    // 投保单号
    private String applicationformNo;
    // 被保人客户号
    private String insuredNo;
    // 产品编码
    private String productCode;
    // 险种名称
    private String productName;
    // 是否为主险
    private String isMainCoverage;
    //是否豁免
    private String waiverFlag;
    // 产品类型
    private String productType;
    // 产品类别
    private String  productPeriod;
    // 主险编码
    private String mainProductCode;
    // 自动续保标识
    private String autoRenewalType;
    // 保额
    private BigDecimal basicSumInsured;
    // 标准保费
    private BigDecimal premium;
    // 总保费
    private BigDecimal sumPremium;
    // 保险年期
    private String policyPeriod;
    // 保险年期单位
    private String policyPeriodType;
    // 产品份数
    private Integer copies;
    // 产品档次
    private String grade;
    // 交费间隔
    private String premiumPaymentType;
    // 交费年期
    private String premiumPaymentPeriod;
    // 交费年期单位
    private String premiumPaymentPeriodType;

    // 年金领取频率
    private String annuityDrawingFrequency;
    // 年金领取期限
    private String annuityDrawingPeriod;
    // 年金领取方式
    private String annuityDrawingType;
    // 年金开始领取年龄
    private Date annuityDrawingStartdate;
    //年金类型(平准、递增)
    private String getKind;

    // 红利领取方式
    private String dividendOptionType;
    // 养老金领取频率
    private String guarantAnnuityDrawingFrequency;
    // 养老金领取方式
    private String guarantAnnuityDrawingMode;
    // 养老金领取年龄
    private Integer guarantAnnuityDrawingAge;
    // 浮动费率
    private BigDecimal premiumRateAdjustment;
    // 是否法定受益人
    private String isLegalBeneficiary;

    // 特别约定内容
    private String specialAgreement;
    // 起领期间
    private String getYear;
    // 起领期间单位
    private String getYearFlag;
    // 给付方法
    private String getDutyKind;
    //生存金领取方式
    private String liveGetMode;

    // 核保结论
    private String uwFlag;
    // 核保日期
    private Date uwDate;
    // 核保时间
    private String uwTime;
    // 最终核保人编码
    private String uwCode;

    //产品信息
    private ProductDes productDesInfo;
    //责任信息
    private ProductDutyInfo productDutyInfo;

}
