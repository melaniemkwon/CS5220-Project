<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>

</head>
<body>

<div class="container">

	<div class="col-md-offset-3 col-md-6">
		<h3>Register New Account</h3>
		
		<div class="panel panel-primary">
		
			<div class="panel-heading">
				<h4 class="panel-title">Signup</h4>
			</div>
				
				<form:form modelAttribute="user" class="User" method="post" >
				
				
						<div class="form-group label-static ">
							<label for="username" class="control-label ">Username</label>
							<form:input path="username" maxlength="12" cssClass="form-control" required="required" />
						</div>
					
						<div class="form-group label-static ">
							<label for="password" class="control-label ">Password</label>
							<form:password path="password" maxlength="12" cssClass="form-control" required="required" />
						</div>

						<div class="form-group label-static ">
							<label for="email" class="control-label ">Email </label> <form:errors class="error" path="email" />
							<form:input path="email" cssClass="form-control" required="required" />
						</div>
					
						<div class="form-group label-static ">
							<label for="firstName" class="control-label ">First Name</label>
							<form:input path="firstName" maxlength="12" cssClass="form-control" required="required" />
						</div>
					
						<div class="form-group label-static ">
							<label for="lastName" class="control-label ">Last Name</label>
							<form:input path="lastName" maxlength="12" cssClass="form-control" required="required" />
						</div>
						
						<div class="form-group label-static ">
							<label for="phoneNumber" class="control-label ">Phone Number</label> <form:errors class="error" path="phoneNumber" />
							<form:input path="phoneNumber" maxlength="12" cssClass="form-control" required="required" />
						</div>
						
						<div class="form-group label-static ">
							<label for="street" class="control-label ">Street</label>
								<form:input path="street" maxlength="12" cssClass="form-control" required="required" />
						</div>
					
						<div class="form-group label-static ">
							<label for="city" class="control-label ">City</label>
							<form:input path="city" maxlength="12" cssClass="form-control" required="required" />
						</div>
					
						<div class="form-group label-static ">
							<label for="state" class="control-label ">State</label>
							<form:input path="state" maxlength="12" cssClass="form-control" required="required" />
						</div>
					
					
						<div class="form-group label-static ">
							<label for="zip" class="control-label ">Zipcode</label> <form:errors class="error" path="zip" />
							<form:input path="zip" maxlength="12" cssClass="form-control" required="required" />
						</div> 
					
					<div align="center">
					<button type="submit" class="btn btn-raised btn-primary ">
						<span class="glyphicon glyphicon-plus-sign"></span> Sign Up
					</button>
				</div>
				
			</form:form>
			</div>
		</div>
	</div>
</body>
</html>