package com.manara.project.perscholasinstructorsdirectory.repository;

import java.util.List;

import com.manara.project.perscholasinstructorsdirectory.model.Course;
import com.manara.project.perscholasinstructorsdirectory.model.Review;

public interface ReviewDAO {
	
	// Create a method to retrieve all reviews
	public List<Review> findAll();
	
	// Create a method to add a review
	// I don't believe I need this method because a review alone is meaningless and should always be paired to a course
//	public Review save(Review review);
	
	// Create a method to find a review by id
	public Review findById(int id);
	
	// Create a method to add a review to a course
	public Review save(int id, Review review);
	
	// Create a method to delete a review alone without deleting the course
	public void deleteById(int id);
}
