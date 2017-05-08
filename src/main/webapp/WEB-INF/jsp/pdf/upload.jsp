	
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	
<body>

	<h1 align=center>File Management</h1> 
	
	<div class="container" >
		
	
	<table class="table table-striped table-bordered" style="text-align= center; vertical-align:middle; ">
		<thead>
		<tr> <th> Name </th> <th> View </th> <th> Download </th> <th> Delete </th> <th> Rename File </th></tr></thead>
		<c:forEach items="${files}" var="file" > 
		<tbody> 
		<tr> <td align=center valign="middle">${file.name}</td> <td><a class="btn" href="upload/view.html?f=${file}" data-toggle="tooltip" title="Open"> <i class="glyphicon glyphicon-eye-open"></i></a></td> 
			 <td ><a class="btn" href="upload/download.html?f=${file}" data-toggle="tooltip" title="Download"> <i class="glyphicon glyphicon-open-file"></i></a></td>
			 <td ><a class="btn" href="upload/delete.html?f=${file}" data-toggle="tooltip" title="Delete"> <i class="glyphicon glyphicon-trash"></i> </a></td>
			 <td> 
			 <div align=center style="valign:middle;">
			 <form method="get" action="upload/edit.html" >
			 <input type="text" name="userName" />
			 <input type="hidden" value="${file}" name="fileName"/>
			 <input type="submit" value="Rename" />
			 </form>
			 </div>
			 </td>
			 </tr>
		</tbody>
		</c:forEach>
		</table>
		</div> 
		
			
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-success" style="width=50%;">
			<div class="panel-heading">
				<h4 align=center class="panel-title">Upload New File</h4>
			</div>
		
			<div class="panel-body">
					<form method="post" action="upload.html" enctype="multipart/form-data">
				<div >
					
					<div align=center>
						<input type="file" name="fileUpload" />
					</div>
			
				</div>
					<div align=center>
					<input type="submit" value="Upload" />
					</div>
				</form>
		</div>
	</div>
	</div>
</body>
</html>