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

@WebServlet("/Delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("Text/HTML");
        PrintWriter out = resp.getWriter();
        String email = req.getParameter("email");
        String name = "",emails="",pass="",city="",phone="";

        ServletContext sc = req.getServletContext();

        try {
            Class.forName(sc.getInitParameter("Driver"));
            Connection con = DriverManager.getConnection(sc.getInitParameter("JDBC"), sc.getInitParameter("User"), sc.getInitParameter("Password"));


            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from register where email ='"+email+"'");
            while(rs.next()){
                name = rs.getString(1);
                emails=rs.getString(2);
                pass=rs.getString(3);
                city =rs.getString(4);
                phone=rs.getString(5);

            }
            System.out.println(name+" "+emails+" "+city);
            PreparedStatement pst = con.prepareStatement("insert into backup values(?,?,?,?,?)");
            pst.setString(1,name);
            pst.setString(2,emails);
            pst.setString(3,pass);
            pst.setString(4,city);
            pst.setString(5,phone);
            pst.executeUpdate();








            PreparedStatement ps = con.prepareStatement("delete from register where email = '"+email+"'");
            ps.executeUpdate();


            RequestDispatcher rd = req.getRequestDispatcher("Admin");
            rd.forward(req,resp);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
