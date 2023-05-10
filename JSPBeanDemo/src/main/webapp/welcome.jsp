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
	<jsp:useBean id="student" class="Student" scope="application">
	<jsp:setProperty property="*" name="student"/>

<hr>Student Information<br>
	<jsp:getProperty property="id" name="student"/>
	<jsp:getProperty property="fname" name="student"/>
	<jsp:getProperty property="lname" name="student"/>
	</jsp:useBean>


</body>
</html>