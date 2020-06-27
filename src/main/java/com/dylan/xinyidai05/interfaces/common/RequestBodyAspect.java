package com.dylan.xinyidai05.interfaces.common;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2020/6/27 23:31
 */
@Aspect
@Slf4j
@Component
public class RequestBodyAspect {

	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
			"@annotation(org.springframework.web.bind.annotation.PostMapping) ||"+
			"@annotation(org.springframework.web.bind.annotation.PutMapping) ||"+
			"@annotation(org.springframework.web.bind.annotation.DeleteMapping) ||"+
			"@annotation(org.springframework.web.bind.annotation.RequestMapping)"
	)
	public void annotationCut(){}

	@Around(value = "annotationCut()")
	public Object pointCut(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		log.info("请求：{}，参数:{}",requestAttributes.getRequest().getRequestURI(), JSONObject.toJSONString(args));
		Object proceed = joinPoint.proceed();
		return proceed;
	}

}
