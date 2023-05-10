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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ParseException {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag) {
            System.out.println("Press 0 for exit");
            System.out.println("Press 1 for insert Student Data");
            System.out.println("Press 2 for insert Subjects Data");
            System.out.println("Press 3 for inserting which student gets which subject");
            System.out.println("Press 4 for Criteria Builder Query for duration 3 years");
            System.out.println("Press 5 for Criteria Builder query for less than 2012");
            System.out.println("Press 6 for Criteria Builder query for in wala ");
            System.out.println("Press 7 for Criteria Builder query for where subject = c and address = dewas ");
            System.out.println("Press 8 to enter Teacher Details ");

            int ch = Integer.parseInt(br.readLine());
            switch (ch) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    EntityManager em = emf.createEntityManager();
                    em.getTransaction().begin();
                    System.out.println("Enter the name of student");
                    String name = br.readLine();
                    System.out.println("Enter the address of student");
                    String address = br.readLine();
                    System.out.println("Enter the joining date of student (format: yyyy-MM-dd)");
                    String dateString = br.readLine();
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

                    System.out.println("Enter the end date of student (format: yyyy-MM-dd)");
                    String endDateString = br.readLine();
                    Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateString);

                    Student student = new Student();
                    student.setName(name);
                    student.setAddress(address);
                    student.setJoiningdate(date);
                    student.setEnddate(endDate);

                    em.persist(student);
                    em.getTransaction().commit();
                    em.close();
                    break;
                case 2:
                    EntityManager ems = emf.createEntityManager();
                    ems.getTransaction().begin();
                    System.out.println("Enter the name of Subject");
                    String namesubject = br.readLine();
                    Subjects subject = new Subjects();
                    subject.setName(namesubject);
                    ems.persist(subject);
                    ems.getTransaction().commit();
                    ems.close();
                    break;

                case 3:
                    EntityManager em3 = emf.createEntityManager();
                    em3.getTransaction().begin();
                    System.out.println("Enter the student id");
                    int studentId = Integer.parseInt(br.readLine());
                    Student students = em3.find(Student.class, studentId);
                    if(students == null) {
                        System.out.println("Invalid student id. Please try again.");
                        break;
                    }
                    System.out.println("Enter the number of subjects that the student wants to enroll in");
                    int numSubjectss = Integer.parseInt(br.readLine());
                    List<Subjects> subjectsLists = new ArrayList<Subjects>();
                    for(int i=0; i<numSubjectss; i++) {
                        System.out.println("Enter the subject id #" + (i+1));
                        int subjectId = Integer.parseInt(br.readLine());
                        Subjects subjects = em3.find(Subjects.class, subjectId);
                        if(subjects == null) {
                            System.out.println("Invalid subject id. Please try again.");
                            break;
                        }
                        subjectsLists.add(subjects);
                    }
                    students.setSubjects(subjectsLists);
                    em3.merge(students);
                    em3.getTransaction().commit();
                    em3.close();
                    break;
                case 4:
                    EntityManager em4 = emf.createEntityManager();
                    em4.getTransaction().begin();
                    CriteriaBuilder cb = em4.getCriteriaBuilder();
                    CriteriaQuery<Student> cq = cb.createQuery(Student.class);
                    Root<Student> root = cq.from(Student.class);
                    cq.select(root);
                    cq.where(cb.greaterThan(root.get("joiningdate"),new Date(2000-1900, 5, 6)));
                    TypedQuery<Student> dates = em4.createQuery(cq);
                    List<Student> st = dates.getResultList();
                    for(Student s : st){
                        System.out.println(s);
                    }



                    break;
                case 5:
                    break;
                case 6:
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
                    break;
                case 7:
                    EntityManager entityManager = emf.createEntityManager();
                    CriteriaBuilder cbs = entityManager.getCriteriaBuilder();
                    CriteriaQuery<Student> criteriaQuery = cbs.createQuery(Student.class);
                    Root<Student> student2 = criteriaQuery.from(Student.class);
                    criteriaQuery.where(
                            cbs.equal(student2.get("favouriteSubject"), "maths"),
                            cbs.equal(student2.get("address"), "pune")
                    );
                    List<Student> student1 = entityManager.createQuery(criteriaQuery).getResultList();
                    break;
                case 8:
                    EntityManager em8 = emf.createEntityManager();
                    em8.getTransaction().begin();
                    System.out.println("Enter the name");
                    String sname = br.readLine();
                    Teacher teacher = new Teacher();
                    teacher.setName(sname);
                    System.out.println("Enter the student id");
                    int sid = Integer.parseInt(br.readLine());
                    Student student8 = em8.find(Student.class,sid);
                    teacher.setStudent(student8);
                    em8.persist(teacher);
                    em8.getTransaction().commit();
                    em8.close();




                    break;

            }
        }

    }
}











//
//                    EntityManager em = emf.createEntityManager();
//                    em.getTransaction().begin();
//                    System.out.println("Enter the name of student");
//                    String name = br.readLine();
//                    System.out.println("Enter the address of student");
//                    String address = br.readLine();
//                    Student student = new Student();
//                    student.setName(name);
//                    student.setAddress(address);
//                    System.out.println("Enter the number of subjects that the student is enrolled in");
//                    int numSubjects = Integer.parseInt(br.readLine());
//                    List<Subjects> subjectsList = new ArrayList<Subjects>();
//                    for (int i = 0; i < numSubjects; i++) {
//                        System.out.println("Enter the name of subject #" + (i + 1));
//                        String subjectName = br.readLine().trim();
//                        Subjects subject = new Subjects();
//                        subject.setName(subjectName);
//                        subjectsList.add(subject);
//
//                    }
//                    student.setSubjects(subjectsList);
//                    em.persist(student);
//                    em.getTransaction().commit();
//                    em.close();