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
	<form method="get" action="Update">
      <label >Name:</label>
      <input type="text" name="name" value="<%=request.getAttribute("name")%>">
      <br>
      <label>Email:</label>
      <input type="text" name="email" value="<%=request.getAttribute("email")%>">
      <br>
      <label>Pass:</label>
      <input type="text" name="pass" value="<%=request.getAttribute("pass")%>">
      <br>
      <label>City</label>
      <input type="text" name="city" value="<%=request.getAttribute("city")%>">
      <br>
      <label>Phone</label>
      <input type="text" name="phone" value="<%=request.getAttribute("phone")%>">
      <br>
      <input type="submit" value="Edit">
    </form>





	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>