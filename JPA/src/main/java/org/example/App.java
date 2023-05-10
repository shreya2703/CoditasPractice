package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");
        EntityManager em = emf.createEntityManager();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag){
            System.out.println("Press 0 for exit");
            System.out.println("Press 1 for insert");
            System.out.println("Press 2 for Update");
            System.out.println("Press 3 for Delete");
            System.out.println("Press 4 for Retrieve");
            System.out.println("Press 5 for Projection");
            System.out.println("Press 6 for Criteria");
            System.out.println("Press 5 for Restriction");

            int ch = Integer.parseInt(br.readLine());
            switch(ch){
                case 0:
                    flag = false;
                    break;
                case 1:
                    //insert
                    Teacher teacher = new Teacher();
                    System.out.println("Enter the Name of Teacher");
                    String tname = br.readLine();
                    System.out.println("Enter the salary");
                    int sal = Integer.parseInt(br.readLine());
                    teacher.setName(tname);
                    teacher.setSalary(sal);
                    TeacherDAO.insert(teacher);
                    break;
                case 2:
                    //update
                    System.out.println("Enter the id of tecaher");
                    int id = Integer.parseInt(br.readLine());
                    System.out.println("Enter the update salary of teacher");
                    int tsal = Integer.parseInt(br.readLine());
                    TeacherDAO.update(id,tsal);
                    break;
                case 3:
                    //delete
                    System.out.println("Enter the id of tecaher");
                    int tid = Integer.parseInt(br.readLine());
                    TeacherDAO.delete(tid);
                    break;
                case 4:
                    //retrieve
                    List<Teacher> teach = TeacherDAO.retrieve();
                    for(Teacher t: teach){
                        System.out.println(t);
                    }
                    break;
//                case 5:
//                    List<Teacher> t = TeacherDAO.retrievesome();
//                    for(Teacher t1: t){
//                        System.out.println(t1);
//                    }
//                    break;

                default:
                    System.out.println("Please input the corect choice");
                    break;

            }
        }
//        System.out.println( "Hello World!" );
//        em.getTransaction().begin();
//        Teacher teacher = new Teacher();
//        teacher.setName("Shreya");
//        em.persist(teacher);
//        em.getTransaction().commit();
//        em.close();
    }
}
