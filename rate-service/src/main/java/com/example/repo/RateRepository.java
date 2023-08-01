package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Rate;	


public interface RateRepository extends MongoRepository<Rate, String>{

}
