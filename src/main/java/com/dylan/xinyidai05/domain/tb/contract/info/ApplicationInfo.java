package com.dylan.xinyidai05.domain.tb.contract.info;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dylan.xinyidai05.domain.Entity.Applicant;
import com.dylan.xinyidai05.domain.Entity.Person;
import com.dylan.xinyidai05.domain.common.Assert;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.ApplicantDO;
import com.dylan.xinyidai05.infrastructure.persitence.service.tb.ApplicationService;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:06
 */
public class ApplicationInfo extends AbstractContractInfoQuery<ApplicantDO, Applicant> {

	private ApplicationService applicationService;

	private PersonInfo personInfo;

	public ApplicationInfo() {
		applicationService = getBean(ApplicationService.class);
		personInfo = getBean(PersonInfo.class);
	}

	@Override
	public Applicant query() {
		check();
		ApplicantDO applicantDO = applicationService.getOne(getQueryCondition());
		Assert.isNotBank(applicantDO,"保单构建，投保人信息未查询到");
		Applicant applicant = (Applicant)transDOToEntity(applicantDO, Applicant.class);
		applicant.setPerson(querPerson(applicantDO.getApplicantNo()));
		return applicant;
	}

	@Override
	public QueryWrapper<ApplicantDO> getQueryCondition() {
		QueryWrapper<ApplicantDO> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(ApplicantDO::getApplicantNo,condition.getPrtNo());
		return queryWrapper;
	}

	public Person querPerson (String appntNo){
		personInfo.setCustomerNo(appntNo);
		Person person = personInfo.query();
		Assert.isNotBank(person,"保单构建，投保人信息未查询到");
		return person;
	}

}
