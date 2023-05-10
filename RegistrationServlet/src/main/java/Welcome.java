import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Welcome")
public class Welcome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session  = req.getSession();
        resp.setContentType("Text/HTML");

        if (session.getAttribute("uname")!= null) {
            PrintWriter out = resp.getWriter();
            out.println("<h1>");
            out.println("Hello "+session.getAttribute("uname"));
            out.println("</h1>");
            out.println("<h3><a href ='Profile'>Profile</a><br/></h3>");
            out.println("<h3><a href ='Logout'>Logout</a></h3>");
        }
        else{
            System.out.println(session);
            //req.getRequestDispatcher("register.html").include(req, resp);
            resp.sendRedirect("LoginUser.html");
        }






    }
}
