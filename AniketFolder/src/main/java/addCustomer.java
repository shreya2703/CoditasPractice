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

@WebServlet("/addcustomer")
public class addCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("Id"));
        String name = request.getParameter("Name");
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();




        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setCustomerName(name);
        customer.setCustomerEmail(email);
        customer.setCustomerPassword(password);

        session.save(customer);
        transaction.commit();
        session.close();


        response.sendRedirect("addcustomer.jsp");
        /*RequestDispatcher dispatcher = request.getRequestDispatcher("addCustomer.jsp");
        dispatcher.include(request, response);
        out.println("<h1 style='color: #fff'>Registration Successful<h1>");*/
    }
}
