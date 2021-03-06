package com.dylan.xinyidai05.domain.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @Aouthor: yixingheng
 * @name: 子订单
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
public class SuborderDO {

    private Long id;
    // 订单号
    private String orderNo;
    // 子订单号
    private String subOrderNo;
    // 子订单状态
    private String status;
    // 子订单撤销原因
    private String cancelReason;
    // 服务申请ID
    private String transactionNo;

}
