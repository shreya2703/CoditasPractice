import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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

   // @Override
  //  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //resp.setContentType("Text/HTML");
//        PrintWriter out = resp.getWriter();
//        out.println("Hello from Servlet");
//
//        HttpSession session = req.getSession();
//        String emails = req.getParameter("emails");
//        String passw = req.getParameter("passw");
//
//
//        session.setAttribute("email",emails);
//
//        if(emails.equals("admin") && passw.equals("admin")){
//            RequestDispatcher rd = req.getRequestDispatcher("Admin");
//            rd.forward(req,resp);
//        }
//
//
//        ServletContext sc = req.getServletContext();
//
//        try {
//            Class.forName(sc.getInitParameter("Driver"));
//            Connection con = DriverManager.getConnection(sc.getInitParameter("JDBC"), sc.getInitParameter("User"), sc.getInitParameter("Password"));
//
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select email,pass from login where email = ' "+emails+ "' and pass = '"+passw+"'");
//
//
//            while(rs.next()){
//                   resp.sendRedirect("Home");
//
//
////                RequestDispatcher rd = req.getRequestDispatcher("Home");
////                rd.forward(req,resp);
//            }
////            if(!rs.next()) {
////            out.println("Invalid Credentials !! ");
////            RequestDispatcher rd = req.getRequestDispatcher("Login.html");
////            rd.include(req,resp);
////            }
//
//
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }


  //  }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Hello from Servlet");


        String emails = req.getParameter("emails");
        String passw = req.getParameter("passw");
        boolean flag=false;



        if (emails.equals("admin") && passw.equals("admin")) {
            RequestDispatcher rd = req.getRequestDispatcher("Admin");
            rd.forward(req, resp);

        } else {
//            RequestDispatcher rd = req.getRequestDispatcher("Student");
//            rd.forward(req, resp);

            ServletContext sc = req.getServletContext();

            try {
                Class.forName(sc.getInitParameter("Driver"));
                Connection con = DriverManager.getConnection(sc.getInitParameter("JDBC"), sc.getInitParameter("User"), sc.getInitParameter("Password"));

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from login where email='" + emails + "' and pass='" + passw + "'");

                while (rs.next()) {
                    out.println(rs.getString(1));
                    out.println(rs.getString(2));
                    out.println(rs.getString(3));
                   flag = true;

                }
                if(flag){
                    HttpSession session = req.getSession();
                    session.setAttribute("email", emails);
                    RequestDispatcher rd = req.getRequestDispatcher("Home");
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
//}
