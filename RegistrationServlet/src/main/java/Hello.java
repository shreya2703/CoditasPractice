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
import javax.servlet.http.*;

@MultipartConfig
@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		out.println("Hello from Servlet");
//
//		//HttpSession session = request.getSession();
//
//
//		String fname = request.getParameter("fname");
//		String lname = request.getParameter("lname");
//		String dob = request.getParameter("dob");
//		String email = request.getParameter("email");
//		String pass = request.getParameter("pass");
//		String image = request.getParameter("img");
//		String resume = request.getParameter("resume");
//		String address= request.getParameter("address");
//		String phone = request.getParameter("phone");
//
//
//		Part file = request.getPart("img");
//		String imageFileName = file.getSubmittedFileName();
//		String uploadPath="C:/Users/Coditas/IdeaProjects/RegistrationServlet/src/main/webapp/images"+image;
//		FileOutputStream fos = new FileOutputStream(uploadPath);
//		InputStream is = file.getInputStream();
//
//		byte[] data = new byte[is.available()];
//		is.read(data);
//		fos.write(data);
//		fos.close();
//
//
//
//
//		// session.setAttribute("key",fname);
//	//	Part filePart = request.getPart("img");
////		InputStream imageInputStream = filePart.getInputStream();
////		Part fileP = request.getPart("resume");
////		InputStream fileInputStream = fileP.getInputStream();
//
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegisterServlet","root","Star@123");
//			PreparedStatement ps = con.prepareStatement("insert into register(fname,lname,dob,email,pass,image,resume,address,phone) values(?,?,?,?,?,?,?,?,?)");
//			ps.setString(1,fname);
//			ps.setString(2,lname);
//			ps.setString(3,dob);
//			ps.setString(4,email);
//			ps.setString(5,pass);
//			ps.setString(6,imageFileName);
//			ps.setString(7,resume);
////			ps.setBinaryStream(6,imageInputStream);
////			ps.setBinaryStream(7,fileInputStream);
//			ps.setString(8,address);
//			ps.setString(9,phone);
//
//			ps.executeUpdate();
//			RequestDispatcher rd = request.getRequestDispatcher("LoginUser.html");
//			rd.forward(request,response);
//
////			out.println("<a href ='LoginUser.html'></a>");
//
//
//
//
//
//
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello from Servlet");

		//HttpSession session = request.getSession();


		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String image = request.getParameter("img");
		String resume = request.getParameter("resume");
		String address= request.getParameter("address");
		String phone = request.getParameter("phone");


		Part file = request.getPart("img");
		String imageFileName = file.getSubmittedFileName();
		String uploadPath="C:/Users/Coditas/IdeaProjects/RegistrationServlet/src/main/webapp/images/"+imageFileName;
		FileOutputStream fos = new FileOutputStream(uploadPath);
		InputStream is = file.getInputStream();

		byte[] data = new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();




		// session.setAttribute("key",fname);
		//	Part filePart = request.getPart("img");
//		InputStream imageInputStream = filePart.getInputStream();
//		Part fileP = request.getPart("resume");
//		InputStream fileInputStream = fileP.getInputStream();


		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegisterServlet","root","Star@123");
			PreparedStatement ps = con.prepareStatement("insert into register(fname,lname,dob,email,pass,image,resume,address,phone) values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,fname);
			ps.setString(2,lname);
			ps.setString(3,dob);
			ps.setString(4,email);
			ps.setString(5,pass);
			ps.setString(6,imageFileName);
			ps.setString(7,resume);
//			ps.setBinaryStream(6,imageInputStream);
//			ps.setBinaryStream(7,fileInputStream);
			ps.setString(8,address);
			ps.setString(9,phone);

			ps.executeUpdate();
			RequestDispatcher rd = request.getRequestDispatcher("LoginUser.html");
			rd.forward(request,response);

//			out.println("<a href ='LoginUser.html'></a>");






		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
