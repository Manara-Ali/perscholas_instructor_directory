package com.manara.project.perscholasinstructorsdirectory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manara.project.perscholasinstructorsdirectory.model.TeacherAssistant;
import com.manara.project.perscholasinstructorsdirectory.service.TeacherAssistantService;

@RestController
@RequestMapping("/api/v2")
public class TeacherAssistantController {

	// Create field to recieve our service class
	private TeacherAssistantService teacherAssistantService;
	
	// Use dependency injection to inject TA service class
	@Autowired
	public TeacherAssistantController(TeacherAssistantService teacherAssistantService) {
		this.teacherAssistantService = teacherAssistantService;
	}
	
	// Create routes
	@GetMapping("/teacher-assistants/all")
	public List<TeacherAssistant> getAllTA() {
		return teacherAssistantService.findAll();
	}
	
	@PostMapping("/teacher-assistants/add")
	public TeacherAssistant addTeacherAssistant(@RequestBody TeacherAssistant teacherAssistant) {
		return teacherAssistantService.save(teacherAssistant);
	}
}
