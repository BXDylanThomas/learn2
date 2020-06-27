package com.dylan.xinyidai05.infrastructure.persitence.mapper.tb;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dylan.xinyidai05.infrastructure.persitence.entity.tb.OrderDO;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<OrderDO> {
}
