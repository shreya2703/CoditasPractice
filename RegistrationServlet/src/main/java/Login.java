import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        resp.setContentType("Text/HTML");
        String uname = req.getParameter("user");
        String passw = req.getParameter("password");
        session.setAttribute("uname",uname);
        int cnt =0;


            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegisterServlet", "root", "Star@123");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select email, pass from register where email ='" + uname + "' and pass ='" + passw + "'");
                while (rs.next()) {
                    RequestDispatcher rd = req.getRequestDispatcher("Welcome");
                    rd.forward(req, resp);

                }
                out.println("Need to Register first");
                RequestDispatcher rd = req.getRequestDispatcher("LoginUser.html");
                rd.include(req, resp);

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }



        }




    }

