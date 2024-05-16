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
		<h1>Edit</h1>
		<a href="/">Home</a>
		<form:form action="/updateArtist" method="post" modelAttribute="artist">
			<input type="hidden" name="_method" value="put"> 
			<input type="hidden" name="id" value="${artist.id}"> 
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