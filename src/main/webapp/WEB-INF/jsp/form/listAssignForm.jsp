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
			<h2>Form assignment of : ${form.name }</h2>
			<table id="userTable" class="table table-striped table-bordered">
				<thead>
					<tr><th >ID</th><th>Username</th><th>First Name</th><th>Last Name</th><th>Assign Status</th><th>Operations</th></tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<c:set var="contains" value="false" />
						<c:forEach items="${user.forms}" var="item">
						  <c:if test="${item eq form}">
						    <c:set var="contains" value="true" />
						  </c:if>
						</c:forEach>
						<tr>
							<td class="col-md-1">${user.id}</td>
							<td class="col-md-1">${user.username}</td>
							<td class="col-md-2">${user.firstName}</td>
							<td class="col-md-2">${user.lastName}</td>
							<c:choose>
								<c:when test="${contains }">
									<td class="col-md-1"><div style="text-align:center; color:green" data-toggle="tooltip" title="Assigned" ><i class="glyphicon glyphicon-export" style="font-size:1.5em"></i></div></td>
									<td class="col-md-1">
										<a class="btn disabled" href="" data-toggle="tooltip" title="Assign Form"><i class="glyphicon glyphicon-ok"></i></a>
										<a class="btn" href="deassignForm.html?id=${form.id}&uId=${user.id}" data-toggle="tooltip" title="Deassgin Form" style="color:red"><i class="glyphicon glyphicon-remove"></i></a>
									</td>
								</c:when>
								<c:otherwise>
									<td class="col-md-1"><div style="text-align:center;" data-toggle="tooltip" title="Not assign" ><i class="glyphicon glyphicon-minus" style="font-size:1.5em"></i></div></td>
									<td class="col-md-1">
										<a class="btn" href="assignForm.html?id=${form.id}&uId=${user.id}" data-toggle="tooltip" title="Assign Form" style="color:green"><i class="glyphicon glyphicon-ok"></i></a>
										<a class="btn disabled" href="" data-toggle="tooltip" title="Deassgin Form"><i class="glyphicon glyphicon-remove"></i></a>
									</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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