<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ attribute name="question" required="true" type="formbuilder.model.questionform.Question"%>
<%@ tag body-content="scriptless"%>

<div class="form-group row" style="margin-left: 10px; margin-top: 10px;">

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
				
				<form:input class="form-control" path="answers[${question.questionNumber}]" value=""/>
			
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
					<label> <form:checkbox path="answers[${question.questionNumber}]" value="${loop.index}"/> ${choice}</label>
				</div>
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
</div>

