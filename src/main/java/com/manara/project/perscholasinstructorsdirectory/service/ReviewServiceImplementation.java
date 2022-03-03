package com.manara.project.perscholasinstructorsdirectory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manara.project.perscholasinstructorsdirectory.model.Course;
import com.manara.project.perscholasinstructorsdirectory.model.Review;
import com.manara.project.perscholasinstructorsdirectory.repository.ReviewDAO;

@Service
public class ReviewServiceImplementation implements ReviewService {

	// Create a field to receive our reviewDAO
	private ReviewDAO reviewDAO;
	
	// Use constructor injection to inject DAO
	@Autowired
	public ReviewServiceImplementation(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}
	
	@Override
	@Transactional
	public List<Review> findAll() {
		return reviewDAO.findAll();
	}

	@Override
	public Review save(Review review) {
		return reviewDAO.save(review);
	}

	@Override
	public Review findById(int id) {
		return reviewDAO.findById(id);
	}

	@Override
	public Review save(int id, Review review) {
		return reviewDAO.save(id, review);
	}

}
