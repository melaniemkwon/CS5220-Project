<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<style>
.error {
	color: red;
	font-weight: bold;
	size: 50px;
}
</style>

<div class="container">
	<div class="row">

		<!-- left column -->
		<div class="col-md-4 col-sm-6 col-xs-12">
			<div class="text-center">
				<img src="http://placehold.it/150x150" class="avatar img-circle img-thumbnail" alt="avatar">
				<h6>Upload a different photo...</h6>
				<input type="file" class="text-center center-block panel panel-default">
			</div>
		</div>

		<div class="col-md-8 col-sm-6 col-xs-12 personal-info">
			<div class="panel panel-default">
				<div class="panel-heading">Edit Account Details</div>
				<div class="panel-body">
					<form:form modelAttribute="user" class="form" cssClass="form-horizontal">

						<div class="form-group">
							<label class="col-md-3 control-label">Username:</label>
							<div class="col-md-8">
								<security:authorize access="hasRole('ROLE_ADMIN')">
									<form:input path="username" maxlength="12" cssClass="form-control" required="required" />
								</security:authorize>
								<security:authorize access="!hasRole('ROLE_ADMIN')">
									<form:input path="username" maxlength="12" cssClass="form-control" required="required" disabled="true" />
								</security:authorize>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Password:</label>
							<div class="col-md-8">
								<form:password path="password" maxlength="12" cssClass="form-control" showPassword="true" required="required" />
							</div>
						</div>

						
							<security:authorize access="hasRole('ROLE_ADMIN')">
							<div class="form-group">
								<div>
									<label for="role" class="col-md-3 control-label">Role</label>
								</div>
								<div class="col-md-8">
									<form:select path="role" cssClass="form-control">
										<form:option value="ROLE_USER">USER</form:option>
										<form:option value="ROLE_STAFF">STAFF</form:option>
										<form:option value="ROLE_ADMIN">ADMIN</form:option>
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-2"></div>
								<div class="togglebutton col-md-8">
									<label> 
									Enabled <form:checkbox path="enabled" />
									</label>
								</div>
							</div>
							</security:authorize>
						

						<hr>

						<div class="form-group">
							<label class="col-lg-3 control-label">First name:</label>
							<div class="col-lg-8">
								<form:input path="firstName" maxlength="12" cssClass="form-control" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Last name:</label>
							<div class="col-lg-8">
								<form:input path="lastName" maxlength="12" cssClass="form-control" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Email:</label>
							<form:errors class="error" path="email" />
							<div class="col-lg-8">
								<form:input path="email" maxlength="12" cssClass="form-control" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Phone Number:</label>
							<form:errors class="error" path="phoneNumber" />
							<div class="col-lg-8">
								<form:input path="phoneNumber" maxlength="12" cssClass="form-control" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Street:</label>
							<div class="col-lg-8">
								<form:input path="street" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">City:</label>
							<div class="col-lg-8">
								<form:input path="city" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">State:</label>
							<div class="col-lg-8">
								<form:input path="state" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">Zip code:</label>
							<div class="col-lg-8">
								<form:input path="zip" cssClass="form-control" />
							</div>
						</div>

						<div class="text-center">
							<button type="submit" class="btn btn-raised btn-primary">
								<span class="glyphicon glyphicon-floppy-disk"></span> SAVE
							</button>
						</div>
					</form:form>
				</div>
			</div>

		</div>

	</div>

</div>
