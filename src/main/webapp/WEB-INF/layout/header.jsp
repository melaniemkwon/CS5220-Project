<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		</div>
	</div>
</nav>
