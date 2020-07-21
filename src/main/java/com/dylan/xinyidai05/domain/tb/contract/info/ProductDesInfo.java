package com.dylan.xinyidai05.domain.tb.contract.info;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dylan.xinyidai05.domain.Entity.ProductDes;
import com.dylan.xinyidai05.infrastructure.external.service.ProductInfoQueryService;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.ProductDO;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/26 21:06
 */
public class ProductDesInfo extends AbstractContractInfoQuery<ProductDO, ProductDes> {

    private ProductInfoQueryService productInfoQueryService;

    public ProductDesInfo() {
        productInfoQueryService = getBean(ProductInfoQueryService.class);
    }

    @Override
    public ProductDes query() {
        return productInfoQueryService.queryProduct(null);
    }

    @Override
    public QueryWrapper<ProductDO> getQueryCondition() {
        return null;
    }
}
