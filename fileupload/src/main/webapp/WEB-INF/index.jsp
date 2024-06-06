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
		<h1>Upload images!</h1>
		<form action="/upload" method="post" enctype="multipart/form-data">
			<input name="image" type="file"/>
			<button class="btn btn-primary">Upload</button>
		</form>
		<c:forEach var="image" items="${images}">
			<img alt="image" src="/uploads/${image}" class="w-25">
		</c:forEach>
	</div>
</body>
</html>