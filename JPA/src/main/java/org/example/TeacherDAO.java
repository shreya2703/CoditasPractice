package org.example;

import javax.persistence.*;
import java.util.List;

public class TeacherDAO {

  static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");


  public static void  insert(Teacher teacher){

      EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(teacher);
    em.getTransaction().commit();
    em.close();

  }


  public static void update(int id, int tsal) {
      EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();

    Teacher teacher = em.find(Teacher.class,id);
    teacher.setSalary(tsal);
    em.merge(teacher);
   em.getTransaction().commit();
    em.close();

  }


  public static void delete(int tid) {
      EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Teacher teacher = em.find(Teacher.class,tid);
//    TypedQuery<Teacher> t = em.createQuery("Delete from Teacher where id =: id", Teacher.class);//.remove(teacher);
//    t.setParameter("id",tid);
     em.remove(teacher);
//    em.createNativeQuery("delete from Teacher where id ="+tid);

    em.getTransaction().commit();
    em.close();

  }

  public static List<Teacher> retrieve() {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      TypedQuery<Teacher> teacher = em.createQuery("select t from Teacher t ", Teacher.class);
      List<Teacher> teachers = teacher.getResultList();
      em.getTransaction().commit();
      em.close();
      return teachers;
  }

//    public static List<Teacher> retrievesome() {
//      EntityManager em = emf.createEntityManager();
//      em.getTransaction().begin();
//      Query q = em.createNativeQuery("select name,salary from Teacher t ", Teacher.class);
//      List<Teacher> t1 = q.getResultList();
//        em.getTransaction().commit();
//        em.close();
//        return t1;
//
//
//    }
}

