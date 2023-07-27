package com.example.service;

import java.util.List;	
import java.util.Optional;

import com.example.model.User;
import com.example.model.UserEntity;

public interface UserService {
	
	UserEntity createUser(UserEntity user);

	List<UserEntity> listUsers();

	User getUserById(String userId);
	
}
