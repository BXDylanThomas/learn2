package com.dylan.xinyidai05.infrastructure.persitence.service.tb.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.PersonDO;
import com.dylan.xinyidai05.infrastructure.persitence.mapper.tb.PersonMapper;
import com.dylan.xinyidai05.infrastructure.persitence.service.tb.PersonService;
import org.springframework.stereotype.Service;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/25 22:29
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, PersonDO> implements PersonService {
}
