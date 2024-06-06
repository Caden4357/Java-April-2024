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
	<div class="container border border-2 border-primary">
		<a href="/band/form">Add An Artist</a>
		<a href="/logout">Logout</a>
		<h1>Welcome <c:out value="${user.username}"/></h1>
		<table class="table table-dark table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Number Of Albums</th>
			<th>Genre</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="band" items="${bands}">
			<tr>
				<td><a href="/view/band/${band.id}"><c:out value="${band.name}" /></a></td>
				<td><c:out value="${band.numOfAlbums}" /></td>
				<td><c:out value="${band.genre}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	</div>
</body>
</html>