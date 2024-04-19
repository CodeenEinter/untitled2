package spring;

import org.aspectj.lang.JoinPoint;

public class xmlAdvice {
    public void before(JoinPoint joinPoint){
        System.out.println("Before Advice");
    }
    public void after(JoinPoint joinPoint){
        System.out.println("After Advice");
    }
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("After Returning Advice");
    }
    public void afterThrowing(JoinPoint joinPoint){
        System.out.println("After Throwing Advice");
    }
    public void Around(JoinPoint joinPoint){
        System.out.println("Around Advice");
    }
}
