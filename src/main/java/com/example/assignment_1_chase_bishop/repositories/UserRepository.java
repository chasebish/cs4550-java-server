package com.example.assignment_1_chase_bishop.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.assignment_1_chase_bishop.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {}
