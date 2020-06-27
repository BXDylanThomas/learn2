package com.dylan.xinyidai05.domain.tb.contract.strategy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 22:04
 */
public class PrtnoQueryStrategy extends InfoQuery{

	@Override
	public <T> QueryWrapper<T> queryStrategy(Condition condition, Class<T> clazz) {
		return new QueryWrapper<T>();
	}
}
