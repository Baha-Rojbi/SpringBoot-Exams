package tn.esprit.examencoursclassroom;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class ExamenCoursClassroomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenCoursClassroomApplication.class, args);
	}

}
