package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "Hello World!" );
        System.out.println( "Hello World!" );

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Shreya");
        s1.setAddress("Dewas");
        s1.setDivision("B");
        s1.setDob(new Date());

        Certificate certi = new Certificate();
        certi.setCourse("Java");
        certi.setDuration("4");
        s1.setCertificate(certi);
//        try {
//            FileInputStream fis = new FileInputStream("src/main/resources/image.png");
//            byte[] data = new byte[fis.available()];
//            fis.read(data);
//            s1.setImage(data);
//
//
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        session.save(s1);
        transaction.commit();


    }
}
