package com.dylan.xinyidai05.infrastructure.external.service;

import com.dylan.xinyidai05.domain.Entity.ProductDes;
import com.dylan.xinyidai05.infrastructure.external.entity.ProductDesInfoRequest;

public interface ProductInfoQueryService {

    ProductDes queryProduct(ProductDesInfoRequest productDesInfoRequest);

}
