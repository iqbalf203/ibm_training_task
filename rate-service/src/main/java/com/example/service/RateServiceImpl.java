package com.example.service;

import java.util.List;	
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.model.Rate;
import com.example.repo.RateRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RateServiceImpl implements RateService {

	private final RateRepository rateRepository;

	@Override
	public Rate createRate(Rate rate) {
		// TODO Auto-generated method stub
		return rateRepository.save(rate);
	}

	@Override
	public Optional<Rate> findRate(String id) {
		// TODO Auto-generated method stub
		return rateRepository.findById(id);
	}

	@Override
	public List<Rate> getAllRate() {
		// TODO Auto-generated method stub
		return null;
	}

}
