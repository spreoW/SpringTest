package com.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author wangquan
 * @date 2020/12/19
 */
@Component
@Aspect
public class LoggerUtil {
   @Pointcut("execution(* com.service.impl.*.*(..))")
   private void pointcut(){
   }

    @Before("pointcut()")
    public void beforePrintLog(){
        System.out.println("beforePrintLog执行了。。。");
    }
    @AfterReturning("pointcut()")
    public void afterReturnPrintLog(){
        System.out.println("afterReturnPrintLog执行了。。。");
    }
    @AfterThrowing("pointcut()")
    public void afterThrowingPrintLog(){
        System.out.println("afterThrowingPrintLog执行了。。。");
    }
    @After("pointcut()")
    public void afterPrintLog(){
        System.out.println("afterPrintLog执行了。。。");
    }

    /**
     * Spring环绕通知，相当于一种代码配置SpringAOP
     * @param pjp
     */
    //@Around("pointcut()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        try {
            System.out.println("aroundPrintLog的前置执行了。。。");
            // 被代理对象的方法要用到的参数
            Object[] args = pjp.getArgs();
            // 被代理对象的方法执行之后产生的返回值
            Object returnValue = pjp.proceed(args);
            System.out.println("aroundPrintLog的后置执行了。。。");
            return returnValue;
        } catch (Throwable throwable) {
            System.out.println("aroundPrintLog的异常执行了。。。");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("aroundPrintLog的finally执行了。。。");
        }
    }
}
