<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${form.title}</h2>
	
	<h4>Edit question</h4>

	        <form:form modelAttribute="item">
				Choose question type:
				<form:select path="itemType" id="selectedItemType"> 
	              <c:forEach items="${itemTypes}" var="type">
	              	<form:option value="${type}">${type}</form:option>
	              </c:forEach>
		        </form:select> <br />
				Question: <form:input path="title" />
				<br> 
				Description: <form:textarea path="description" rows="3" cols="30"/>
				<br>
				Available: <form:checkbox path="available" />
				<br>
				Required: <form:checkbox path="required" />
				<br>
				Order #: <form:input path="orderNum" />
				<br>
				
				<c:if test="${itemType == 'CHECKBOX' || itemType == 'DROPDOWN_LIST' || itemType == 'MULTIPLE_CHOICE'}">
					Selections: 
					<ul>
						<c:forEach items="${selections}" var="selection">
							<li>${selection.value}</li><a href="../editSelection/${selection.id}.html"> Edit this Selection</a>
						</c:forEach>
							<li><a href="../addSelection/${item.id}">ADD A NEW SELECTION</a>
					</ul>
				</c:if>	
	
				<input type="submit" class="btn btn-info" name="add" value="Save Changes" />
			</form:form>

	<h5><a href="../edit/${form.id}.html">Go back to main form</a></h5>
</body>
</html>