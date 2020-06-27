package com.dylan.xinyidai05.infrastructure.persitence.service.tb.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.AgentDO;
import com.dylan.xinyidai05.infrastructure.persitence.mapper.tb.AgentMapper;
import com.dylan.xinyidai05.infrastructure.persitence.service.tb.AgentService;
import org.springframework.stereotype.Service;

@Service
public class AgentServieimpl extends ServiceImpl<AgentMapper, AgentDO> implements AgentService {
}
