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

import com.manara.project.perscholasinstructorsdirectory.model.Course;
import com.manara.project.perscholasinstructorsdirectory.model.Instructor;
import com.manara.project.perscholasinstructorsdirectory.service.CourseService;
import com.manara.project.perscholasinstructorsdirectory.service.InstructorService;

@RestController
@RequestMapping("/api/v2")
public class InstructorController {

	// Create a field to receive the DAO
	private InstructorService instructorService;
	
	// Create a field to receive Course DAO
	private CourseService courseService;
	
	// Use dependency inject to inject DAO into the field
	@Autowired
	public InstructorController(InstructorService instructorService) {
		this.instructorService = instructorService;
		this.courseService = courseService;
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
	
	// Create a method to add an instructor AND a course
	@PostMapping("/instructors/courses/add")
	public Instructor addInstructorWithCourse(@RequestBody Instructor instructor, Course course) {
		
		course = instructor.getCourses().get(0);
		
		instructor.addCourse(course);
		
		// Save the instructor
		instructorService.save(instructor);
		
		return instructor;
	}
	
	@PutMapping("/instructors/update")
	public Instructor updateInstructor(@RequestBody Instructor instructor) {
		return instructorService.save(instructor);
	}
	
	@DeleteMapping("/instructors/delete/{id}")
	public String deleteInstructor(@PathVariable int id) {
		Instructor instructor = instructorService.findById(id);
		
		if(instructor == null) return "No instructor found with id of: " + id;
		
		// Verify that the instructor you're about to delete does NOT have a course
		if(instructor.getCourses() == null) {
			
			// If the instructor does not have a current course he is teaching, then delete the instructor
			instructorService.delete(id);
			
		} else {
			
			// Find the course the instructor is teaching
			List <Course> courseList = instructor.getCourses();
			
			
			// Also 
			for(Course element : courseList) {
				// Loop through the list of course and set the instructor for these courses to null
				element.setInstructor(null);

				// Persist the instructor with all his courses removed
				instructorService.save(instructor);
			}

		}
		
		// Delete the instructor without getting a SQL Foreign Key error
		instructorService.delete(id);

		// Provide feedback to user
		return "Instructor " + instructor.getFirstName() + ", " + instructor.getFirstName() + " deleted!";

	}
}
