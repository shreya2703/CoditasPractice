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

//between range and like a% and min(sal)
//criteria order by ranges
//range min max avg sum

public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag) {
            System.out.println("Press 0 for exit");
            System.out.println("Press 1 for insert Zoo Name");
            System.out.println("Press 2 for insert Animals Data");
            System.out.println("Press 3 for update Animals Data");
            System.out.println("Press 4 for update Zoo Data");
            System.out.println("Press 5 for delete Animals Data");
            System.out.println("Press 6 for delete Zoo Data");
            System.out.println("Press 7 to get all animals whose age is greater than 4");
            System.out.println("Press 8 to get category wise animals");
            System.out.println("Press 9 to get age range between 3 to 6");
            System.out.println("Press 10 to get name like Z% from Zoo");
          //System.out.println("Press 11 to get category wise animals");

            int ch = Integer.parseInt(br.readLine());
            switch (ch) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    EntityManager em = emf.createEntityManager();
                    em.getTransaction().begin();
                    System.out.println("Enter the name of Zoo");
                    String name = br.readLine();
                    System.out.println("Enter the city");
                    String city = br.readLine();
                    Zoo zoo = new Zoo();
                    zoo.setName(name);
                    zoo.setCity(city);
                    ZooDAO.insert(zoo);

                    break;
                case 2:
                    EntityManager ems = emf.createEntityManager();
                    ems.getTransaction().begin();
                    System.out.println("Enter the name of Animal");
                    String Animalname = br.readLine();
                    System.out.println("Enter the age");
                    String age = br.readLine();
                    System.out.println("Enter the category :: Domestic/Wild");
                    String category = br.readLine();
                    System.out.println("Enter the Zoo in which you want it ");
                    int zid = Integer.parseInt(br.readLine());
                    Zoo zoo2 = ems.find(Zoo.class, zid); // fetch zoo by id
                    if (zoo2 != null) {
                        Animals animal = new Animals();
                        animal.setName(Animalname);
                        animal.setAge(age);
                        animal.setCategory(category);
                        animal.setZoo(zoo2);
                       AnimalsDAO.insert(animal);
                       //ems.persist(animal);
                        ems.getTransaction().commit();
                    }
                    break;
                case 3:
                    EntityManager em1 = emf.createEntityManager();
                    em1.getTransaction().begin();
                    System.out.println("Enter the id of animal");
                    int id2 = Integer.parseInt(br.readLine());
                    System.out.println("Enter the updated age of animal");
                    String ages = br.readLine();
                    AnimalsDAO.update(id2,ages);
                    break;
                case 4:
                    EntityManager em9 = emf.createEntityManager();
                    em9.getTransaction().begin();
                    System.out.println("Enter the id of zoo");
                    int id8 = Integer.parseInt(br.readLine());
                    System.out.println("Enter the updated name of city");
                    String city2 = br.readLine();
                    ZooDAO.update(id8,city2);
                    break;
                case 5:
                    System.out.println("Enter the id of animal");
                    int tid = Integer.parseInt(br.readLine());
                    EntityManager em5 = emf.createEntityManager();
                    em5.getTransaction().begin();
                    AnimalsDAO.delete(tid);
                    break;
                case 6:
                    System.out.println("Enter the id of zoo");
                    int Zooid = Integer.parseInt(br.readLine());
                    EntityManager em6 = emf.createEntityManager();
                    em6.getTransaction().begin();
                    ZooDAO.delete(Zooid);
                    break;
                case 7:
                    EntityManager em2 = emf.createEntityManager();
                    em2.getTransaction().begin();
                    System.out.println("Enter the age of animal");
                    String ag = br.readLine();
                    TypedQuery<Animals> ani = em2.createQuery("select a from Animals a where a.age >= : age", Animals.class);
                    ani.setParameter("age",ag);
                     List<Animals> ani5 = ani.getResultList();
                     for(Animals an1 : ani5){
                         System.out.println(an1);
                     }
                    em2.getTransaction().commit();
                    em2.close();
                    break;
                case 8:
                    EntityManager em3 = emf.createEntityManager();
                    em3.getTransaction().begin();
                    System.out.println("Enter the category of animal(domestic/wild)");
                    String c = br.readLine();
                    TypedQuery<Animals> a = em3.createQuery("select a from Animals a where a.category = : category", Animals.class);
                    a.setParameter("category",c);
                    List<Animals> a1 = a.getResultList();
                    for(Animals an1 : a1){
                        System.out.println(an1);
                    }
                    em3.getTransaction().commit();
                    em3.close();
                    break;
                case 9:
                    EntityManager entityManager = emf.createEntityManager();
                    entityManager.getTransaction().begin();
                    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
                    CriteriaQuery<Animals> cq = cb.createQuery(Animals.class);
                    Root<Animals> root = cq.from(Animals.class);
                    cq.where(cb.between(root.get("age"), 3, 6));
                    List<Animals> results = entityManager.createQuery(cq).getResultList();
                    for(Animals a2 : results){
                        System.out.println(a2);
                    }
                    entityManager.getTransaction().commit();
                    entityManager.close();
                    break;
                case 10:
                    EntityManager em0 = emf.createEntityManager();
                    em0.getTransaction().begin();
                    CriteriaBuilder cbs = em0.getCriteriaBuilder();
                    CriteriaQuery<Zoo> cqs = cbs.createQuery(Zoo.class);
                    Root<Zoo> roo = cqs.from(Zoo.class);
                    cqs.select(roo);
                    cqs.where(cbs.like(roo.get("name"), "Z%"));
                    TypedQuery<Zoo> query = em0.createQuery(cqs);
                    List<Zoo> result = query.getResultList();
                    for(Zoo an0 : result){
                        System.out.println(an0);
                    }
                    em0.getTransaction().commit();
                    em0.close();
                    break;



            }
        }


    }
}

//min sal

//    CriteriaBuilder cb = entityManager.getCriteriaBuilder(); // Get the CriteriaBuilder from the EntityManager
//    CriteriaQuery<Double> cq = cb.createQuery(Double.class); // Create a CriteriaQuery for a Double value
//    Root<Person> root = cq.from(Person.class); // Create a Root object that represents the Person entity
//cq.select(cb.min(root.get("salary"))); // Specify that we want to select the minimum salary
//        Double minSalary = entityManager.createQuery(cq).getSingleResult();


//multiselect

//    CriteriaBuilder cb = entityManager.getCriteriaBuilder(); // Get the CriteriaBuilder from the EntityManager
//    CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class); // Create a CriteriaQuery for an Object array
//    Root<Person> root = cq.from(Person.class); // Create a Root object that represents the Person entity
//cq.multiselect(root.get("name"), root.get("age")); // Specify that we want to select the name and age attributes
//        List<Object[]> result = entityManager.createQuery(cq).getResultList();



//Order bY
//EntityManager em1 = emf.createEntityManager();
//                    em1.getTransaction().begin();
//                            CriteriaBuilder cbs = em1.getCriteriaBuilder(); // Get the CriteriaBuilder from the EntityManager
//                            CriteriaQuery<Object[]> cqs = cbs.createQuery(Object[].class); // Create a CriteriaQuery for an Object array
//        Root<Books> roo = cqs.from(Books.class); // Create a Root object that represents the Book entity
//        cqs.multiselect(roo.get("publisher"), cbs.count(roo)); // Specify that we want to select the "publisher" attribute and the count of books
//        cqs.groupBy(roo.get("publisher")); // Group the results by the "publisher" attribute
//        cqs.orderBy(cbs.asc(roo.get("publisher"))); // Order the results by the "publisher" attribute in ascending order
//        TypedQuery<Object[]> q1 = em1.createQuery(cqs); // Create a TypedQuery for the Object array
//        List<Object[]> result = q1.getResultList();
//        break;



//gt
//CriteriaBuilder
//EntityManager entityManager = emf.createEntityManager();
//                    entityManager.getTransaction().begin();
//                            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//                            CriteriaQuery<Books> cq = cb.createQuery(Books.class);
//        Root<Books> root = cq.from(Books.class);
//        cq.select(root);
//        cq.where(cb.gt(root.get("price"), 450));
//        TypedQuery<Books> query = entityManager.createQuery(cq);
//        List<Books> expensiveBooks = query.getResultList();
//        for(Books b: expensiveBooks){
//        System.out.println(b);
//        }
//        break;



//adress in pune or indore
//                    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//                    CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);
//                    Root<Student> student = criteriaQuery.from(Student.class);
//                    criteriaQuery.where(
//                            cb.or(
//                                    cb.equal(student.get("address"), "pune"),
//                                    cb.equal(student.get("address"), "dewas")
//                            )
//                    );
//                    List<Student> students = entityManager.createQuery(criteriaQuery).getResultList();



//where and wala
//  EntityManager entityManager = emf.createEntityManager();
//                    CriteriaBuilder cbs = entityManager.getCriteriaBuilder();
//                    CriteriaQuery<Student> criteriaQuery = cbs.createQuery(Student.class);
//                    Root<Student> student2 = criteriaQuery.from(Student.class);
//                    criteriaQuery.where(
//                            cbs.equal(student2.get("favouriteSubject"), "maths"),
//                            cbs.equal(student2.get("address"), "pune")
//                    );
//                    List<Student> student1 = entityManager.createQuery(criteriaQuery).getResultList();
//                    break;