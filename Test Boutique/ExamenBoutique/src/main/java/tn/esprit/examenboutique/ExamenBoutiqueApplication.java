package tn.esprit.examenboutique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExamenBoutiqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenBoutiqueApplication.class, args);
    }

}
