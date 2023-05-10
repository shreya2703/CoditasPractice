<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Employee Form</title>
	<style>
		form {
			margin: auto;
			width: 50%;
			padding: 20px;
			border: 1px solid black;
		}
		input[type="submit"] {
			margin-top: 10px;
		}
	</style>
</head>
<body>
	<h1>Custumer Form</h1>
	<form action="addcustomer" method="get">
		<label for="Id">Customer ID:</label>
		<input type="text" id="Id" name="Id"><br><br>
		<label for="Name">Customer Name:</label>
		<input type="text" id="Name" name="Name"><br><br>
		<label for="Email">Customer Email:</label>
		<input type="text" id="Email" name="Email"><br><br>
		<label for="Password">Customer password:</label>
        <input type="text" id="Password" name="Password"><br><br>
		<input type="submit" value="Submit">
		<a href="index.jsp">back</a>
	</form>

	<%

	%>

</body>
</html>
