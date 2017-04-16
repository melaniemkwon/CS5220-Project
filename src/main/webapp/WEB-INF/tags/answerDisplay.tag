<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="answer" required="true" type="formbuilder.model.questionform.Answer"%>
<%@ tag body-content="scriptless"%>


<div class="form-group row" style="margin-left: 10px; margin-top: 10px;">
	<c:choose>
		<c:when test="${answer.question.tagAttribute.type eq 'text'}">
			<div>
				<label for="question${answer.question.questionNumber}"
					class="control-label">${answer.question.questionNumber}.
					${answer.question.description }</label>
			</div>
			<div class="${answer.question.tagAttribute.size } input-group">
			<c:choose>
				<c:when test="${answer.question.tagAttribute.inputType eq 'email' }">
					<div class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></div>
				</c:when>
				<c:when test="${answer.question.tagAttribute.inputType eq 'tel' }">
					<div class="input-group-addon"><span class="glyphicon glyphicon-earphone"></span></div>
				</c:when>
				<c:when test="${answer.question.tagAttribute.inputType eq 'time' }">
					<div class="input-group-addon"><span class="glyphicon glyphicon-time"></span></div>
				</c:when>
				<c:when test="${answer.question.tagAttribute.inputType eq 'url' }">
					<div class="input-group-addon">http://</div>
				</c:when>
				<c:when test="${answer.question.tagAttribute.inputType eq 'date' }">
					<div class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></div>
				</c:when>
			</c:choose>	
				<input type="${answer.question.tagAttribute.inputType}" class="form-control"
					id="question${answer.question.questionNumber}"
					placeholder="${answer.question.tagAttribute.placeholder }">
			</div>
		</c:when>

		<c:when test="${answer.question.tagAttribute.type eq 'number'}">
			<div>
				<label for="question${answer.question.questionNumber}"
					class="control-label">${answer.question.questionNumber}.
					${answer.question.description }</label>
			</div>
			<div class="${answer.question.tagAttribute.size }">
				<input type="number" class="form-control"
					id="question${answer.question.questionNumber}"
					min="${answer.question.tagAttribute.min}" max="${answer.question.tagAttribute.max}"
					step="${answer.question.tagAttribute.step}"
					placeholder="${answer.question.tagAttribute.placeholder }">
			</div>
		</c:when>

		<c:when test="${answer.question.tagAttribute.type eq 'textarea'}">
			<div>
				<label for="question${answer.question.questionNumber}"
					class="control-label">${answer.question.questionNumber}.
					${answer.question.description }</label>
			</div>
			<div class="${answer.question.tagAttribute.size }">
				<textarea class="form-control" rows="${answer.question.tagAttribute.rows}"></textarea>
			</div>
		</c:when>

		<c:when test="${answer.question.tagAttribute.type eq 'checkbox'}">
			<div>
				<label for="question${answer.question.questionNumber}"
					class="control-label">${answer.question.questionNumber}.
					${answer.question.description }</label>
			</div>
			<c:forEach items="${answer.question.choices}" var="choice">
				<div class="checkbox">
					<label> <input type="checkbox" value=""> ${choice }</label>
				</div>
			</c:forEach>
		</c:when>

		<c:when test="${answer.question.tagAttribute.type eq 'radio'}">
			<div>
				<label for="question${answer.question.questionNumber}"
					class="control-label">${answer.question.questionNumber}.
					${answer.question.description }</label>
			</div>
			<c:forEach items="${answer.question.choices}" var="choice" varStatus="loop">
				<div class="radio">
					<label> <input type="radio"
						name="question${answer.question.questionNumber}"
						id="optionsRadios${answer.choiceLoop.index }" value=""> ${choice }
					</label>
				</div>
			</c:forEach>
		</c:when>

		<c:when test="${answer.question.tagAttribute.type eq 'options'}">
			<div>
				<label for="question${answer.question.questionNumber}"
					class="control-label">${answer.question.questionNumber}.
					${answer.question.description}</label>
			</div>
			<div class="${answer.question.tagAttribute.size }">
				<select class="form-control">
					<option label=" "></option>
					<c:forEach items="${answer.question.choices}" var="choice">
						<option>${answer.choice }</option>
					</c:forEach>
				</select>
			</div>
		</c:when>
		<c:otherwise>
			<p>QUESTION TYPE NOT FOUND</p>
			<p>${answer.question.tagAttribute.type }</p>
		</c:otherwise>
	</c:choose>
</div>
