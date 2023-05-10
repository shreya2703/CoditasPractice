import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		out.println("Hello from Servlet");
		ServletContext sc = getServletContext();
		try {
			Class.forName(sc.getInitParameter("Driver"));
			Connection con = DriverManager.getConnection(sc.getInitParameter("JDBC"),sc.getInitParameter("User"),sc.getInitParameter("Password"));

			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			String[] hobbies = new String[]{request.getParameter("hobbies")};
             String city = request.getParameter("city");
			 String email = request.getParameter("email");

			PreparedStatement ps = con.prepareStatement("insert into details values(?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,pass);
			for(String hobby : hobbies) {
				ps.setString(3, hobby);
			}
			ps.setString(4,city);
			ps.setString(5,email);

			ps.executeUpdate();

			out.println("Done inserted ");











		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
