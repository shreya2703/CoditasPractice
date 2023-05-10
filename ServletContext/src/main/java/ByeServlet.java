import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ByeServlet")
public class ByeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session!=null) {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/HTML");
            out.println("Bye User");
            out.println("<a href ='LogoutServlet'>Logout</a>");
            out.println("<a href ='Facebook'>Coditas</a>");
            System.out.println(session);
        }
        else{
            System.out.println(session);
            req.getRequestDispatcher("index.html").include(req,resp);
        }


    }
}



