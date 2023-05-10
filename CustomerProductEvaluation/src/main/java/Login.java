import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Hello from Servlet");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession s = req.getSession();


        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("1");

        System.out.println("2");
        Query q = session.createQuery("from Customer where email =:email and  password =:password");
        q.setParameter("email", email);
        q.setParameter("password", password);
        System.out.println("4");
        List<Customer> l = q.list();
        System.out.println("5");
        System.out.println(l.size());
        if (l.size() >= 0) {
            s.setAttribute("email", email);
            resp.sendRedirect("UserPage");
        } else {
            out.println("Invalid Credentials");
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.include(req,resp);
        }
        tx.commit();

    }
}

