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
		<h1>Pokemon API Practice</h1>
		
<%-- 		<c:forEach var="poke" items="${pokeList}">
			<h1>Name: <c:out value="${poke.name}"/></h1>
		</c:forEach> --%>
		
		<form action="/poke/search">
			<input name="search" placeholder="search"/>
			<button>Search</button>
		</form>
		
		<c:out value="${pokemon.name}"/>
		<img alt="Pokemon" src="${pokemon.sprites.frontShiny }">
	</div>
</body>
</html>