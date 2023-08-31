package com.example.study_aspectspring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("within(@org.springframework.stereotype.Service com.example.study_aspectspring.GreetingService+)")
//    public void anyGreetingServiceMethod(){}
//
//    @Pointcut("execution(public String getGreeting(String))")
//    public void anyGreetingServiceMethod(){}
//
//    @Pointcut("this(com.example.study_aspectspring.GreetingService+)")
//    public void anyGreetingServiceMethod(){}
//
//    @Before("anyGreetingServiceMethod()")
//    public void beforeAnyGreetingServiceMethod(){
//        LOGGER.info("===== BEFORE ======");
//    }
//
//
//    @Pointcut("this(proxy)")
//    public void anyGreetingServiceMethod(GreetingService proxy){}
//
//    @Before("anyGreetingServiceMethod(proxy)")
//    public void beforeAnyGreetingServiceMethod(GreetingService proxy){
//        LOGGER.info("===== BEFORE ======");
//    }
//
//
//        @Pointcut("target(com.example.study_aspectspring.GreetingService+)")
//    public void anyGreetingServiceMethod(){}
//
//    @Before("anyGreetingServiceMethod()")
//    public void beforeAnyGreetingServiceMethod(){
//        LOGGER.info("===== BEFORE ======");
//    }
//
//    @Pointcut("args(java.lang.String)")
//    public void anyGreetingServiceMethod(){}
//
//    @Before("anyGreetingServiceMethod()")
//    public void beforeAnyGreetingServiceMethod(){
//        LOGGER.info("===== BEFORE ======");
//    }
//
//    @Pointcut("@target(annotation)")
//    public void anyGreetingServiceMethod(Service annotation){}
//
//    @Before("anyGreetingServiceMethod(annotation)")
//    public void beforeAnyGreetingServiceMethod(Service annotation){
//        LOGGER.info("===== BEFORE ======" + " " + annotation.value());
//    }
//
//    @Pointcut("@args(annotation)")
//    public void anyGreetingServiceMethod(Service annotation){}
//
//    @Before("anyGreetingServiceMethod(annotation)")
//    public void beforeAnyGreetingServiceMethod(Service annotation){
//        LOGGER.info("===== BEFORE ======" + " " + annotation.value());
//    }
//
//    @Pointcut("@within(annotation)")
//    public void anyGreetingServiceMethod(Service annotation){}
//
//    @Before("anyGreetingServiceMethod(annotation)")
//    public void beforeAnyGreetingServiceMethod(Service annotation){
//        LOGGER.info("===== BEFORE ======" + " " + annotation.value());
//    }
//
//    @Pointcut("@annotation(SFR)")
//    public void anyGreetingServiceMethod(){}
//
//    @Before("anyGreetingServiceMethod()")
//    public void beforeAnyGreetingServiceMethod(){
//        LOGGER.info("===== BEFORE ======");
//    }

    @Pointcut("bean(*Service) && args(String)")
    public void anyGreetingServiceMethod() {
    }

    @Before("anyGreetingServiceMethod()")
    public void beforeAnyGreetingServiceMethod(JoinPoint joinPoint) {
        LOGGER.info("===== BEFORE ======");
        LOGGER.info("===== BEFORE ====== {}", joinPoint.getArgs());
        LOGGER.info("===== BEFORE ====== {}", joinPoint.getThis().getClass().getName());
        LOGGER.info("===== BEFORE ====== {}", joinPoint.getTarget().getClass().getName());
        LOGGER.info("===== BEFORE ====== {}", joinPoint.getSignature());
    }

    @After("anyGreetingServiceMethod()")
    public void afterAnyGreetingServiceMethod() {
        LOGGER.info("===== AFTER ======");
    }

    @AfterReturning(value = "anyGreetingServiceMethod()", returning = "result")
    public void afterRetAnyGreetingServiceMethod(Object result) {
        System.out.println("ОтВЕТ" + result);
        LOGGER.info("===== Returning ======");
    }

    @AfterThrowing(value = "anyGreetingServiceMethod()", throwing = "error")
    public void afterThrowingAnyGreetingServiceMethod(Exception error) {
        LOGGER.info("===== Throwing ======");
    }

    @Around("anyGreetingServiceMethod()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("beggin");
        Object[] args = proceedingJoinPoint.getArgs();
        if (args[0] instanceof String string) {
            args[0] = string.toUpperCase();
        }
        var result = proceedingJoinPoint.proceed(args);
        LOGGER.info("END");
        return result;
    }
}