package com.dylan.xinyidai05.infrastructure.persitence.service.tb.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.OrderDO;
import com.dylan.xinyidai05.infrastructure.persitence.mapper.tb.OrderMapper;
import com.dylan.xinyidai05.infrastructure.persitence.service.tb.OrderService;
import org.springframework.stereotype.Service;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/25 22:26
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderDO> implements OrderService {
}
