import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class Login extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("Text/HTML");
        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("Logout").include(req,resp);
        out.println("<html>" +
                "<head><title>Login</title>" +
                "<style>" +
                "body{font-family:arial;}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<center>" +
                "<h1>Login</h1>" +
                "<form action='Check' method='post'>" +
                "<input type='text' name='username'>" +
                "<input type='password' name='password'>" +
                "<input type='Submit' value='Submit'>" +
                "</form>" +
                "</center>" +
                "</body>" +
                "</html>");






    }
}
