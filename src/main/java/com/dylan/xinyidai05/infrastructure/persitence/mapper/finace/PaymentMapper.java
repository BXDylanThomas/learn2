package com.dylan.xinyidai05.infrastructure.persitence.mapper.finace;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.dylan.xinyidai05.infrastructure.persitence.entity.finace.PaymentDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMapper extends BaseMapper<PaymentDO> {

    @Select("select * from trade_payment ${ew.customSqlSegment}")
    PaymentDO select(@Param(Constants.WRAPPER) Wrapper wrappers);
}
