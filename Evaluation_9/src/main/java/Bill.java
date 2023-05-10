import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/Bill")
public class Bill extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.println("Hello from Bill Servlet");
        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        HttpSession se = req.getSession();
        Customer customer = (Customer) se.getAttribute("customer");
        int custId = customer.getId();
        Query q = session.createQuery("Select p.qty,p.price from Customer c INNER JOIN c.product p where c.id =: id");
        q.setParameter("id",custId);

        List<Object[]> list = q.getResultList();
        int total=0;
        for(Object[] arr : list){

            String qtys = (String) arr[0];
            String prices = (String) arr[1];
            int qty = Integer.parseInt(qtys);
            int price = Integer.parseInt(prices);
            out.println("Qty: " + qty + ", Price: " + price);
            total = total +(qty*price);
        }
        out.println("Total Bill is : "+total);




    }
}
