package tn.esprit.examenfinal.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
   @AfterThrowing("execution(* tn.esprit.examenfinal.Services.*.ajouterTicketsEtAffecterAEvenementEtInternaute*(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        String name=joinPoint.getSignature().getName();
        log.info("Le nombre de places restantes depasse le nombre de tickets demandé ! "+name+":");
    }

/*    public static void main(String[] args) {
        LocalTime time1 = LocalTime.of(10, 30, 0); // Replace with your first LocalTime
        LocalTime time2 = LocalTime.of(12, 45, 30); // Replace with your second LocalTime

        Duration duration = Duration.between(time1, time2);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.toSeconds() % 60;

        System.out.println("Time difference: " + hours + " hours, " + min*/



/*    @Around("execution(* tn.esprit.examencinema.Services.*.*(..))")
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
    }*/

}
