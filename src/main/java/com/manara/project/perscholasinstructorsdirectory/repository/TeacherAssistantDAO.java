package com.manara.project.perscholasinstructorsdirectory.repository;

import java.util.List;

import com.manara.project.perscholasinstructorsdirectory.model.Instructor;
import com.manara.project.perscholasinstructorsdirectory.model.TeacherAssistant;

public interface TeacherAssistantDAO {

	// Create a method to retrieve all the teacher assistants
	public List<TeacherAssistant> findAll();
	
	// Create a method to save/update teacher assistant alone
	public TeacherAssistant save(TeacherAssistant teacherAssistant);
	
	// Create a method to find a single teacher assistant by its id
	public TeacherAssistant findById(int id);
	
	// Create a method to delete a TA
	public void deleteById(int id);
	
	// Create a method to update TA information and instructor
	public TeacherAssistant save(TeacherAssistant teacherAssistant, int instructorId);
}
