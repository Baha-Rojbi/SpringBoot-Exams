package tn.esprit.bus.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
        @After("execution(* tn.esprit.bus.Services.*.add*(..))")
    public void logMethodEntry(){
        log.info("C est une methode d ajout ! ");
    }
    @After("execution(* tn.esprit.bus.Services.*.affecter*(..))")
    public void logMethodEntry1(){
        log.info("C est une methode d affectation ! ");
    }
}
