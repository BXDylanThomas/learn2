package com.dylan.xinyidai05.interfaces.common.result;

import lombok.Builder;
import lombok.Data;

/**
 * @author baoxiang
 * @create 2020-06-28 11:11
 */
@Data@Builder
public class Error {

    //序号
    private int no;
    //错误信息
    private String message;
}
 