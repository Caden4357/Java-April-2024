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
		<a href="/logout">logout</a> 
		<a href="/artist/form">Add An Artist</a>
		<h1>
			Welcome
			<c:out value="${user.username}" />
		</h1>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Number Of Albums</th>
					<th>Genre</th>
					<th>Still Touring</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="artist" items="${artists}">
					<tr>
						<td><a href="/view/artist/${artist.id}"><c:out value="${artist.name }" /></a></td>
						<td><c:out value="${artist.numOfAlbums }" /></td>
						<td><c:out value="${artist.genre }" /></td>
						<td><c:if test="${artist.stillTouring}">
								<p>
									<c:out value="Yes Buy Tickets" />
								</p>
							</c:if> <c:if test="${!artist.stillTouring}">
								<p>
									<c:out value="Not currently touring" />
								</p>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>