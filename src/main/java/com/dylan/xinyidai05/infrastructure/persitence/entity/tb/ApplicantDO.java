package com.dylan.xinyidai05.infrastructure.persitence.entity.tb;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Aouthor: yixingheng
 * @name: 投保人
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
@TableName("trade_applicant")
public class ApplicantDO extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    // 投保单号
    private String applicationformNo;
    // 投保人客户号
    private String applicantNo;
    // 系主被保人
    private String relationToMainInsured;

}
