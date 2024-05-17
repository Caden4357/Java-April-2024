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
		<h1>Add A Coach</h1>
		<form:form action="/createCoach" method="post" modelAttribute="coach"
			class="mx-auto w-50">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input class="w-100" path="name" />
			</p>
			<p>
				<form:label path="role">Role</form:label>
				<form:errors class="text-danger" path="role" />
				<form:input class="w-100" path="role" />
			</p>
			<p>
				<form:select path="team">

					<c:forEach var="team" items="${teams}">

						<option value="${team.id}"><c:out value="${team.name}" /></option>

					</c:forEach>

				</form:select>
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>