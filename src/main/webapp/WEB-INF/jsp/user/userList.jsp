<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Edit</th></tr>
<c:forEach items="${users}" var="user">
<tr>
  <td>${user.id}</td>
  <td><a href="userView.html?id=${user.id}">${user.firstName}</a></td>
  <td>${user.lastName}</td>
  <td><a href="userEdit.html?id=${user.id}">Edit</a><td>
</tr>
</c:forEach>
</table>
<a href="add.html" > Add New User</a>


</body>
</html>