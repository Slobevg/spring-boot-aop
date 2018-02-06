package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggedAdvice {

    @Pointcut("execution(public * *(..))")
    private void anyPublicOperation() {}

    @Pointcut("within(@com.example.aop.Logged *)")
    private void isLogged() {}

    @Pointcut("anyPublicOperation() && isLogged()")
    private void loggedOperation() {}

    @Before("loggedOperation() && args(name,..)")
    public void log(JoinPoint jp, String name) {
        LoggerFactory.getLogger(jp.getTarget().getClass()).info("Hello from " + name);
    }
}
