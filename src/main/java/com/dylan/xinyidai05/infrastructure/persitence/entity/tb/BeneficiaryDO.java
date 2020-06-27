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
 * @name: 受益人
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
@Builder
@TableName("trade_beneficiary")
public class BeneficiaryDO extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    // 产品ID
    private Long productId;
    // 投保单号
    private String applicationformNo;
    // 受益人客户号
    private String beneficiaryNo;
    // 受益人类别
    private String beneficiaryType;
    // 系被保人
    private String relationToInsured;
    // 受益比例
    private Integer benefitPercentage;
    // 受益顺序
    private String beneficiaryOrder;
    // 受益说明
    private String benefitRemark;

}
