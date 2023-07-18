<%@page import="org.example.factory.MyHibernateSessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.example.entity.LeagueEntity"%>
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
	LeagueEntity entity = new LeagueEntity(league.getYear(),league.getSeason(),league.getTitle());
	try {
	Session s = MyHibernateSessionFactory.getHibernateSession();
	s.getTransaction().begin();
	s.save(entity);
	s.getTransaction().commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	out.println("<h2>League Added Sucessfully</h2><hr><br/>" + "League year: " + league.getYear()
	+ "<br/>League season: " + league.getSeason() + "<br/>" + "League title: " + league.getTitle()
	+ "<br/><br/>");
%>
<a href='index.jsp'>Home</a>
</body>
</html>