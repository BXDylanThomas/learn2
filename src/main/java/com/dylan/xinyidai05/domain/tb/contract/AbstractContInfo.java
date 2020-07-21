package com.dylan.xinyidai05.domain.tb.contract;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:04
 */
public interface AbstractContInfo {

	PolicyInfo addAgent();

	PolicyInfo addApplication();

	PolicyInfo addInsuered();

	PolicyInfo addProduct();

	PolicyInfo addProductByRiskCodes(List<String> riskCodes);

	PolicyInfo addProductByInsuredNoAndRiskCodes(String insuredNo,List<String> riskCodes);
}
