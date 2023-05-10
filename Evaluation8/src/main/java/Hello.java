import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		response.setContentType("Text/HTML");
		HttpSession session = request.getSession(false);

		if(session == null){
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		}else {
//		if(session.getAttribute("email") == null){
//			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//			rd.forward(request,response);
//		}

			PrintWriter out = response.getWriter();
			out.println("<link rel=\"stylesheet\"\n" +
					"    \thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n" +
					"    \tintegrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\n" +
					"    \tcrossorigin=\"anonymous\">");
			out.println("<nav class=\"navbar navbar-expand-md navbar-dark\"\n" +
					"\t\t\tstyle=\"background-color: blue\">\n" +
					"\t\t\t<div>\n" +
					"\t\t\t\t<a href=\"https://www.xadmin.net\" class=\"navbar-brand\"> User Management Application </a>\n" +
					"\t\t\t</div>\n" +
					"\n" +
					"\t\t\t<ul class=\"navbar-nav\">\n" +
					"\t\t\t\t<li><a href='Profile' class=\"nav-link\">Profile</a></li>\n" +
					"\t\t\t</ul>\n" +
					"\t\t\t<ul class=\"navbar-nav\">\n" +
					"               <li><a href='Logout' class=\"nav-link\">Logout</a></li>\n" +
					"            </ul>\n" +
					"\t\t</nav>");
			out.println("<br/>");
			out.println("<br/>");
			out.println("<br/>");
			out.println("<br/>");
			out.println("<br/>");
			out.println("<br/>");

			out.println("<div class=\"container col-md-5\">");


			out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");

			String name = (String) session.getAttribute("emails");
			out.println("<h4style=\"text-align:center;> Welcome " + name + "</h4>");


			out.println("</div>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
