package com.manara.project.perscholasinstructorsdirectory.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="course_description")
	private String courseDescription;
	
	// CREATE A MANY TO ONE RELATIONSHIP BETWEEN COURSE AND INSTRUCTOR
	
	@ManyToOne(
			cascade= {
					CascadeType.PERSIST,
					CascadeType.MERGE,
					CascadeType.REFRESH,
					CascadeType.DETACH
			}
	)
	@JoinColumn(name="instructor_id")
	@JsonIgnoreProperties("courses")
	private Instructor instructor;
	
	// Getters and setters for instructor
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	// CONSTRUCTOR
	public Course() {}

	public Course(String courseName, String courseDescription) {
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	// toString method
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseDescription=" + courseDescription + "]";
	};
}
