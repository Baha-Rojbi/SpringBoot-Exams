package tn.esprit.examencinema.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* tn.esprit.examencinema.Services.*.*(..))")
    public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = proceedingJoinPoint.getSignature().getName();

        try {
            // Execute the method
            return proceedingJoinPoint.proceed();
        } finally {
            // Compute the duration after method execution
            long duration = System.currentTimeMillis() - start;
            log.info("Execution Time of method " + methodName + " is " + duration + " ms");
        }
    }
}
