package org.example;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BookDao {


    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    public static void insertBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }


    public static void Update(int price, String bookname) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "UPDATE Book SET price = :price WHERE bookname = :bookname";
           // Query query = session.createQuery(hql);
            Query query = session.createQuery(hql);
            query.setParameter("price", price);
            query.setParameter("bookname", bookname);
            int result = query.executeUpdate();
            tx.commit();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Book> fetchByRestriction(int p) {
        Session session = sessionFactory.openSession();
        Criteria c = session.createCriteria(Book.class);
        c.add(Restrictions.gt("price",p));
        return c.list();

    }

    public static List<Book> fetchByOrder(String order,String pn){
        Session session = sessionFactory.openSession();
        Criteria c = session.createCriteria(Book.class);
        if(order.equalsIgnoreCase("asc")){
            c.addOrder(Order.asc(pn));
        }else if(order.equalsIgnoreCase("desc")){
            c.addOrder(Order.desc(pn));
        }
       return c.list();
    }

    public static List<Object> fetchByProjection(String pnt){
        Session session = sessionFactory.openSession();
        Criteria c1 = session.createCriteria(Book.class);
        c1.setProjection(Projections.property(pnt));
        return c1.list();
    }

    public static List<Object[]> fetchByProjectionList(String pn3,String pn1, String pn2) {
        Session session = sessionFactory.openSession();
        Criteria c2 = session.createCriteria(Book.class);

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property(pn3));
        projectionList.add(Projections.property(pn1));
        projectionList.add(Projections.property(pn2));
        c2.setProjection(projectionList);

//        c2.add(Restrictions.eq("bookName", bookName))
//                .add(Restrictions.eq("authorName", authorName))
        // c2.setProjection(projectionList);

        return c2.list();
    }

    public static void delete(int id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.get(Book.class,id);
        session.delete(book);
        transaction.commit();
        session.close();
    }

    public static List<Book> fetchAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Book> b;

        try {
            Query query = session.createQuery("from Book");
            b = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        session.close();
        return b;

    }
}