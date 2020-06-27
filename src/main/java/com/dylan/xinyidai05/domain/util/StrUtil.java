package com.dylan.xinyidai05.domain.util;

import lombok.extern.slf4j.Slf4j;

import java.text.NumberFormat;

/**
 * @program: dorado-insuring
 * @description: ${description}
 * @author: xiao ma
 * @create: 2019-10-09 10:51
 */
@Slf4j
public class StrUtil {

    /**
     * 字符左补0
     * @param max	位数
     * @param number 数字
     * @return void
     * @author makai
     * @date 2019/9/30 16:39
     */
    public static String numberFormatStr(int max,long number){
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(max);
        //设置最小整数位数
        nf.setMinimumIntegerDigits(max);
        //输出测试语句
        log.info("数字是多少：{}",nf.format(number));
        return nf.format(number);
        //System.out.println(nf.format(number));
    }

    public static void main(String[] args) {
        numberFormatStr(7,10L);
    }
}
