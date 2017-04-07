<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="formbuilder" uri="http://formbuilder.com/formbuilder" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Edit Question</title>
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
	
	
		<div class="row  col-md-offset-1">
			<div class="col-md-4">
		        <div class="panel panel-info">
		            <div class="panel-heading">
		                <h4 class="panel-title">
		                        QUESTION CONTROL                
		                </h4>
		            </div>            
		            <div class="panel-body">                
		                <p class="text-center" >Edit the field here.</p>
		                <c:if test="${question.type eq 'TEXT'}">
		                	<formbuilder:editText></formbuilder:editText>	                	
		                </c:if>
		                <c:if test="${question.type eq 'CHOICE'}">
		                	<formbuilder:editChoice question="${question }"></formbuilder:editChoice>	                	
		                </c:if>
		                <a href="viewPage.html?id=${id}&pageNum=${pageNum}"><button type="button" class="btn btn-warning btn-sm"><span class="glyphicon glyphicon-arrow-left"></span> RETURN TO PAGE</button></a>              
		            </div>
		        </div>       
		    </div>			      	
		
		
		
			<div class="col-md-7" style="position: fixed; right: 0; height:500px; overflow:auto;">
				<H3>QUESTION LIVE PREVIEW</H3>
		        <div class="panel panel-primary">
		            <div class="panel-heading">
		                <h4 class="panel-title">
		                    QUESTION ${question.questionNumber}               
		                </h4>
		            </div>            
		            <div class="panel-body">
		            	<formbuilder:fieldDisplay question="${question }"></formbuilder:fieldDisplay>		                
		            </div>
		        </div>
		        
			</div>
			
	  
	    </div>
	
		<script src="<c:url value='/assets/vendors/jquery/jquery-3.2.0.min.js' />"></script>
		<script src="<c:url value='/assets/vendors/bootstrap-3.3.7-dist/js/bootstrap.min.js' />"></script>		
	</body>
</html>
