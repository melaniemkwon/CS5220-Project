<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Edit selection</h4>

	<form:form modelAttribute="selection">
		Selection: <form:input path="value" />
		<input type="submit" class="btn btn-info" name="add" value="Edit Selection" />
	</form:form>

	<h5>
		<a href="../edit/${form.id}.html">Go back to main form</a>
	</h5>
</body>
</html>