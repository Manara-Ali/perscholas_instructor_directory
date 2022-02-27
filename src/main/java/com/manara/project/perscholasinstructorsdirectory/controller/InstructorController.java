package com.manara.project.perscholasinstructorsdirectory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manara.project.perscholasinstructorsdirectory.model.Instructor;
import com.manara.project.perscholasinstructorsdirectory.service.InstructorService;

@RestController
@RequestMapping("/api/v2")
public class InstructorController {

	// Create a field to receive the DAO
	private InstructorService instructorService;
	
	// Use dependency inject to inject DAO into the field
	@Autowired
	public InstructorController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}
	
	// Create routes
	@GetMapping("/instructors")
	public List<Instructor> getAllInstructors() {
		return instructorService.findAll();
	}
	
	@GetMapping("/instructors/{id}")
	public Instructor getInstructor(@PathVariable int id) {
		// Find instructor
		Instructor instructor = instructorService.findById(id);
		
		// Assuming no instructor is found
		if(instructor == null) throw new RuntimeException("No instructor found with id: " + id);
		
		return instructor;
	}
	
	@PostMapping("/instructors/add")
	public Instructor addInstructor(@RequestBody Instructor instructor) {
		System.out.println(instructor);
		
		instructor.setId(0);
		
		Instructor newInstructor = instructorService.save(instructor);
		
		return newInstructor;
	}
	
	@PutMapping("/instructors/update")
	public Instructor updateInstructor(@RequestBody Instructor instructor) {
		return instructorService.save(instructor);
	}
	
	@DeleteMapping("/instructors/delete/{id}")
	public String deleteInstructor(@PathVariable int id) {
		Instructor instructor = instructorService.findById(id);
		
		if(instructor == null) return "No instructor found with id of: " + id;
		
		instructorService.delete(id);
		
		return "Instructor " + instructor.getFirstName() + ", " + instructor.getFirstName() + " deleted!";
	}
}
