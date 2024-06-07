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
		<h1>Dashboard</h1>
		<a href="/logout">Logout</a>
		<h1>Upload images!</h1>
		<form action="/upload" method="post" enctype="multipart/form-data">
			<input name="image" type="file" />
			<input name="title"/>
			<button class="btn btn-primary">Upload</button>
		</form>
		<c:forEach var="post" items="${posts}">
			<img alt="image" src="${post.imagePath}" class="w-25">
			<p>Title: <c:out value="${post.title}"/></p>
			<p>Posted by: <c:out value="${post.user.username}"/></p>
			<form action="/comment/post/${post.id}" method="post">
				<textarea name="body" rows="5" cols="50"></textarea>
				<button>Comment</button>
			</form>
			<c:forEach var="comment" items="${post.comments}">
				<p><c:out value="${comment.user.username}"/> Says: <c:out value="${comment.body}"/></p>
			</c:forEach>
		</c:forEach>
	</div>
</body>
</html>