package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("Hello World!");

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = new Student();
        student.setId(1);
        student.setName("Shreya");
        student.setAddress("Dewas");
        student.setDivision("B");

        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("Aarti");
        teacher.setExperience(5);
        teacher.setSubject("Java");
        teacher.setStudent(student);

        student.setTecaher(teacher);


        session.save(student);
        session.save(teacher);
        transaction.commit();

        Teacher t = (Teacher)session.get(Teacher.class,1);
        Student s = t.getStudent();
        //System.out.println(t);
        System.out.println(s);
        //System.out.println(s.getTecaher());





        System.out.println("Registered");






    }
}
