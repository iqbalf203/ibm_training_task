<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="processForm" modelAttribute="league">
	
		Year: <form:input path="year" />
		
		<br><br>
	
		Season: <form:input path="season" />
		
		<br><br>
		
		Title: <form:input path="title" />
	
		<input type="submit" value="Submit" />
	
	</form:form>

</body>
</html>