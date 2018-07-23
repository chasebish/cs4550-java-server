package com.example.assignment_1_chase_bishop.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@ManyToOne
	@JsonIgnore
	private Module module;
	@OneToMany(mappedBy = "lesson")
	private List<Topic> topics;

	public void setLesson(Lesson newLesson) {
		this.title = newLesson.title != null ? newLesson.title : this.title;
		this.module = newLesson.module != null ? newLesson.module : this.module;
	}
	

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
