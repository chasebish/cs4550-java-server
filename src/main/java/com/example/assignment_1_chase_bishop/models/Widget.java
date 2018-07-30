package com.example.assignment_1_chase_bishop.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Widget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int order;
	private String text;
	private String className;
	private String style;
	private String width;
	private String height;
	/*
	 * For Heading widget
	 */
	private int size;
	/*
	 * For Link widget
	 */
	private String href;
	/*
	 * For Image widget
	 */
	private String src;
	/*
	 * For List widget
	 */
	private String listItems;
	private Boolean ordered;
	@ManyToOne
	@JsonIgnore
	private Topic topic;
	
	public void setWidget(Widget newWidget) {
		this.name = newWidget.name != null ? newWidget.name : this.name;
		this.order = newWidget.order != 0 ? newWidget.order : this.order;
		this.text = newWidget.text != null ? newWidget.text : this.text;
		this.className = newWidget.className != null ? newWidget.className : this.className;
		this.style = newWidget.style != null ? newWidget.style : this.style;
		this.width = newWidget.width != null ? newWidget.width : this.width;
		this.height = newWidget.height != null ? newWidget.height : this.height;
		this.size = newWidget.size != 0 ? newWidget.size : this.size;
		this.href = newWidget.href != null ? newWidget.href : this.href;
		this.src = newWidget.src != null ? newWidget.src : this.src;
		this.listItems = newWidget.listItems != null ? newWidget.listItems : this.listItems;
		this.ordered = newWidget.ordered != null ? newWidget.ordered : this.ordered;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getListItems() {
		return listItems;
	}

	public void setListItems(String listItems) {
		this.listItems = listItems;
	}

	public Boolean getOrdered() {
		return ordered;
	}

	public void setOrdered(Boolean ordered) {
		this.ordered = ordered;
	}
	
	

}
