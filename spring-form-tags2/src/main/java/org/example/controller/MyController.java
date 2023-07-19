package org.example.controller;

import org.example.model.League;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping
	public String goHome() {
		return "index";
	}
	@RequestMapping("/showForm") 
	public String showForm(Model theModel) {
		League league = new League();
		theModel.addAttribute(league);
		return "showForm";
	}
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("league") League theLeague) {
		return "success";
	}
}
