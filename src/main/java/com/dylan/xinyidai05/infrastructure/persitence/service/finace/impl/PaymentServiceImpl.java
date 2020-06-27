package com.dylan.xinyidai05.infrastructure.persitence.service.finace.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dylan.xinyidai05.infrastructure.persitence.common.redis.ServiceWithRedisImpl;
import com.dylan.xinyidai05.infrastructure.persitence.entity.finace.PaymentDO;
import com.dylan.xinyidai05.infrastructure.persitence.mapper.finace.PaymentMapper;
import com.dylan.xinyidai05.infrastructure.persitence.service.finace.PaymentService;
import org.springframework.stereotype.Service;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/25 22:37
 */
@Service
public class PaymentServiceImpl extends ServiceWithRedisImpl<PaymentMapper, PaymentDO> implements PaymentService {
}
