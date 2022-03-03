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
public class CourseController {

	// Create a field to receive a service injection
	private CourseService courseService;
	
	private InstructorService instructorService;
	
	// Constructor injection for service class
	@Autowired
	public CourseController(CourseService courseService, InstructorService instructorService) {
		this.courseService = courseService;
		this.instructorService = instructorService;
	}
	
	// Create routes for controller
	@GetMapping("/courses")
	public List<Course> getAllCourse() {
		return courseService.findAll();
	}
	
	// Create a method to retrieve a single course
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable int id) {
		
		// Retrieve a course
		Course course = courseService.findById(id);
		
		// If no course was found throw an error
		if(course == null) {
			throw new RuntimeException("No course found with id of : " + id);
		}
		
		return course;
	}
	
	// Create a method to add new course
	@PostMapping("/courses/add")
	public Course addCourse(@RequestBody Course course) {
		
		// Set the course id to 0 to force a save instead of an update
		course.setId(0);
		
		// Save course
		Course newCourse = courseService.save(course);
		
		return newCourse;
	}
	
	// Create a method to update courses
	@PutMapping("/courses/update")
	public Course updateCourse(@RequestBody Course course) {
		
		Course updatedCourse = courseService.save(course);
		
		return updatedCourse;
	}
	
	@DeleteMapping("/courses/delete/{id}")
	public String deleteCourse(@PathVariable int id) {
		
		Course course = courseService.findById(id);

		if(course == null) throw new RuntimeException("No course found with id: " + id);
		
		courseService.deleteById(id);
		
		return "Deleted course with id: " + id;
	}
	
	// Create a method to assign an existing course to an instructor
	@PutMapping("/assign/courses/{courseId}/instructors/{instructorId}")
	public Course assignCourse(@PathVariable int courseId, @PathVariable int instructorId) {
		// Find the course to add
		Course course = courseService.findById(courseId);
		
		if(course == null) throw new RuntimeException("No course found with id: " + courseId);
		
		// Find the instructor you want to add the course to
		Instructor instructor = instructorService.findById(instructorId);
		
		if(instructor == null) throw new RuntimeException("No cnstructor found with id: " + instructorId);
		
		// Set this instructor for this course
		course.setInstructor(instructor);
		
		// Save the course
		courseService.save(course);
		
		return course;
	}
}
