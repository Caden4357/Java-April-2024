<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World from index.jsp</h1>
	<c:forEach var="person" items="${users}">
    	<c:out value="${person.name}"/>
	</c:forEach>
	
	
	
<!-- 	<h1>Two plus two is: </h1> -->
<%-- 	<h2><c:out value="${item}"/></h2> --%>
</body>
</html>