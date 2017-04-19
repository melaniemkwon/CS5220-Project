<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
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
		<h3>Spring Security Custom Login Form (XML)</h3>
		
		<div class="panel panel-primary">
		
			<div class="panel-heading">
				<h4 class="panel-title">Login</h4>
			</div>
			
			<div class="panel-body">
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="fade in">${msg}</div>
				</c:if>
				
				<form name='loginForm' action="<c:url value='/login' />" method='POST'>

					<div class="form-group label-static">
						<label for="username" class="control-label">Username</label>
						<input type='text' name='username' class="form-control" value='' id='username'>
					</div>
					
					<div class="form-group label-static">
						<label for="password" class="control-label">Password</label>
						<input type='password' name='password' class="form-control" id='password'/>
					</div>
					
					<input name="submit" type="submit" value="Login" class="btn btn-raised btn-primary"/>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>