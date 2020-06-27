package com.dylan.xinyidai05.infrastructure.persitence.entity.tb;

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
 * @Date :create in 2020/6/25 20:04
 */
@Data
@TableName("trade_person_address")
public class PersonAddressDO extends BaseEntity implements Serializable {

	@TableId(type = IdType.AUTO)
	private Integer id;
	//客户号
	private String customerNo;
	// 地址-省
	private String homeProvince;
	// 地址-市
	private String homeCity;
	// 地址-区/县
	private String homeCounty;
	// 地址-街道
	private String homeStreet;
	// 地址-详细
	private String homeDetailedAddress;
	// 地址-邮编
	private String homeZipcode;
	// 通讯地址-省
	private String postalProvince;
	// 通讯地址-市
	private String postalCity;
	// 通讯地址-区/县
	private String postalCounty;
	// 通讯地址-街道/乡镇
	private String postalStreet;
	// 通讯地址-详细
	private String postalDetailedAddress;
	// 通讯地址-邮编
	private String zipcode;
}
