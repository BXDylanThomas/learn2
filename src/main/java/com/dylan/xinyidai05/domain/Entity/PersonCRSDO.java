package com.dylan.xinyidai05.domain.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/25 20:03
 */
@Data
@TableName("trade_person_crs")
public class PersonCRSDO extends BaseEntity implements Serializable {

	@TableId(type = IdType.AUTO)
	private Integer id;
	//客户号
	private String customerNo;
	// 客户CRS版本号
	private String customerCrsVerson;
	// CRS个人税收身份标识
	private String crsType;
	// CRS姓
	private String crsSurname;
	// CRS名
	private String crsName;
	// CRS现居住地址(境内) 省
	private String crsProvince;
	// CRS现居住地址(境内) 市
	private String crsCity;
	// CRS现居住地址(境内) 区/县
	private String crsCounty;
	// CRS现居住地址(境内) 小区街道
	private String crsCommunity;
	// CRS现居住地址(境内) 通讯地址
	private String crsPostalAddress;
	// CRS出生地（境内） 省
	private String crsBirthProvince;
	// CRS出生地（境内） 市
	private String crsBirthCity;
	// CRS出生地（境内）详细地址
	private String crsBirthPlace;
	// CRS出生地（境内）区
	private String crsBirthCounty;
	// CRS出生地（境外） 国家
	private String crsBirthForeignCountry;
	// CRS出生地（境外）
	private String crsBirthForeignAddress;
	// CRS现居住地址（境外） 国家
	private String crsForeignCountry;
	// CRS现居住地址（境外）
	private String crsForeignAddress;
	// CRS居民税收国
	private String crsResidentTaxCountry;
	// CRS纳税人税收号
	private String crsTaxno;
	// 无法提供税收号原因代码
	private String notaxReasonCode;
	// 无法提供税收号原因
	private String notaxReason;

}
