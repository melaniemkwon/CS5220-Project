<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Add New User</title>
		<link rel="stylesheet" href="<c:url value='/assets/vendors/bootstrap-3.3.7-dist/css/bootstrap.min.css' />">
		<style>
			body {
				padding-top: 50px;
			}
		</style>
	</head>
	<body>
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/formcreator/">Formbuilder</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="/formcreator/">Home</a></li>
						<li class="active"><a href="/formcreator/user/list.html">Users</a></li>
						<li><a href="/formcreator/form/listForm.html">Forms</a></li>
					</ul>
				</div>
			</div>
		</nav>
	
		<div class="col-md-6 col-md-offset-3" >
	        <div class="page-header">
	            <h2>Add New User</h2>
	        </div>
	
	        <div class="panel panel-primary">
	            <div class="panel-heading">
	                <h4 class="panel-title">
	                    Enter New User Information               
	                </h4>
	            </div>            
	            <div class="panel-body">
					<form:form  modelAttribute="user" class = "form" cssClass="form-horizontal" >
						<div class="col-md-6 col-md-offset-3">
							<div class="form-group">
								<div><label for="username">Username</label></div>			
								<form:input path="username" maxlength="12" cssClass="form-control" required="required"/>
							</div>
							<div class="form-group">
								<div><label for="password">Password</label></div>
								<form:password path="password" maxlength="12" cssClass="form-control" required="required"/>
							</div>
							<div class="form-group">
								<div><label for="firstName">First Name</label></div>			
								<form:input path="firstName" maxlength="12" cssClass="form-control" required="required"/>
							</div>
							<div class="form-group">
								<div><label for="lastname">Last Name</label></div>			
								<form:input path="lastName" maxlength="12" cssClass="form-control" required="required"/>
							</div>
							<div class="form-group">
								<div><label for="email">Email</label></div>
								<form:input path="email" cssClass="form-control" required="required"/>
							</div>
							<div class="form-group">
								<div><label for="role">Role</label></div>
					            <form:select path="role" cssClass="form-control" >            
									<form:option selected="selected" value="USER">USER</form:option>
									<form:option value="ADMIN">ADMIN</form:option>
					            </form:select>
					       </div>
					       <button type="submit" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-plus-sign"></span> ADD</button>
						</div>       
				    </form:form>
				</div>
	        </div>
		</div>
		       		
		<script src="<c:url value='/assets/vendors/jquery/jquery-3.2.0.min.js' />"></script>
		<script src="<c:url value='/assets/vendors/bootstrap-3.3.7-dist/js/bootstrap.min.js' />"></script>
	</body>
</html>


    

		

