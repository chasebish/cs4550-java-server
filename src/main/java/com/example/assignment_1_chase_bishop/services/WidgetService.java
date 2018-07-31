package com.example.assignment_1_chase_bishop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment_1_chase_bishop.models.Topic;
import com.example.assignment_1_chase_bishop.models.Widget;
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

	@PostMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic/{topicId}/widget")
	public Widget createWidget(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId,
			@PathVariable("lessonId") int lessonId, @PathVariable("topicId") int topicId,
			@RequestBody Widget newWidget) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			Topic topic = data.get();
			newWidget.setTopic(topic);
			return widgetRepository.save(newWidget);
		}
		return null;
	}

	@DeleteMapping("/api/widget/{widgetId}")
	public void deleteWidget(@PathVariable("widgetId") int widgetId) {
		widgetRepository.deleteById(widgetId);
	}

	@GetMapping("/api/widget")
	public List<Widget> findAllWidgets() {
		return (List<Widget>) widgetRepository.findAll();
	}

	@GetMapping("/api/widget/{widgetId}")
	public Widget findWidgetById(@PathVariable("widgetId") String id) {

		int intId = Integer.parseInt(id);

		return widgetRepository.findById(intId).orElse(null);
	}

	@GetMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic/{topicId}/widget")
	public List<Widget> findAllWidgetsForTopic(@PathVariable("courseId") int courseId,
			@PathVariable("moduleId") int moduleId, @PathVariable("lessonId") int lessonId,
			@PathVariable("topicId") int topicId) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			Topic topic = data.get();
			return topic.getWidgets();
		}
		return null;
	}

	@PutMapping("/api/widget/{widgetId}")
	public Widget updateWidget(@PathVariable("widgetId") String widgetId, @RequestBody Widget newWidget) {

		int intId = Integer.parseInt(widgetId);

		Widget widget = widgetRepository.findById(intId).orElse(null);
		widget.setWidget(newWidget);
		return widgetRepository.save(widget);

	}

	@PostMapping("/api/topic/{topicId}/widget")
	public void saveAllWidgets(@PathVariable("topicId") String topicId, @RequestBody List<Widget> widgets) {

		int intId = Integer.parseInt(topicId);
		Optional<Topic> data = topicRepository.findById(intId);

		if (data.isPresent()) {
			Topic topic = data.get();

			List<Widget> toDelete = topic.getWidgets();
			for (Widget widget : toDelete) {
				widgetRepository.delete(widget);
			}
			for (Widget widget : widgets) {
				widget.setTopic(topic);
				widgetRepository.save(widget);
			}
		}
	}

}
