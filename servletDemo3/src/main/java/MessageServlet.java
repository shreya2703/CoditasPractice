import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //out.println("Hello from Servlet");

        String name= req.getParameter("name");
        String pass = req.getParameter("pass");

            out.println("Welcome "+name);
            //response.sendRedirect("suc.jsp");
            out.println("<a href='UserServlet'>Next</a>");
            out.println("<a href='index.jsp'>Back</a>");


    }
}
