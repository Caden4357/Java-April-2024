<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- <link rel="stylesheet" href="/css/style.css"/> -->

<style>
	.container-height {
	height: 100vh;
	background: "red";
}
</style>
</head>
<body>
	<div class="container container-height">
		<h1 class="text-center">Ninja Gold!</h1>
		<form action="/reset" method="POST">
			<button class="btn btn-primary">Reset</button>
		</form>
		<h2>
			Your Gold:
			<c:out value="${gold}" />
		</h2>

		<div class="d-flex justify-content-between">
			<div class="border border-2 border-primary text-center p-5">
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<form action="/getGold" method="POST">
					<input type="hidden" name="location" value="farm" />
					<button>Find Gold!</button>
				</form>
			</div>
			<div class="border border-2 border-primary text-center p-5">
				<h2>Cave</h2>
				<p>(earns 5-10 gold)</p>
				<form action="/getGold" method="POST">
					<input type="hidden" name="location" value="cave" />
					<button>Find Gold!</button>
				</form>
			</div>
			<div class="border border-2 border-primary text-center p-5">
				<h2>House</h2>
				<p>(earns 2-5 gold)</p>
				<form action="/getGold" method="POST">
					<input type="hidden" name="location" value="house" />
					<button>Find Gold!</button>
				</form>
			</div>
			<div class="border border-2 border-primary text-center p-5">
				<h2>Quest</h2>
				<p>(earns/takes 0-50 gold)</p>
				<form action="/getGold" method="POST">
					<input type="hidden" name="location" value="quest" />
					<button>Find Gold!</button>
				</form>
			</div>
		</div>
		<div class="d-flex flex-column-reverse border border-2 border-dark mt-4 overflow-scroll h-25">
			<c:forEach var="activity" items="${activities}">
				<p class="${activity.styleClass}">
					<c:out value="${activity.note}"></c:out>
				</p>
			</c:forEach>
		</div>
	</div>
</body>
</html>