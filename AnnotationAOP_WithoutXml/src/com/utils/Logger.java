package com.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect
public class Logger {
    @Pointcut("execution(* com.service.iml.*.*(..))")
    private void pt(){}
    /*
     * 前置通知
     * */
    public void beforePrintLogger(){
        System.out.println("beforePrintLogger=============");
    }
    /*
     * 后置通知
     * */
    public void afterReturningPrintLogger(){
        System.out.println("afterreturningPrintLogger=============");
    }
    /*
     * 异常通知
     * */
    public void afterThrowingPrintLogger(){
        System.out.println("throwPrintLogger=============");
    }
    /*
     * 最终通知
     * */
    public void afterPrintLogger(){
        System.out.println("afterPrintLogger=============");
    }
    /*
     * 环绕通知
     * */
    @Around("pt()")
    public Object aroundPrintLogger(ProceedingJoinPoint pjp){
        Object obj=null;
        try {
            System.out.println("aroundPrintLogger=======前置通知");
            obj = pjp.proceed();
            System.out.println("aroundPrintLogger=======后置通知");
        } catch (Throwable throwable) {
            System.out.println("aroundPrintLogger=======异常通知");
            throwable.printStackTrace();
        }finally {
            System.out.println("aroundPrintLogger=======最终通知");
        }

        System.out.println("aroundPrintLogger=============");
        return obj;
    }
}
