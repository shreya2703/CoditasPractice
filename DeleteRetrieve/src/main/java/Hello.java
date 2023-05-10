import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello from Servlet");
		String name= request.getParameter("name");
		String pass= request.getParameter("pass");
         Part part = request.getPart("img");
		 String fileimagePath = part.getSubmittedFileName();
		 String uploadPath = "C:/Users/Coditas/IdeaProjects/DeleteRetrieve/src/main/webapp/images/"+fileimagePath;
		 FileOutputStream fos = new FileOutputStream(uploadPath);
		 InputStream is = part.getInputStream();

		 byte[] b = new byte[is.available()];
		 is.read(b);
		 fos.write(b);
		 fos.close();


		


	}

}
