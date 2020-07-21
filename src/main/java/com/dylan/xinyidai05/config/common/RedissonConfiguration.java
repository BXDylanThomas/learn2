package com.dylan.xinyidai05.config.common;

import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author baoxiang
 * @create 2020-07-06 10:03
 */
@ConfigurationProperties(prefix = "server")
@Configuration
//@AutoConfigureAfter(value = RedisAutoConfiguration.class)
public class RedissonConfiguration {

//上下文中存在bean 配置生效
    @ConditionalOnBean
    @ConditionalOnMissingBean
//按照某个类在classpath中，配置是否生效
    @ConditionalOnClass
    @ConditionalOnMissingClass

// 注解根据name 来读取Spring Boot 的Environment 的变量包含的属性，根据其值与havingValue 的值比较结果决定配置是否生效。
// 如果没有指定havingValue ，只要属性不为fa lse ，配置都能生效。
// matchIfMissing = true 如果上述不满足，也生效
    @ConditionalOnProperty(name = {"server.port"},havingValue = "8080")
//当条件为true时，生效
    @ConditionalOnExpression
//存在指定的java版本
    @ConditionalOnJava(value = JavaVersion.EIGHT)
    public String str(){
        return null;
    }
}
 