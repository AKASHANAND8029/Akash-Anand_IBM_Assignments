<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="add-task-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>ToDo LIST</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save ToDo</h3>
	
		<form:form action="saveToDo" modelAttribute="todo" method="POST">

			<!-- need to associate this data with task id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Task name:</label></td>
						<td><form:input path="taskName" /></td>
					</tr>
				
					<tr>
						<td><label>Is Complete:</label></td>
						<td><form:input path="isComplete" /></td>
					</tr>

					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
					

				
				</tbody>
			</table>
			
			
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="/">Back to Task List</a>
		</p>
	
	</div>

</body>

</html>