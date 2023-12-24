package tn.esprit.examendatacenter.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingAspect {
    @Around("execution(* tn.esprit.examendatacenter.Services.*.*(..))")
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
