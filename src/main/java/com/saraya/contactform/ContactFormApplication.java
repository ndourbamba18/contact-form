package com.saraya.contactform;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author NdourCodeur
 **/

@SpringBootApplication
@EnableAsync
public class ContactFormApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
		System.setProperty("SPRING_MAIL_HOST", dotenv.get("SPRING_MAIL_HOST"));
		System.setProperty("SPRING_MAIL_PORT", dotenv.get("SPRING_MAIL_PORT"));
		System.setProperty("SPRING_MAIL_USERNAME", dotenv.get("SPRING_MAIL_USERNAME"));
		System.setProperty("SPRING_MAIL_PASSWORD", dotenv.get("SPRING_MAIL_PASSWORD"));
		System.setProperty("PORT", dotenv.get("PORT"));

		
		SpringApplication.run(ContactFormApplication.class, args);
		System.out.println("Server started...");
	}

}
