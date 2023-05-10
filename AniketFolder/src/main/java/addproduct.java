import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addpro")
public class addproduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session1 = request.getSession();
        int cusId = (int) session1.getAttribute("cidd");
        /*int id = Integer.parseInt(request.getParameter("pid"));
        String name = request.getParameter("Name");
        int price = Integer.parseInt(request.getParameter("price1"));
        int quantity = Integer.parseInt(request.getParameter("Quantity"));*/

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();


        Product product = new Product();
        product.setProductId(1);
        product.setProductName("pen");
        product.setProductPrice(10);
        product.setProductQuantity(100);

        Product product1 = new Product();
        product1.setProductId(2);
        product1.setProductName("pencil");
        product1.setProductPrice(5);
        product1.setProductQuantity(50);

        Product product2 = new Product();
        product2.setProductId(3);
        product2.setProductName("box");
        product2.setProductPrice(2);
        product2.setProductQuantity(10);

        Product product3 = new Product();
        product3.setProductId(4);
        product3.setProductName("Ball");
        product3.setProductPrice(10);
        product3.setProductQuantity(120);

        Customer customer1 = new Customer();
        customer1.setCustomerId(cusId);

        product.setCustomer(customer1);
        product1.setCustomer(customer1);
        product2.setCustomer(customer1);
        product3.setCustomer(customer1);

        session.save(product);
        session.save(product1);
        session.save(product2);
        session.save(product3);


        transaction.commit();
        session.close();


        response.sendRedirect("showproduct");
    }
}

