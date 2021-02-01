<html>
<head>
	<title>Add Or Update TODO</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	
	<div class="container">
		Add a TODO here <br />
		<form method="POST">
			<fieldset class = "form-group">
				<label class="form-label">Description</label> 
				<input type="text" placeholder="Add a Description" name="desc" class = "form-control" required="required" />
			</fieldset>
			<button type="submit" class="btn btn-success" >Add to list</button>
		</form>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>