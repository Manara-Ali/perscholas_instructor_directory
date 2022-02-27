package com.manara.project.perscholasinstructorsdirectory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manara.project.perscholasinstructorsdirectory.model.Instructor;
import com.manara.project.perscholasinstructorsdirectory.repository.InstructorDAO;

@RestController
@RequestMapping("/api/v2")
public class InstructorController {

	// Create a field to receive the DAO
	private InstructorDAO instructorDAO;
	
	// Use dependency inject to inject DAO into the field
	@Autowired
	public InstructorController(InstructorDAO instructorDAO) {
		this.instructorDAO = instructorDAO;
	}
	
	// Create routes
	@GetMapping("/instructors")
	public List<Instructor> getAllInstructors() {
		return instructorDAO.findAll();
	}
}
