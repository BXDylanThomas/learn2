package com.dylan.xinyidai05.domain.tb.contract.info;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dylan.xinyidai05.domain.Entity.Product;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.ProductDO;
import com.dylan.xinyidai05.infrastructure.persitence.service.tb.ProductService;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:06
 */
public class ProductInfo extends AbstractContractInfoQuery<ProductDO, List<Product>>{

	private ProductService productService;

	@Override
	public List<Product> query() {
		super.check();
		List<ProductDO> list = productService.list(getQueryCondition());
		List<Product> productList=(List<Product>)transDOToEntity(list, Collections.singletonList(Product.builder().build()));

		dealProductDesAndRepo(productList);
		return productList;
	}

	@Override
	public QueryWrapper<ProductDO> getQueryCondition() {
		QueryWrapper<ProductDO> queryWrapper = new QueryWrapper<>();
		if (!CollectionUtils.isEmpty(condition.getInsuredOfRiskCodes())){
			Map<String, String> map = condition.getInsuredOfRiskCodes();
			for (Map.Entry<String, String> entry : map.entrySet()) {
				queryWrapper.lambda().eq(ProductDO::getApplicationformNo, condition.getPrtNo()).eq(ProductDO::getInsuredNo,entry.getKey()).eq(ProductDO::getProductCode,entry.getValue());
				break;
			}
		}else if (!CollectionUtils.isEmpty(condition.getInsuredNos())){
			queryWrapper.lambda().eq(ProductDO::getApplicationformNo, condition.getPrtNo()).in(ProductDO::getInsuredNo, condition.getInsuredNos());
		}else if (!CollectionUtils.isEmpty(condition.getRiskCodes())){
			queryWrapper.lambda().eq(ProductDO::getApplicationformNo, condition.getPrtNo()).in(ProductDO::getProductCode, condition.getRiskCodes());
		}else{
			queryWrapper.lambda().eq(ProductDO::getApplicationformNo, condition.getPrtNo());
		}
		queryWrapper.last("limit 0,10");

		return queryWrapper;
	}

	private void dealProductDesAndRepo(List<Product> productList) {

	}



}
