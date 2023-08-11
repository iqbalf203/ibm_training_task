package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;	

import com.example.entity.PatientRegistration;


public interface PatientRegistrationRepository extends JpaRepository<PatientRegistration, Integer>{
	PatientRegistration findByUserId(String userId);
	PatientRegistration findByEmail(String email);
}
