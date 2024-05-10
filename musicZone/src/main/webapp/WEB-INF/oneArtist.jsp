<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<a href="/">Home</a>
		<h1>Artist: <c:out value="${artist.name}"/></h1>
		<h2>Number Of Members: <c:out value="${artist.numOfMembers}"/></h2>
		<h2>Still Touring?: <c:out value="${artist.stillTouring}"/></h2>
	</div>
</body>
</html>