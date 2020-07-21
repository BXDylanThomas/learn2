package com.dylan.xinyidai05;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.dylan.xinyidai05.infrastructure.persitence.mapper")
@ServletComponentScan
public class Xinyidai05Application {

	public static void main(String[] args) {
		SpringApplication.run(Xinyidai05Application.class, args);
	}

}
