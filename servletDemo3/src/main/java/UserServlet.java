import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
      //  out.println("Hello from Servlet");

        String name= req.getParameter("name");
        String pass = req.getParameter("pass");

        out.println("Welcome "+name+" Hope you are doing good.");
        //response.sendRedirect("suc.jsp");
        out.println("<a href='ByeServlet'>Next</a>");
        out.println("<a href='MessageServlet'>Back</a>");

    }
}
