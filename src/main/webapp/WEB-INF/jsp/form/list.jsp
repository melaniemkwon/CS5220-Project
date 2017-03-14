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
<h1>List of Forms</h1>
<a href="add.html">Add New Form</a>
<table border=1>
<tr><th>ID</th><th>Name</th><th>Description</th><th><br/></th></tr>
<c:forEach items="${forms}" var="form">
<tr><td>${form.id}</td><td>${form.name}</td><td>${form.description}</td>
<td><a href="view/${form.id}.html">View</a></td>

</tr>
</c:forEach>
</table>

</body>
</html>