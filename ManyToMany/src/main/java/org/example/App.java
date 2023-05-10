package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

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

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Teacher t1 = new Teacher();
        t1.setId(1);
        t1.setName("Aarti");
        t1.setExperience(5);
        t1.setSubject("Java");

        Teacher t2 = new Teacher();
        t2.setId(2);
        t2.setName("Aniruddha");
        t2.setExperience(8);
        t2.setSubject("Node");

        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Shreya");
        s1.setAddress("Dewas");
        s1.setDivision("B");


        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Riya");
        s2.setDivision("A");
        s2.setAddress("Betul");

        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);

        List<Teacher> l1 = new ArrayList<Teacher>();
        l1.add(t1);
        l1.add(t2);

        s1.setTeacher(l1);
        t1.setStudent(list);

        session.save(s1);
        session.save(s2);
        session.save(t1);
        session.save(t2);

        transaction.commit();
        System.out.println("Registered");


    }
}
