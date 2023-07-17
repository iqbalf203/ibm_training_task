package org.example.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.entity.Course;
import org.example.factory.MyHibernateSessionFactory;
import org.hibernate.Session;

/**
 * Servlet implementation class SuccessServlet
 */
public class SuccessServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		responseRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		responseRequest(request, response);
	}
	protected void responseRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Course course = (Course) request.getAttribute("COURSE");
		try {
			
		
		Session session=MyHibernateSessionFactory.getHibernateSession();
		session.getTransaction().begin();
		session.save(course);
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("<h2>League Added Sucessfully</h2><hr><br/>" + "<br/>Course Name: " + course.getCourse() + "<br/>" + "Course Price: " + course.getPrice()
				+ "<br/><br/>");

		out.println("<a href='index.html'>Home</a>");

	}

		
	}
