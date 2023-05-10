<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>Hello World!</h1>
	<form method ="get" action="hello">
	Enter user name
	<input type ="text" name ="uname">
	Enter password
	<input type="password" name ="pass">
	<input type ="Submit" name ="submit">
	<input type ="Reset" name ="reset">
	</form>




	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>
