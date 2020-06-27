package com.dylan.xinyidai05.infrastructure.persitence.entity.tb;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Aouthor: yixingheng
 * @name: 订单
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
@TableName("trade_service_order")
public class ServiceOrderDO extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    // 服务申请ID
    private String transactionNo;
    // 合同ID
    private String contractNo;
    // 投保单号
    private String applicationFormNo;
    // 申请人ID
    private String applyerCustomerNo;
    // 申请人类别
    private String applyerType;
    // 申请时间戳
    private Date applicationTime;
    //所属工作池 0：共享工作池  其他为个人工作池
    private String owner;
    // 申请处理状态
    private String processingStatus;
    // 申请受理机构
    private String acceptanceOrganizationCode;
    // 申请受理时间戳
    private Date acceptanceTime;
    // 申请处理完成时间戳
    private Date finishTime;
    // 最后一次核保通过的日期
    private String lastUnderwriteTime;
    //保单性质
    private String policyNature;
    //核保不通过原因
    private String notParseReason;
    //强制人工核保标志
    private String forceuwFlag;
    //强制人工核保原因
    private String forceuwReason;
    //扫描日期
    private String scanDate;

}
