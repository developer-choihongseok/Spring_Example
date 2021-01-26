package com.myway.tok.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Advice : 부가기능을 담당하는 역할. 여기서는 Logging을 담당할 클래스
public class MyLoggingAdvice {
	private static final Logger logger = LoggerFactory.getLogger(MyLoggingAdvice.class);
	
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		// 추가 로직
		logger.info(joinPoint.getSignature().toString());
		
		// 메서드 실행
		return joinPoint.proceed();
	}
}
