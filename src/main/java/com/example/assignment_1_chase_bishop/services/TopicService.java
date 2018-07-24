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

import com.example.assignment_1_chase_bishop.models.Lesson;
import com.example.assignment_1_chase_bishop.models.Module;
import com.example.assignment_1_chase_bishop.models.Topic;
import com.example.assignment_1_chase_bishop.repositories.CourseRepository;
import com.example.assignment_1_chase_bishop.repositories.LessonRepository;
import com.example.assignment_1_chase_bishop.repositories.ModuleRepository;
import com.example.assignment_1_chase_bishop.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TopicService {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	TopicRepository topicRepository;

	@PostMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic")
	public Topic createTopic(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId,
			@PathVariable("lessonId") int lessonId, @RequestBody Topic newTopic) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if (data.isPresent()) {
			Lesson lesson = data.get();
			newTopic.setLesson(lesson);
			return topicRepository.save(newTopic);
		}
		return null;
	}

	@DeleteMapping("/api/topic/{topicId}")
	public void deleteTopic(@PathVariable("topicId") int topicId) {
		topicRepository.deleteById(topicId);
	}

	@GetMapping("/api/topic")
	public List<Topic> findAllTopics() {
		return (List<Topic>) topicRepository.findAll();
	}

	@GetMapping("/api/topic/{topicId}")
	public Topic findTopicById(@PathVariable("topicId") String id) {

		int intId = Integer.parseInt(id);

		return topicRepository.findById(intId).orElse(null);
	}

	@GetMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic")
	public List<Topic> findAllTopicsForLesson(@PathVariable("courseId") int courseId,
			@PathVariable("moduleId") int moduleId, @PathVariable("lessonId") int lessonId) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if (data.isPresent()) {
			Lesson lesson = data.get();
			return lesson.getTopics();
		}
		return null;
	}

	@PutMapping("/api/topic/{topicId}")
	public Topic updateTopic(@PathVariable("topicId") String topicId, @RequestBody Topic newTopic) {

		int intId = Integer.parseInt(topicId);

		Topic topic = topicRepository.findById(intId).orElse(null);
		topic.setTopic(newTopic);
		return topicRepository.save(topic);

	}

}
