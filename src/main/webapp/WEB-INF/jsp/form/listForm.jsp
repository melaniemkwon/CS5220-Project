<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"/>

<div class="container">
	<table id="formTable" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Form Name</th>
				<th>Description</th>
				<th>Enabled</th>
				<th>Total Pages</th>
				<th>Operations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${forms}" var="form">
				<tr>
					<td class="col-md-1">${form.id}</td>
					<td class="col-md-2">${form.name}</td>
					<td class="col-md-2">${form.description}</td>
					<td class="col-md-1">${form.enabled}</td>
					<td class="col-md-1">${form.totalPages}</td>
					<c:choose>
					<c:when test="${form.published == true}">
						<td class="col-md-2">
						<a class="btn" href="viewPage.html?id=${form.id}&pageNum=1" data-toggle="tooltip" title="View Form"><i class="glyphicon glyphicon-eye-open"></i></a>
						<a class="btn" href="#" data-toggle="tooltip" title="Edit Form Page"><span class="fa-stack fa-lg"><i class="glyphicon glyphicon-pencil" style="color: grey"></i><i class="fa fa-ban fa-stack-2x text-danger"></i></span></a>
						<a class="btn" href="deleteForm.html?id=${form.id}" data-toggle="tooltip" title="Delete Form"><i class="glyphicon glyphicon-trash"></i></a>
						<a class="btn" href="listAssignForm.html?id=${form.id}" data-toggle="tooltip" title="Assign Form"><i class="glyphicon glyphicon-open-file"></i></a>
						<a class="btn" href="downloadPdf.html?id=${form.id}" data-toggle="tooltip" title="Download PDF"><i class="glyphicon glyphicon-download"></i></a>
					</c:when>
					<c:otherwise>
						<td class="col-md-2">
						<a class="btn" href="viewPage.html?id=${form.id}&pageNum=1" data-toggle="tooltip" title="View Form"><i class="glyphicon glyphicon-eye-open"></i></a>
						<a class="btn" href="editPage.html?id=${form.id}&pageNum=1" data-toggle="tooltip" title="Edit Form Page"><i class="glyphicon glyphicon-pencil"></i></a>
						<a class="btn" href="deleteForm.html?id=${form.id}" data-toggle="tooltip" title="Delete Form"><i class="glyphicon glyphicon-trash"></i></a>
						<a class="btn" href="listAssignForm.html?id=${form.id}" data-toggle="tooltip" title="Assign Form"><i class="glyphicon glyphicon-open-file"></i></a>
						<a class="btn" href="publishForm.html?id=${form.id}" data-toggle="tooltip" title="Publish Form" onclick="return confirm('You cannot undo the publish. Are you sure you want to publish this form?');"><i class="glyphicon glyphicon-globe"></i></a>
						<a class="btn" href="downloadPdf.html?id=${form.id}" data-toggle="tooltip" title="Download PDF"><i class="glyphicon glyphicon-download"></i></a></td>	
					</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="col-md-offset-10">
		<a href="addForm.html" id="popupAddForm"><button type="button" class="btn btn-success btn-sm btn-raised">
				<span class="glyphicon glyphicon-plus"></span> ADD NEW FORM
			</button></a>
	</div>
</div>


<script src="<c:url value='/assets/vendors/DataTables-1.10.13/js/jquery.dataTables.min.js' />"></script>
<script src="<c:url value='/assets/vendors/DataTables-1.10.13/js/dataTables.bootstrap.min.js' />"></script>

<script>
	$(document).ready(function() {
		$('#formTable').DataTable();
		$('#formTable_filter').addClass('form-group');
	});
</script>