package com.dylan.xinyidai05.infrastructure.persitence.entity.tb;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dylan.xinyidai05.infrastructure.persitence.common.BaseEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Aouthor: yixingheng
 * @name: 代理人
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
@Builder
@TableName("trade_agent")
public class AgentDO extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    // 投保单号
    private String applicationformNo;
    // 代理人编码
    private String agentCode;
    // 代理人展业类型
    private String branchType;
    //代理人组别
    private String agentGroup;
    //代理人机构
    private String agentCom;
    //代理人姓名
    private String agentName;
    // 操作人
    private String operation;
}
