package com.example.assignment_1_chase_bishop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment_1_chase_bishop.models.User;
import com.example.assignment_1_chase_bishop.repositories.UserRepository;

@RestController
public class UserService {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/api/user")
	public Iterable<User> findAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PutMapping("/api/user")
	public User updateUser(@PathVariable("userId") int id, @RequestBody User newUser) {
		User user = userRepository.findById(id).orElse(null);
		user.set(newUser);
		return userRepository.save(user);
	}

//	@GetMapping("api/user")
//	public Iterable<User> findAllUsers(@RequestParam(name = "username", required = false) String username) {
//		if (username != null) {
//			return userRepository.findUserByUsername(username);
//		}
//		return userRepository.findAll();
//	}

}
