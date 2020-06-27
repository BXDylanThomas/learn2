package com.dylan.xinyidai05.infrastructure.persitence.service.log.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dylan.xinyidai05.infrastructure.persitence.entity.log.ApplicationInfoDO;
import com.dylan.xinyidai05.infrastructure.persitence.mapper.log.ApplicationInfoMapper;
import com.dylan.xinyidai05.infrastructure.persitence.service.log.ApplicationInfoService;
import org.springframework.stereotype.Service;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/25 22:33
 */
@Service
public class ApplicationInfoServiceImpl extends ServiceImpl<ApplicationInfoMapper,ApplicationInfoDO> implements ApplicationInfoService {
}
