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
		<a href="/logout">logout</a> <a href="/homepage">Home</a>
		<h1>

			Name:
			<c:out value="${artist.name}" />
		</h1>
		<h2>
			Number Of Albums:
			<c:out value="${artist.numOfAlbums}" />
		</h2>
		<h2>
			Genre:
			<c:out value="${artist.genre}" />
		</h2>
		<h2>
			<c:if test="${artist.stillTouring}">
				<c:out value="Yes Buy Tickets" />
			</c:if>
			<c:if test="${!artist.stillTouring}">
				<c:out value="Not currently touring" />
			</c:if>
		</h2>
		<c:if test="${userId == artist.user.id}">
			<a class="btn btn-warning" href="/edit/artist/${artist.id}">Edit</a>
			<form action="/delete/artist/${artist.id}" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					class="btn btn-danger" type="submit" value="Delete">
			</form>
		</c:if>
				<form:form action="/create/comment/${artist.id}" method="post" modelAttribute="comment"
			class="mx-auto w-50">
			<p>
				<form:label path="body">Comment</form:label>
				<form:errors class="text-danger" path="body" />
				<form:input class="w-100" path="body" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
		<div>
			<c:forEach var="comment" items="${artist.comments}">
				<p>
					<span><c:out value="${comment.user.username}" /> Says: </span>
					<c:out value="${comment.body}" />
				</p>
			</c:forEach>
		</div>
	</div>
</body>
</html>