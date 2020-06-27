package com.dylan.xinyidai05.domain.common.Exception;

/**
 * code is far away from bug with the animal protecting
 *
 * 业务异常
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 22:23
 */
public class BusinessException extends RuntimeException{
	private String code;
	private String message;

	public BusinessException(String message) {
		super(message);
		this.message = message;
	}

	public BusinessException(String code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

//	public BusinessException(ErrorEnum errorEnum){
//
//	}
}
