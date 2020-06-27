package com.dylan.xinyidai05.infrastructure.persitence.service.tb.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.ApplicantDO;
import com.dylan.xinyidai05.infrastructure.persitence.mapper.tb.ApplicationMapper;
import com.dylan.xinyidai05.infrastructure.persitence.service.tb.ApplicationService;
import org.springframework.stereotype.Service;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/25 22:21
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, ApplicantDO> implements ApplicationService {
}
