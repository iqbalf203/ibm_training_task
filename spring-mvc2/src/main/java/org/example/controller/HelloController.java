package org.example.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.example.model.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	private final DataSource dataSource;

	@Autowired
	public HelloController(DataSource dataSource) {

		this.dataSource = dataSource;
	}

	@GetMapping
	public String goHome() {
		return "home";
	}

	@GetMapping("/showForm")
	public String showForm() {
		return "add_league";
	}
	@GetMapping("/listLeague")
	public String listLeague(Model theModel) {
		List<League> list =new ArrayList<>();
		try {
		Connection connection=dataSource.getConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from league");
		while(resultSet.next())
		{
			list.add(new League(resultSet.getInt(1), resultSet.getString(3), resultSet.getString(2)));
		}
		
	}catch(Exception e) {e.printStackTrace();}
		theModel.addAttribute("LEAGUE",list);
		return "list_league";}
	

	@PostMapping("/addLeague")
	public String addEmployee(@RequestParam(name = "season") String season, @RequestParam(name = "year") String tempYear,@RequestParam(name = "title") String title,
			Model theModel) 
	{	int year = 0;
	List<String> errors = new ArrayList<String>();
	if (season.equals("UNKNOWN")) {
		errors.add("please select a season.");
	}
	if(title.length()<=0)
	{
		errors.add("title field can not be blank.");
	}
	
	try {
		year=Integer.parseInt(tempYear);
		if(year<2023)
		{
			errors.add("year must be present year(2023)");
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		
		errors.add("year field must be numeric.");
	}
	
if(!errors.isEmpty()) {
	theModel.addAttribute("ERROR", errors);
	return "add_league";
	}
	theModel.addAttribute("LEAGUE",new League(year, season, title));
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement pst=connection.prepareStatement("insert into league(title,season,year) values(?,?,?)");
			pst.setString(1, title);
			pst.setString(2, season);
			pst.setInt(3, year);
			pst.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "Success";
	}
}