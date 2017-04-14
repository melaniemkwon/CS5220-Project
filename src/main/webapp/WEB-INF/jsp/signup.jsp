<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<title>Sign up Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
</style>
</head>
<body onload='document.loginForm.username.focus();'>

<div class="container">

	<div class="col-md-offset-3 col-md-6">
		<h3>Thank you for being part of our community</h3>
		
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4 class="panel-title">Sign up</h4>
			</div>
				
				<form:form modelAttribute="user" class="form" method="post" cssClass="form-horizontal">
				
				<div class="col-md-8 col-md-offset-2">
					<div class="form-group">
						<div>
							<label for="username">Username</label>
						</div>
						<form:input path="username" maxlength="12" cssClass="form-control" required="required" />
					</div>
					<div class="form-group">
						<div>
							<label for="password">Password</label>
						</div>
						<form:password path="password" maxlength="12" cssClass="form-control" required="required" />
					</div>
					
					<button type="submit" class="btn btn-raised btn-primary">
						<span class="glyphicon glyphicon-plus-sign"></span> ADD NEW USER
					</button>
				</div>
			</form:form>
			
			</div>
		</div>
		</div>
</body>
</html>