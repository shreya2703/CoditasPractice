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

@WebServlet("/Edit")
public class Edit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("Text/HTML");
        PrintWriter out = resp.getWriter();
        String email = req.getParameter("email");
        String detail = req.getParameter("detail");
        String update = req.getParameter("update");
        ServletContext sc = req.getServletContext();

        try {
            Class.forName(sc.getInitParameter("Driver"));
            Connection con = DriverManager.getConnection(sc.getInitParameter("JDBC"), sc.getInitParameter("User"), sc.getInitParameter("Password"));

//            PreparedStatement ps = con.prepareStatement("update register set "+detail+" = '"+update+"' where email = '"+email+"'");
//            ps.executeUpdate();
//
//            RequestDispatcher rd = req.getRequestDispatcher("Admin");
//            rd.forward(req,resp);

            String emails = req.getParameter("email");
            String name="",email1="",city="",pass="",phone="";
            PreparedStatement ps = con.prepareStatement("SELECT * FROM register WHERE email = ?");
            ps.setString(1,emails);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                name=rs.getString(1);
                email1=rs.getString(2);
                city=rs.getString(3);
                pass=rs.getString(4);
                phone=rs.getString(5);

            }

            out.println("<h2></h2>" +
                    "<form action='Update'>" +
                    "NAME: <input type='text' name='name' value='"+name+"'>" +
                    "EMAIL:<input type='text' name='email' value='"+email+"'>" +
                    "CITY:<input type='text' name='city' value='"+city+"'>" +
                    "PHONE:<input type='text' name='phone' value='"+phone+"'>" +
                    "<input type='submit' value='UPDATE'>" +
                    "</form>");

//            req.setAttribute("name",rs.getString(1));
//            req.setAttribute("email",rs.getString(2));
//            req.setAttribute("pass",rs.getString(3));
//            req.setAttribute("city",rs.getString(4));
//            req.setAttribute("phone",rs.getString(5));
//            RequestDispatcher rd = req.getRequestDispatcher("Student.jsp");
//            rd.forward(req,resp);







        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
