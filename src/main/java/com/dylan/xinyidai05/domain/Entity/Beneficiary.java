package com.dylan.xinyidai05.domain.Entity;

import com.dylan.xinyidai05.domain.common.Entity;
import lombok.Data;

/**
 * @Aouthor: yixingheng
 * @name: 受益人
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
public class Beneficiary extends Entity {

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

    private Person person;

}
