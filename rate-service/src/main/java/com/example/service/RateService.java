package com.example.service;

import java.util.List;	
import java.util.Optional;

import com.example.model.Rate;

public interface RateService {
	
	Rate createRate(Rate stream);
	Optional<Rate> findRate(String id);
	List<Rate> getAllRate();

}
