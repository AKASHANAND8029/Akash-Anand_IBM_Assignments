<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>ToDo List</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Task"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Task Name</th>
					<th>Is Complete</th>
					
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempToDo" items="${todos}">
				
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/showFormForUpdate">
						<c:param name="todoId" value="${tempToDo.id}" />
					</c:url>
										

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/delete">
						<c:param name="todoId" value="${tempToDo.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempToDo.taskName} </td>
						<td> ${tempToDo.isComplete} </td>
						
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this task?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>