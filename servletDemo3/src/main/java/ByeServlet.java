import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ByeServlet")
public class ByeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
       // out.println("Hello from Servlet");

        String name= req.getParameter("name");
        String pass = req.getParameter("pass");

        out.println("Byy "+name+" See you again.");
        //response.sendRedirect("suc.jsp");
        out.println("<a href='UserServlet'>Back</a>");
    }
}
