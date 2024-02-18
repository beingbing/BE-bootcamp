package com.samar.bootcamp;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // will look for @scheduled and start it
public class BootcampApplication {
    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(BootcampApplication.class, args);
        System.out.println("Hello Samar !!!");
    }
}
