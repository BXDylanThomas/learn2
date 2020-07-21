package com.dylan.xinyidai05.domain.tb.contract.strategy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:56
 */
@Data
public class Condition {
	private String prtNo;
	private String contNo;
	private String appntNo;
	private List<String> insuredNos;
	private List<String> riskCodes;
	private Map<String,String> insuredOfRiskCodes;

}
