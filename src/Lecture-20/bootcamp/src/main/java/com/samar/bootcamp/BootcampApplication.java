package com.samar.bootcamp;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(BootcampApplication.class, args);
		System.out.println("Hello Samar !!!");
	}
}
