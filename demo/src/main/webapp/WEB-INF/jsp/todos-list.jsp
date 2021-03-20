<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation-bar.jspf" %>

<div class="container">
	<h1>Hello ${name}</h1>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>isComplete</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${todos }" var = "todo">
				<tr>
					<td> ${todo.desc } </td>
					<td> <fmt:formatDate pattern = "dd/MM/yyyy" value = "${todo.targetDate }" />  </td>
					<td> ${todo.complete} </td>	
					<td> <a href = "/update-todo?id=${todo.id }" class = "btn btn-success">Udpate</a> </td>
					<td> <a href = "/delete-todo?id=${todo.id }" class = "btn btn-warning">Delete </a> </td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
	<a href ="/add-todo" class = "btn btn-success" >Add a TODO</a>
</div>

<%@ include file = "common/footer.jspf"%>