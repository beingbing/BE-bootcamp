package com.samar.bootcamp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.samar.bootcamp.entity.LockdownOffer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // will look for @scheduled and start it
public class BootcampApplication implements ApplicationRunner {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(BootcampApplication.class, args);
        System.out.println("Hello Samar !!!");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("run called");
        EntityManagerFactory entityManagerFactory = setUp();
        persistWithJPA(entityManagerFactory);
    }

    protected EntityManagerFactory setUp() {
        // JPA interface - Hibernate implementation
        return Persistence.createEntityManagerFactory("persistence");
    }

    private void inTransaction(EntityManagerFactory entityManagerFactory, LockdownOffer offer) {
        // Persistence Context
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(offer); // changes staged (managed state)
            transaction.commit(); // changes committed
            System.out.println("Generated ID = " + offer.getId());
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void persistWithJPA(EntityManagerFactory entityManagerFactory) {
        LockdownOffer offer = new LockdownOffer(); // object in new state
        offer.setAvgAmt(30L);
        offer.setMerchantId(123L);
        offer.setAvgCnt(65L);
        System.out.println("offer: " + offer); // object in transient state
        inTransaction(entityManagerFactory, offer);
    }
}
