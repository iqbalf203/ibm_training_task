<%@page import="org.example.model.League"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	League league = (League) request.getAttribute("LEAGUE");
	out.println("<h2>League Added Sucessfully</h2><hr><br/>" + "League year: " + league.getYear()
	+ "<br/>League season: " + league.getSeason() + "<br/>" + "League title: " + league.getTitle()
	+ "<br/><br/>");
%>
<a href='http://localhost:8081/spring-mvc2/'>Home</a>
</body>
</html>