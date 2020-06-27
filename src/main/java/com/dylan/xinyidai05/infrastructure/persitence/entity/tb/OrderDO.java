package com.dylan.xinyidai05.infrastructure.persitence.entity.tb;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Aouthor: yixingheng
 * @name: 订单
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
@TableName("trade_order")
public class OrderDO extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    // 订单号
    private String orderNo;
    // 订单状态
    private String status;
    // 撤销原因
    private String cancelReason;

}
