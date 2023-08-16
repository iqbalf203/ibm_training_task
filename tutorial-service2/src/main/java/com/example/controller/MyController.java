package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Tutorial;
import com.example.repo.ServiceRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tutorials")
public class MyController {
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@GetMapping
	public List<Tutorial> getAll(){
		return serviceRepository.findAll();
	}
	
	@PostMapping
	public Tutorial createTutorial(@RequestBody Tutorial tutorial) {
		return serviceRepository.save(tutorial);
	}
	
	@DeleteMapping
	public String deleteTutorial(@RequestParam int id) {
		serviceRepository.deleteById(id);
		return "Deleted Successfully";
	}
}
