package com.manara.project.perscholasinstructorsdirectory.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manara.project.perscholasinstructorsdirectory.model.Course;
import com.manara.project.perscholasinstructorsdirectory.model.Review;

@Repository
public class ReviewDAOImplementation implements ReviewDAO {
	
	// Create a field to receive the Session Factory
	private EntityManager entityManager;
	
	private CourseDAO courseDAO;
	
	// Use constructor dependency injection to inject the Session Factory
	@Autowired
	public ReviewDAOImplementation(EntityManager entityManager, CourseDAO courseDAO) {
		this.entityManager = entityManager;
		this.courseDAO = courseDAO;
	}

	@Override
	public List<Review> findAll() {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Create a query for the list of review
		Query<Review> query = session.createQuery("FROM Review", Review.class);
		
		// 3. Create a list of all the reviews
		List<Review> reviewList = query.getResultList();
		
		// 4. Return the result
		return reviewList;
	}

	@Override
	public Review findById(int id) {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Return the review
		return session.get(Review.class, id);
	}

	@Override
	public Review save(int id, Review review) {
		// Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// Find the course to review
		Course course = courseDAO.findById(id);
		
		return null;
	}

	@Override
	public void deleteById(int id) {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Find the review to delete
		Review review = session.get(Review.class, id);
		
		// 2. Delete the review
		session.delete(review);
	}

}
