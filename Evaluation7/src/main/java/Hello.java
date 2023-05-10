import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
		response.setContentType("Text/HTML");
		PrintWriter out = response.getWriter();
		out.println("Hello from Servlet");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String city = request.getParameter("city");
		String phone = request.getParameter("phone");

		ServletContext sc = request.getServletContext();

		try {
			Class.forName(sc.getInitParameter("Driver"));
			Connection con = DriverManager.getConnection(sc.getInitParameter("JDBC"),sc.getInitParameter("User"),sc.getInitParameter("Password"));
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,pass);
			ps.setString(4,city);
			ps.setString(5,phone);

			ps.executeUpdate();


			PreparedStatement pst = con.prepareStatement("insert into login(email,pass) values(?,?)");
			pst.setString(1,email);
			pst.setString(2,pass);
			pst.executeUpdate();

			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.forward(request,response);






		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
