package com.nestdigital.nestEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class NestEmployeeApplication {


	public static void main(String[] args) {
		SpringApplication.run(NestEmployeeApplication.class, args);
	}

}
