import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Check")
public class Check extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String uname= req.getParameter("username");
        String pass = req.getParameter("pass");
        Connection con = ConnectDB.connect();
        try {
            PreparedStatement ps = con.prepareStatement("select * from users where username='"+uname+"'and password ='"+pass+"'");
            ResultSet rs = ps.executeQuery();
            String U,P;
            if(rs.next()){
                U = rs.getString(1);
                P = rs.getString(2);
                if(uname.equalsIgnoreCase(U) && pass.equalsIgnoreCase(P)){
                    HttpSession session = req.getSession();
                    session.setAttribute("Username",U);
                    RequestDispatcher rd = req.getRequestDispatcher("Profile");
                    rd.forward(req,resp);
                }



            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
