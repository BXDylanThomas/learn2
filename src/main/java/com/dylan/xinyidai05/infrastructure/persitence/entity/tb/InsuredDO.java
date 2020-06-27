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
 * @name: 被保人
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
@Builder
@TableName("trade_insured")
public class InsuredDO extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    // 投保单号
    private String applicationformNo;
    // 被保人客户号
    private String insuredNo;
    // 产品套餐
    private String productPackage;
    // 系投保人
    private String relationToApplicant;
    // 系主被保人
    private String relationToMainInsured;
    //客户等级
    private String customerlevel;
}
