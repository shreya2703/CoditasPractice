import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String email = req.getParameter("email");
        String password = req.getParameter("password");



//        int cnt =0;
//
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CRM", "root", "Star@123");
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select email, password from user where email ='" + email + "' and password ='" + password + "'");
//
//            while (rs.next()) {
//                RequestDispatcher rd = req.getRequestDispatcher("hello");
//                rd.forward(req, resp);
//
//            }
//            out.println("Need to Register first");
//            RequestDispatcher rd = req.getRequestDispatcher("Register.jsp");
//            rd.include(req, resp);
//
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        } catch (ClassNotFoundException ex) {
//            throw new RuntimeException(ex);
//        }
//
//



    }
}
