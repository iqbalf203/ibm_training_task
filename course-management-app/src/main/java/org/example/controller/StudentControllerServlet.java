package org.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.entity.Course;
import org.example.entity.Student;
import org.example.factory.MyHibernateSessionFactory;
import org.hibernate.Session;

/**
 * Servlet implementation class ControllerServlet
 */
public class StudentControllerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String studentName=null;
		int courseId=0;
		String course = null;
		List<Course> courseList=null;
		List<String> errors = new ArrayList<String>();

		course = request.getParameter("course");
		if (course.equals("Unknown")) {
			errors.add("please select a course.");
		}
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
			if(course.equals(c.getCourse())) {
				courseId = c.getCourseId();
				count +=1;}
		
			}
			
		if (count ==0) {errors.add("Course Not Available");}
		
		studentName = request.getParameter("sname");
		if (studentName.length()<=0) {
			errors.add("Please enter your Name");
		}
		
		
		if(!errors.isEmpty())
		{
			request.setAttribute("ERROR", errors);
			RequestDispatcher view=request.getRequestDispatcher("add_student.view");
			view.forward(request, response);
		}
		
		else
		{
			request.setAttribute("STUDENT", new Student(studentName, course,courseId));
			RequestDispatcher view=request.getRequestDispatcher("success_student.view");
			view.forward(request, response);
		}

	}
}
