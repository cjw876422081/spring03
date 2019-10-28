package com.niitcoder;

import org.aspectj.lang.JoinPoint ;
import org.aspectj.lang.ProceedingJoinPoint;

public class myaspect {
    public void myBefore(JoinPoint joinPoint){
        System.out.println("前置通知");
        System.out.println("目标类"+joinPoint.getTarget());
        System.out.println("增强方法"+joinPoint.getSignature().getName());
    }

    public void myAfterReturning(JoinPoint joinPoint){
        System.out.println("记录日志");
        System.out.println("增强方法"+joinPoint.getSignature().getName());

    }

     public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
         System.out.println("环绕钱");
         Object obj = proceedingJoinPoint.proceed() ;
         System.out.println("环绕结束后");
         return obj ;
     }
     public void  myAfterThrowing(JoinPoint joinPoint , Throwable e){
         System.out.println("出错" +e.getMessage());

     }

     public void  myatfer(){
         System.out.println("最终通知");
     }
}
