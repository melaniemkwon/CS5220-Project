<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
			<div class="panel-heading">View Account Details</div>
			<div class="panel-body">
			<div style="white-space: nowrap;">

				<table id="userTable" class="table">
					<tr>
						<th>ID</th>
						<td><div class="col-md-1">${user.id}</div></td>
					</tr>
					<tr>
						<th>Username</th>
						<td><div class="col-md-1">${user.username}</div></td>
					</tr>
					<tr>
						<th>Role</th>
						<td><div class="col-md-1">${user.role}</div></td>
					</tr>
					<tr>
						<th>Account Enabled</th>
						<td><div class="col-md-1">${user.enabled}</div></td>
					</tr>
					<tr><td></td><td></td></tr>
					<tr>
						<th>Name</th>
						<td><div class="col-md-1">${user.firstName} ${user.lastName}</div></td>
					</tr>
					<tr>
						<th>Email</th>
						<td><div class="col-md-1">${user.email}</div></td>
					</tr>
					<tr>
						<th>Phone Number</th>
						<td><div class="col-md-1">${user.phoneNumber}</div></td>
					</tr>
					<tr>
						<th>Address</th>
						<td><div class="col-md-1">${user.street}, ${user.city} ${user.state} ${user.zip}</div></td>
					</tr>
				</table>
			
			</div>
			</div>
		</div>
	</div>
</div>
</div>



