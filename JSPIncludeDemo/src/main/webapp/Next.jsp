<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>Hello World!</h1>

    <%--
    String name = (String)session.getAttribute("Suser");
    out.println("How are you "+name);
    --%>


    <%--
    String Nname=(String)pageContext.getAttribute("Uname",PageContext.APPLICATION_SCOPE);
    out.print("How are you  "+Nname);

    --%>

    <% out.println("error has occured");%>
    <%=exception %>

	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>