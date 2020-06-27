package com.dylan.xinyidai05.domain.util;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:40
 */
public class BeanCopyUtils {

	public static Object copy(Object source,Class target){
		if (target == null){
			//todo
		}
		Object obj = null;
		try {
			obj = target.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		BeanUtils.copyProperties(source,obj);
		return obj;
	}

	public static Object copy(Object source, Object target){
		BeanUtils.copyProperties(source,target);
		return target;
	}
}
