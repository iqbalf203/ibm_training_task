package org.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.entity.Course;
import org.example.factory.MyHibernateSessionFactory;

import org.hibernate.Session;

/**
 * Servlet implementation class MyServlet
 */
public class ListCoursesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Course> courseList=null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// Create the set of leagues
		try {
			Session session=MyHibernateSessionFactory.getHibernateSession();
			TypedQuery<Course> query=session.createQuery(" FROM Course C",Course.class);
			courseList=query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		out.println("<html>");
		out.println("<head>");
		String pageTitle = "Courses Available";
		out.println("<title>" + pageTitle + "</title>");
		out.println("</head>");
		out.println("<body bgcolor='white'>");

		out.println("<h2>"+pageTitle+"</h2>");

		out.println("<ul>");
		Iterator<Course> items = courseList.iterator();
		while (items.hasNext()) {
			Course course = items.next();
			out.println(" <li>Course Name: " + course.getCourse() + "</br>    Course Price: "+course.getPrice()+"</li>");
		}
		out.println("</ul><br/><br/>");
		out.println("<a href='index.html'>Home</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
