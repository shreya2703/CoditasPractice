<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  // Destroy the session
  session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>

 <script type="text/javascript">
        // Disable the back button
        window.history.forward();

        // Redirect to the login page after a short delay
        setTimeout(function() {
            window.location.href = "Register.html";
        }, 5000);
    </script>

	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>

