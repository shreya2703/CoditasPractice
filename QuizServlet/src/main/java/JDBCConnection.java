import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection extends HttpServlet {


    public Connection getConnection(){
                ServletContext sc = getServletContext();
            try {
                Class.forName(sc.getInitParameter("Driver"));
                return DriverManager.getConnection(sc.getInitParameter("URL"),sc.getInitParameter("User"),sc.getInitParameter("Password"));

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }



    }






}
