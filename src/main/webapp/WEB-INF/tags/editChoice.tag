<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ attribute name="question" required="true" type="formbuilder.model.questionform.Question"%>
<%@ tag body-content="scriptless"%>

<form:form  modelAttribute="question" class = "form" >
	<div class="form-group">
		<div><label>Description</label></div>			
		<form:input path="description" cssClass="form-control" required="required"/>
	</div>
	<hr>
	<div><label>Choices</label><a class="btn btn-link" href="#choiceEditSection" data-toggle="collapse">Hide</a></div>
		<div class="collapse in" id="choiceEditSection">
			<c:forEach items="${question.choices}" var="choice" varStatus="choiceStatus">
				<div class="form-group">
					<div class="input-group">
		  				<div class="input-group-btn">
							<a href="addChoice.html?qId=${question.id}&choiceIndex=${choiceStatus.index}" class="btn btn-success" data-toggle="tooltip" title="Add new choice"><span class="glyphicon glyphicon-plus-sign"></span></a>
						</div>
							<form:input path="choices[${choiceStatus.index}]" cssClass="form-control" required="required"/>  
		  				<c:if test="${fn:length(question.choices) > 1 }">
			  				<div class="input-group-btn">
			  					<a href="deleteChoice.html?qId=${question.id}&choiceIndex=${choiceStatus.index}" class="btn btn-danger" data-toggle="tooltip" title="Remove this choice"><span class="glyphicon glyphicon-minus-sign"></span></a>
							</div>
						</c:if>
					</div>			
				</div>
			</c:forEach>
		</div>
	<hr>
	<button type="submit" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-floppy-disk"></span> SAVE</button>						
</form:form>

