package com.example.assignment_1_chase_bishop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment_1_chase_bishop.models.Course;
import com.example.assignment_1_chase_bishop.repositories.CourseRepository;

@RestController
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/api/course")
	public Course createCourse(@RequestBody Course course) {
		return null;
	}
	
	@DeleteMapping("/api/course/{courseId}")
	public void deleteCourse(@PathVariable("courseId") int id) {
		courseRepository.deleteById(id);
	}
	
	@GetMapping("/api/course")
	public Iterable<Course> findAllCourses() {
		return (List<Course>) courseRepository.findAll();
	}
	
	@GetMapping("/api/course/{courseId}")
	public Course findCourseById(@PathVariable("courseId") String id) {

		int intId = Integer.parseInt(id);

		return courseRepository.findById(intId).orElse(null);
	}
	
	@PutMapping("/api/course/{courseId}")
	public Course updateCourse(@PathVariable("courseId") String id, @RequestBody Course newCourse) {
		
		int intId = Integer.parseInt(id);
		
		Course course = courseRepository.findById(intId).orElse(null);
		course.setCourse(newCourse);
		return courseRepository.save(course);
		
	}

}
