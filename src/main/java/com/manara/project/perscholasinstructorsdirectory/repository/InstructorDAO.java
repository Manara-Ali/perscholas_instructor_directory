package com.manara.project.perscholasinstructorsdirectory.repository;

import java.util.List;

import com.manara.project.perscholasinstructorsdirectory.model.Course;
import com.manara.project.perscholasinstructorsdirectory.model.Instructor;

public interface InstructorDAO {

	// Create a method to retrieve all instructor
	public List<Instructor> findAll();
	
	// Create a method to retrieve a single instructor
	public Instructor findById(int id);
	
	// Create a method to add a new instructor
	public Instructor save(Instructor instructor);
	
	
	
	// Create a method to delete instructor
	public void delete(int id);
}
