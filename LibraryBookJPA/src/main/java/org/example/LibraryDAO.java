package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LibraryDAO {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");


    public static void insert(Library library) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(library);
        em.getTransaction().commit();
        em.close();
    }
}
