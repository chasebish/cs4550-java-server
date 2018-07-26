package com.example.assignment_1_chase_bishop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment_1_chase_bishop.repositories.CourseRepository;
import com.example.assignment_1_chase_bishop.repositories.LessonRepository;
import com.example.assignment_1_chase_bishop.repositories.ModuleRepository;
import com.example.assignment_1_chase_bishop.repositories.TopicRepository;
import com.example.assignment_1_chase_bishop.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class WidgetService {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	TopicRepository topicRepository;
	@Autowired
	WidgetRepository widgetRepository;
	
}
