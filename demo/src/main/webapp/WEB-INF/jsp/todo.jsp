<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>Add Or Update TODO</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	
	<div class="container">
		Add a TODO here <br />
		<form:form method="POST" modelAttribute="todoBean">
			<fieldset class = "form-group">
				<form:label class="form-label" path = "desc">Description</form:label> 
				<form:input type="text" placeholder="Add a Description" class = "form-control" path = "desc" required="required" />
			</fieldset>
			<button type="submit" class="btn btn-success" >Add to list</button>
		</form:form>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>