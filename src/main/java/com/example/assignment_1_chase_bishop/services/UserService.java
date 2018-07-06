package com.example.assignment_1_chase_bishop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment_1_chase_bishop.models.User;
import com.example.assignment_1_chase_bishop.repositories.UserRepository;

@RestController
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	@GetMapping("api/hello")
	public Iterable<User> findAllUsers() {
		return repository.findAll();
	}
	
	@PostMapping("api/hello")
	public User createUser(@RequestBody User user) {
		return repository.save(user);
	}
}
