package com.dylan.xinyidai05.domain.tb.contract.info;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dylan.xinyidai05.domain.Entity.Beneficiary;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.BeneficiaryDO;
import com.dylan.xinyidai05.infrastructure.persitence.service.tb.BeneficiaryService;

import java.util.Collections;
import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:10
 */
public class BeneficiaryInfo extends AbstractContractInfoQuery<BeneficiaryDO, List<Beneficiary>> {

	private BeneficiaryService beneficiaryService;

	private PersonInfo personInfo;
	public BeneficiaryInfo() {
		beneficiaryService = getBean(BeneficiaryService.class);
		personInfo = getBean(PersonInfo.class);
	}

	@Override
	public List<Beneficiary> query() {
		check();
		List<BeneficiaryDO> beneficiaryDOList = beneficiaryService.list(getQueryCondition());
		List<Beneficiary> beneficiaries = (List<Beneficiary>) transDOToEntity(beneficiaryDOList, Collections.singletonList(new Beneficiary()));
		queryPerson(beneficiaries);
		return beneficiaries;
	}

	@Override
	public QueryWrapper<BeneficiaryDO> getQueryCondition() {
		QueryWrapper<BeneficiaryDO> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(BeneficiaryDO::getApplicationformNo,condition.getPrtNo());
		return queryWrapper;
	}

	public void queryPerson(List<Beneficiary> beneficiaries){
		beneficiaries.forEach(x->{
			personInfo.setCustomerNo(x.getBeneficiaryNo());
			x.setPerson(personInfo.query());
		});
	}
}
