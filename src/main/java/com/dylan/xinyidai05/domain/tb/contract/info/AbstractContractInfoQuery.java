package com.dylan.xinyidai05.domain.tb.contract.info;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.dylan.xinyidai05.domain.common.Assert;
import com.dylan.xinyidai05.domain.common.Entity;
import com.dylan.xinyidai05.domain.common.Exception.BusinessException;
import com.dylan.xinyidai05.domain.tb.contract.strategy.Condition;
import com.dylan.xinyidai05.domain.util.BeanCopyUtils;
import com.dylan.xinyidai05.domain.util.SpringContextUtil;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;


public abstract class AbstractContractInfoQuery<T extends BaseEntity,M> {

	protected Condition condition;

	public abstract M query();

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public void check(){
		Assert.isNotBank(condition.getPrtNo(),"保单信息构建，投保单号不能为空");
	}
	public abstract QueryWrapper<T> getQueryCondition();

	protected Entity transDOToEntity(Object object,Class<? extends Entity> clazz){
		return (Entity) BeanCopyUtils.copy(object, clazz);
	}
	protected Object transDOToEntity(Object object, M target){
		return  BeanCopyUtils.copy(object, target);
	}

	protected <T> T getBean(Class<T> clazz){
		return SpringContextUtil.getBean(clazz);
	}
}
