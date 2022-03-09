package com.manara.project.perscholasinstructorsdirectory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manara.project.perscholasinstructorsdirectory.model.Course;
import com.manara.project.perscholasinstructorsdirectory.model.Review;

@Service
public interface ReviewService {

	// 1. Create a method to get all the reviews
	public List<Review> findAll();
	
	// 2. Create a method to add a review
//	public Review save(Review review);
	
	// 3. Create a method to retrieve a single review
	public Review findById(int id);
	
	// 4. Create a method to save review to course
	public Review save(int id, Review review);
	
	// 5. Create a method for deleting a review
	public void deleteById(int id);
}
