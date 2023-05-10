<%@ page import = "org.hibernate.Session"%>
<%@ page import = "org.hibernate.Transaction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EditPage</title>
</head>
<body>
	<h1>This is Edit Page!</h1>
	<%
	  int noteId = Integer.parseInt(request.getParameter("note_id"));
	  Session s = com.helper.FcatoryProvider.getSessionFactory().openSession();
	  Transaction tx = s.beginTransaction();
	   com.helper.Note note = (com.helper.Note)s.get(com.helper.Note.class,noteId);

	%>
	<form method="get" action="com.helper.Update">
	    <input type="hidden" value="<%=note.getId() %>"name ="noteId">
    	Enter Title:
    	<input type="text" name="title" value="<%=note.getTitle() %>"></br>
    	Enter Content:
    	<input type="text" name="content" value="<%=note.getContent() %>"></br>
    	<input type="Submit" value="Edit Changes">
    	</form>

	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>