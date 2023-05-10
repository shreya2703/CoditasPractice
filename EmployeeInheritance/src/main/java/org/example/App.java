package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Employee e1 = new Employee(1,"Aarti");
        ParttimeExp e2 = new ParttimeExp(2,"Kriti",500,70);
        FulltimeEmp e3 = new FulltimeEmp(3,"Preeti",25000,12,500);

        session.save(e1);
        session.persist(e1);
        session.save(e2);
        session.persist(e2);
        session.save(e3);
        session.persist(e1);
        transaction.commit();

    }
}
