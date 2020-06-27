package com.dylan.xinyidai05.interfaces.common;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Executable;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/27 21:23
 */
@ControllerAdvice
@Slf4j
public class ResponesBodyHandleInterceptor implements ResponseBodyAdvice {

	@Override
	public boolean supports(MethodParameter methodParameter, Class aClass) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
		Executable executable = methodParameter.getExecutable();
		String url= serverHttpRequest.getURI().getPath();
		String methodSign=executable.getDeclaringClass().getSimpleName()+"#"+executable.getName();
		log.info("请求：{}，方法：{}，返回结果：{}",url,methodSign,JSONObject.toJSONString(o));
		return o;
	}
}
