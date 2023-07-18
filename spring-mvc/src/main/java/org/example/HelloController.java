package org.example;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping
	public String goHome() {
		return "home";
	}

	@GetMapping("/showForm")
	public String showForm() {
		return "showForm";
	}

	@PostMapping("/addEmployee")
	public String addEmployee(HttpServletRequest request, Model theModel) {
		List<String> errors= new ArrayList<>();
		double age = 0;
		String name = request.getParameter("t1");
		if(name.length()<=0) {errors.add("Name not Filled.");}
		try { age= Double.parseDouble(request.getParameter("t2"));}
		catch(Exception e) {e.printStackTrace();errors.add("Number not numeric");}
		if(age<18) {errors.add("age is under 18");}
		theModel.addAttribute("emp", new Employee(name, age));
if(!errors.isEmpty()) {
	request.setAttribute("ERROR", errors);
	return "showForm";
	}
else {
		return "success";
	}}
}