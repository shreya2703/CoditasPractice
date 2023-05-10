package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your choice");
        int ch = Integer.parseInt(br.readLine());
        switch(ch){
            case 1:
                //insert
                System.out.println("Enter name");
                String name = br.readLine();
                System.out.println("Enter auth name");
                String authname=br.readLine();
                Book book = new Book();
                book.setName(name);
                book.setAuthname(authname);
                BookDao.insert(book);
                break;
            case 2:
                //update
                System.out.println("Enter name");
                String name1 = br.readLine();
                System.out.println("Enter auth name");
                String authname1=br.readLine();
                BookDao.update(name1,authname1);

                break;

            case 3:
                //all
                List<Book> list;
                list = BookDao.fetchall();
                for(Book b1 : list){
                    System.out.println(b1);
                }

                break;

            case 4:
                //Delete
                System.out.println("Enter id");
                int id = Integer.parseInt(br.readLine());
                BookDao.deleteBook(id);
                break;

            case 5:
                //Restriction
                System.out.println("Enter the authname");
                String auth = br.readLine();
                List<Book> l1 = BookDao.RestrictionDao(auth);
                for(Book b1 : l1){
                    System.out.println(b1);
                }

                break;
            case 6:
                System.out.println("Enter the asc/desc");
                String order = br.readLine();
                System.out.println("Enter property name");
                String pn = br.readLine();
                List<Book> l2 = BookDao.RestrictOrder(order,pn);

                break;





        }
    }
}
