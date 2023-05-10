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

@WebServlet("/Profile")
public class Profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("Text/HTML");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("emails");

        out.println("<link rel=\"stylesheet\"\n" +
                "    \thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n" +
                "    \tintegrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\n" +
                "    \tcrossorigin=\"anonymous\">");
        out.println("<nav class=\"navbar navbar-expand-md navbar-dark\"\n" +
                "\t\t\tstyle=\"background-color: blue\">\n" +
                "\t\t\t<div>\n" +
                "\t\t\t\t<a href=\"https://www.xadmin.net\" class=\"navbar-brand\"> User Management Application </a>\n" +
                "\t\t\t</div>\n" +
                "\t\t</nav>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","Star@123");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where email = '"+email+"'");
            out.println("<div class=\"container\">");
            out.println("<table border=2px; class=\"table table-bordered\"><tr><th>ID</th><th>NAME</th><th>EMAIL</th><th>COUNTRY</th><th>IMAGE</th></tr>");
            if(rs.next()){
                System.out.println("hello");
                String images = rs.getString(5);
                System.out.println(images);
                out.println("<tr><td>");
                out.println(rs.getInt(1));
                out.println("</td><td>");
                out.println(rs.getString(2));
                out.println("</td><td>");
                out.println(rs.getString(3));
                out.println("</td><td>");
                out.println(rs.getString(4));
                out.println("</td><td>");
                out.println("<img src ='images/"+images+"'  alt ='my image' width='200px' height ='200px'>");
                out.println("</td></tr>");


            }
            out.println("</table>");
            out.println("</div>");



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


    }

