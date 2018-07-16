package com.example.assignment_1_chase_bishop.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.assignment_1_chase_bishop.models.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{

}
