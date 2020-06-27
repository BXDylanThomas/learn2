package com.dylan.xinyidai05.domain.Entity;

import com.dylan.xinyidai05.domain.common.Entity;
import lombok.Data;

/**
 * @Aouthor: yixingheng
 * @name: 投保人
 * @projectName: IntelligentOperation
 * @create 2019-09-26 18:26
 */
@Data
public class Applicant extends Entity {

    private String applicationFormNo;

    private String customerNo;

    private Person person;
}
