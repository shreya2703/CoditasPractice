import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Student")
public class Student extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Hello from Servlet");
//
//        ServletContext sc = req.getServletContext();
//
//            try {
//                Class.forName(sc.getInitParameter("Driver"));
//                Connection con = DriverManager.getConnection(sc.getInitParameter("JDBC"), sc.getInitParameter("User"), sc.getInitParameter("Password"));
//
//                Statement st = con.createStatement();
//               // ResultSet rs = st.executeQuery("select * from login where email='"+emails+"' and pass='"+passw+"'");
//
//               // while (rs.next()) {
////                    RequestDispatcher rd = req.getRequestDispatcher("Home");
////                    rd.forward(req, resp);
//
//              //  }
//
//
////            if(!rs.next()) {
////            out.println("Invalid Credentials !! ");
////            RequestDispatcher rd = req.getRequestDispatcher("Login.html");
////            rd.include(req,resp);
////            }
//                System.out.println("done");
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
   }
}


