package com.dylan.xinyidai05.domain.Entity;

import com.dylan.xinyidai05.domain.common.Entity;
import lombok.Data;

import java.util.Date;

/**
 * @Aouthor: yixingheng
 * @name: 投保单
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
public class ApplicationForm extends Entity {

    // 服务申请ID
    private String transactionNo;
    // 投保单号
    private String applicationformNo;
    // 投保单类型
    private String type;
    // 机构编码
    private String organizationCode;
    // 销售渠道
    private String distribchnlCode;
    // 投保申请日期
    private Date applyDate;
    // 投保申请时间
    private String applyTime;
    // 签单日期
    private Date signDate;
    // 签单时间
    private String signTime;
    // 保单生效日期
    private Date effectiveDate;
    // 保单生效时间
    private String effectiveTime;
    // 续期缴费方式
    private String renewalPaymentType;
    // 续期银行编码
    private String renewalBankCode;
    // 银行网点
    private String bankoutlets;
    // 续期银行账号
    private String renewalBankAccno;
    // 续期银行账户名
    private String renewalBankAccname;
    // 溢交处理方式
    private String outPayType;
    // 特别约定内容
    private String specialAgreement;
    // 是否存在告知标识
    private String isDisclosure;
    // 保单形式
    private String policyType;
    //出单方式
    private String sellType;
    // 自动垫交标识
    private String isAutoLoanPay;
    // 电子签名标识
    private String signatureFlag;
    //备注 //腾讯投连险理财通传入，也用此字段
    private String remark;
    // 单子是否转人工核保 Y是 N否
    private String isManualUnderwriting;

    //------------------------无扫描录入增加字段------------------------------
    //初审员签名
    private String firstInspectorSignature;
    //初审日期
    private Date firstTrialDate;
    //续期交费提示
    private String renewalPayTips;
    //交费形式
    private String paymentMode;
    //账户银行预留手机号
    private String bankAccountPhone;
    //转帐开户行
    private String bankAccountCode;
    //帐户姓名
    private String bankAccountName;
    //银行账号
    private String bankAccountNo;
    //续期账户银行预留手机号
    private String renewalBankAccountPhone;
    //首续期是否一致
    private String firstRenewalConsistencyFlag;
    //续期/续保交费形式
    private String renewalPaymentMode;
    //受益人标识
    private String beneficiarieFlag;
    //续期转帐开户行
    private String renewalBank;
    //自助互保件标识
    private String selfMutualInsuranceFlag;
    //是否银代
    private String isSilverGeneration;
    //首期银行开户行省
    private String bankProvince;
    //首期银行开户行市
    private String bankCity;
    //续期银行开户行省
    private String renewalBankProvince;
    //续期银行开户行市
    private String renewalBankCity;
    // 是否达到反洗钱
    private String antiMoneyFlag;
    //关联投保单号 多个用,号隔开
    private String relationApplicationFormNo;
    // 核保结论
    private String uwFlag;
    // 核保描述
    private String uwResult;
    // 核保日期
    private Date uwDate;
    // 不通过的原因
    private String uwNotParseReason;
    // 核保时间
    private String uwTime;
    // 最终核保人编码
    private String uwCode;
    // 核保人
    private String uwOperator;

    /*********************************保单回执操作新增字段开始*******************************************************************/
    //保单回执日期
    private Date customgetpoldate;
    /*********************************保单回执操作新增字段结束*******************************************************************/


}
