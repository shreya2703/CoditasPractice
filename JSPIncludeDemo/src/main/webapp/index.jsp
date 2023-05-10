<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   errorPage="Next.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>Hello World!</h1>
	<%-- String name = request.getParameter("user");
	out.println("Welcome "+name);
	--%>

	<%-- response.sendRedirect("hello"); --%>

    <%-- String name= application.getInitParameter("Driver");
    out.print("The Driver is "+name);
    --%>

    <%-- String name = request.getParameter("user");
    out.println("Hello "+name);

    session.setAttribute("Suser",name);
    out.println("<a href ='Next.jsp'>Next</a>");

    --%>

    <%-- String name=request.getParameter("user");
    out.println("Hello "+name);

    pageContext.setAttribute("Uname",name,PageContext.APPLICATION_SCOPE);
    out.println("<a href='Next.jsp'>Next</a>");

    --%>

    <%--
     String name=request.getParameter("user");
        out.println("Hello "+name);

        pageContext.setAttribute("Uname",name,PageContext.PAGE_SCOPE);
        out.println("<a href='Next.jsp'>Next</a>");

     --%>


     <% out.println("Hii how are you the result of");
     out.println(100/0);
     response.sendError(HttpServletResponse.SC_NOT_FOUND);
     %>






	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>
