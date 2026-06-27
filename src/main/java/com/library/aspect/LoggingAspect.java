package com.library.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect     // Tells Spring this class contains cross-cutting advice rules
@Component  // Registers this aspect as a discoverable bean during component scanning
public class LoggingAspect {

    // @Before execution: Runs right before the target method executes
    @Before("execution(* com.library.service.BookService.*(..))")
    public void logBeforeMethod() {
        System.out.println("[AOP Advice] >>> Before Advice: Method execution is about to begin.");
    }

    // @After execution: Runs immediately after the target method finishes execution
    @After("execution(* com.library.service.BookService.*(..))")
    public void logAfterMethod() {
        System.out.println("[AOP Advice] <<< After Advice: Method execution has completed successfully.");
    }
}