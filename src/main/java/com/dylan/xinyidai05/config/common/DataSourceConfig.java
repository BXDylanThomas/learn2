package com.dylan.xinyidai05.config.common;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author baoxiang
 * @create 2020-06-28 17:22
 */
@Configuration
public class DataSourceConfig implements ApplicationRunner {

    @Autowired
    Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println(JSONObject.toJSONString(environment));
    }
}
 