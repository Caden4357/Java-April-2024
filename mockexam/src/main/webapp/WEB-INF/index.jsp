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
<body class="bg-dark text-white">
	<div class="container">
		<h1 class="text-center mb-5">Welcome To MusicZone!</h1>
		<form:form action="/login" method="post" modelAttribute="newLogin"
			class="w-100">
			<h1 class="text-center">Login</h1>
			<p>
				<form:errors class="text-danger" path="email" />
				<form:input class="form-control w-100" path="email" placeholder="Email..."/>
			</p>
			<p>
				<form:errors class="text-danger" path="password" />
				<form:input class="form-control w-100" type="password" path="password" placeholder="Password..."/>
			</p>
			<input class="w-100 btn btn-secondary" type="submit" value="Submit" />
		</form:form>
		<form:form action="/register" method="post" modelAttribute="newUser"
			class="mt-5">
			<h1 class="text-center">Register</h1>
			<p>
				<form:errors class="text-danger" path="username" />
				<form:input class="form-control w-100" path="username" placeholder="Username..."/>
			</p>
			<p>
				<form:errors class="text-danger" path="email" />
				<form:input class="form-control w-100" path="email" placeholder="Email..."/>
			</p>
			<p>
				<form:errors class="text-danger" path="password" />
				<form:input class="form-control w-100" type="password" path="password" placeholder="Password..."/>
			</p>
			<p>
				<form:errors class="text-danger" path="confirm" />
				<form:input class="form-control w-100" type="password" path="confirm" placeholder="Confirm Password..."/>
			</p>
			<input class="w-100 btn btn-secondary" type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>