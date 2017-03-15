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
<form action="add1.html" method="POST">
First Name: <input type="text" name="firstName" /> <br/>
Last Name: <input type="text" name="lastName" /> <br/>
Email: <input type="text" name="email" /> <br/>
Role: <input type="text" name="userRole" /> <br/>
<input type="submit" name="add" value="Add" />
</form>

</body>
</html>