<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<title>Edit Page</title>
		<link rel="stylesheet" href="<c:url value='/assets/vendors/bootstrap-3.3.7-dist/css/bootstrap.min.css' />">
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
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/formbuilder/">Formbuilder</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="/formbuilder/">Home</a></li>
						<li><a href="/formbuilder/user/list.html">Users</a></li>
<<<<<<< HEAD
						<li class="active"><a href="/FormBuilder/form/listForm.html">Forms</a></li>
=======
						<li class="active"><a href="/formbuilder/form/listForm.html">Forms</a></li>
>>>>>>> 78b66a586d66aff4fc81db61a82d849f7ae229b1
					</ul>
				</div>
			</div>
		</nav>
	
	
		<div class="row  col-md-offset-1">
			<div class="col-md-7">
				<H3>FORM LIVE PREVIEW</H3>
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
									<div class="btn-group btn-group-sm" role="group"
										aria-label="..." style="margin-left: 10px;">
										<a href="copyQuestion.html?qId=${question.id}" class="btn btn-success" data-toggle="tooltip" title="Duplicate this question"><span class="glyphicon glyphicon-plus-sign"></span></a>
										<a href="deleteQuestion.html?qId=${question.id}" class="btn btn-danger" data-toggle="tooltip" title="Remove this question"><span class="glyphicon glyphicon-minus-sign"></span></a> 
										<a href="moveUpQuestion.html?qId=${question.id}" class="btn btn-warning" data-toggle="tooltip" title="Move this question up"><span class="glyphicon glyphicon-arrow-up"></span></a> 
										<a href="editQuestion.html?qId=${question.id}" class="btn btn-default" data-toggle="tooltip" title="Edit this question"><span class="glyphicon glyphicon-pencil"></span></a> 
										<a href="moveDownQuestion.html?qId=${question.id}" class="btn btn-warning" data-toggle="tooltip" title="Move this question down"><span class="glyphicon glyphicon-arrow-down"></span></a>
									</div>
									<hr/>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
	
			</div>
	
			<div class="col-md-4" style="position: fixed; right: 0; height:500px; overflow:auto;">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4 class="panel-title">FORM CONTROL</h4>
					</div>
					<div class="panel-body">
						<p class="text-center">Click here to add field to the form.</p>
						<div>
							<a href="addTextQuestion.html?id=${param.id}&pageNum=${param.pageNum}&type=text"><button type="button" class="btn btn-info btn-sm custom"><span class="glyphicon glyphicon-font"></span> TEXT</button></a> 
							<a href="addTextQuestion.html?id=${param.id}&pageNum=${param.pageNum}&type=number"><button type="button" class="btn btn-info btn-sm custom"><span class="glyphicon glyphicon-sound-5-1"></span> NUMBER</button></a> 
							<a href="addTextQuestion.html?id=${param.id}&pageNum=${param.pageNum}&type=textarea"><button type="button" class="btn btn-info btn-sm custom"><span class="glyphicon glyphicon-text-size"></span> TEXT AREA</button></a>
						</div>
						<div>
							<a href="addChoiceQuestion.html?id=${param.id}&pageNum=${param.pageNum}&type=checkbox"><button type="button" class="btn btn-info btn-sm custom"><span class="glyphicon glyphicon-check"></span> CHECKBOX</button></a> 
							<a href="addChoiceQuestion.html?id=${param.id}&pageNum=${param.pageNum}&type=radio"><button type="button" class="btn btn-info btn-sm custom"><span class="glyphicon glyphicon-th-list"></span> RADIO</button></a> 
							<a href="addChoiceQuestion.html?id=${param.id}&pageNum=${param.pageNum}&type=options"><button type="button" class="btn btn-info btn-sm custom"><span class="glyphicon glyphicon-collapse-down"></span> OPTION</button></a>
						</div>
						<hr />
						<div>
							<a href="addPage.html?id=${param.id}"><button type="button" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-plus"></span> ADD NEW PAGE</button></a> 
							<c:if test="${form.totalPages > 1 }">
								<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deletePage"><span class="glyphicon glyphicon-trash"></span> DELETE PAGE</button>
							</c:if>
						</div>
					</div>
				</div>
				<div class="text-center">
					<nav aria-label="Page navigation">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<c:forEach begin="1" end="${form.totalPages}" step="1" var="i">
								<c:choose>
									<c:when test="${param.pageNum eq i }">
										<li class="active"><a href="" onclick="return false">${i}
										</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="editPage.html?id=${param.id}&pageNum=${i}">${i}
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
		</div>

<!-- Modal -->
	<div class="modal fade" id="deletePage" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
					<h4 class="modal-title custom_align" id="Heading">Delete this entry</h4>
				</div>
				<div class="modal-body">

					<div class="alert alert-danger">
						<span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Page?
					</div>

				</div>
				<div class="modal-footer ">
					<a href="deletePage.html?id=${param.id}&pageNum=${param.pageNum}">
						<button type="button" class="btn btn-danger">
							<span class="glyphicon glyphicon-ok-sign"></span> Yes
						</button>
					</a>	
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span> No
					</button>
				</div>
			</div>
		</div>
	</div>

	<script src="<c:url value='/assets/vendors/jquery/jquery-3.2.0.min.js' />"></script>
		<script src="<c:url value='/assets/vendors/bootstrap-3.3.7-dist/js/bootstrap.min.js' />"></script>
	</body>
</html>
