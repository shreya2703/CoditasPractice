import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateIssueStatus")
public class updateIssueStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int issueId = Integer.parseInt(req.getParameter("issueId"));
        String newStatus = req.getParameter("status");

        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "from Issue where id =:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", issueId);
        Issue issue = (Issue) query.uniqueResult();
        issue.setStatus(newStatus);
        session.saveOrUpdate(issue);
        tx.commit();
        session.close();
        resp.sendRedirect("ManagerWelcome");
    }
}
