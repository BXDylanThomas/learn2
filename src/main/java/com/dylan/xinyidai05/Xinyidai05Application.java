package com.dylan.xinyidai05;

import org.apache.ibatis.annotations.CacheNamespace;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.cache.RedisCacheManager;

@SpringBootApplication
@EnableCaching
@MapperScan("com.dylan.xinyidai05.infrastructure.persitence.mapper")
@ServletComponentScan
public class Xinyidai05Application {

	public static void main(String[] args) {
		SpringApplication.run(Xinyidai05Application.class, args);
	}

}
