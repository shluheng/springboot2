package com.luheng.demo.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
//@Slf4j
@Aspect
@Component
public class WebLogAspect {
	private static final Logger log = LoggerFactory.getLogger(WebLogAspect.class);
	
	@Pointcut("execution(public * com.luheng.demo.web.controller.*.*(**))")
	public void webLog(){
		
	}
	
	@Before("webLog()")
	public void doBefore(JoinPoint point) throws Throwable{
		//获取请求参数
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//记录请求内容
		log.info("URL: " +request.getRequestURL());
		log.info("HTTP_METHOD: " +request.getMethod());
		log.info("IP: " +request.getRemoteAddr());
		Enumeration<String> enm = request.getParameterNames();
		while (enm.hasMoreElements()) {
			String name = enm.nextElement();
			log.info("name:{},value:{}",name, request.getParameter(name));
		}
	}
	
	@AfterReturning(returning = "result", pointcut = "webLog()")
	public void doAfter(Object result) throws Throwable{
		//请求处理完成，返回结果
		log.info("RESPONSE : "+result);
	}
}
