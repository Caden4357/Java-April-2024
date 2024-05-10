<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1 class="text-center">Music Zone!</h1>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Number Of Members</th>
					<th>Still Touring?</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="artist" items="${artists}">
					<tr>
						<td><c:out value="${artist.name}" /></td>
						<td><c:out value="${artist.numOfMembers}" /></td>
						<td><c:out value="${artist.stillTouring}" /></td>
						<td><a class="btn btn-success" href="/artist/${artist.id}">View</a>
							<form action="/artist/delete/${artist.id}" method="post">
								<input type="hidden" name="_method" value="delete"> 
								<input class="btn btn-danger" type="submit" value="Delete">
							</form>
							<a class="btn btn-primary" href="/artist/edit/${artist.id}">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h2>Add your favorite artist</h2>

		<form:form action="/newArtist" method="post" modelAttribute="artist">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="numOfMembers">Number Of Members</form:label>
				<form:errors class="text-danger" path="numOfMembers" />
				<form:input type="number" path="numOfMembers" />
			</p>
			<p>
				<form:label path="stillTouring">Still Touring?</form:label>
				<form:errors class="text-danger" path="stillTouring" />
				<form:checkbox path="stillTouring" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>