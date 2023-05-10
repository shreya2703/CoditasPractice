import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Details")
public class Details extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("Text/Html");
        PrintWriter out = resp.getWriter();
        out.println("Hello Admin");
        ServletContext sc = req.getServletContext();

        try {
            Class.forName(sc.getInitParameter("Driver"));
            Connection con = DriverManager.getConnection(sc.getInitParameter("JDBC"), sc.getInitParameter("User"), sc.getInitParameter("Password"));
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from register");

            out.println("<table border=2px><tr>" +
                    "<th>Name</th>" +
                    "<th>Email</th>" +
                    "<th>Password</th>" +
                    "<th>City</th>" +
                    "<th>Phone</th>" +
                    "</tr>");

            while(rs.next()){
                out.println("<tr>");

                out.println("<td>");
                out.println(rs.getString(1));
                out.println("</td><td>");
                out.println(rs.getString(2));
                out.println("</td><td>");
                out.println(rs.getString(3));
                out.println("</td><td>");
                out.println(rs.getString(4));
                out.println("</td><td>");
                out.println(rs.getString(5));
                out.println("</td>");
                out.println("</tr>");

            }
          out.println("</table>");





        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
