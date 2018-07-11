package com.example.assignment_1_chase_bishop.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.assignment_1_chase_bishop.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	/**
	 * Finds a user based on their username and password
	 * 
	 * @param username
	 *            the User's username
	 * @param password
	 *            the User's password
	 * @return - the User found in the database
	 */
	@Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
	public User findUserByCredentials(String username, String password);

	/**
	 * Finds a user based on their username
	 * 
	 * @param username
	 *            the User's username
	 * @return - the User found in the database
	 */
	@Query("SELECT user FROM User user WHERE user.username=:username")
	public User findUserByUsername(String username);
}
