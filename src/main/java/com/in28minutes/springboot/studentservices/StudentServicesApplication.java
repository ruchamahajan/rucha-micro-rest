package com.in28minutes.springboot.studentservices;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class StudentServicesApplication {

	
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {

		SpringApplication.run(StudentServicesApplication.class, args);
	}
}
