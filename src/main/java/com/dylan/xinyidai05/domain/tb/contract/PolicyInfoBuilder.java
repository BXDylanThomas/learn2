package com.dylan.xinyidai05.domain.tb.contract;

import com.dylan.xinyidai05.domain.tb.contract.info.AgentInfo;
import com.dylan.xinyidai05.domain.util.SpringContextUtil;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:25
 */
public class PolicyInfoBuilder extends AbstractContInfoFactory{

	private ThreadLocal<PolicyInfo> threadLocal = new ThreadLocal<>();

	public PolicyInfoBuilder(String prtno){

	}

	@Override
	public PolicyInfo addAgent() {
		AgentInfo agentInfo = SpringContextUtil.getBean(AgentInfo.class);

		return null;
	}

	@Override
	public PolicyInfo addApplication() {
		return null;
	}

	@Override
	public PolicyInfo addInsuered() {
		return null;
	}

	@Override
	public PolicyInfo addSignleInsuered() {
		return null;
	}

	@Override
	public PolicyInfo addInsueredByInsuredNo(String insuredNo) {
		return null;
	}

	@Override
	public PolicyInfo addProduct() {
		return null;
	}

	@Override
	public PolicyInfo addProductByInsuredNo(String insuredNo) {
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
