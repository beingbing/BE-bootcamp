package com.samar.bootcamp.hibernate;

import com.samar.bootcamp.entity.LockdownOffer;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HibernateService {

    @Autowired
    private SessionFactory sessionFactory;

    public void execute() {
        System.out.println("Hibernate Service");
//        persistWithHibernate();
//        fetchAllWithHibernate();
//        LockdownOffer offer = fetchWithHibernate(7);
//        removeWithHibernate(offer);
    }

    private void persistWithHibernate() {
        LockdownOffer offer = new LockdownOffer();
        offer.setAvgAmt(8L);
        offer.setMerchantId(76L);
        offer.setAvgCnt(3L);
        System.out.println("offer: " + offer);
        inTransaction(offer);
    }

    private void inTransaction(LockdownOffer offer) {
        Session session = sessionFactory.openSession();
        EntityTransaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(offer);
            transaction.commit();
            System.out.println("Generated ID = " + offer.getId());
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public LockdownOffer fetchWithHibernate(int id) {
        Session session = sessionFactory.openSession();
        LockdownOffer res = session.find(LockdownOffer.class, id);
        System.out.println("Got object " + res);
        session.close();
        return res;
    }

    public void fetchAllWithHibernate() {
        Session session = sessionFactory.openSession();
        Query listResult = session.createQuery("SELECT e FROM LockdownOffer e", LockdownOffer.class);
        List<LockdownOffer> listRes = listResult.getResultList();

        if (listRes == null) {
            System.out.println("No Restaurant found . ");
        } else {
            for (LockdownOffer r : listRes) {
                System.out.println("Got object : " + r);
            }
        }

        session.close();
    }

    public void removeWithHibernate(LockdownOffer offer) {
        Session session = sessionFactory.openSession();
        EntityTransaction transaction = session.getTransaction();
        try {
            System.out.println("Deleting offer with ID = " + offer.getId());
            transaction.begin();
            session.remove(session.contains(offer) ? offer : session.merge(offer));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}
