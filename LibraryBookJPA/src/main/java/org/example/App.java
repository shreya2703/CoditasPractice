package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag) {
            System.out.println("Press 0 for exit");
            System.out.println("Press 1 for insert Library Details");
            System.out.println("Press 2 for insert Book Details");
            System.out.println("Press 3 for insert Publisher details");
            System.out.println("Press 3 for selecting books having price greater than 450");
            System.out.println("Press 4 for categorising by publisher");
            int ch = Integer.parseInt(br.readLine());
            switch (ch) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    System.out.println("Enter the name of Library");
                    String libName = br.readLine();
                    Library library = new Library();
                    library.setName(libName);
                    LibraryDAO.insert(library);
                    break;
                case 2:
                    EntityManager em = emf.createEntityManager();
                    em.getTransaction().begin();
                    System.out.println("Enter the name of Book");
                    String bname = br.readLine();
                    System.out.println("Enter the Price");
                    int price = Integer.parseInt(br.readLine());
                    System.out.println("Enter the Publisher");
                    String publisher = br.readLine();
                    System.out.println("Enter the id of Library");
                    int libid = Integer.parseInt(br.readLine());
                    Library lib = em.find(Library.class,libid);
                    if(lib != null){
                        Books book = new Books();
                        book.setName(bname);
                        book.setPrice(price);
                        book.setPublisher(publisher);
                        book.setLibrary(lib);
                        BookDAO.insert(book);
                        em.getTransaction().commit();
                    }
                    break;
                case 3:
                    System.out.println("Enter the name of Publisher");
                    String pname = br.readLine();
                    System.out.println("Enter the date in yy-dd-mm format");
                    String date = br.readLine();
                    System.out.println("Enter the book ID");
                    int bid = Integer.parseInt(br.readLine());
                    EntityManager em2 = emf.createEntityManager();
                    em2.getTransaction().begin();

                    Books book = em2.find(Books.class, bid);
                    if (book != null) {
                        Publisher publish = new Publisher();
                        publish.setName(pname);
                        publish.setDate(date);
                        publish.setBooks(book);
                        em2.persist(publish);
                        em2.getTransaction().commit();
                    }
                    break;
                case 4:
                    //CriteriaBuilder
                    EntityManager entityManager = emf.createEntityManager();
                    entityManager.getTransaction().begin();
                    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
                    CriteriaQuery<Books> cq = cb.createQuery(Books.class);
                    Root<Books> root = cq.from(Books.class);
                    cq.select(root);
                    cq.where(cb.gt(root.get("price"), 450));
                    TypedQuery<Books> query = entityManager.createQuery(cq);
                    List<Books> expensiveBooks = query.getResultList();
                    for(Books b: expensiveBooks){
                        System.out.println(b);
                    }
                    break;
                case 5:
                    EntityManager em1 = emf.createEntityManager();
                    em1.getTransaction().begin();
                    CriteriaBuilder cbs = em1.getCriteriaBuilder(); // Get the CriteriaBuilder from the EntityManager
                    CriteriaQuery<Object[]> cqs = cbs.createQuery(Object[].class); // Create a CriteriaQuery for an Object array
                    Root<Books> roo = cqs.from(Books.class); // Create a Root object that represents the Book entity
                    cqs.multiselect(roo.get("publisher"), cbs.count(roo)); // Specify that we want to select the "publisher" attribute and the count of books
                    cqs.groupBy(roo.get("publisher")); // Group the results by the "publisher" attribute
                    cqs.orderBy(cbs.asc(roo.get("publisher"))); // Order the results by the "publisher" attribute in ascending order
                    TypedQuery<Object[]> q1 = em1.createQuery(cqs); // Create a TypedQuery for the Object array
                    List<Object[]> result = q1.getResultList();
                     break;








            }

            }
    }
}






//    CriteriaBuilder cb = entityManager.getCriteriaBuilder(); // Get the CriteriaBuilder from the EntityManager
//    CriteriaQuery<Double> cq = cb.createQuery(Double.class); // Create a CriteriaQuery for a Double value
//    Root<Person> root = cq.from(Person.class); // Create a Root object that represents the Person entity
//cq.select(cb.min(root.get("salary"))); // Specify that we want to select the minimum salary
//        Double minSalary = entityManager.createQuery(cq).getSingleResult();



//    CriteriaBuilder cb = entityManager.getCriteriaBuilder(); // Get the CriteriaBuilder from the EntityManager
//    CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class); // Create a CriteriaQuery for an Object array
//    Root<Person> root = cq.from(Person.class); // Create a Root object that represents the Person entity
//cq.multiselect(root.get("name"), root.get("age")); // Specify that we want to select the name and age attributes
//        List<Object[]> result = entityManager.createQuery(cq).getResultList();