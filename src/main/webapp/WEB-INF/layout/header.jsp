<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<security:authentication var="principal" property="principal" />
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/formbuilder/">Formbuilder</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="/formbuilder/">Home</a></li>
				
				<c:choose>
				  <c:when test="${false}">
				    <li class="active"><a href="/formbuilder/user/list.html">Users</a></li>
				  </c:when>
				  <c:otherwise>
				    <li><a href="/formbuilder/user/list.html">Users</a></li>
				  </c:otherwise>
				</c:choose>
				
				<c:choose>
				  <c:when test="${false}">
				    <li class="active"><a href="/formbuilder/form/listForm.html">Forms</a></li>
				  </c:when>
				  <c:otherwise>
				    <li><a href="/formbuilder/form/listForm.html">Forms</a></li>
				  </c:otherwise>
				</c:choose>
			</ul>

			<ul class="nav navbar-nav navbar-right">
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span> ${principal.id}  's Profile <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	                <li><a href="/formbuilder/user/edit.html?id= ${principal.id}">Your Account</a></li>
	                <li class="disabled"><a href="#">Settings</a></li>
	                <li role="separator" class="divider"></li>
	                <li id="logoutDropdownLink" onclick="$('#logout').submit()"><a>Sign Out</a></li>
	              </ul>
	            </li>
          	</ul>
			
			<form action="<c:url value='/logout'/>" method="POST" id="logout">
			  <!-- Form is submitted when User clicks dropdown link to 'Sign Out' -->
			</form>
		</div>
	</div>
</nav>
