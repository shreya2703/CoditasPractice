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

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();



//        out.println("<form method=\"get\" action=\"Login\">\n" +
//                "\n" +
//                "  <label>Enter Email:</label>\n" +
//                "  <input type=\"text\" name=\"emails\"><br/>\n" +
//                "  <label>Enter Name:</label>\n" +
//                "  <input type=\"text\" name=\"name\"><br/>\n" +
//                "\n" +
//                "  <input type=\"Submit\" value=\"Login\">\n" +
//                "  <input type=\"Reset\" value=\"Reset\">\n" +
//                "\n" +
//                "</form>");


        String emails = req.getParameter("emails");
        String name = req.getParameter("name");
        boolean flag=false;



        if (emails.equals("admin") && name.equals("admin")) {
            RequestDispatcher rd = req.getRequestDispatcher("user-list.jsp");
            rd.forward(req, resp);

        } else {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","Star@123");


                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from users where email='" + emails + "' and name='" + name + "'");

                while (rs.next()) {
                    out.println(rs.getInt(1));
                    out.println(rs.getString(2));
                    out.println(rs.getString(3));
                    out.println(rs.getString(4));
                    flag = true;

                }
                if(flag){
                    HttpSession session = req.getSession();
                    session.setAttribute("emails", emails);
                    RequestDispatcher rd = req.getRequestDispatcher("hello");
                    rd.forward(req,resp);
                }
                else{
                    out.println("Not registerd");
                    RequestDispatcher rd = req.getRequestDispatcher("Login.html");
                    rd.include(req,resp);
                }






            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }


    }


