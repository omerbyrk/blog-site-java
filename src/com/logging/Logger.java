package com.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
	
	private static final BuildLog successBuildLog = new SuccessBuildLog();
	private static final BuildLog errorBuildLog = new ErrorBuildLog();

	@AfterReturning("allServiceClasses()")
	public void successLog(JoinPoint joinPoint) {
		StringBuilder log = successBuildLog.build(joinPoint);
		System.out.println(log);
	}

	@AfterThrowing(pointcut = "allServiceClasses()", throwing = "exception")
	public void errorLog(JoinPoint joinPoint, Exception exception) {
		StringBuilder log = errorBuildLog.build(joinPoint);
		log.append(" [ Exception Message :  " + exception.getMessage() +  "] ");
		System.err.println(log);
	}

	@Pointcut("within (com.service.imp.*)")
	public void allServiceClasses() { }

}
