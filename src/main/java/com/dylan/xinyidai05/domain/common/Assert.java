package com.dylan.xinyidai05.domain.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/27 1:03
 */
public class Assert {

	public static void isNotBank(Object obj, String msg){
		if (obj == null ){
			throw new RuntimeException(msg);
		}
		if (obj instanceof String){
			if (StringUtils.isBlank((String)obj)){
				throw new RuntimeException(msg);
			}
		}
		if (obj instanceof Collection){
			if (CollectionUtils.isEmpty((Collection<?>) obj)){
				throw new RuntimeException(msg);
			}
		}
		if (obj instanceof Map){
			if (CollectionUtils.isEmpty((Map<?, ?>) obj)){
				throw new RuntimeException(msg);
			}
		}
	}
}
