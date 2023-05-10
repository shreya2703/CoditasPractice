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

@WebServlet("/IssueOfUser")
public class IssueOfUser extends HttpServlet {
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
     //  String hqls ="FROM Issue i WHERE i.user IN (SELECT u FROM User u WHERE u.manager.id = id )";
        String hqls = "SELECT i FROM Issue i\n" +
                "INNER JOIN i.user u\n" +
                "INNER JOIN u.manager m\n" +
                "WHERE m.id = :id";
        System.out.println(hqls);
       Query querys = session.createQuery(hqls);
       querys.setParameter("id", id);
        System.out.println("Queries list:::"+querys.getResultList());
       List<Issue>issues = querys.list();
//        out.println("<table border = 2px>");
//        out.println("<tr><th>ID</th><th>User Name</th><th>Isue</th><th>Name</th><th>Other</th></tr>");
//            for (Issue issue : issues) {
//                out.println("<tr><td>" + issue.getId() + "</td><td>" + issue.getUser().getName()+  "</td><td>" + issue.getIssue() + "</td><td>"+issue.getName()+"</td><td>"+issue.getOther()+"</td><td>"+issue.getStatus()+"</td></tr>");
//            }
//            out.println("</table>");

        out.println("<table border = 2px>");
        out.println("<tr><th>ID</th><th>User Name</th><th>Issue</th><th>Name</th><th>Other</th><th>Status</th></tr>");
        for (Issue issue : issues) {
            out.println("<tr><td>" + issue.getId() + "</td><td>" + issue.getUser().getName()+  "</td><td>" + issue.getIssue() + "</td><td>"+issue.getName()+"</td><td>"+issue.getOther()+"</td><td>");
            out.println("<form method='get' action='updateIssueStatus'>");
            out.println("<input type='hidden' name='issueId' value='" + issue.getId() + "'>");
            out.println("<input type='text' name = 'status' >");
            out.println("<input type='submit' value='Update Status'>");
            out.println("</form></td></tr>");
        }
        out.println("</table>");

            out.println("</br>");
            out.println("</br>");
            out.println("</br>");
        tx.commit();
        session.close();

out.println("*********************************************************************************************");

//        Session sessions = FactoryProvider.getSessionFactory().openSession();
//        Transaction txs = session.beginTransaction();
//
//        out.println("</br>");
//        out.println("</br>");
//        out.println("</br>");
//
//
//
//        String hqlss = "SELECT i FROM EventBooking i\n" +
//                "INNER JOIN i.user u\n" +
//                "INNER JOIN u.manager m\n" +
//                "WHERE m.id = :id";
//        System.out.println(hqlss);
//        Query queryss = sessions.createQuery(hqlss);
//        querys.setParameter("id", id);
//
//        List<EventBooking> eb = querys.list();
//        out.println("<table border = 2px>");
//        out.println("<tr><th>ID</th><th>User Name</th><th>Monthly Call Time</th></tr>");
//        for (EventBooking eb1 : eb) {
//            out.println("<tr><td>" + eb1.getId() + "</td><td>" + eb1.getUser().getName()+ "</td><td>" + eb1.getEventDatetime()+ "</td></tr>");
//        }
//        out.println("</table>");
//
//        txs.commit();
//        sessions.close();
//
//
//
//
//      //  Issue issues = (Issue) querys.uniqueResult();
//     //   out.println(issues.getId());
//
////            out.println("<table>");
////            out.println("edhar bhi");
////            out.println("<tr><th>ID</th><th>User Name</th><th>Monthly Call Time</th><th>Isue</th><th>Name</th><th>Other</th></tr>");
////            for (Issue issue : issues) {
////                out.println("<tr><td>" + issue.getId() + "</td><td>" + issue.getUser().getName()+ "</td><td>" + issue.getEventDatetime()+ "</td></tr>" + issue.getIssue() + "</td></tr>"+issue.getName()+"</td></tr>"+issue.getOther());
////            }
////            out.println("</table>");
//
//
//        tx.commit();
//        session.close();
//


    }
}
