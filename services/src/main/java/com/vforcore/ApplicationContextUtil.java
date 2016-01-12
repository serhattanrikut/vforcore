/**
 * 
 */
package com.vforcore;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author stanriku
 *
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

	private static ApplicationContext context;
		
	
	public static ApplicationContext getContext() {
		return context;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContext:"+applicationContext.getApplicationName());
		context = applicationContext;
	}
	
}
