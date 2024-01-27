package tn.esprit.examen.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@org.aspectj.lang.annotation.Aspect
@Component
public class LoginAspect {
    @After("execution(* tn.esprit.examen.Services.*.addDonation(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Merci pour ce don : " + name + " : ");
    }
}
