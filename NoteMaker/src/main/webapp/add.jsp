<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>AddNotes</title>
</head>
<body>
	<h1>This is add notes page</h1>
	<form method="get" action="com.helper.Save">
	Enter Title:
	<input type="text" name="title"></br>
	Enter Content:
	<input type="text" name="content"></br>
	<input type="Submit" value="Submit">
	</form>

	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>
