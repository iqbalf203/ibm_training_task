package com.example.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Rate;
import com.example.service.RateService;

@RestController
@RequestMapping("rates")
public class RateController {

private final RateService rateService;

	
	public RateController(RateService rateService) {
	super();
	this.rateService = rateService;
}


	@PostMapping
	public ResponseEntity<Rate> createRate(@RequestBody Rate rate)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(rateService.createRate(rate));
	}
	
	@GetMapping("/{id}")
	public Optional<Rate> findById(@PathVariable("id") String id){
		
		Optional<Rate> rate =  (rateService.findRate(id));
		return rate;
		
	}
}
