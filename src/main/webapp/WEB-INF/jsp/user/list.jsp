<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="container">
	<table id="userTable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Role</th>
				<th>Operations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td class="col-md-1">${user.id}</td>
					<td class="col-md-2">${user.firstName}</td>
					<td class="col-md-2">${user.lastName}</td>
					<td class="col-md-1"></td>
					<td class="col-md-1">
						<security:authorize access="hasRole('ROLE_ADMIN') or principal.username == '${user.username }'">
							<a class="btn" href="view.html?id=${user.id}" data-toggle="tooltip" title="View User"><i class="glyphicon glyphicon-eye-open"></i></a> <a class="btn"
							href="edit.html?id=${user.id}" data-toggle="tooltip" title="Edit User Information"><i class="glyphicon glyphicon-pencil"></i></a> <a class="btn" href="delete.html?id=${user.id}"
							data-toggle="tooltip" title="Delete User"><i class="glyphicon glyphicon-trash"></i></a>
						</security:authorize>	
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="col-md-offset-10">
	<a href="add.html" id="popupAddUser"><button type="button" class="btn btn-success btn-sm">
			<span class="glyphicon glyphicon-plus"></span> ADD NEW USER
		</button></a>
</div>




<script src="<c:url value='/assets/vendors/DataTables-1.10.13/js/jquery.dataTables.min.js' />"></script>
<script src="<c:url value='/assets/vendors/DataTables-1.10.13/js/dataTables.bootstrap.min.js' />"></script>

<script>
	$(document).ready(function() {
		$('#userTable').DataTable();
		$('#userTable_filter').addClass('form-group');
	});
</script>