package com.example.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *使用AOP处理请求 
 *
 */
@Aspect
@Component
public class HttpAspect {
	public static final Logger logger=LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(* com.example.controller.GirlController.*(..))")
	public void log(){
	}
	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		ServletRequestAttributes attribute=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=attribute.getRequest();
		
		//URL
		logger.info("URL={}", request.getRequestURL());
		logger.info("URI={}", request.getRequestURI());
		//method
		logger.info("method={}", request.getMethod());
		
		//IP
		logger.info("IP={}", request.getRemoteAddr());
		
		//类方法
		logger.info("classs_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		
		//参数
		logger.info("arg={}", joinPoint.getArgs());
	}
	
	@After("log()")
	public void doAfter(){
		logger.info("好吧结束也执行了~~");
	}
	@AfterReturning(returning="object",pointcut="log()")
	public void doAfterReturning(Object object){
		logger.info("response={}",object.toString());
	}
	
}
