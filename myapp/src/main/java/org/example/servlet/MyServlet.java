package org.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.entity.LeagueEntity;
import org.example.factory.MyHibernateSessionFactory;
import org.example.model.League;
import org.hibernate.Session;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<LeagueEntity> leagueList=null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// Create the set of leagues
		try {
			Session session=MyHibernateSessionFactory.getHibernateSession();
			TypedQuery<LeagueEntity> query=session.createQuery(" FROM LeagueEntity L",LeagueEntity.class);
			leagueList=query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		out.println("<html>");
		out.println("<head>");
		String pageTitle = "Duke’s Soccer League: List Leagues";
		out.println("<title>" + pageTitle + "</title>");
		out.println("</head>");
		out.println("<body bgcolor='white'>");

		// Generate page heading
		out.println("<!-- Page Heading -->");
		out.println("<table border='1' cellpadding='5' cellspacing='0' width='400'>");
		out.println("<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>");

		out.println(" <td><h3>" + pageTitle + "</h3></td>");
		out.println("</tr>");
		out.println("</table>");

		// Generate main body
		out.println("<p>");
		out.println("The set of soccer leagues are:");
		out.println("</p>");

		out.println("<ul>");
		Iterator<LeagueEntity> items = leagueList.iterator();
		while (items.hasNext()) {
			LeagueEntity league = items.next();
			out.println(" <li>" + league.getTitle() + "</li>");
		}
		out.println("</ul><br/><br/>");
		out.println("<a href='index.html'>Home</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
