package com.example.assignment_1_chase_bishop.services;

import java.util.List;
import java.util.Optional;

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
	 * @param user
	 *            the User being registered
	 * @param session
	 *            the HttpSession to be updated so that the user stays logged in
	 * @return - the new User that has been created
	 */
	@PostMapping("/api/user/register")
	public User register(@RequestBody User user, HttpSession session) {
		User currentUser = userRepository.save(user);
		session.setAttribute("currentUser", currentUser);
		return currentUser;
	}

	/**
	 * Logs a user in and saves their session
	 * 
	 * @param user
	 *            the User being logged in
	 * @param session
	 *            the HttpSession to be updated so that the user stays logged in
	 * @return - the User that has been logged in
	 */
	@PostMapping("/api/user/login")
	public User login(@RequestBody User user, HttpSession session) {
		user = userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
		session.setAttribute("currentUser", user);
		return user;
	}

	/**
	 * Logs a user out and invalidates their session
	 * 
	 * @param session
	 *            the HttpSession to be invalidated
	 */
	@PostMapping("/api/user/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}

	/**
	 * Checks to see if a user is logged in and gets their attributes Errors are
	 * handled client-side
	 * 
	 * @param session
	 *            the HttpSession with the current user saved
	 * @return - the User that is currently logged in
	 */
	@GetMapping("/api/user/profile")
	public User checkLogin(HttpSession session) {
		User currentUser = (User) session.getAttribute("currentUser");
		return userRepository.findById(currentUser.getId()).orElse(null);
	}

	/**
	 * Updates a User's profile
	 * 
	 * @param newUser
	 *            the User object being passed in client-side
	 * @param session
	 *            the HttpSession with the current user saved
	 * @return - the newly updated User
	 */
	@PutMapping("/api/user/profile")
	public User updateProfile(@RequestBody User newUser, HttpSession session) {
		User sessionUser = (User) session.getAttribute("currentUser");
		int sessionUserId = sessionUser.getId();
		return this.updateUser(sessionUserId, newUser);
	}

	/**
	 * Checks to see if a username is valid
	 * 
	 * @param username
	 *            the username to be checked
	 * @return - true -> username is valid, false -> username is invalid
	 */
	@PostMapping("/api/user/username")
	public Boolean validUsername(@RequestBody String username) {
		return userRepository.findUserByUsername(username) == null;
	}

	/**
	 * Finds all current users
	 * 
	 * @return - the list of all users
	 */
	@GetMapping("/api/user")
	public Iterable<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	/**
	 * Creates a new user
	 * 
	 * @param user
	 *           	the User object being passed in client-side
	 * @return - the new User that has been created
	 */
	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	/**
	 * Finds a user by their unique ID
	 * 
	 * @param id
	 *            the unique ID matching to a user
	 * @return - the User that matches with the ID. If no match, returns null
	 */
	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") String id) {

		int intId = Integer.parseInt(id);

		return userRepository.findById(intId).orElse(null);
	}

	/**
	 * Updates a user with new fields
	 * 
	 * @param id
	 *            the unique ID matching to a user
	 * @param newUser
	 *            the User object being passed in client-side
	 * @return - the User that has been updated
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
	 * @param id
	 *            the unique ID matching to a user
	 */
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		userRepository.deleteById(id);
	}

}
