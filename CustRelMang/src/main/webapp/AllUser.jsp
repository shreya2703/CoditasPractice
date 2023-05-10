<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>AllUser</title>
</head>
<body>
	<h1>All Users</h1>


    <table>
                <thead>
                   <tr>
                      <th>ID</th>
                      <th>address</th>
                      <th>email</th>
                      <th>name</th>
                      <th>Password</th>
                      <th>Phone</th>
                      <th>Manager Name</th>
                      <th>Edit</th>
                      <th>Delete</th>
                   </tr>
                </thead>
                <tbody>
                                   <!--   for (User user: listUser) {  -->
                                   <c:forEach var="user" items="${listUser}">

                                      <tr>
                                         <td><c:out value="${user.id}" /></td>
                                         <td><c:out value="${user.address}" /></td>
                                         <td><c:out value="${user.email}" /></td>
                                         <td><c:out value="${user.name}" /></td>
                                         <td><c:out value="${user.passwod}" /></td>
                                         <td><c:out value="${user.phone}" /></td>
                                         <td><c:out value="${user.manager.name}" /></td>
                                         <td><a href="editServlet?id=<c:out value='${user.id}' />">Edit</a></td>
                                          <td><a href="deleteServlet?id=<c:out value='${user.id}'/>">Delete</a></td>
                                         <td></td>
                                      </tr>
                                   </c:forEach>
                                   <!-- } -->
                                </tbody>
                             </table>


	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>