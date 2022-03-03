package com.manara.project.perscholasinstructorsdirectory.repository;

import java.util.List;

import com.manara.project.perscholasinstructorsdirectory.model.Course;
import com.manara.project.perscholasinstructorsdirectory.model.Review;

public interface ReviewDAO {
	
	// Create a method to retrieve all reviews
	public List<Review> findAll();
	
	// Create a method to add a review
	public Review save(Review review);
	
	// Create a method to find a review by id
	public Review findById(int id);
	
	// Create a method to add a review to a course
	public Review save(int id, Review review);
}
