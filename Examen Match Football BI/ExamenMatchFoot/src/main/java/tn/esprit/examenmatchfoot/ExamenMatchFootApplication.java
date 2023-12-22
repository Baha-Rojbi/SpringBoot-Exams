package tn.esprit.examenmatchfoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExamenMatchFootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenMatchFootApplication.class, args);
	}

}
