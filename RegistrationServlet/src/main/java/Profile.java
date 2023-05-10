import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/Profile")
public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("Text/HTML");
        //resp.setContentType("image/png");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(false);
        String name = (String) session.getAttribute("uname");
        if (session != null) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegisterServlet", "root", "Star@123");
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery("select * from register where email = '" + name + "';");
                while (rs.next()) {

                    String image = rs.getString(7);

                    out.println("<h3>");
                    out.println(rs.getString(2));
                    out.println("<br/>");
                    out.println(rs.getString(3));
                    out.println("<br/>");
                    out.println(rs.getString(4));
                    out.println("<br/>");
                    out.println(rs.getString(5));
                    out.println("<br/>");
                    out.println(rs.getString(6));
                    out.println("<br/>");
                   // out.println(rs.getString(7));
                   out.println("<img src ='images/"+image+"'  alt ='my image' width='200px' height ='200px'>");
                    out.println(rs.getString(9));
                    out.println("<br/>");
                    out.println(rs.getString(10));
                    out.println("</h3>");
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(session);
            resp.sendRedirect("LoginUser.html");


        }
    }
}
