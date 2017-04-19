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
							<li><a href="viewPage.html?id=${param.id}&pageNum=${i}">${i} </a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>

	<H2>FORM : ${form.name}</H2>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4 class="panel-title">PAGE ${param.pageNum}</h4>
		</div>
		<div class="panel-body">
			<c:choose>
				<c:when test="${empty questionsPage}">
					<h3 class="text-center">There is no question on this page.</h3>
				</c:when>
				<c:otherwise>
				    <form:form  modelAttribute="userAnswer" class = "form" action="/formbuilder/userForm/fillForm.html">
					<input type="hidden" name="id" value="${id}" />
					<input type="hidden" name="pageNum" value="${pageNum}" />
					<c:set var="counter" value="0"/>
					<c:forEach items="${questionsPage}" var="question" varStatus="questionloop">
						
		<c:choose>
		<c:when test="${question.tagAttribute.type eq 'text'}">
			<div>
				<label for="question${question.questionNumber}"
					class="control-label">${question.questionNumber}.
					${question.description }</label>
			</div>
			<div class="${question.tagAttribute.size } input-group">
			<c:choose>
				<c:when test="${question.tagAttribute.inputType eq 'email' }">
					<div class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></div>
				</c:when>
				<c:when test="${question.tagAttribute.inputType eq 'tel' }">
					<div class="input-group-addon"><span class="glyphicon glyphicon-earphone"></span></div>
				</c:when>
				<c:when test="${question.tagAttribute.inputType eq 'time' }">
					<div class="input-group-addon"><span class="glyphicon glyphicon-time"></span></div>
				</c:when>
				<c:when test="${question.tagAttribute.inputType eq 'url' }">
					<div class="input-group-addon">http://</div>
				</c:when>
				<c:when test="${question.tagAttribute.inputType eq 'date' }">
					<div class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></div>
				</c:when>
			</c:choose>
			
			<c:choose>
			<c:when test="${size eq 0}">
				<form:input class="form-control" path="answers[${question.questionNumber}]" value="" />
\			</c:when>
			<c:otherwise>
				<c:forEach items="${answerlist}" var="ans" varStatus="loop">
			    		<c:choose>
			    			<c:when test="${loop.index eq counter }">
								<form:input class="form-control" path="answers[${question.questionNumber}]" value="${ans}" />
								<c:set var="counter" value="${counter + 1}"/>
							</c:when>
			    		</c:choose>
				</c:forEach>
				
			</c:otherwise>
			</c:choose>
			</div>
			
		</c:when>

		<c:when test="${question.tagAttribute.type eq 'number'}">
			<div>
				<label for="question${question.questionNumber}"
					class="control-label">${question.questionNumber}.
					${question.description }</label>
			</div>
			<div class="${question.tagAttribute.size }">
				<input class="form-control"
					path="answers[${question.questionNumber}]" 
					min="${question.tagAttribute.min}" max="${question.tagAttribute.max}"
					step="${question.tagAttribute.step}"
					placeholder="${question.tagAttribute.placeholder }"/>
			</div>
		</c:when>

		<c:when test="${question.tagAttribute.type eq 'textarea'}">
			<div>
				<label for="question${question.questionNumber}"
					class="control-label">${question.questionNumber}.
					${question.description }</label>
			</div>
			<div class="${question.tagAttribute.size }">
				<input type="textarea" class="form-control" name="answers[${question.questionNumber}]" rows="${question.tagAttribute.rows}"/>
			</div>
		</c:when>

		<c:when test="${question.tagAttribute.type eq 'checkbox'}">
			<div>
				<label for="question${question.questionNumber}"
					class="control-label">${question.questionNumber}.
					${question.description }</label>
			</div>
			
			<c:forEach items="${question.choices}" var="choice" varStatus="loop">
				<div class="checkbox">
					<c:choose>
					<c:when test="${size eq 0}">
						<label> <form:checkbox path="answers[${question.questionNumber}]" value="${loop.index}"/> ${choice}</label>
					</c:when>
					<c:otherwise>
					<c:forEach items="${answerlist}" var="ans" varStatus="loop">
						<c:choose>
						<c:when test="${loop.index eq counter}">
						<label> <form:checkbox path="answers[${question.questionNumber}]" value="${loop.index}" checked="true"/> ${choice}</label>
						</c:when>
						</c:choose>
					</c:forEach>
					</c:otherwise>
					</c:choose>
				</div>
				<c:set var="counter" value="${counter + 1}"/> ${counter}
			</c:forEach>
		</c:when>

		<c:when test="${question.tagAttribute.type eq 'radio'}">
			<div>
				<label for="question${question.questionNumber}"
					class="control-label">${question.questionNumber}.
					${question.description }</label>
			</div>
			<c:forEach items="${question.choices}" var="choice" varStatus="loop">
				<div class="radio">
					<label> <input type="radio" name="answers[${question.questionNumber}]" 
					value="${loop.index}"/> ${choice }
						
					</label>
				</div>
			</c:forEach>
		</c:when>

		<c:when test="${question.tagAttribute.type eq 'options'}">
			<div>
				<label for="question${question.questionNumber}"
					class="control-label">${question.questionNumber}.
					${question.description}</label>
			</div>
			<div class="${question.tagAttribute.size }">
				<select class="form-control">
					<option label=" "></option>
					<c:forEach items="${question.choices}" var="choice">
						<option>${choice }</option>
					</c:forEach>
				</select>
			</div>
		</c:when>
		<c:otherwise>
			<p>QUESTION TYPE NOT FOUND</p>
			<p>${question.tagAttribute.type }</p>
		</c:otherwise>
	</c:choose>
						<hr />
					</c:forEach>
					<button type="submit" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-floppy-disk"></span> SAVE</button></button>
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
							<li><a href="viewPage.html?id=${param.id}&pageNum=${i}">${i} </a></li>
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