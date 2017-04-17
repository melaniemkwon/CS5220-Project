<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="container">
	<c:set var="count" value="0" scope="page" />
	<c:forEach items="${forms}" var="form">
			
		<c:if test="${count % 3 == 0}">
			<div class="row">	
		</c:if>

	   	<div class="col-md-4">
			<a href="/formbuilder/userForm/fillForm.html?id=${form.id}&pageNum=1"><img src="<c:url value='/assets/resources/img/form.png' />"></a>
			<div><a href="/formbuilder/userForm/fillForm.html?id=${form.id}&pageNum=1">${form.name}</a></div>
			<span>${form.description}</span>
		</div>
		
		<c:choose>
		    <c:when test="${count % 3 == 2}">
				</div>
				<c:set var="count" value="${0}" scope="page"/>
		    </c:when>
		    <c:otherwise>
		        <c:set var="count" value="${count + 1}" scope="page"/>
		    </c:otherwise>
		</c:choose>
		
	</c:forEach>
	
	</div>

</div>