<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row">
<div class="col-md-6 col-md-offset-3">
	<div class="page-header">
		<h2>Add New User</h2>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4 class="panel-title">Enter New User Information</h4>
		</div>
		<div class="panel-body">
			<form:form modelAttribute="user" class="form" cssClass="form-horizontal">
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
					<div class="form-group">
						<div>
							<label for="role">Role</label>
						</div>
						<form:select path="role" cssClass="form-control">
							<form:option selected="selected" value="ROLE_USER">USER</form:option>
							<form:option value="ROLE_STAFF">STAFF</form:option>
							<form:option value="ROLE_ADMIN">ADMIN</form:option>
						</form:select>
					</div>
					<div class="form-group">
						<div class="togglebutton">
							<form:checkbox path="enabled" label=" Enable" />
						</div>
					</div>
					<hr>
					<div class="form-group">
						<div>
							<label for="email">Email</label>
						</div>
						<form:input path="email" cssClass="form-control" required="required" />
					</div>
					<div class="form-group">
						<div>
							<label for="firstName">First Name</label>
						</div>
						<form:input path="firstName" maxlength="12" cssClass="form-control" required="required" />
					</div>
					<div class="form-group">
						<div>
							<label for="lastName">Last Name</label>
						</div>
						<form:input path="lastName" maxlength="12" cssClass="form-control" required="required" />
					</div>
					<div class="form-group">
						<div>
							<label for="phoneNumber">Phone Number</label>
						</div>
						<form:input path="phoneNumber" maxlength="12" cssClass="form-control" required="required" />
					</div>
					<div class="form-group">
						<div>
							<label for="street">Street</label>
						</div>
						<form:input path="street" maxlength="12" cssClass="form-control" required="required" />
					</div>
					<div class="form-group">
						<div>
							<label for="city">City</label>
						</div>
						<form:input path="city" maxlength="12" cssClass="form-control" required="required" />
					</div>
					<div class="form-group">
						<div>
							<label for="state">State</label>
						</div>
						<form:input path="state" maxlength="12" cssClass="form-control" required="required" />
					</div>
					<div class="form-group">
						<div>
							<label for="zip">Zipcode</label>
						</div>
						<form:input path="zip" maxlength="12" cssClass="form-control" required="required" />
					</div>
					<button type="submit" class="btn btn-raised btn-primary">
						<span class="glyphicon glyphicon-plus-sign"></span> ADD NEW USER
					</button>
				</div>
			</form:form>
		</div>
	</div>
</div>
</div>





