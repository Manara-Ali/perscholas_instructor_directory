package com.manara.project.perscholasinstructorsdirectory.service;

import java.util.List;

import com.manara.project.perscholasinstructorsdirectory.model.Course;

public interface CourseService {

	// Create a method to retrieve all course
	public List<Course> findAll();
	
	// Create a method to retrieve a single course
	public Course findById(int id);
	
	// Create a method to save/update a course
	public Course save(Course course);
	
	// Create a method to delete a course by id
	public void deleteById(int id);
}
