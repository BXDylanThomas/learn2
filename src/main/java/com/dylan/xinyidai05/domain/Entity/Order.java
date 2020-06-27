package com.dylan.xinyidai05.domain.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dylan.xinyidai05.domain.common.Entity;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @Aouthor: yixingheng
 * @name: 订单
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
public class Order extends Entity{

    // 订单号
    private String orderNo;
    // 订单状态
    private String status;
    // 撤销原因
    private String cancelReason;

}
