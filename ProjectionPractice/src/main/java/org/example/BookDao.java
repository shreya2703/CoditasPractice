package org.example;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class BookDao {

    static Configuration configuration=new Configuration().configure();
    static SessionFactory sessionfactory = configuration.buildSessionFactory();

    public static void  insert(Book book){
       Session session = sessionfactory.openSession();
        Transaction tx = session.getTransaction();
        session.save(book);
        tx.commit();
        session.close();
    }

    public static void update(String name,String authname){
        Session session = sessionfactory.openSession();
        Transaction tx = session.getTransaction();
        Query query = session.createQuery("update Book set authname=:authname where name=:name");
        query.setParameter("authname",authname);
        query.setParameter("name",name);
        query.executeUpdate();
        tx.commit();
    }

    public static List<Book> fetchall(){

        Session session = sessionfactory.openSession();
        Transaction tx = session.getTransaction();
        Query query = session.createQuery("from Book");
        List<Book> b =query.getResultList();

          return b;

    }


    public static void deleteBook(int id) {

        Session session = sessionfactory.openSession();
        Transaction tx = session.getTransaction();
       Book book = session.get(Book.class,id);
       session.delete(book);
       tx.commit();

    }


    public static List<Book> RestrictionDao(String auth) {

        Session session = sessionfactory.openSession();
        Transaction tx = session.getTransaction();
        Criteria c = session.createCriteria(Book.class);
        c.add(Restrictions.like("authname",auth));
        return c.list();
    }


    public static List<Book> RestrictOrder(String order, String pn) {
        Session session = sessionfactory.openSession();
        Transaction tx = session.getTransaction();
        Criteria c = session.createCriteria(Book.class);
        c.addOrder(Order.asc())
        return null;
    }
}
