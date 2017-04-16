<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="row">
	<c:forEach items="${forms}" var="form">
		<div>
			<a href="fillForm.html?uId=${user.id }&fId=${form.id }&pageNum=1"><img src="<c:url value='/assets/resources/img/form.png' />"></a>
			<p>${form.name }
		</div>
	</c:forEach>
</div>