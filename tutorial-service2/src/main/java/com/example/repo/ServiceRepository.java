package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Tutorial;

public interface ServiceRepository extends JpaRepository<Tutorial, Integer>{

}
