<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="formbuilder" uri="http://formbuilder.com/formbuilder"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>View Page</title>
<link rel="stylesheet"
	href="<c:url value='/assets/vendors/bootstrap-3.3.7-dist/css/bootstrap.min.css' />">
<style>
body {
	padding-top: 60px;
}

.custom {
	width: 100px !important;
	margin-right: 5px;
	margin-top: 5px;
	border-radius: 24px;
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


	<div class="row  col-md-offset-3 col-md-6">

		<div class="text-center">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<c:forEach begin="1" end="${form.totalPages}" step="1" var="i">
						<c:choose>
							<c:when test="${param.pageNum eq i }">
								<li class="active"><a href="" onclick="return false">${i}
								</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="viewPage.html?id=${param.id}&pageNum=${i}">${i}
								</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>

		<H2>FORM : ${form.name}</H2>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4 class="panel-title">PAGE ${param.pageNum}</h4>
			</div>
			<div class="panel-body">
				<c:choose>
					<c:when test="${empty questionsPage}">
						<h3 class="text-center">There is no question on this page.</h3>
					</c:when>
					<c:otherwise>
						<c:forEach items="${questionsPage}" var="question">
							<formbuilder:fieldDisplay question="${question }"></formbuilder:fieldDisplay>
							<hr />
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<div class="text-center">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<c:forEach begin="1" end="${form.totalPages}" step="1" var="i">
						<c:choose>
							<c:when test="${param.pageNum eq i }">
								<li class="active"><a href="" onclick="return false">${i}
								</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="viewPage.html?id=${param.id}&pageNum=${i}">${i}
								</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>

	</div>
	<script
		src="<c:url value='/assets/vendors/jquery/jquery-3.2.0.min.js' />"></script>
	<script
		src="<c:url value='/assets/vendors/bootstrap-3.3.7-dist/js/bootstrap.min.js' />"></script>
</body>
</html>
