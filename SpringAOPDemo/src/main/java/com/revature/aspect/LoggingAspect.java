package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.revature.beans.Animal;

@Aspect // marks class as containing advice, prevents autoproxying
@Component // stereotype indicating that the LoggingAspect is a Spring bean
public class LoggingAspect {

	// could create Logger as a bean and inject it with DI
	private static Logger log = Logger.getRootLogger();

	// INFO log when a method is executed
	// ERROR log when exception is thrown
	// WARN log when "chase" gets called

	// after any method in my service package executes normally
	@AfterReturning(pointcut = "within(com.revature.service.*)")
	public void logAfterReturn(JoinPoint jp) {
		log.info(jp.getSignature());
	}

	// after any method in any package throws any Throwable
	@AfterThrowing(pointcut = "within(*)", throwing = "t")
	public void logAfterThrow(JoinPoint jp, Throwable t) {
		log.error(jp.getSignature() + " threw " + t.getClass() + " with stack trace: " + t.getStackTrace());
	}

	// use Around advice to control whether chase() ever finishes executing
	@Around("execution(* com.revature.service.CircleOfLifeService.chase(..))")
	public void chaseMaybe(ProceedingJoinPoint pjp) throws Throwable {
		Animal a1 = (Animal) pjp.getArgs()[0];
		Animal a2 = (Animal) pjp.getArgs()[1];
		log.info(a1 + " is chasing " + a2);
		if (a1.getSpeed() > a2.getSpeed()) {
			log.warn(a1 + " is faster " + a2);
			pjp.proceed(); // decide whether method executes
		} else {
			log.info(a2 + " got away");
		}
	}

}
