package com.manara.project.perscholasinstructorsdirectory.repository;

import java.util.List;

import com.manara.project.perscholasinstructorsdirectory.model.Course;

public interface CourseDAO {

	// Create a method to retrieve all the courses
	public List<Course> findAll();
	
	// Create a method to retrieve a course given its id
	public Course findById(int id);
	
	// Create a method to add a course
	public Course save(Course course);
	
	// Create a method to delete courses using their id
	public void deleteById(int id);
}
