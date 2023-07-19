
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.example.model.League"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<title>Duke's Soccer League: List Leagues</title>
</head>
<body bgcolor='white'>

<!-- Page Heading -->
<table>
<tr>

 <td><font color="blue"><h3>Duke's Soccer League: List Leagues</h3></font></td>
</tr>
</table>

<p>
The set of soccer leagues are:
</p>

<ul>
<%
List<League> list = (List<League>)request.getAttribute("LEAGUE");
Iterator<League> items = list.iterator();
while (items.hasNext()) {
	League league = items.next();
	out.println(" <li>" + league.getTitle() + "</li>");
}%>
</ul><br/><br/>
<a href='http://localhost:8081/spring-mvc2/'>Home</a>

</body>
</html>