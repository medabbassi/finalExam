package com.example.finalexam.Configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Aspect
public class AOP {

    private Logger logger(JoinPoint joinPoint) {
        return LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(* com.example.finalexam.FinalExamApplication.*.add*(..))")
    public void beforeAddMethod(JoinPoint joinPoint) {
        Logger log = logger(joinPoint);
        log.debug("Added successfully ");
    }

}