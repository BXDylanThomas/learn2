package com.dylan.xinyidai05.infrastructure.persitence.service.tb.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.ProductDO;
import com.dylan.xinyidai05.infrastructure.persitence.mapper.tb.ProductMapper;
import com.dylan.xinyidai05.infrastructure.persitence.service.tb.ProductService;
import org.springframework.stereotype.Service;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/25 22:30
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductDO> implements ProductService {
}
