package com.dylan.xinyidai05.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author baoxiang
 * @create 2020-06-15 11:22
 */
@Configuration
public class MyBatisAutoConfiguration {

    /**
     * 启用sql打印
     * @return
     */
    @Bean
    @ConditionalOnExpression("${mybatis.print.enable:true}")
    public MybatisSqlCompletePrintInterceptor mybatisSqlCompletePrintInterceptor() {
        return new MybatisSqlCompletePrintInterceptor();
    }

    /**
     * 启用分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
