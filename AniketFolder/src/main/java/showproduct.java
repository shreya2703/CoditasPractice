import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showproduct")
public class showproduct extends HttpServlet {
    static Configuration configuration = new Configuration().configure().addAnnotatedClass(Product.class);
    static SessionFactory sessionFactory = configuration.buildSessionFactory();


    public static List<Product> selectAllCrm() {
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        List<Product> product =s.createQuery("from Product").list();
        tx.commit();
        s.close();
        return product;
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




        List<Product> productList =selectAllCrm();
        request.setAttribute("custList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
// Print the retrieved books



        out.println("<a href=\"product.jsp\">back</a>");

    }
}
