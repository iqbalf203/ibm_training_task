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
 * Servlet implementation class SearchCourseServlet
 */
public class SearchCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Course> courseList = null;
		String course = null;
		
		out.println("<html><head><title>Search for a Course</title></head><body>");
		out.println("<center><p><h2>Search for a Course</h2></p><hr/>");
		out.println("<form action='search_course.view' method='post'>");
		out.println("<tr><td>Course Name: </td><td><input type='text' name='cname'></td></tr>");
		out.println("<tr><td><input type='submit' value='Search Course'></table></form></body></html>");
		
		
		course = request.getParameter("cname");
		
		if (course.length()>0) {
			course = course.toLowerCase();
		try {
			Session session=MyHibernateSessionFactory.getHibernateSession();
			TypedQuery<Course> query=session.createQuery(" FROM Course C",Course.class);
			courseList=query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Iterator<Course> items = courseList.iterator();
		int count = 0;
		while (items.hasNext()) {
			Course c = items.next();
			if(course.equals(c.getCourse().toLowerCase())) {
				count +=1;
			}
	}
		if(count>0) {
			out.println("<font color='red'>Course Found!</font>");
		}
		else {out.println("<font color='red'>Course Not Found!</font>");}
		}
}}
