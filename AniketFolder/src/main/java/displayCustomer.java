import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/displayCustomer")
public class displayCustomer extends HttpServlet {

    static Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
    static SessionFactory sessionFactory = configuration.buildSessionFactory();


    public static List<Customer> selectAllCrm() {
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        List<Customer> customers =s.createQuery("from Customer").list();
        tx.commit();
        s.close();
        return customers;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        /*List<Customer> customers = null;


        try (Session session = sessionFactory.openSession()) {
            // Create a Hibernate Query object
            Query<Customer> query = session.createQuery("FROM Customer", Customer.class);

            // Retrieve all books from the database
            customers = query.list();

        } catch (HibernateException e) {
            System.err.println("Error while retrieving all Custumer: " + e.getMessage());
        }*/




        List<Customer> customerList =selectAllCrm();
        request.setAttribute("custList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-list.jsp");
        dispatcher.forward(request, response);
// Print the retrieved books



        out.println("<a href=\"product-list.jsp\">back</a>");

    }
}
