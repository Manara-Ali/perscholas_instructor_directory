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
import com.manara.project.perscholasinstructorsdirectory.model.TeacherAssistant;
import com.manara.project.perscholasinstructorsdirectory.service.InstructorService;
import com.manara.project.perscholasinstructorsdirectory.service.TeacherAssistantService;

@RestController
@RequestMapping("/api/v2")
public class TeacherAssistantController {

	// Create field to receive our service class
	private TeacherAssistantService teacherAssistantService;
	
	// Create a field to receive our instructor
	private InstructorService instructorService;
	
	// Use dependency injection to inject TA service class
	@Autowired
	public TeacherAssistantController(TeacherAssistantService teacherAssistantService, InstructorService instructorService) {
		this.teacherAssistantService = teacherAssistantService;
		this.instructorService = instructorService;
	}
	
	// Create routes
	@GetMapping("/teacher-assistants/all")
	public List<TeacherAssistant> getAllTA() {
		return teacherAssistantService.findAll();
	}
	
	@GetMapping("/teacher-assistants/{id}")
	public TeacherAssistant getTeacherAssistant(@PathVariable int id) {
		TeacherAssistant teacherAssistant = teacherAssistantService.findById(id);
		
		if(teacherAssistant == null) throw new RuntimeException("No teacher assistant found with id: " + id);
		
		return teacherAssistant;
	}
	
	@PostMapping("/teacher-assistants/add")
	public TeacherAssistant addTeacherAssistant(@RequestBody TeacherAssistant teacherAssistant) {
		return teacherAssistantService.save(teacherAssistant);
	}
	
	@PostMapping("/instructors/{instructorId}/teacher-assistants/add")
	public TeacherAssistant addTeacherAssistantWithInstructor(@PathVariable int instructorId, @RequestBody TeacherAssistant teacherAssistant) {
		// Retrieve the instructor
		Instructor instructor = instructorService.findById(instructorId);
		
		if(instructor == null) throw new RuntimeException("No instructor found with id: " + instructorId);
		
		// Add the TA to the instructor
		teacherAssistant.setInstructor(instructor);
		
		teacherAssistantService.save(teacherAssistant);
		
		return teacherAssistant;
	}
	
	// Update TA information alone
	@PutMapping("/teacher-assistants/info/update")
	public TeacherAssistant updateTAInfo(@RequestBody TeacherAssistant teacherAssistant) {
	
		teacherAssistantService.save(teacherAssistant);
		
		return teacherAssistant;
	}
	
	@PutMapping("/teacher-assistants/update/{teacherAssistantId}") // Update TA that have existing instructors
	public TeacherAssistant updateTA(@RequestBody TeacherAssistant teacherAssistant, @PathVariable int teacherAssistantId) {
		
		// Retrieve the lead instructor of this TA
		Instructor existingInstructor = teacherAssistantService.findById(teacherAssistantId).getInstructor();
		
		System.out.println(existingInstructor);
		
		// Assuming no instructor was found
		if(existingInstructor == null) {
			
			teacherAssistantService.save(teacherAssistant);
			
		}
		
		teacherAssistant.setInstructor(existingInstructor);
		
		instructorService.save(existingInstructor);

		teacherAssistantService.save(teacherAssistant);
		
		return teacherAssistant;
	}
	
	@DeleteMapping("/teacher-assistants/delete/{id}")
	public String deleteTeacherAssistant(@PathVariable int id) {
		
		// 1. Lets find the TA to delete
		TeacherAssistant teacherAssistant = teacherAssistantService.findById(id);
		
		// 2. Assuming no TA was found
		if(teacherAssistant == null) throw new RuntimeException("No teacher assistant found with id: " + id);
		
		// 3. Delete TA
		teacherAssistantService.deleteById(id);
		
		return "Teacher assistant " + id + " deleted!";
	}
}
