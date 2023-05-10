import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ManagereditServlet")
public class ManagereditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));

        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Manager manager = session.get(Manager.class,id);

        req.setAttribute("managerEdit",manager);
        req.getRequestDispatcher("showManagerEdit.jsp").forward(req,resp);

        session.close();
    }
}
