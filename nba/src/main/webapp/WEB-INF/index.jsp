<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!-- For JSTL Forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1 class="text-center">NBA Roster</h1>
		<a href="/addPlayer">Add A Player</a>
		<a href="/addCoach">Add A Coach</a>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="team" items="${teams}">
					<tr>
						<td><c:out value="${team.name}" /></td>
						<td>
							<a class="btn btn-success" href="/team/${team.id}">View</a>
							<form action="/team/delete/${team.id}" method="post">
								<input type="hidden" name="_method" value="delete"> 
								<input class="btn btn-danger" type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h1>Add A Team!</h1>
		<form:form action="/newTeam" method="post" modelAttribute="team">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input path="name" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>