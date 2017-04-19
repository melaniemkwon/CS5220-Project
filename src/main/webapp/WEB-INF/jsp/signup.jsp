<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<<<<<<< HEAD

=======
<title>Sign up Page</title>

<link rel="stylesheet" href="/formbuilder/assets/vendors/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/formbuilder/assets/vendors/bootstrap-material-design/css/bootstrap-material-design.min.css">
<link rel="stylesheet" href="/formbuilder/assets/vendors/bootstrap-material-design/css/ripples.min.css">
<link rel="stylesheet" href="/formbuilder/assets/vendors/DataTables-1.10.13/css/dataTables.bootstrap.css">
<link rel="stylesheet" href="/formbuilder/assets/resources/css/formbuilder.css">

<script src="/formbuilder/assets/vendors/jquery/jquery-3.2.0.min.js"></script>
<script src="/formbuilder/assets/vendors/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<!-- Material Design for Bootstrap -->
<script src="/formbuilder/assets/vendors/bootstrap-material-design/js/material.js"></script>
<script src="/formbuilder/assets/vendors/bootstrap-material-design/js/ripples.min.js"></script>
>>>>>>> a804ea5c9eb98b80cfef6171e799600f0417974f
</head>
<body>

<div class="container">

<<<<<<< HEAD
	<div class="col-md-offset-3 col-md-6">
		<h3>Register New Account</h3>
=======
	<div class="col-md-offset-3 col-md-7">
		<h3>Thank you for being part of our community</h3>
>>>>>>> a804ea5c9eb98b80cfef6171e799600f0417974f
		
		<div class="panel panel-primary">
		
			<div class="panel-heading">
				<h4 class="panel-title">Signup</h4>
			</div>
				
				<form:form modelAttribute="user" class="User" method="post" >
				
				
<<<<<<< HEAD
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
=======
						<div class="form-group label-static">
							<label for="username" class="control-label">Username</label>
							<form:input path="username" maxlength="12" cssClass="form-control" required="required" />
						</div>
					
						<div class="form-group label-static">
							<label for="password" class="control-label">Password</label>
							<form:password path="password" maxlength="12" cssClass="form-control" required="required" />
						</div>
						
					<%-- <div class="form-group">
						<div>
							<label for="role">Role</label>
						</div>
						<form:select path="role" cssClass="form-control">
							<form:option selected="selected" value="ROLE_USER">USER</form:option>
							<form:option value="ROLE_STAFF">STAFF</form:option>
							<form:option value="ROLE_ADMIN">ADMIN</form:option>
						</form:select>
					</div> --%>
					<%-- <div class="form-group">
						<div class="togglebutton">
							<form:checkbox path="enabled" label=" Enable" />
						</div>
					</div>
					<hr> --%>

						<div class="form-group label-static">
							<label for="email" class="control-label">Email </label> <form:errors class="error" path="email" />
							<form:input path="email" cssClass="form-control" required="required" />
						</div>
					
						<div class="form-group label-static">
							<label for="firstName" class="control-label">First Name</label>
							<form:input path="firstName" maxlength="12" cssClass="form-control" required="required" />
						</div>
					
						<div class="form-group label-static">
							<label for="lastName" class="control-label">Last Name</label>
							<form:input path="lastName" maxlength="12" cssClass="form-control" required="required" />
						</div>
						
						<div class="form-group label-static">
							<label for="phoneNumber" class="control-label">Phone Number</label> <form:errors class="error" path="phoneNumber" />
							<form:input path="phoneNumber" maxlength="12" cssClass="form-control" required="required" />
						</div>
						
						<div class="form-group label-static">
							<label for="street" class="control-label">Street</label>
								<form:input path="street" maxlength="12" cssClass="form-control" required="required" />
						</div>
					
						<div class="form-group label-static">
							<label for="city" class="control-label">City</label>
							<form:input path="city" maxlength="12" cssClass="form-control" required="required" />
						</div>
					
						<div class="form-group label-static">
							<label for="state" class="control-label">State</label>
>>>>>>> a804ea5c9eb98b80cfef6171e799600f0417974f
							<form:input path="state" maxlength="12" cssClass="form-control" required="required" />
						</div>
					
					
<<<<<<< HEAD
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
=======
						<div class="form-group label-static">
							<label for="zip" class="control-label">Zipcode</label> <form:errors class="error" path="zip" />
							<form:input path="zip" maxlength="12" cssClass="form-control" required="required" />
						</div> 
					
					<button type="submit" class="btn btn-raised btn-primary">
						<span class="glyphicon glyphicon-plus-sign"></span> ADD NEW USER
					</button>

			</form:form>
			
>>>>>>> a804ea5c9eb98b80cfef6171e799600f0417974f
			</div>
		</div>
	</div>
</body>
</html>