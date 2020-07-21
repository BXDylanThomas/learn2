package com.dylan.xinyidai05.domain.tb.contract;

import com.dylan.xinyidai05.domain.Entity.Agent;
import com.dylan.xinyidai05.domain.Entity.Applicant;
import com.dylan.xinyidai05.domain.Entity.Insured;
import com.dylan.xinyidai05.domain.common.Entity;
import com.dylan.xinyidai05.domain.tb.contract.info.AbstractContractInfoQuery;
import com.dylan.xinyidai05.domain.tb.contract.info.AgentInfo;
import com.dylan.xinyidai05.domain.tb.contract.info.ApplicationInfo;
import com.dylan.xinyidai05.domain.tb.contract.info.InsuredInfo;
import com.dylan.xinyidai05.domain.tb.contract.strategy.Condition;
import com.dylan.xinyidai05.domain.util.SpringContextUtil;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:25
 */
public class PolicyInfoBuilder extends AbstractContInfoFactory{

	private ThreadLocal<PolicyInfo> policyInfoThreadLocal = new ThreadLocal<>();
	private ThreadLocal<Condition> conditionThreadLocal = new ThreadLocal<>();

	public PolicyInfoBuilder(Condition condition){
		conditionThreadLocal.set(condition);
		policyInfoThreadLocal.set(new PolicyInfo());
	}

	public Object query(Class clazz){
		AbstractContractInfoQuery infoQuery = getBean(clazz);
		infoQuery.setCondition(conditionThreadLocal.get());
		return infoQuery.query();
	}

	@Override
	public PolicyInfo addAgent() {
		policyInfoThreadLocal.get().setAgent((Agent) query(AgentInfo.class));
		return policyInfoThreadLocal.get();
	}

	@Override
	public PolicyInfo addApplication() {
		policyInfoThreadLocal.get().setApplicant((Applicant) query(ApplicationInfo.class));
		return policyInfoThreadLocal.get();
	}

	@Override
	public PolicyInfo addInsuered() {
		policyInfoThreadLocal.get().setInsuredInfo((List<Insured>) query(InsuredInfo.class));
		return policyInfoThreadLocal.get();
	}

	@Override
	public PolicyInfo addProduct() {
		return null;
	}

	@Override
	public PolicyInfo addProductByRiskCodes(List<String> riskCodes) {
		return null;
	}

	@Override
	public PolicyInfo addProductByInsuredNoAndRiskCodes(String insuredNo, List<String> riskCodes) {
		return null;
	}
}
