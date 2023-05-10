package org.example;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class DirectorDAO {
    public static Configuration configuration = new Configuration().configure();
    public static SessionFactory sessionFactory = configuration.buildSessionFactory();

    public static void insert(Director director){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(director);
        System.out.println(director);
        transaction.commit();
        session.close();
    }

}
