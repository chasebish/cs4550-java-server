package com.example.assignment_1_chase_bishop.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment_1_chase_bishop.models.User;
import com.example.assignment_1_chase_bishop.repositories.UserRepository;


// Service for homework
@RestController
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	/**
	 * Registers a user and saves their session
	 * 
	 * @param user - the User being registered
	 * @param session - the HttpSession to be saved so that the user stays logged in
	 * @return - the new User that has been created
	 */
	@PostMapping("/register")
	public User register(@RequestBody User user, HttpSession session) {
		User currentUser = userRepository.save(user);
		session.setAttribute("currentUser", currentUser);
		return currentUser;
	}

	/**
	 * Finds all current users
	 * @return - the list of all users
	 */
	@GetMapping("/api/user")
	public Iterable<User> findAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * Creates a new user
	 * 
	 * @param user - the new User object
	 * @return - the User that has been created
	 */
	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	/**
	 * Finds a user by their unique ID
	 * 
	 * @param id - the unique ID matching to a user
	 * @return - the User that matches with the ID.  If no match, returns null
	 */
	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") String id) {
		
		int intId = Integer.parseInt(id);
		
		return userRepository.findById(intId).orElse(null);
	}
	
	/**
	 * Updates a user with new fields
	 * 
	 * @param id - the unique ID matching to a user
	 * @param newUser - the new User object to update a current User
	 * @return - the User that has been updated.  If no match, returns null
	 */
	@PutMapping("/api/user/{userId}")
	public User updateUser(@PathVariable("userId") int id, @RequestBody User newUser) {
		User user = userRepository.findById(id).orElse(null);
		user.setUser(newUser);
		return userRepository.save(user);
	}
	
	/**
	 * Deletes a user
	 * 
	 * @param id - the unique ID matching to a user
	 */
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		userRepository.deleteById(id);
	}

}
