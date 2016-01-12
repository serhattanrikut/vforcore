/**
 * 
 */
package com.vforcore.services.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Logging aspect in order to log spring managed components
 * 
 * @author stanriku
 *
 */
@Component
@Aspect
public class LoggingAspect {
	
	private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	/**
	 * 
	 */
	public LoggingAspect() {
		
	}
	
	/**
	 * Around point cut and joint definition in order to log all spring managed beans
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.vforcore..*.*(..)) "
			+ "&& !@annotation(com.vforcore.commons.nologging.NoLogging) ")
	public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object retVal = null;
		if(logger.isDebugEnabled()) {
			StringBuilder logMessage = new StringBuilder("{} : ");
			Class<? extends Object> target = joinPoint.getTarget().getClass();
			
			if(target.getInterfaces() != null && target.getInterfaces().length > 0) {
				logMessage.append(target.getInterfaces()[0].getName());
			}
			else
				logMessage.append(target.getName());
			
			logMessage.append(".");
			logMessage.append(joinPoint.getSignature().getName());
			logMessage.append(" arguments:(");
			// append args
			Object[] args = joinPoint.getArgs();
			for (int i = 0; i < args.length; i++) {
				logMessage.append(args[i]).append(",");
			}
			if (args.length > 0) {
				logMessage.deleteCharAt(logMessage.length() - 1);
			}
			
			logMessage.append(")");
			
			logger.debug(logMessage.toString(),"ENTRY");
			System.out.println("ENTRY" + logMessage.toString());
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			retVal = joinPoint.proceed();

			stopWatch.stop();

			logMessage.append(" execution time: ");
			logMessage.append(stopWatch.getTotalTimeMillis());
			logMessage.append(" ms, return value:").append(retVal);
			logger.debug(logMessage.toString(),"EXIT");
			System.out.println("EXIT" + logMessage.toString());
		}
		else
			retVal = joinPoint.proceed();
			
		return retVal;
	}

}

