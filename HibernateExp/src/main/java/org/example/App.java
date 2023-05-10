package org.example;

import org.example.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println("Hello World!");
        System.out.println("Hello World!");


        Scanner sc = new Scanner(System.in);
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Book> l;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while (flag){

            System.out.println("Press 0 for Exit");
        System.out.println("Press 1 for Insert");
        System.out.println("Press 2 for Update");
        System.out.println("Press 3 for Delete");
        System.out.println("Press 4 to show all data");
        System.out.println("Press 5 fetch BY Restriction");
        System.out.println("Press 6 ORDER BY Restriction");
        System.out.println("Press 7 projection");
        System.out.println("Press 8 projections by various ");


        int ch = sc.nextInt();
        switch (ch) {
            case 0:
                flag = false;
                break;
            case 1:
                Book book = new Book();
                System.out.println("Enter Bid,bookname,authname,publishername,publisheryear,price");
                book.setId(sc.nextInt());
                sc.nextLine();
                book.setBookname(sc.nextLine());
                book.setAuthname(sc.nextLine());
                book.setPublishername(sc.nextLine());
                book.setPublisheryear(sc.nextInt());
                book.setPrice(sc.nextInt());

                BookDao.insertBook(book);

                break;
            case 2:
                Book book1 = new Book();
                System.out.println("Enter the price and book name");
                int price = sc.nextInt();
                sc.nextLine();
                String bookname = sc.nextLine();
                BookDao.Update(price, bookname);

                break;
            case 3:
                System.out.println("Enter the id");
                int id = Integer.parseInt(br.readLine());
                BookDao.delete(id);
                break;
            case 4:
                l = BookDao.fetchAll();
                for (Book b1 : l) {
                    System.out.println(b1);
                }

                break;
            case 5:
                System.out.println("Enter the price ");
                int p = sc.nextInt();
                l = BookDao.fetchByRestriction(p);
                for (Book b1 : l) {
                    System.out.println(b1);
                }
                break;
            case 6:
//                System.out.println(" Enter order");
//                String order = sc.nextLine();
//                System.out.println("Enter property name");
//                String pn = sc.nextLine();
//                l=BookDao.fetchByOrder(order,pn);
//                for(Book b1:l){
//                    System.out.println(b1);
//                }
                System.out.println("Enter order(asc/desc)");
                String order = br.readLine();
                System.out.println("Enter property name");
                String pn = br.readLine();
                l = BookDao.fetchByOrder(order, pn);
                for (Book b1 : l) {
                    System.out.println(b1);
                }
                break;
            case 7:
                System.out.println("Enter the property");
                String pnt = br.readLine();
                List<Object> obj = BookDao.fetchByProjection(pnt);
                for (Object b1 : obj) {
                    System.out.println(b1);
                }
                break;
            case 8:
                System.out.println("Enter three property");
                String pn3 = br.readLine();
                System.out.println(pn3);
                String pn1 = br.readLine();
                String pn2 = br.readLine();

                List<Object[]> projectionList = BookDao.fetchByProjectionList(pn3, pn1, pn2);

                for (Object[] objArr : projectionList) {
                    System.out.println(objArr[0] + "  " + objArr[1] + " " + objArr[2]);
                }

                break;
        }


    }



















//        Book book = new Book();
//        System.out.println(book);
//        book.setId(1);
//        book.setBookname("Simple C");
//        book.setAuthname("Shreya");
//        book.setPublishername("Krati");
//        book.setPublisheryear(1932);
//        book.setPrice(290);
//        System.out.println(book);
//
//
//        //session.getTransaction().commit();
//        session.save(book);
//       transaction.commit();
//        session.close();
//
//        System.out.println("Registered");
    }
}
