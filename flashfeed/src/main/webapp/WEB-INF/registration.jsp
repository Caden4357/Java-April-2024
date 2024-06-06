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
	<div class="container min-vh-100 d-flex align-items-center">

		<div class="d-flex">
			<div class="w-50">
				<div class="w-75 mx-auto">
					<img alt="Flash Feed Main Logo Camera"
						src="/images/mainlogoblue-bg-w.png" class="img-thumbnail border-0">
				</div>
			</div>
			<div class="w-50 ">
				<h2 class="text-center">Register</h2>
				<form:form action="/register" method="post" modelAttribute="newUser"
					class="w-50 mx-auto mt-5">
					<p>
						<form:errors class="text-danger" path="username" />
						<form:input class="w-100 form-control" path="username"
							placeholder="Username..." />
					</p>
					<p>
						<form:errors class="text-danger" path="email" />
						<form:input class="w-100 form-control" path="email"
							placeholder="Email..." />
					</p>
					<p>
						<form:errors class="text-danger" path="password" />
						<form:input class="w-100 form-control" type="password"
							path="password" placeholder="Password..." />
					</p>
					<p>
						<form:errors class="text-danger" path="confirm" />
						<form:input class="w-100 form-control" type="confirm"
							path="confirm" placeholder="Password..." />
					</p>
					<a class="d-block text-center" href="/">Already have an account sign in!</a>
					<br />
					<input class="btn btn-primary d-block mx-auto" type="submit"
						value="Submit" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>