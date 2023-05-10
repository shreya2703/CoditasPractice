package org.example;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
//5.6.5
/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args)
    {
        System.out.println( "Hello World!" );

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Student student = new Student();
        System.out.println(student);
        student.setId(1);
        student.setName("Shreya");
        student.setMarks(23);
        System.out.println(student);


       session.save(student);
        transaction.commit(); //session.getTransaction.commit();
        session.close();
        System.out.println("Registered");
//        if(i>0){
//            transaction.commit();
//            System.out.println("Done");
//        }


    }
}
