import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello from Servlet");
		response.setContentType("Text/HTML");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		int count =0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userDB","root","Star@123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from user");

			while(rs.next()){

				String un = rs.getString(1);
				String up = rs.getString(2);
				if(name.equals(un) && pass.equals(up)){
					out.println("Hello "+un);
					count++;
					break;
				}

			}
			if(count == 0){
				out.println("Sorry Login Fail");
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
