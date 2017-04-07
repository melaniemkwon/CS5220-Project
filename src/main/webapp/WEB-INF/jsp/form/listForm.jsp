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
		<title>List Form</title>
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
						<li><a href="/FormBuilder/">Home</a></li>
						<li><a href="/FormBuilder/user/list.html">Users</a></li>
						<li class="active"><a href="/FormBuilder/form/listForm.html">Forms</a></li>
					</ul>
				</div>
			</div>
		</nav>
	
		<div class="container">
			<table id="formTable" class="table table-striped table-bordered">
				<thead>
					<tr><th >ID</th><th>Form Name</th><th>Description</th><th>Enabled</th><th>Total Pages</th><th>Operations</th></tr>
				</thead>
				<tbody>
					<c:forEach items="${forms}" var="form">
						<tr>
							<td  class="col-md-1" >${form.id}</td>
							<td  class="col-md-2">${form.name}</td>
							<td  class="col-md-2">${form.description}</td>
							<td  class="col-md-1">${form.enabled}</td>
							<td  class="col-md-1">${form.totalPages}</td>
							<td  class="col-md-1">
								<a class="btn" href="viewPage.html?id=${form.id}&pageNum=1" data-toggle="tooltip" title="View Form"><i class="glyphicon glyphicon-eye-open"></i></a>
								<a class="btn" href="editForm.html?id=${form.id}" data-toggle="tooltip" title="Edit Form Property"><i class="glyphicon glyphicon-pencil"></i></a>
								<a class="btn" href="deleteForm.html?id=${form.id}" data-toggle="tooltip" title="Delete Form"><i class="glyphicon glyphicon-trash"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-offset-10">
			<a href="addForm.html" id="popupAddForm"><button type="button" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-plus"></span> ADD NEW FORM </button></a>
		</div>

	<script src="<c:url value='/assets/vendors/jquery/jquery-3.2.0.min.js' />"></script>
	<script src="<c:url value='/assets/vendors/bootstrap-3.3.7-dist/js/bootstrap.min.js' />"></script>  
	<script src="<c:url value='/assets/vendors/DataTables-1.10.13/js/jquery.dataTables.min.js' />"></script>
	<script src="<c:url value='/assets/vendors/DataTables-1.10.13/js/dataTables.bootstrap.min.js' />"></script>
	
	<script>
	  $(document).ready(function(){
		    $('#formTable').DataTable();
		});
	</script>
	
	</body>
</html>