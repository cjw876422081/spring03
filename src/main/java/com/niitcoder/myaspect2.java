package com.niitcoder;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class myaspect2 {
    @Pointcut("execution(* com.niitcoder.*.*(..))")
    private  void myPonintCut(){}

    @Before("myPonintCut()")
    public void myBefore(JoinPoint joinPoint){
        System.out.println("前置通知");
        System.out.println("目标类"+joinPoint.getTarget());
        System.out.println("增强方法"+joinPoint.getSignature().getName());
    }
    @AfterReturning("myPonintCut()")
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.println("记录日志");
        System.out.println("增强方法"+joinPoint.getSignature().getName());

    }
    @Around("myPonintCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕钱");
        Object obj = proceedingJoinPoint.proceed() ;
        System.out.println("环绕结束后");
        return obj ;
    }
    @AfterThrowing(value = "myPonintCut()" , throwing = "e")
    public void  myAfterThrowing(JoinPoint joinPoint , Throwable e){
        System.out.println("出错" +e.getMessage());

    }
    @After("myPonintCut()")
    public void  myatfer(){
        System.out.println("最终通知");
    }
}
