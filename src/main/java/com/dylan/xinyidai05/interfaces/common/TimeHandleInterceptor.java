package com.dylan.xinyidai05.interfaces.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * code is far away from bug with the animal protecting
 *
 * 统计接口耗时
 *
 * @Author : dylan
 * @Date :create in 2020/6/27 20:47
 */
@Slf4j
public class TimeHandleInterceptor implements HandlerInterceptor {
	private ThreadLocal<LocalDateTime> timeThreadLocal = new ThreadLocal<>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		timeThreadLocal.set(LocalDateTime.now());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		String url = request.getRequestURI();
		LocalDateTime start = timeThreadLocal.get();
		log.info("请求：{} 总耗时：{}s",url,Duration.between(start, LocalDateTime.now()).getSeconds());
	}
}
