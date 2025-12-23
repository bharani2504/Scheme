package com.example.Scheme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ImportResource("classpath:scheduler.xml")
public class SchemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchemeApplication.class, args);
	}

}
