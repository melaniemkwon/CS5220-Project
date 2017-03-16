<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="docroot" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page View</title>
</head>
<body>
<a href="${docroot}form/add_block.html?id=${page.form.id}&p=${page.pageNumber}">Add New Block</a>

<table border=1>
<tr><th>Form: </th><td>${page.form.name}</td></tr>
<tr><th>Page Number</th><td>${page.pageNumber}</td></tr>
<tr><th>Available</th><td></td></tr>

</table>
Blocks:<br/>
<c:forEach items="${page.block}" var="block">
	<a href="${docroot}form/block/${block.id}.html">${block.name}</a><br/></a>
</c:forEach>
</body>
</html>