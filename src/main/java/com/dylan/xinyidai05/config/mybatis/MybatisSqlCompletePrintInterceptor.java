package com.dylan.xinyidai05.config.mybatis;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * @author baoxiang
 * @create 2020-06-15 11:20
 */

@Intercepts(
        {@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
         @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
         @Signature(type = StatementHandler.class, method = "batch", args = {Statement.class})
        })
public class MybatisSqlCompletePrintInterceptor implements Interceptor {
    private static final Logger log = LoggerFactory.getLogger(MybatisSqlCompletePrintInterceptor.class);
    private Configuration configuration = null;
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT_THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }
    };

    public MybatisSqlCompletePrintInterceptor() {
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        long startTime = System.currentTimeMillis();
        boolean var24 = false;

        Object var5;
        try {
            var24 = true;
            var5 = invocation.proceed();
            var24 = false;
        } finally {
            if (var24) {
                long var15 = System.currentTimeMillis();
                long sqlCost = var15 - startTime;
                StatementHandler statementHandler = (StatementHandler)target;
                BoundSql boundSql = statementHandler.getBoundSql();
                if (this.configuration == null) {
                    DefaultParameterHandler parameterHandler = (DefaultParameterHandler)statementHandler.getParameterHandler();
                    Field configurationField = ReflectionUtils.findField(parameterHandler.getClass(), "configuration");
                    ReflectionUtils.makeAccessible(configurationField);
                    this.configuration = (Configuration)configurationField.get(parameterHandler);
                }

                String sql = this.formatSql(boundSql, this.configuration);
                log.info("SQL:{}    执行耗时={}", sql, sqlCost);
            }
        }

        long endTime = System.currentTimeMillis();
        long sqlCost = endTime - startTime;
        StatementHandler statementHandler = (StatementHandler)target;
        BoundSql boundSql = statementHandler.getBoundSql();
        if (this.configuration == null) {
            DefaultParameterHandler parameterHandler = (DefaultParameterHandler)statementHandler.getParameterHandler();
            Field configurationField = ReflectionUtils.findField(parameterHandler.getClass(), "configuration");
            ReflectionUtils.makeAccessible(configurationField);
            this.configuration = (Configuration)configurationField.get(parameterHandler);
        }

        String sql = this.formatSql(boundSql, this.configuration);
        log.info("SQL:{}    执行耗时={}", sql, sqlCost);
        return var5;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    private String formatSql(BoundSql boundSql, Configuration configuration) {
        String sql = boundSql.getSql();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        Object parameterObject = boundSql.getParameterObject();
        if (sql != null && sql.length() != 0) {
            if (configuration == null) {
                return "";
            } else {
                TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
                sql = this.beautifySql(sql);
                if (parameterMappings != null) {
                    Iterator var7 = parameterMappings.iterator();

                    while(var7.hasNext()) {
                        ParameterMapping parameterMapping = (ParameterMapping)var7.next();
                        if (parameterMapping.getMode() != ParameterMode.OUT) {
                            String propertyName = parameterMapping.getProperty();
                            Object value;
                            if (boundSql.hasAdditionalParameter(propertyName)) {
                                value = boundSql.getAdditionalParameter(propertyName);
                            } else if (parameterObject == null) {
                                value = null;
                            } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                                value = parameterObject;
                            } else {
                                MetaObject metaObject = configuration.newMetaObject(parameterObject);
                                value = metaObject.getValue(propertyName);
                            }

                            String paramValueStr = "";
                            if (value instanceof String) {
                                paramValueStr = "'" + value + "'";
                            } else if (value instanceof Date) {
                                paramValueStr = "'" + ((SimpleDateFormat)DATE_FORMAT_THREAD_LOCAL.get()).format(value) + "'";
                            } else {
                                paramValueStr = value + "";
                            }

                            sql = sql.replaceFirst("\\?", paramValueStr);
                        }
                    }
                }

                return sql;
            }
        } else {
            return "";
        }
    }

    private String beautifySql(String sql) {
        sql = sql.replaceAll("[\\s\n ]+", " ");
        return sql;
    }
}
