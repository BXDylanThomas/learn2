package com.dylan.xinyidai05.interfaces.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/27 20:46
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

	private final static String DEFOUT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 处理时间
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TimeHandleInterceptor());
	}

	/**
	 * 格式化时间
	 * @param registry
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new LocalDateTimeFormatter());
	}
}
