package com.samar.bootcamp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.samar.bootcamp.entity.LockdownOffer;
import com.samar.bootcamp.hibernate.HibernateService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
public class BootcampApplication implements ApplicationRunner {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(BootcampApplication.class, args);
        System.out.println("Hello Samar !!!");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("run called");
    }
}
