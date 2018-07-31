package com.example.assignment_1_chase_bishop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Widget {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int widgetOrder;
	private String text;
	private String className;
	private String style;
	private String width;
	private String height;
	private String src;
	private String href;
	private String listItems;
	private ListType listType;
	private int size;
	private boolean editorOpen;

	@ManyToOne
	@JsonIgnore
	private Topic topic;
	
	public void setWidget(Widget newWidget) {
		this.size = newWidget.size != 0 ? newWidget.size : this.size;
		this.widgetOrder = newWidget.widgetOrder != 0 ? newWidget.widgetOrder : this.widgetOrder;
		this.name = newWidget.name != null ? newWidget.name : this.name;
		this.text = newWidget.text != null ? newWidget.text : this.text;
		this.className = newWidget.className != null ? newWidget.className : this.className;
		this.style = newWidget.style != null ? newWidget.style : this.style;
		this.width = newWidget.width != null ? newWidget.width : this.width;
		this.height = newWidget.height != null ? newWidget.height : this.height;
		this.href = newWidget.href != null ? newWidget.href : this.href;
		this.src = newWidget.src != null ? newWidget.src : this.src;
		this.listItems = newWidget.listItems != null ? newWidget.listItems : this.listItems;
		this.listType = newWidget.listType != null ? newWidget.listType : this.listType;
		this.editorOpen = newWidget.editorOpen;
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

	public int getWidgetOrder() {
		return widgetOrder;
	}
	
	public void setWidgetOrder(int widgetOrder) {
		this.widgetOrder = widgetOrder;
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

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ListType getListType() {
		return listType;
	}

	public void setListType(ListType listType) {
		this.listType = listType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getListItems() {
		return listItems;
	}

	public void setListItems(String listItems) {
		this.listItems = listItems;
	}

	public boolean isEditorOpen() {
		return editorOpen;
	}

	public void setEditorOpen(boolean editorOpen) {
		this.editorOpen = editorOpen;
	}
	
}
