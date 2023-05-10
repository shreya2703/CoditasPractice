import java.io.IOException;
import java.io.PrintWriter;

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
		String name = request.getParameter("name");
		out.println("Hello "+name);

		out.println("<form method='get' action='Welcome'>");
		out.println("<input type='hidden' name='uname' value = '"+name+"'>");
		out.println("<input type='Submit' value='Go'>");
		out.println("</form>");









	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
