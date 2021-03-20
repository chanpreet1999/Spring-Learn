<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation-bar.jspf" %>
	
	<div class="container">
		Add a TODO here <br />
		
		<form:form method="POST" modelAttribute="todoBean">
			
			<form:input type = "hidden" path = "id" />
			
			<fieldset class = "form-group">
				<form:label class="form-label" path = "desc">Description</form:label> 
				<form:input type="text" placeholder="Add a Description" class = "form-control" path = "desc" required="required" />
				<form:errors path = "desc" cssClass = "text-warning"/>
			</fieldset>
			
			<fieldset class = "form-group">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type = "text" path = "targetDate" placeholder="Enter Target Date" class="form-control" />
				<form:errors path = "targetDate" cssClass = "text-warning"/>
			</fieldset>
			
			<button type="submit" class="btn btn-success" >Add to list</button>
		</form:form>
	</div>
	
<%@ include file = "common/footer.jspf"%>