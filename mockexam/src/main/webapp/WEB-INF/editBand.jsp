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
	<div class="container border border-2 border-primary">
		<h1>
			Edit
			<c:out value="${band.name}" />
		</h1>
		<form:form action="/update/band/${band.id}" method="post"
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
				<form:label path="genre">Genre</form:label>
				<form:errors class="text-danger" path="genre" />
				<form:select path="genre">
					<form:option value="Pop">Pop</form:option>
					<form:option value="Rock">Rock</form:option>
					<form:option value="Punk">Punk</form:option>
					<form:option value="Country">Country</form:option>
					<form:option value="Hip-Hop/Rap">Hip-Hop/Rap</form:option>
					<form:option value="R&B">R&B</form:option>
				</form:select>
			</p>
			<input type="hidden" name="_method" value="put">
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>