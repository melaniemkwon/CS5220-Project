<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload files</title>
</head>
<body>
	<div align="center">
		<h1>Spring MVC - Hibernate File Upload to Database Demo</h1>
		<form method="post" action="upload.html" enctype="multipart/form-data">
			<table border="0">
				<tr>
					<td>Pick file #1:</td>
					<td><input type="file" name="fileUpload" size="50" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Upload" /></td>
				</tr>
			</table>
		</form> 
	</div>
	
	
	  <c:forEach items="${files}" var="file" > 
		<ul>
		<li><a href="${file.name}" >${file.name}</a></li>
		</ul>
		</c:forEach> 
</body>
</html>