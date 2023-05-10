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
	<form action="welcome.jsp" method="post">
	Enter ID:<input type="text" name="id">
	Enter First Name:<input type="text" name="fname">
	Enter Last Name:<input type="text" name="lname">
	<input type="submit" value="Register">
	</form>

</body>
</html>
