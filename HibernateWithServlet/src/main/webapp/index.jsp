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

	<form method="get" action="hello">
	Enter name
	<input type="text" name="name">
	Enter Department
	<input type="text" name="department">
	Enter Salary
	<input type="text" name="salary">
	Enter Email
	<input type="text" name="email">
	Enter Password
	<input type="password" name="password">
	<input type="Submit" value="Submit">




	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>
