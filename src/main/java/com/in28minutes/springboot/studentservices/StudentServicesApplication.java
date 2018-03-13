package com.in28minutes.springboot.studentservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StudentServicesApplication {


	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {

		SpringApplication.run(StudentServicesApplication.class, args);
	}
}
