package org.example;


//One Teacher Many Student


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("Aarti");
        teacher.setExperience(5);
        teacher.setSubject("Java");

        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Shreya");
        s1.setAddress("Dewas");
        s1.setDivision("B");
        s1.setTeacher(teacher);

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Riya");
        s2.setDivision("A");
        s2.setAddress("Betul");
        s2.setTeacher(teacher);


        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);

        teacher.setStudent(list);





        session.save(teacher);
        session.save(s1);
        session.save(s2);
        transaction.commit();

//        Lazy loading we need to explicitly call getid or getanswer bydefault it is this only
//        Teacher t = (Teacher)session.get(Teacher.class,1);
//        System.out.println(t.getId());
//        System.out.println(t.getName());
//        System.out.println(t.getStudent().size());

        //Eager Loading in mapped by add fetch = fetchBy.Eager
        Teacher t = (Teacher)session.get(Teacher.class,1);
        System.out.println(t.getId());
        System.out.println(t.getName());
        System.out.println(t.getStudent().size());





//        Student s = t.getStudent().get(1);
//        System.out.println(s);



        System.out.println("Registered");

    }

}
