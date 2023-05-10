import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/shreya")
//@WebServlet(@WebInitParam(""));
@WebServlet(urlPatterns = {"/shreya"},initParams = {@WebInitParam(name ="Driver",value ="com.mysql.jdbc.Driver")})

public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("type/html");  //audio,image,video,

		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		//out.println("Hello from Servlet");
		response.setContentType("text/html");



		ServletConfig servletConfig = getServletConfig();
		String Driver = servletConfig.getInitParameter("Driver"); //key add karna hai that is page name which we have given in .xml file
        out.println("Servlet Config"+Driver);



		String name= request.getParameter("name");
		String pass = request.getParameter("pass");
		if(name.equals("shreya") && pass.equals("shreya") ){
			out.println("Welcome "+name);
			//response.sendRedirect("suc.jsp");
			out.println("<a href='MessageServlet'>Next</a>");


		}
		else{
			//
			out.println("sorry");

		}

	}

}
