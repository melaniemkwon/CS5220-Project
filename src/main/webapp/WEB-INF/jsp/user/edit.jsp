<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-md-6 col-md-offset-3">
	<div class="page-header">
		<h2>Edit User</h2>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4 class="panel-title">Enter User Information</h4>
		</div>
		<div class="panel-body">
			<form:form modelAttribute="user" class="form" cssClass="form-horizontal">
				<div class="col-md-6 col-md-offset-3">
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
					<div class="form-group">
						<div>
							<label for="firstName">First Name</label>
						</div>
						<form:input path="firstName" maxlength="12" cssClass="form-control" required="required" />
					</div>
					<div class="form-group">
						<div>
							<label for="lastname">Last Name</label>
						</div>
						<form:input path="lastName" maxlength="12" cssClass="form-control" required="required" />
					</div>
					<div class="form-group">
						<div>
							<label for="email">Email</label>
						</div>
						<form:input path="email" cssClass="form-control" required="required" />
					</div>
					<div class="form-group">
						<div>
							<label for="role">Role</label>
						</div>
						<form:select path="role" cssClass="form-control">
							<form:option selected="selected" value="USER">USER</form:option>
							<form:option value="ADMIN">ADMIN</form:option>
						</form:select>
					</div>
					<button type="submit" class="btn btn-primary btn-sm">
						<span class="glyphicon glyphicon-floppy-disk"></span> SAVE
					</button>
				</div>
			</form:form>
		</div>
	</div>
</div>
