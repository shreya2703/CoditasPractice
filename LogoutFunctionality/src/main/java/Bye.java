import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Bye")
public class Bye extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("name") !=null) {
            PrintWriter out = resp.getWriter();

            resp.setContentType("Text/HTML");
            out.println("Bye User");
            out.println("<a href ='Logout'>Logout</a>");
        }
        else{
            resp.sendRedirect("form.html");
        }

    }
}
