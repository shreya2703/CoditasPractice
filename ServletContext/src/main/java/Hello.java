import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello from Servlet");
		response.setContentType("Text/HTML");
		HttpSession session = request.getSession();

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		session.setAttribute("user",uname);
		int cnt =0;
		ServletContext sc = getServletContext();
		try {
			Class.forName(sc.getInitParameter("Driver"));
			Connection con = DriverManager.getConnection(sc.getInitParameter("URL"),sc.getInitParameter("User"),sc.getInitParameter("Password"));
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from user");
			while(rs.next()){
				String n = rs.getString(1);
				String p =rs.getString(2);
				if(n.equals(uname) && p.equals(pass)) {
					//response.sendRedirect("Welcome");
					RequestDispatcher rd = request.getRequestDispatcher("Welcome");
					rd.forward(request,response);
					cnt++;
					break;
				}

			}
			if(cnt ==0){
				out.println("Sorry U need to login");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request,response);

			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
