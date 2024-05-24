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
		<a href="/logout">logout</a> <a href="/homepage">Home</a>
		<h1>
			Edit
			<c:out value="${artist.name}" />
		</h1>
		<form:form action="/update/artist/${artist.id}" method="post"
			modelAttribute="artist" class="mx-auto w-50">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input class="w-100" path="name" />
			</p>
			<p>
				<form:label path="numOfAlbums">Number Of Albums</form:label>
				<form:errors class="text-danger" path="numOfAlbums" />
				<form:input type="number" class="w-100" path="numOfAlbums" />
			</p>
			<p>
				<form:label path="genre">Genre</form:label>
				<form:errors class="text-danger" path="genre" />
				<form:select path="genre">
					<form:option value="Pop">Pop</form:option>
					<form:option value="Rock">Rock</form:option>
					<form:option value="Country">Country</form:option>
					<form:option value="Hip-Hop/Rap">Hip-Hop/Rap</form:option>
					<form:option value="Classical">Classical</form:option>
					<form:option value="R&B">R&B</form:option>
					<form:option value="Jazz">Jazz</form:option>
					<form:option value="Metal">Metal</form:option>
				</form:select>
			</p>
			<p>
				<form:label path="stillTouring">Still Touring?</form:label>
				<form:errors class="text-danger" path="stillTouring" />
				<form:checkbox path="stillTouring" />
			</p>
			<input type="hidden" value="put" name="_method" />
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>