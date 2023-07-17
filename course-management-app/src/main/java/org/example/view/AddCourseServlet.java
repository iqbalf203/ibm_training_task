package org.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCourseServlet
 */
public class AddCourseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<String> list = (List<String>) request.getAttribute("ERROR");
		if (list!=null) {
			out.println("Some error incurred!</br>");
			for(String s:list) {
				out.println("<font color='red'><li>"+s+"</li></font>");
			}
		}
		String str = getServletConfig().getInitParameter("courses");
		String[] courses = str.split(",");
		out.println("<html><head><title>Add Course</title></head><body>");
		out.println("<center><p><h2>Add a Course</h2></p><hr/>");
		out.println("<form action='controller.do' method='post'>");
		
		out.println("<tr><td>Course</td><td><select name='course'><option value='Unknown'>Select...</option>");
		
		for(String s:courses)
		{
			out.println("<option value='"+s+"'>"+s+"</option>");
		}
		out.println("</select></td></tr>");
		out.println("<tr><td>Course Price</td><td><input type='text' name='price'></td></tr>");
		out.println("<tr><td><input type='submit' value='Add New Course'></form></body></html>");
	
	}
}
