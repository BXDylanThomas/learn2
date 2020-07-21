package com.dylan.xinyidai05.config.common;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author baoxiang
 * @create 2020-07-06 14:10
 */
public class AutoCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        ResourceLoader resourceLoader = conditionContext.getResourceLoader();
        return false;
    }
}
 