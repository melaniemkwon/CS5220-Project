<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<style>
    .error {
        color: red; font-weight: bold;
        size: 50px;
    }
</style>
<%-- <div class="row">
<div class="col-md-6 col-md-offset-3">
	<div class="page-header">
		<h2>Edit User</h2>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4 class="panel-title">Edit User Information</h4>
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
							<label for="">Role</label>
						</div>
						<form:select path="role" cssClass="form-control">
							<form:option selected="selected" value="USER">USER</form:option>
							<form:option value="STAFF">STAFF</form:option>
							<form:option value="ADMIN">ADMIN</form:option>
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
						<span class="glyphicon glyphicon-floppy-disk"></span> SAVE
					</button>
				</div>
			</form:form>
		</div>
	</div>
</div>
</div>

 --%>
<!-- ********************************** -->

<div class="container" style="padding-top: 60px;">
  <h1 class="page-header">Edit User Profile</h1>
  <div class="row">
   
   
    <!-- left column -->
    <div class="col-md-4 col-sm-6 col-xs-12">
      <div class="text-center">
        <img src="http://sun.calstatela.edu/~cysun/www/img/cysun3.jpg" class="avatar img-circle img-thumbnail" alt="avatar">
        <h6>Upload a different photo...</h6>
        <input type="file" class="text-center center-block well well-sm">
      </div>
    </div>
    
    
    
    <!-- edit form column -->
    <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
      
      <h3>Personal info</h3>
      
      
      <!--  START THE FORM  -->
      <form:form modelAttribute="user" class="form" cssClass="form-horizontal">
        
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
          <label class="col-lg-3 control-label">Phone Number:</label> <form:errors class="error" path="phoneNumber" />
          <div class="col-lg-8">
           <form:input path="phoneNumber" maxlength="12" cssClass="form-control" required="required"/>
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Email:</label> <form:errors class="error" path="email" />
          <div class="col-lg-8">
           <form:input path="email" cssClass="form-control" required="required" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Username:</label>
          <div class="col-md-8">
				<security:authorize access="hasRole('ROLE_ADMIN')">		
	            	<form:input path="username" maxlength="12" cssClass="form-control" required="required" />
				</security:authorize>
				<security:authorize access="!hasRole('ROLE_ADMIN')">
					<form:input path="username" maxlength="12" cssClass="form-control" required="required" disabled="true"/>
				</security:authorize>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Password:</label>
          <div class="col-md-8">
            <form:password path="password" maxlength="12" cssClass="form-control" showPassword="true" required="required" />
          </div>
        </div>
        
        <div class="form-group">
			
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<div>
						<label for="role">Role</label>
					</div>
					<form:select path="role" cssClass="form-control">
						<form:option value="ROLE_USER">USER</form:option>
						<form:option value="ROLE_STAFF">STAFF</form:option>
						<form:option value="ROLE_ADMIN">ADMIN</form:option>
					</form:select>
				</security:authorize>
		</div>
        
        <button type="submit" class="btn btn-raised btn-primary">
		<span class="glyphicon glyphicon-floppy-disk"></span> SAVE </button>
      
      </form:form>
    
    </div>
    
  </div>

</div>
