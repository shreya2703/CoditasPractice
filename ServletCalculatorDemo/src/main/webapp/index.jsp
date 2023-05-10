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
	<form method ="get" action ="hello">
	<h1>Calculator</h1>
	First Number :
	<input type ="text" name ="first"/></br>
	Second Number :
	<input type ="text" name ="second"/></br>
	Select the option :</br>
	<input type ="radio" name ="operation" value ="add">Addition
	<input type ="radio" name ="operation" value ="sub">Subtraction
	<input type ="radio" name ="operation" value ="mul">Multiplication
	<input type ="radio" name ="operation" value ="div">Division<br/>

	<input type ="submit" value="Calculate"/>
	<input type ="reset" value ="Reset"/>

	</form>
	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>
