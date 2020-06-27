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
 * @name: 客户
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
@Builder
@TableName("trade_person")
public class PersonDO extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    // 投保单号
    private String applicationformNo;
    // 客户版本号
    private String customerVersion;
    // 客户号
    private String customerNo;
    // 姓名
    private String name;
    // 性别
    private String sex;
    // 出生日期
    private Date birthDate;
    // 证件类型代码
    private String certificateType;
    // 证件号码
    private String certificateNo;
    // 有效期至
    private String expireDate;
    // 国籍
    private String country;
    // 婚姻状况
    private String marriageStatus;
    // 身高
    private BigDecimal height;
    // 体重
    private BigDecimal weight;
    // 工作单位
    private String employmentOrganization;
    // 职业代码
    private String occupationCode;
    // 职业名称
    private String occupationName;
    // 兼职代码
    private String pluralityCode;
    // 兼职名称
    private String pluralityName;
    // 手机
    private String mobliePhone;
    // 固定电话
    private String telePhone;
    // 电子邮箱
    private String email;
    //年收入
    private BigDecimal yearGet;
    //客户风险等级
    private String cusDisRisk;
    // 是否拥有公共医疗、社会医疗保险
    private String socialInsuflag;
    //客户职业风险
    private String cusJobRisk;
    //医疗险职业等级
    private String medicalOccupationType;

}
