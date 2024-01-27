package tn.esprit.examenassurance.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Slf4j
@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {
    @After("execution(* tn.esprit.examenassurance.Services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        String name=joinPoint.getSignature().getName();
        log.info(name);
    }
}
