<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="docroot" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Item View</title>
</head>
<body>
<h1>Item View</h1>

<c:choose>
  <c:when test="${item.itemType=='CHECKBOX' and item.minRequirements==0}">
  ${item.name}  ${item.description}
  <input type="checkbox" value="${item.id}"/>
  </c:when>
</c:choose>
<br/>
<c:choose>
  <c:when test="${item.required==true}">Required</c:when>
  <c:otherwise>Not required</c:otherwise>
</c:choose>
<br/>
<c:choose>
  <c:when test="${item.available==true}">Available</c:when>
  <c:otherwise>Unavailable</c:otherwise>
</c:choose>

</body>
</html>