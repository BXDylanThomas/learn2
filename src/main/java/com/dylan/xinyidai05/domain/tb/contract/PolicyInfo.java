package com.dylan.xinyidai05.domain.tb.contract;

import com.dylan.xinyidai05.domain.tb.contract.info.*;
import lombok.Data;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * 保单信息
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:05
 */
@Data
public class PolicyInfo {
	private boolean usePrtNoFlag = true;
	private String prtNo;
	private String contNo;
	//代理人
	private AgentInfo agentInfo;
	//投保人
	private ApplicationInfo applicationInfo;
	//被保人
	private List<InsuredInfo> insuredInfo;
	//受益人
	private List<BeneficiaryInfo> beneficiaryInfo;
	//合同层
	private ContractInfo contractInfo;
	//险种层
	private List<ProductInfo> productInfos;

	public PolicyInfo(String prtNo) {
		this(prtNo,true);
	}

	public PolicyInfo(String prtNo,boolean usePrtNoFlag) {
		if (usePrtNoFlag){
			this.prtNo = prtNo;
		}else {
			this.contNo = prtNo;
		}
	}

}
