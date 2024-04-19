package spring;

import org.aspectj.lang.annotation.*;

@Aspect
public class annoAdvice {
    @Pointcut("execution())")
    public void pointcut() {

    }
    @Before("pointcut()")
    public void before() {
        System.out.println("前置通知");
    }
    @After("pointcut()")
    public void after() {
        System.out.println("后置通知");
}
    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("返回通知");
    }
    @Around("pointcut()")
    public void around(){
        System.out.println("环绕通知");
    }
    @AfterThrowing("pointcut()")
    public void afterException(){
        System.out.println("异常通知");
    }
}

