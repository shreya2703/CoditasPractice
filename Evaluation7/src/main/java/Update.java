import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Update")
public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("Text/HTML");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String city = req.getParameter("city");
        String phone = req.getParameter("phone");

        ServletContext sc = req.getServletContext();

        try {
            Class.forName(sc.getInitParameter("Driver"));
            Connection con = DriverManager.getConnection(sc.getInitParameter("JDBC"), sc.getInitParameter("User"), sc.getInitParameter("Password"));
            PreparedStatement ps = con.prepareStatement("update register set name=?, email=?, pass=?,city =?,phone=? WHERE email=?");
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,pass);
            ps.setString(4,city);
            ps.setString(5,phone);
            ps.setString(6,email);
            ps.executeUpdate();
            RequestDispatcher rd = req.getRequestDispatcher("Admin");
            rd.forward(req,resp);

//            PreparedStatement ps = con.prepareStatement("update register set "+detail+" = '"+update+"' where email = '"+email+"'");
//            ps.executeUpdate();
//
//            RequestDispatcher rd = req.getRequestDispatcher("Admin");
//            rd.forward(req,resp);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
