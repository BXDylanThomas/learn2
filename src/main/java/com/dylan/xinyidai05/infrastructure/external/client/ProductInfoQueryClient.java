package com.dylan.xinyidai05.infrastructure.external.client;

import com.dylan.xinyidai05.infrastructure.external.entity.ProductDesInfoRequest;
import com.dylan.xinyidai05.infrastructure.external.entity.ProductDesInfoResponse;

public interface ProductInfoQueryClient {

    ProductDesInfoResponse queryProduct(ProductDesInfoRequest productDesInfoRequest);
}
