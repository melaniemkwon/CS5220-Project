<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="formbuilder" uri="http://formbuilder.com/formbuilder"%>

<div class="row">
<div class="col-md-offset-3 col-md-6">

	<div class="text-center">
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<li><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach begin="1" end="${form.totalPages}" step="1" var="i">
					<c:choose>
						<c:when test="${param.pageNum eq i }">
							<li class="active"><a href="" onclick="return false">${i} </a></li>
						</c:when>
						<c:otherwise>
							<li><a href="fillForm.html?uId=${param.uId}&fId=${param.fId}&pageNum=${i}">${i} </a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>

	<H2>FORM : ${form.name}
	<c:choose>
	<c:when test="${finished eq '1'}">
	( Completed )
	</c:when>
	</c:choose>
	</H2>
	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4 class="panel-title">PAGE ${param.pageNum}</h4>
		</div>
		<div class="panel-body">
			<c:choose>
				<c:when test="${numQuestion eq 0}">
					<h3 class="text-center">There is no question on this page.</h3>
				</c:when>
				<c:otherwise>

					<form:form  modelAttribute="form" class = "form" >
						<c:forEach items="${form.questions}" var="question" varStatus="status">
							<c:if test="${question.pageNumber eq param.pageNum }">
								<formbuilder:answerDisplay question="${question }" index="${status.index }"></formbuilder:answerDisplay>
								<hr />	
							</c:if>
						</c:forEach>
						<c:choose>
							<c:when test="${finished eq '1'}">
								
								<a href="listForm.html?id=${param.uId}"><button type="button" class="btn btn-warning btn-sm">
						<span class="glyphicon glyphicon-arrow-left"></span> RETURN TO FORM LIST
					</button></a>
							</c:when>
							<c:otherwise>
							<div><label class="control-label">Please check when filling is completed.</label></div>
							<div class="checkbox">
							<label><input type="checkbox" name='finished' label="Completed" value="1"/></label></div>
							<button type="submit" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-floppy-disk"></span> SAVE</button>	
							</c:otherwise>
						</c:choose>
					</form:form>	
				</c:otherwise>
			</c:choose>
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
							<li class="active"><a href="" onclick="return false">${i} </a></li>
						</c:when>
						<c:otherwise>
							<li><a href="fillForm.html?uId=${param.uId}&fId=${param.fId}&pageNum=${i}">${i} </a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>

</div>
</div>