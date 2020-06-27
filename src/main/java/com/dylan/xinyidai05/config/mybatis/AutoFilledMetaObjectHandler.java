package com.dylan.xinyidai05.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author baoxiang
 * @create 2020-06-15 13:54
 */
@Configuration
public class AutoFilledMetaObjectHandler implements MetaObjectHandler {
    public static final DateTimeFormatter DEFAULT_DATE_FORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    public AutoFilledMetaObjectHandler() {}

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("makeDate", currentDate(), metaObject);
        this.setFieldValByName("modifyDate", currentDate(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modifyDate", currentDate(), metaObject);
    }

    public static LocalDateTime currentDate() {
        return LocalDateTime.now();
    }
}
