import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("Text/Html");
        PrintWriter out = resp.getWriter();
            out.println("Hello Admin");
        ServletContext sc = req.getServletContext();
        HttpSession session = req.getSession(false);
        if(session.getAttribute("email")==null){
            resp.sendRedirect("Login.html");
        }


        else {

            try {
                Class.forName(sc.getInitParameter("Driver"));
                Connection con = DriverManager.getConnection(sc.getInitParameter("JDBC"), sc.getInitParameter("User"), sc.getInitParameter("Password"));
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from register");

                out.println("<table border=2px><tr><th>Name</th><th>Email</th><th>Password</th><th>City</th><th>Phone</th><th>Edit</th><th>Delete</th></tr>");

                while (rs.next()) {
                    String email = rs.getString(2);

                    out.println("<tr><td>");
                    out.println(rs.getString(1));
                    out.println("</td><td>");
                    out.println(rs.getString(2));
                    out.println("</td><td>");
                    out.println(rs.getString(3));
                    out.println("</td><td>");
                    out.println(rs.getString(4));
                    out.println("</td><td>");
                    out.println(rs.getString(5));
                    out.println("</td><td>");
                    out.println("<a href='Edit?email=" + email + "'>Edit</a>");
                    out.println("</td><td>");
                    out.println("<a href='Delete?email=" + email + "'>Delete</a>");
                    out.println("</td></tr>");


                }
                out.println("</table>");

                out.println("<a href ='Logout'>Logout</a>");
                // out.println("<a href ='Edit.html'>Edit</a>");
                out.println("<a href ='Register.html'>Add</a>");
                // out.println("<a href ='Delete.html'>Delete</a>");
                out.println("<a href ='DeletedData'>Show Deleted Data</a>");


            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
