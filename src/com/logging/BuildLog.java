package com.logging;

import org.aspectj.lang.JoinPoint;

public interface BuildLog {
	
	public StringBuilder build(JoinPoint joinPoint);
	
}

