package com.dylan.xinyidai05.domain.tb.contract;

import com.dylan.xinyidai05.domain.util.SpringContextUtil;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:07
 */
public abstract class AbstractContInfoFactory implements AbstractContInfo{
	private boolean needProductDuty;

	protected <T> T getBean(Class<T> clazz){
		return SpringContextUtil.getBean(clazz);
	}
}
