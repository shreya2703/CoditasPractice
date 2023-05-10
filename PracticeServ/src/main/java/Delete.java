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
        PrintWriter out = resp.getWriter();
        resp.setContentType("Text/HTML");
        String name = req.getParameter("name");

        ServletContext sc = getServletContext();
        try {

            Class.forName(sc.getInitParameter("Driver"));
            Connection con = DriverManager.getConnection(sc.getInitParameter("JDBC"), sc.getInitParameter("User"), sc.getInitParameter("Password"));
            Statement st = con.createStatement();
           st.executeUpdate("delete from details where name ='"+name+"'");
            RequestDispatcher rd = req.getRequestDispatcher("Display");
            rd.forward(req,resp);
    } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}

