<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr><th>ID</th><td>${user.id}</td></tr>
<tr><th>Username</th><td>${user.firstName}</td></tr>
<tr><th>Password</th><td>${user.lastName}</td></tr>
<tr><th>Enabled</th><td>${user.email}</td></tr>

</table>

</body>
</html>