<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


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
						<li class="active"><a href="/formbuilder/user/list.html">Users</a></li>
						<li><a href="/formbuilder/form/listForm.html">Forms</a></li>
					</ul>
				</div>
			</div>
		</nav>
		
	
	<div class="container" style="white-space: nowrap;">
		
		<table id="userTable" class="table table-striped table-bordered">
			<tr> <th> Name </th>  <td><div class="col-md-1">${user.firstName} ${user.lastName}</div></td> </tr>
			<tr> <th> Email </th> <td><div class="col-md-1">${user.email} </div></td> </tr>
			<tr> <th> Address </th> <td><div class="col-md-1">${user.street}, ${user.city} ${user.state}  ${user.zip} </div></td></tr>
		</table>
		
	</div>       
	
	<script src="<c:url value='/assets/vendors/jquery/jquery-3.2.0.min.js' />"></script>
	<script src="<c:url value='/assets/vendors/bootstrap-3.3.7-dist/js/bootstrap.min.js' />"></script>  
	<script src="<c:url value='/assets/vendors/DataTables-1.10.13/js/jquery.dataTables.min.js' />"></script>
	<script src="<c:url value='/assets/vendors/DataTables-1.10.13/js/dataTables.bootstrap.min.js' />"></script>	
	
<script>
  $(document).ready(function(){
	    $('#userTable').DataTable();
	});
</script>

<!--  *****************************************  -->






