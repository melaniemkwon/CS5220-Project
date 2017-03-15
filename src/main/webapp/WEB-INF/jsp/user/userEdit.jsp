<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="user">
First Name: <form:input path="firstName" /><br />
Last Name: <form:input path="lastName" /><br />
email: <form:input path="email"/> <br />
role: <form:input path="role" /> <br />
<input type="submit" name="save" value="Save" />
</form:form>

</body>
</html>