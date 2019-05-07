package com.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component("logger")
public class Logger {
    @Pointcut("execution(* com.serivce.impl.*.*(..))")
    private void pt(){}
    @Around("pt()")
    public Object aroundLogger(ProceedingJoinPoint pjp){
        Object obj=null;
        try {
            obj=pjp.proceed();
            System.out.println("记录了日志");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
}
