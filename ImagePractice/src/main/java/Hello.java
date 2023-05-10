import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello from Servlet");
		response.setContentType("Text/HTML");
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		Part file = request.getPart("image");
		String imageFileName = file.getSubmittedFileName();
		String uploadPath="C:/Users/Coditas/IdeaProjects/ImagePractice/src/main/webapp/images/"+imageFileName;
		FileOutputStream fos = new FileOutputStream(uploadPath);
		InputStream is = file.getInputStream();

		byte[] data = new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		out.println("Hello from Servlet");
		try {
			out.println("Hello from Servlet");
			Class.forName("com.mysql.jdbc.Driver");
			out.println("Hello from Servlet");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imagepractice","root","Star@123");
			out.println("Hello from Servlet");
			PreparedStatement ps = con.prepareStatement("insert into register(name,city,image) values(?,?,?)");
			ps.setString(1,name);
			ps.setString(2,city);
			ps.setString(3,imageFileName);
			ps.executeUpdate();
			RequestDispatcher rd = request.getRequestDispatcher("Welcome");
			rd.forward(request,response);
			//out.println("<a href='index.jsp'>Next</a>");

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}


	}

}
