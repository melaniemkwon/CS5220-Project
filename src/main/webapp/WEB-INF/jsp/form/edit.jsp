<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form List</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<style>
body {
	min-height: 2000px;
	padding-top: 70px;
}
</style>
</head>
<body>

	<!-- Fixed navbar -->
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
				<a class="navbar-brand" href="/formbuilder/">Formbuilder</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/formbuilder/">Home</a></li>
					<li><a href="/formbuilder/user/list.html">Users</a></li>
					<li class="active"><a href="/formbuilder/form/list.html">Forms</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Menu1</a></li>
					<li><a href="#">Menu2</a></li>
					<li class="active"><a href="./">Menu3<span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<%-- <form:form modelAttribute="form">
<h1>Edit Form</h1>
	<div class="row form-group">
            <label for="title" class="col-md-2 control-label">Form Name </label>

            <div class="col-md-5">
                <form:input path="title"/>
            </div>
    </div>
    <div class="row form-group">
            <label for="description" class="col-md-2 control-label">Form Description </label>

            <div class="col-md-5">
                <form:input path="description"/>
            </div>
    </div>
    <div class="row form-group">
    	<label for="available" class="col-md-2 control-label">Available </label>
    	<form:radiobutton path="available" value="true" label="Available" /> 
        <form:radiobutton path="available" value="false" label="Unavailable" />
	</div>
    <div class="row form-group">
    	<label for="available" class="col-md-2 control-label">Author </label>
    	<div class="col-md-5">
        	<a href="user/view/${form.author.id}.html">${form.author.id}</a>
        </div>
	</div>
	<div class="row form-group">
            <label for="description" class="col-md-2 control-label">Page Number </label>

            <div class="col-md-5">
                <c:forEach begin="1" end="${fn:length(form.pages)}" varStatus="loop">
					<a href="${docroot}form/page_view.html?id=${form.id}&p=${loop.index}">${loop.index}</a>
				</c:forEach>
            </div>
    </div>
    <input type="submit" name="edit" value="Save Changes" /> 
</form:form> --%>

		<a href="/formbuilder/form/add_UI-preview.html">Preview of UI Concept. (unfinished static page)</a><br><br>

		<form:form modelAttribute="form">
			Form name: <form:input path="title" />
			<br> 
			Description: <form:textarea path="description" rows="3" cols="30"/>
			<br>
			Available: <form:checkbox path="available" />
			<br>

			<input type="submit" class="btn btn-info" name="add" value="Save Form" />
		</form:form>
		<br>
		<br>
		
		<c:if test="${empty items}">
			<h4>Use the right-hand buttons to create your first question.</h4>
		</c:if>
		<c:if test="${not empty items}">
			<c:forEach items="${items}" var="item">
				<br><br>
				# ${item.orderNum} <br>
				<a href="/formbuilder/form/editQuestion/${item.id}.html">Edit this Question</a><br>
				<a href="/formbuilder/form/deleteQuestion/${item.id}.html">Delete this Question</a><br>
				Title: ${item.title} <br>
				Description: ${item.description} <br>
				Type: ${item.itemType} <br>
				
				Required: ${item.required} <br>
				Available: ${item.available} <br>
				
				<c:if test="${item.itemType == 'CHECKBOX' || item.itemType == 'DROPDOWN_LIST' || item.itemType == 'MULTIPLE_CHOICE' }">
					Selections: 
					<ul>
						<c:forEach items="${item.selections}" var="selection">
							<li>${selection.value}</li>
								<ul>
								<li><a href="../editSelection/${selection.id}.html"> Edit this Selection</a></li>
								<li><a href="../deleteSelection/${selection.id}.html"> Delete this Selection</a></li>
								</ul>
						</c:forEach>
							<li><a href="../addSelection/${item.id}.html">ADD A NEW SELECTION</a>
					</ul>
				</c:if>							
			</c:forEach>
		</c:if>
		<br>
		<br>
		<a href="/formbuilder/form/addQuestion/${form.id}.html" class="btn btn-info"> <span
			class="glyphicon glyphicon-plus"></span> ADD NEW QUESTION
		</a>

	</script>
</body>
</html>