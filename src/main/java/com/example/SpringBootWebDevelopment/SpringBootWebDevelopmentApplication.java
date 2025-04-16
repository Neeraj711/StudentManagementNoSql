package com.example.SpringBootWebDevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.example.SpringBootWebDevelopment")
public class SpringBootWebDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebDevelopmentApplication.class, args);
	}

}
