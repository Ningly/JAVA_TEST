package com.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect  //配置了切面
public class Logger {
    @Pointcut("execution(* com.Service.Imp.*.*(..))")
    private void pt(){}
    /*
    * 前置通知
    * */
//    @Before("pt()")
    public void beforePrintLog(){
        System.out.println("beforePrintLog");
    }
    /*
     * 后置通知
     * */
//    @AfterReturning("pt()")
    public void afterreturningPrintLog(){
        System.out.println("afterreturningPrintLog");
    }
    /*
     * 异常通知
     * */
//    @AfterThrowing("pt()")
    public void throwPrintLog(){
        System.out.println("throwPrintLog");
    }
    /*
     * 最终通知
     * */
//    @After("pt()")
    public void afterPrintLog(){
        System.out.println("afterPrintLog");
    }

    /*
     * 环绕通知
     *      问题：当我们配置环绕通知后，切入点方法没有执行，而环绕通知里的代码执行了。
     * 分析：
     *      由动态代理可知，环绕通知指的是（绿框中）invoke方法，并且里面有明确的切入点方法调用。而我们现在的环绕通知没有切入点方法调用
 *     解决
 *          spring为我们提供了一个接口：ProceedingJoinPoint。该接口可以作为环绕通知的方法参数来使用。
 *          在程序运行时，spring框架会为我们提供该接口的实现类，供我们使用。
 *          该接口中有一个方法,proceed()，它的作用就等于menthod.invoke方法，就是明确调用业务层核心方法（切入点方法）
*      简单理解：它是spring框架为我们提供的一种可以在代码中手动控制通知方法什么时候执行的方式
     * */
    @Around("pt()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object obj=null;
        try {
            System.out.println("aroundPrintLog:前置通知");
            obj = pjp.proceed();
            System.out.println("aroundPrintLog:后置通知");
        } catch (Throwable throwable) {
            System.out.println("aroundPrintLog:异常通知");
            throwable.printStackTrace();
        }finally {
            System.out.println("aroundPrintLog:最终通知");
        }
        return obj;
    }
}
