<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="question" required="true" type="formbuilder.model.questionform.Question"%>
<%@ attribute name="index" required="true" type="java.lang.Integer"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

				
				<form:input path="questions[${index }].answers[0].text" cssClass="form-control" required="${question.tagAttribute.required }"/>
					

			</div>
		</c:when>

		<c:when test="${question.tagAttribute.type eq 'number'}">
			<div>
				<label for="question${question.questionNumber}"
					class="control-label">${question.questionNumber}.
					${question.description }</label>
			</div>
			<div class="${question.tagAttribute.size }">
				<form:input path="questions[${index }].answers[0].text" cssClass="form-control" required="${question.tagAttribute.required }"/>
				
			</div>
		</c:when>

		<c:when test="${question.tagAttribute.type eq 'textarea'}">
			<div>
				<label for="question${question.questionNumber}"
					class="control-label">${question.questionNumber}.
					${question.description }</label>
			</div>
			<div class="${question.tagAttribute.size }">

				<form:textarea path="questions[${index }].answers[0].text" cssClass="form-control" rows="${question.tagAttribute.rows}" required="${question.tagAttribute.required }"/>			

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
	    			<label>
						<form:checkbox path="questions[${index }].answers[0].selections[${loop.index }]" value="${choice }" label="${choice }"/>
	    			</label>
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
				<form:radiobutton path="questions[${index }].answers[0].selections[0]" value="${choice }" label="${choice }" /> 				
			</c:forEach>
		</c:when>

		<c:when test="${question.tagAttribute.type eq 'options'}">
			<div>
				<label for="question${question.questionNumber}"
					class="control-label">${question.questionNumber}.
					${question.description}</label>
			</div>
			<div class="${question.tagAttribute.size }">
				<form:select path="questions[${index }].answers[0].selections[0]" class="form-control">
		            <form:option value="NONE" label="--- Select ---" />
		            <form:options items="${question.choices }"/>
	            </form:select>
            </div>
		</c:when>
		<c:otherwise>
			<p>QUESTION TYPE NOT FOUND</p>
			<p>${question.tagAttribute.type }</p>
		</c:otherwise>
	</c:choose>
</div>
