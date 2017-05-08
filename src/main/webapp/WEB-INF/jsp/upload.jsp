<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1>Spring MVC file upload example</h1>

<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
    <div class="form-group">
	  <input type="file" name="file">
	  <input type="text" class="form-control" placeholder="Browse File" readonly>
	</div>
	<button type="submit" class="btn btn-raised btn-primary">Submit</button>
</form>
