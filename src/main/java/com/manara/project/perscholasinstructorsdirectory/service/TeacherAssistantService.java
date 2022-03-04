package com.manara.project.perscholasinstructorsdirectory.service;

import java.util.List;

import com.manara.project.perscholasinstructorsdirectory.model.TeacherAssistant;

public interface TeacherAssistantService {

	// Create a method to list all TA
	public List<TeacherAssistant> findAll();
	
	// Create a method to save/update a new TA
	public TeacherAssistant save(TeacherAssistant teacherAssistant);
}
