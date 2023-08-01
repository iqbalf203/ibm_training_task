package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;	
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ui.Ratedto;


@RestController
@RequestMapping("conversions")
public class ConversionController {
	
	private final RestTemplate restTemplate;
	
	public ConversionController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@GetMapping("/{id}")
	public Ratedto getConversion(@PathVariable String id, @RequestParam("value") double value) {
		
		Object dpt = restTemplate.getForObject("http://localhost:9999/RATE-SERVICE/rates/"+id,Ratedto.class);
		Ratedto dto = (Ratedto) dpt;
		dto.setValue(dto.getValue()*value);
		return dto;
}
}