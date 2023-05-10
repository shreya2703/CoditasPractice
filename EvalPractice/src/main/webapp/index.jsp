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
          <label>Enter Email:</label>
          <input type="text" name="emails"><br/><br/>
          <label>Enter Name:</label>
          <input type="text" name="name"><br/><br/>
          <input type='Submit' value='Submit'>
          <input type='Reset' value='Reset'>
    </div>
        </form>
	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>
