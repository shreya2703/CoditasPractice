
<%@ page import = "java.util.List"%>
<%@ page import = "org.hibernate.Query"%>

<%@ page import = "org.hibernate.Session"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>AllNotes</title>
</head>
<body>
	<h1>All Notes</h1>

	<%
	 Session s = com.helper.FcatoryProvider.getSessionFactory().openSession();
       Query q = s.createQuery("from com.helper.Note");
       List<com.helper.Note> list = q.list();
       for(com.helper.Note note : list) {
         out.println(note.getId()+" "+note.getTitle());
         out.println("</br>");
         out.println("<a href='com.helper.Delete?note_id=" + note.getId() + "'>Delete</a>");
         out.println("<a href='edit.jsp?note_id=" + note.getId() + "'>Update</a>");
         out.println("</br>");
         out.println("</br>");
       }
       s.close();
	%>



	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>