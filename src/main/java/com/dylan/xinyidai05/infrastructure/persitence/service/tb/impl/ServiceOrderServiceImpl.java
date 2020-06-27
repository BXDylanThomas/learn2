package com.dylan.xinyidai05.infrastructure.persitence.service.tb.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.ServiceOrderDO;
import com.dylan.xinyidai05.infrastructure.persitence.mapper.tb.ServiceOrderMapper;
import com.dylan.xinyidai05.infrastructure.persitence.service.tb.ServiceOrderService;
import org.springframework.stereotype.Service;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/25 22:30
 */
@Service
public class ServiceOrderServiceImpl extends ServiceImpl<ServiceOrderMapper, ServiceOrderDO> implements ServiceOrderService {
}
