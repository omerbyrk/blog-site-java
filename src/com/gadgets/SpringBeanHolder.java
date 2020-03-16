package com.gadgets;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanHolder implements ApplicationContextAware {
	
	private static ApplicationContext ctx = null;

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx = ctx;
	}
	
	
	public static <T> T getBean(Class<T> cast) {
		return ctx.getBean(cast);
	}

}
