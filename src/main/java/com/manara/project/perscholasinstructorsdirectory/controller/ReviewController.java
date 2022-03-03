package com.manara.project.perscholasinstructorsdirectory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manara.project.perscholasinstructorsdirectory.model.Course;
import com.manara.project.perscholasinstructorsdirectory.model.Review;
import com.manara.project.perscholasinstructorsdirectory.service.CourseService;
import com.manara.project.perscholasinstructorsdirectory.service.ReviewService;

@RestController
@RequestMapping("/api/v2")
public class ReviewController {

	// Create a field to receive our service class
	private ReviewService reviewService;
	
	// Create a field to receive the course service class
	private CourseService courseService;
	
	@Autowired
	public ReviewController(ReviewService reviewService, CourseService courseService) {
		this.reviewService = reviewService;
		this.courseService = courseService;
	}
	
	// Create routes
	@GetMapping("/reviews")
	public List<Review> getAllReviews() {
		return reviewService.findAll();
	}
	
	@GetMapping("/reviews/{id}")
	public Review getReview(@PathVariable int id) {
		// Find the review
		Review review = reviewService.findById(id);
		
		if(review == null) throw new RuntimeException("No review found with id: " + id);
	
		return review;
	}
	
	@PostMapping("/reviews/add")
	public Review save(@RequestBody Review review) {
		
		// Force a save rather than delete
		review.setId(0);
		
		Review newReview = reviewService.save(review);
		
		return newReview;
	}
	
	@PostMapping("/courses/{courseId}/reviews/add")
	public Review addCourseReview(@PathVariable int courseId, @RequestBody Review review) {
		
		// Find the course we would like to review
		Course course = courseService.findById(courseId);
		
		if(course == null) throw new RuntimeException("No course with id " + courseId);
		
		course.getReviewList().add(review);
		
		System.out.println(course.getReviewList());
		
		review.setCourse(course);

		courseService.save(course);
		
		return review;
	}
}
