<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<security:authentication var="principal" property="principal" />
<div class="container">
	<div class="jumbotron">
		<h2>Welcome ${principal.username} to Formbuilder</h2>
	</div>
	<a href="/formbuilder/userForm/listForm.html?id=${principal.id} ">Link to your form</a>
</div>
