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
		<a href="/welcome">Dashboard</a> <a href="/logout">Logout</a>
		<form:form action="/create/band" method="post"
			modelAttribute="band">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="numOfAlbums">Number Of Albums</form:label>
				<form:errors class="text-danger" path="numOfAlbums" />
				<form:input path="numOfAlbums" />
			</p>
			<p>

				<form:select path="genre">
					<option value="Pop">Pop</option>
					<option value="Rock">Rock</option>
					<option value="Punk">Punk</option>
					<option value="Country">Country</option>
					<option value="Hip-Hop/Rap">Hip-Hop/Rap</option>
					<option value="R&B">R&B</option>
				</form:select>
			</p>
			<p>
				<form:input type="hidden" path="user" value="${userId}" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>