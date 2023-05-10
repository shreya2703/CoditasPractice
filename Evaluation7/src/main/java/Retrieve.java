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

@WebServlet("/Retrieve")
public class Retrieve extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("Text/HTML");
        PrintWriter out = resp.getWriter();
        out.println("Hello from Servlet");

        String email = req.getParameter("email");
        out.println(1);
        ServletContext sc = req.getServletContext();
        String name=" ",emails=" ",pass=" ",city=" ",phone=" ";
          out.println(2);
        try {
            Class.forName(sc.getInitParameter("Driver"));
            Connection con = DriverManager.getConnection(sc.getInitParameter("JDBC"),sc.getInitParameter("User"),sc.getInitParameter("Password"));
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from backup where email= '"+email+"'");
            out.println(3);
             while(rs.next()){
                 out.println(4);
                 name=rs.getString(1);
                 emails=rs.getString(2);
                 pass=rs.getString(3);
                city= rs.getString(4);
                phone= rs.getString(5);
                 out.println(5);
             }
              out.println(name);
              out.println(emails);
              out.println(pass);
              out.println(city);
              out.println(phone);

             PreparedStatement ps = con.prepareStatement("insert into register(name,email,pass,city,phone) values(?,?,?,?,?)");
            out.println(6);
             ps.setString(1,name);
            out.println(7);
             ps.setString(2,emails);
            out.println(8);
             ps.setString(3,pass);
            out.println(9);
             ps.setString(4,city);
            out.println(10);
             ps.setString(5,phone);
            out.println(11);
            ps.executeUpdate();
             out.println(12);

//            Statement sts = con.createStatement();
//             out.println(6);
//             sts.executeUpdate("insert into register values('"+name+"','"+emails+"','"+pass+"','"+city+"','"+phone+"'");
//             out.println("shreya");

             PreparedStatement ps1 = con.prepareStatement("delete from backup where email= '"+email+"'");
             ps1.executeUpdate();
            out.println(13);

            RequestDispatcher rd = req.getRequestDispatcher("Admin");
            rd.forward(req,resp);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }










    }
}
