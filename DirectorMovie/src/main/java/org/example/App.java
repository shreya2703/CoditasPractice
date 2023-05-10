package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Song s1 = new Song();
        s1.setName("Yeh Hai");

        Song s2 = new Song();
        s1.setName("Yeh Jawani");




        List<Song> song = new ArrayList<>();
        song.add(s1);
        song.add(s2);



        Movie m1= new Movie();
        m1.setName("PS-1");
        m1.setSong(song);

    s1.setMovie(m1);

        Movie m2 = new Movie();
        m2.setName("YJHD");
        m2.setSong(song);
s2.setMovie(m2);
        Director d = new Director();
        d.setName("Yash Chopra");

        m1.setDirector(d);
        m2.setDirector(d);

        Set<Movie> movies = new HashSet<Movie>();
        movies.add(m1);
        movies.add(m2);
        d.setMovies(movies);

       session.save(d);
       session.save(m1);
       session.save(m2);
       session.save(s1);
       session.save(s2);
       transaction.commit();
    }
}
