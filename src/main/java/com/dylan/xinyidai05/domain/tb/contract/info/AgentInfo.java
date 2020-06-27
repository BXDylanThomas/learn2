package com.dylan.xinyidai05.domain.tb.contract.info;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dylan.xinyidai05.domain.Entity.Agent;
import com.dylan.xinyidai05.domain.common.Assert;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.AgentDO;
import com.dylan.xinyidai05.infrastructure.persitence.service.tb.AgentService;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:06
 */
public class AgentInfo extends AbstractContractInfoQuery<AgentDO,Agent> {

	private AgentService agentService;

	public AgentInfo() {
		this.agentService = getBean(AgentService.class);
	}

	@Override
	public Agent query() {
		check();
		AgentDO agentDO = agentService.getOne(new QueryWrapper<>());
		Assert.isNotBank(agentDO,"保单构建，代理人信息为空");
		return (Agent) transDOToEntity(agentDO,Agent.class);
	}

	@Override
	public QueryWrapper<AgentDO> getQueryCondition() {
		QueryWrapper<AgentDO> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(AgentDO::getApplicationformNo,condition.getPrtNo());
		return queryWrapper;
	}

}
