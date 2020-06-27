package com.dylan.xinyidai05.domain.tb.contract.info;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dylan.xinyidai05.domain.Entity.Beneficiary;
import com.dylan.xinyidai05.domain.Entity.Insured;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.InsuredDO;
import com.dylan.xinyidai05.infrastructure.persitence.service.tb.InsuredService;

import java.util.Collections;
import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:06
 */
public class InsuredInfo extends AbstractContractInfoQuery<InsuredDO, List<Insured>> {
	private InsuredService insuredService;
	private PersonInfo personInfo;

	public InsuredInfo() {
		this.insuredService = getBean(InsuredService.class);
		this.personInfo = getBean(PersonInfo.class);
	}

	@Override
	public List<Insured> query() {
		List<InsuredDO> insuredDOList = insuredService.list(getQueryCondition());
		List<Insured> insureds = (List<Insured>) transDOToEntity(insuredDOList, Collections.singletonList(new Insured()));
		queryPerson(insureds);
		return insureds;
	}

	@Override
	public QueryWrapper<InsuredDO> getQueryCondition() {
		QueryWrapper<InsuredDO> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(InsuredDO::getApplicationformNo,condition.getPrtNo());
		return queryWrapper;
	}

	public void queryPerson(List<Insured> insuredList){
		insuredList.forEach(x->{
			personInfo.setCustomerNo(x.getInsuredNo());
			x.setPerson(personInfo.query());
		});
	}
}
