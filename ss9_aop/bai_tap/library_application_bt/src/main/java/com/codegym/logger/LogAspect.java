package com.codegym.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogAspect {


    @Pointcut("execution(* com.codegym.controller.LibraryController.*(..))")
    public void allMethodPointCut(){}

    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.err.println("Start method name: " + joinPoint.getSignature().getName() + " Time: " + LocalDate.now());
    }

    @After("allMethodPointCut()")
    public void afterCallMethod(JoinPoint joinPoint){
        System.err.println("End method name: " + joinPoint.getSignature().getName() + " Time: " + LocalDate.now());
    }

}
