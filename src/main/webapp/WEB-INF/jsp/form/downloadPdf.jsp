<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"/>

<div class="container">
	<h3>Download PDF for Form ${form.name}</h3>
	<table id="formTable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>User ID</th>
				<th>Username</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${form.users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>
						<form method="get" action="../userForm/downloadPDF">
							<input type="hidden" name="formId" value="${form.id}">
							<input type="hidden" name="userId" value="${user.id}">
							<button type="submit" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-download"></span> DOWNLOAD PDF</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>


<script src="<c:url value='/assets/vendors/DataTables-1.10.13/js/jquery.dataTables.min.js' />"></script>
<script src="<c:url value='/assets/vendors/DataTables-1.10.13/js/dataTables.bootstrap.min.js' />"></script>

<script>
	$(document).ready(function() {
		$('#formTable').DataTable();
		$('#formTable_filter').addClass('form-group');
	});
</script>