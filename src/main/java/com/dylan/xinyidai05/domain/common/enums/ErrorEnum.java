package com.dylan.xinyidai05.domain.common.enums;

import com.dylan.xinyidai05.domain.common.Exception.BusinessException;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 22:26
 */
public enum  ErrorEnum {
	//
	PRTNO_NOT_NULL("E0001","投保单号不能为空"),
	CONTNO_NOT_NULL("E0001","投保单号不能为空");

	private String code;
	private String message;

	ErrorEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public ErrorEnum getCode(String code){
		for (ErrorEnum value : values()) {
			if (value.code == code){
				return value;
			}
		}
		throw new BusinessException("ErrorEnum 中 code="+code +"没有这个枚举");
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
