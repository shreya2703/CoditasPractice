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
	<form method="post" action="shreya">
    		<label for="name">Name:</label>
    		<input type="text" id="name" name="name" required>
    		<label for="password">Password:</label>
    		<input type="password" id ="pass" name ="pass" required>
    		<input type="submit" value="Submit">
	</form>
	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>