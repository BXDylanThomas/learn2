package com.dylan.xinyidai05.infrastructure.persitence.entity.log;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Aouthor: chenmingxin
 * @name: ApplicationInfoDO
 * @projectName P052.0
 * @create 2019-11-13 14:30
 */
@TableName("trade_application_info")
@Data
public class ApplicationInfoDO extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    //投保单号
    private String applicationformNo;
    //订单号
    private String orderNo;
    //子订单号
    private String subOrderNo;
    //服务申请ID
    private String transactionNo;
    //投保请求报文
    private String applicationInfo;

}
