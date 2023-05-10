package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
//        Emp emp1 = (Emp) context.getBean("p1");
//        System.out.println(emp1);
        Emp emp1 = (Emp) context.getBean("getemp");
        System.out.println(emp1);
//        Person p = (Person) context.getBean("constructor");
//        System.out.println(p);
    }
}
