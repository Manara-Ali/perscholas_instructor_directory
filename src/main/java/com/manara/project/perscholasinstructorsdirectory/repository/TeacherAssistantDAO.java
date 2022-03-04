package com.manara.project.perscholasinstructorsdirectory.repository;

import java.util.List;

import com.manara.project.perscholasinstructorsdirectory.model.TeacherAssistant;

public interface TeacherAssistantDAO {

	// Create a method to retrieve all the teacher assistants
	public List<TeacherAssistant> findAll();
	
	// Create a method to save/update teacher assistant
	public TeacherAssistant save(TeacherAssistant teacherAssistant);
}
