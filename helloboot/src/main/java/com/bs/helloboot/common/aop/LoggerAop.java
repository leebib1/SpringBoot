package com.bs.helloboot.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggerAop {
	
	@Before("execution(* com.bs.helloboot..*(..))")
	public void logger(JoinPoint jp) {
		Signature sig=jp.getSignature();
		log.debug("=========== AOP Before ============");
		log.debug(sig.getDeclaringTypeName()+" "+sig.getName());
		log.debug("====================================");
	}
}
