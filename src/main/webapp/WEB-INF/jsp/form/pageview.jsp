<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page View</title>
</head>
<body>
<table border=1>
<a href="block/add_block.html">Add New Block</a>
<tr><th>Name</th><td>${form.name}</td></tr>
<tr><th>Page Number</th><td>${page.pageNumber}</td></tr>
<tr><th>Available</th><td>
<c:choose>
  <c:when test="${form.available==true}">
  Yes
  </c:when>
  <c:otherwise>
  No
  </c:otherwise>
</c:choose>
</td></tr>
</table>
</body>
</html>