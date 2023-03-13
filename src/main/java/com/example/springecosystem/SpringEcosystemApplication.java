package com.example.springecosystem;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEcosystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEcosystemApplication.class, args);
	}


	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return () -> 29;
	}
}
