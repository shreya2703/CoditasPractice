import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SaveEvent")
public class SaveEvent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Hello from Issue Servlet");
        resp.setContentType("text/html");
        String email = req.getParameter("email");
        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "from Manager where email =:email1 ";
        Query query = session.createQuery(hql);
        query.setParameter("email1", email);
        Manager manager = (Manager) query.uniqueResult();
        int id = manager.getId();
        out.println(id);
        String hqlss = "SELECT i FROM EventBooking i\n" +
                "INNER JOIN i.user u\n" +
                "INNER JOIN u.manager m\n" +
                "WHERE m.id = :id";
        System.out.println(hqlss);
        Query querys = session.createQuery(hqlss);
        querys.setParameter("id", id);

        List<EventBooking> eb = querys.list();
        out.println("<table border = 2px>");
        out.println("<tr><th>ID</th><th>User Name</th><th>Monthly Call Time</th></tr>");
        for (EventBooking eb1 : eb) {
            out.println("<tr><td>" + eb1.getId() + "</td><td>" + eb1.getUser().getName()+ "</td><td>" + eb1.getEventDatetime()+ "</td></tr>");
        }
        out.println("</table>");

        tx.commit();
        session.close();
    }
}
