package com.example.rest;

import java.util.List;		

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.model.UserEntity;
import com.example.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	
	private Environment environment;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("service is runing on port: "+environment.getProperty("local.server.port"));
	}

	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
	}

	@GetMapping
	public ResponseEntity<List<UserEntity>> getUsers() {
		return ResponseEntity.ok(userService.listUsers());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> findUserById(@PathVariable("userId") String userId) throws UserNotFoundException {
		User user = userService.getUserById(userId);

		if (user == null) {
			throw new UserNotFoundException("user with " + userId + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
	}
		
	}

