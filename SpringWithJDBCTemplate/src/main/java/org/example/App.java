package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringJt.xml");

        BookDao bookDao = (BookDao) context.getBean("dao");

        Book book = new Book();
        book.setBookName("C");
        book.setAuthorName("Shreya Kalluraya");
        book.setPrice(900.0f);
        bookDao.insertBook(book);

        List<Book> books = bookDao.fetchAllBooks();
        for (Book b : books) {
            System.out.println(b.toString());
        }

        bookDao.deleteBook("C");


        int bookId = 1;
        List<Book> book2 = bookDao.FetchUsingResultset(bookId);
        for (Book book3 : book2) {
            System.out.println(book.toString());
        }







    }
}
