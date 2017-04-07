<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Assign Form</title>
  		<link rel="stylesheet" href="<c:url value='/assets/vendors/bootstrap-3.3.7-dist/css/bootstrap.min.css' />">
 		<link rel="stylesheet" href="<c:url value='/assets/vendors/DataTables-1.10.13/css/dataTables.bootstrap.css' />">
		<style>
			body {
				padding-top: 70px;
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
					<a class="navbar-brand" href="/FormBuilder/">Formbuilder</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="/formbuilder/">Home</a></li>
						<li><a href="/formbuilder/user/list.html">Users</a></li>
						<li class="active"><a href="/formbuilder/form/listForm.html">Forms</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="container">
		    <div class="row form-group">
		        <div class="col-md-offset-3 col-md-6">
		            <label for="search๊หำพ" class="control-label">Search: </label>
		            <input type="text" name="searchUser" id="searchUser" class="form-control custom-input" placeholder="User Name or Full Name" required/>
		        </div>
		    </div>
			<div class="row form-group" style="text-align: center;">
		        <input id="clearSearch" type="button" class="btn btn-default" value="Clear" style="padding-left: 3em; padding-right: 3em;">
		        <input id="choose" type="button" class="btn btn-primary" value="Choose" style="padding-left: 3em; padding-right: 3em;">
		    </div>
		
			<table id="userTable" class="table table-striped table-bordered">
				<thead>
					<tr><th >ID</th><th>First Name</th><th>Last Name</th><th>Role</th><th>Operations</th></tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td class="col-md-1">${user.id}</td>
							<td class="col-md-2">${user.firstName}</td>
							<td class="col-md-2">${user.lastName}</td>
							<td class="col-md-1">${user.role}</td>
							<td class="col-md-1">
								<a class="btn" href="view.html?id=${user.id}" data-toggle="tooltip" title="View User"><i class="glyphicon glyphicon-eye-open"></i></a>
								<a class="btn" href="edit.html?id=${user.id}" data-toggle="tooltip" title="Edit User Information"><i class="glyphicon glyphicon-pencil"></i></a>
								<a class="btn" href="delete.html?id=${user.id}" data-toggle="tooltip" title="Delete User"><i class="glyphicon glyphicon-trash"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-offset-10">
			<a href="add.html" id="popupAddUser"><button type="button" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-plus"></span> ADD NEW USER </button></a>
		</div>

		<!-- Modal -->		
		<div id="successModal" class="modal fade" tabindex="-1" role="dialog">
		    <div class="modal-dialog" role="document">
		        <div class="modal-content">
		            <div class="modal-header">
		                <!--                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>-->
		                <h4 class="modal-title">Success</h4>
		            </div>
		            <div class="modal-body">
		                <p>Your information is successfully added.</p>
		            </div>
		            <div class="modal-footer">
		                <button id="closeSuccessModal" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		            </div>
		        </div>
		    </div>
		</div>
		
		
	<script src="<c:url value='/assets/vendors/jquery/jquery-3.2.0.min.js' />"></script>
	<script src="<c:url value='/assets/vendors/bootstrap-3.3.7-dist/js/bootstrap.min.js' />"></script>  
	<script src="<c:url value='/assets/vendors/DataTables-1.10.13/js/jquery.dataTables.min.js' />"></script>
	<script src="<c:url value='/assets/vendors/DataTables-1.10.13/js/dataTables.bootstrap.min.js' />"></script>
	
	<script>
	  $(document).ready(function(){
		    $('#userTable').DataTable();
		});
	</script>
	
	</body>
</html>