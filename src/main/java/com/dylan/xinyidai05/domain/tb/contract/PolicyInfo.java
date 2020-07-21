package com.dylan.xinyidai05.domain.tb.contract;

import com.dylan.xinyidai05.domain.Entity.Agent;
import com.dylan.xinyidai05.domain.Entity.Applicant;
import com.dylan.xinyidai05.domain.Entity.Insured;
import com.dylan.xinyidai05.domain.tb.contract.info.BeneficiaryInfo;
import com.dylan.xinyidai05.domain.tb.contract.info.ContractInfo;
import com.dylan.xinyidai05.domain.tb.contract.info.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class PolicyInfo {
	private boolean usePrtNoFlag = true;
	private String prtNo;
	private String contNo;
	//代理人
	private Agent agent;
	//投保人
	private Applicant applicant;
	//被保人
	private List<Insured> insuredInfo;
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
