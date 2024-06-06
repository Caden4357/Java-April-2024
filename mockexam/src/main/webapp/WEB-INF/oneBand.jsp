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
	<div class="container border border-2 border-primary text-center">
		<a href="/welcome">Dashboard</a> <a href="/logout">Logout</a>
		<h1>
			Name:
			<c:out value="${band.name}" />
		</h1>
		<h2>
			Genre:
			<c:out value="${band.genre}" />
		</h2>
		<h2>
			Number Of Albums:
			<c:out value="${band.numOfAlbums}" />
		</h2>
		<h2>
			Posted By:
			<c:out value="${band.user.username}" />
		</h2>
		<c:if test="${userId==band.user.id}">
			<div>
				<a class="btn btn-primary" href="/edit/band/${band.id}">Edit</a>
				<form action="/delete/band/${band.id}" method="post">
					<input type="hidden" name="_method" value="delete"> <input
						type="submit" value="Delete">
				</form>
			</div>
		</c:if>
		<form action="/add/musician/to/band/${band.id}" method="post">
			<select name="musicianId">
				<c:forEach var="musician" items="${musicians}">
					<option value="${musician.id}"><c:out
							value="${musician.name}" /></option>
				</c:forEach>
			</select> <input type="submit" value="Add" />
		</form>
		<h2>Members</h2>
		<c:forEach var="musician" items="${band.musicians}">
			<p>
				<c:out value="${musician.name}"></c:out>
				|
				<c:out value="${musician.role}"></c:out>
			</p>
		</c:forEach>


		<form:form action="/create/comment/${band.id}" method="post"
			modelAttribute="comment">
			<p>
				<form:label path="body">Comment:</form:label>
				<form:errors class="text-danger" path="body" />
				<form:input path="body" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
		<div>
			<c:forEach var="comment" items="${band.comments}">
				<p>
					<span><c:out value="${comment.user.username}" /> says: </span>
					<c:out value="${comment.body}" />
				</p>
			</c:forEach>
		</div>
	</div>
</body>
</html>