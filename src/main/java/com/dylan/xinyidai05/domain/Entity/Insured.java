package com.dylan.xinyidai05.domain.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dylan.xinyidai05.domain.common.Entity;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Aouthor: yixingheng
 * @name: 被保人
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
public class Insured extends Entity{

    // 投保单号
    private String applicationformNo;
    // 被保人客户号
    private String insuredNo;
    // 系投保人
    private String relationToApplicant;
    // 系主被保人
    private String relationToMainInsured;

    private Person person;
}
