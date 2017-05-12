
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='/assets/dropzone/dropzone.js'></script>
</head>

<body>

	<h1 align=center>File Management</h1>

	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-success" style="">
			<div class="panel-heading">
				<h4 align=center class="panel-title">Select or Drop a New File</h4>
			</div>

			<div class="panel-body">
				<form method="post" action="upload.html" class="dropzone" enctype="multipart/form-data" id="my-awesome-dropzone">
					<div align=center>
						<input type="file" name="fileUpload" onchange="this.form.submit()" />
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container">
		<table class="table table-striped table-bordered" style="vertical-align: middle;">
			<thead>
				<tr>
					<th>Name</th>
					<th>View</th>
					<th>Download</th>
					<th>Delete</th>
					<th>Map to Application Form</th>
				</tr>
			</thead>
			<c:forEach items="${files}" var="file">
				<tbody>
					<tr>
						<td align=center valign="middle">${file.name}
							<div align=center style="valign: middle;">
								<form method="get" action="upload/edit.html">
									<input type="text" name="userName" /> <input type="hidden" value="${file}" name="fileName" /> <input type="submit" value="Rename" />
								</form>
							</div>
						</td>
						<td><a class="btn" href="upload/view.html?f=${file}" data-toggle="tooltip" title="Open"> <i class="glyphicon glyphicon-eye-open"></i></a></td>
						<td><a class="btn" href="upload/download.html?f=${file}" data-toggle="tooltip" title="Download"> <i class="glyphicon glyphicon-open-file"></i></a></td>
						<td><a class="btn" href="upload/delete.html?f=${file}" data-toggle="tooltip" title="Delete"> <i class="glyphicon glyphicon-trash"></i>
						</a></td>
						<td>
							<form method="get" action="map">
								<c:if test="not empty ${form.uploadFile}">Mapped Form: ${form.uploadFile.name}</c:if>
								<select name="formId">
									<option disabled selected value> -- select mapped form -- </option>
									<c:forEach items="${forms}" var="form">
									  <option value="${form.id}">${form.name}</option>
									  <br><br>
									</c:forEach>
								</select>
								<input type="hidden" name="f" value="${file}">
								<input type="submit" value="Map">
							</form>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>

</body>
</html>
