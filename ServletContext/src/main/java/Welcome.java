import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/HTML");
        out.println("Welcome User");
        ServletContext sc = getServletContext();
        try {
            Class.forName(sc.getInitParameter("Driver"));
            Connection con = DriverManager.getConnection(sc.getInitParameter("URL"), sc.getInitParameter("User"), sc.getInitParameter("Password"));
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from details");
            out.println("<table><tr>");
            out.println("<th>Name</th>");
            out.println("<th>City</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td></tr>");

            }
            out.println("</table>");
            out.println("<a href ='ByeServlet' >Next</a>");
            out.println("<a href ='index.html'>Back</a>");

        } catch (SQLException ex) {
         //   throw new RuntimeException(ex);
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            //throw new RuntimeException(ex);
            System.out.println(ex);
        }

    }
}

