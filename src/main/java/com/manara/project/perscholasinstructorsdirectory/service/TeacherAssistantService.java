package com.manara.project.perscholasinstructorsdirectory.service;

import java.util.List;

import com.manara.project.perscholasinstructorsdirectory.model.Instructor;
import com.manara.project.perscholasinstructorsdirectory.model.TeacherAssistant;

public interface TeacherAssistantService {

	// Create a method to list all TA
	public List<TeacherAssistant> findAll();
	
	// Create a method to save/update a new TA alone
	public TeacherAssistant save(TeacherAssistant teacherAssistant);
	
	// Create a method to save/update TA with instructor
	public TeacherAssistant save(TeacherAssistant teacherAssistant, int instructorId);
	
	// Create a method to find a single teacher assistant by its id
	public TeacherAssistant findById(int id);
	
	// Create a method to delete a TA
	public void deleteById(int id);
}
