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
		out.println("Hello from Servlet");
		String name= request.getParameter("name");
		String department= request.getParameter("department");
		String salary= request.getParameter("salary");
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		Employee emp = new Employee(name,department,salary,email,password);
		System.out.println(emp);

		EmpDao dao = new EmpDao(HibernateUtil.getSessionFactory());
		boolean f = dao.saveEmp(emp);
		if(f){
			System.out.println("Registered");
		}



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
