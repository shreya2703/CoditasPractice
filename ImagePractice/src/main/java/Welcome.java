import javax.servlet.RequestDispatcher;
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
        out.println("Hello from Servlet");
        out.println("How are you");
        resp.setContentType("Text/HTML");
        try {
            out.println(1);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Imagepractice","root","Star@123");
            out.println(2);
           Statement st = con.createStatement();
            out.println(3);
            ResultSet rs = st.executeQuery("select * from register");
            out.println(4);
            while(rs.next()) {
                out.println(5);
                out.println(rs.getInt(1));
                out.println(6);
                out.println(rs.getString(2));
                out.println(7);
                out.println(rs.getString(3));
                out.println(8);
                String image= rs.getString(4);
                out.println(9);
                out.println("<img src='"+image+"' alt ='my image' width='200px' height = '200px'>");
                out.println(10);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    }

