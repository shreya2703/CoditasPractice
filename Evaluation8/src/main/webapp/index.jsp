<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User Management Application</title>
    <link rel="stylesheet"
    	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    	crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> User Management Application </a>
			</div>
		</nav>
	</header>
	<br/>
	<br/>
	<br/>
	<div class="container col-md-5">
    		<div class="card">
    			<div class="card-body">
    			<h2 style="text-align:center; color:blue;">Login</h2><br/>
	<form method="get" action="Login">
       <div style="text-align:center;">
      <label>Enter Email:</label>
      <input type="text" name="emails"><br/><br/>
      <label>Enter Name:</label>
      <input type="text" name="name"><br/><br/>


      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <button type="submit" class="btn btn-success">Submit</button>&nbsp;&nbsp;&nbsp;&nbsp;
      <button type="Reset" class="btn btn-success">Reset</button>
</div>
    </form>
    </div>
    		</div>
    	</div>

	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>

