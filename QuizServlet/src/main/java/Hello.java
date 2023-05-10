import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("Text/HTML");
		out.println("Hello from Servlet");
		ServletContext sc = getServletContext();
		int cnt =0;

		Enumeration e = request.getParameterNames();
            try {
                //Class.forName(sc.getInitParameter("Driver"));
                // Connection con = DriverManager.getConnection(sc.getInitParameter("URL"),sc.getInitParameter("User"),sc.getInitParameter("Password"));
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizDB","root","Star@123");




				Statement st = con.createStatement();

				 ResultSet rs = st.executeQuery("select answer from quiz");



				 while(rs.next()  && e.hasMoreElements()){

					 String un = rs.getString(1);
					 String name = (String)e.nextElement();
					 String an ="";
					 String[] ans = request.getParameterValues(name);
					 for(int i=0;i<ans.length;i++){
                           an = ans[i];
					 }
					 if(un.equals(an)){
						 cnt++;

					 }

				 }
				out.println("You have written "+cnt+" correct answers");


            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
