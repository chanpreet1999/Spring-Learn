<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>List Todos</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<h1>Hello ${name}</h1>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>isComplete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${todos }" var = "todo">
				<tr>
					<td> ${todo.desc } </td>
					<td> ${todo.targetDate } </td>
					<td> ${todo.complete} </td>	
					<td> <a href = "/delete-todo?id=${todo.id }" class = "btn btn-warning">Delete </a> </td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
	<a href ="/add-todo" class = "btn btn-success" >Add a TODO</a>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</div>
</body>
</html>