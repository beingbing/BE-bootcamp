package com.samar.bootcamp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.samar.bootcamp.entity.LockdownOffer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

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
//        persistWithJPA(entityManagerFactory);
//        fetchWithJPA(entityManagerFactory);
        fetchAllWithJPA(entityManagerFactory);
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

    private void inTransaction2(EntityManagerFactory entityManagerFactory, LockdownOffer offer) {
        // Persistence Context
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(offer); // changes staged (managed state)
            // lets change value after staging
            offer.setAvgCnt(78L);
            // will above change be reflected ?
            // the above change got saved because we were still in persist state
            // to not let it reflect we need to go in transient state again using detach();
            entityManager.detach(offer);
            // what if we again want to move it to persist state ?
            // then we need to use merge()
            entityManager.merge(offer);
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
        offer.setAvgAmt(12L);
        offer.setMerchantId(123L);
        offer.setAvgCnt(34L);
        System.out.println("offer: " + offer); // object in transient state
        inTransaction2(entityManagerFactory, offer);
    }

    public void fetchWithJPA(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        LockdownOffer res = entityManager.find(LockdownOffer.class, 10);
        System.out.println("Got object " + res);
    }

    public void fetchAllWithJPA(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query listResult = entityManager.createQuery("SELECT e FROM LockdownOffer e");
        List<LockdownOffer> listRes = listResult.getResultList();

        if (listRes == null) {
            System.out.println("No Restaurant found . ");
        } else {
            for (LockdownOffer r : listRes) {
                System.out.println("Got object : " + r);
            }
        }
    }
}
