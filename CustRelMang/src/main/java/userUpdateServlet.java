import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/userUpdateServlet")
public class userUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        int id = Integer.parseInt(req.getParameter("userId"));


        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        User user = (User)session.get(User.class,id);

        user.setName(name);
        user.setAddress(address);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPasswod(password);

        tx.commit();
        session.close();
        resp.setContentType("Text/HTML");
        PrintWriter out = resp.getWriter();
        out.println("</br>");
       resp.sendRedirect("admin");

    }
}
