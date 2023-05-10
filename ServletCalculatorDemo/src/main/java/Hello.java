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
		out.print("<b><u>SERVLET</u></b><hr>");
		int num1 , num2;
		String str ="";
		num1 = Integer.parseInt(request.getParameter("first"));
		num2 = Integer.parseInt(request.getParameter("second"));
		str = request.getParameter("operation");
		if(str.equals("add")){
			out.println("Result of addition is "+ (num1+num2));
		}
		else if(str.equals("sub")){
			out.println("Result of subtraction is "+ (num1-num2));
		}
		else if(str.equals("mul")){
			out.println("Result of multiplication is "+ (num1*num2));
		}
		else if(str.equals("div")){
			out.println("Result of division is "+ (num1/num2));
		}
		out.println("<a href='index.jsp'>Back </a>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
