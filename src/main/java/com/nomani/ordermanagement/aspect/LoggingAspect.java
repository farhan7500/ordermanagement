package com.nomani.ordermanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Around("execution(* com.nomani.ordermanagement.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Entering method: " + joinPoint.getSignature().getName());
    }
}
