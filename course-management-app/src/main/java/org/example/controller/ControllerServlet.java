package org.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.entity.Course;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String course = null;
		double price = 0;
		List<String> errors = new ArrayList<String>();

		course = request.getParameter("course");
		if (course.equals("Unknown")) {
			errors.add("please select a course.");
		}
		try {
			price=Double.parseDouble(request.getParameter("price"));
			if(price<=0)
			{
				errors.add("Price must be above 0.");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			errors.add("year field must be numeric.");
		}
		
		if(!errors.isEmpty())
		{
			request.setAttribute("ERROR", errors);
			RequestDispatcher view=request.getRequestDispatcher("add_course.view");
			view.forward(request, response);
		}
		
		else
		{
			request.setAttribute("COURSE", new Course(course, price));
			RequestDispatcher view=request.getRequestDispatcher("success.view");
			view.forward(request, response);
		}

	}
}
