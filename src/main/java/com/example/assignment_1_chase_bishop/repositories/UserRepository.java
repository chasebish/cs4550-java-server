package com.example.assignment_1_chase_bishop.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.assignment_1_chase_bishop.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	@Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
	public User findUserByCredentials(String username, String password);
	
	@Query("SELECT user FROM User user WHERE user.username=:username")
	public User findUserByUsername(String username);
}
