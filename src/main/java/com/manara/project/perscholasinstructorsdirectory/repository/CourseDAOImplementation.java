package com.manara.project.perscholasinstructorsdirectory.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manara.project.perscholasinstructorsdirectory.model.Course;

@Repository
public class CourseDAOImplementation implements CourseDAO {
	
	// Create a field to receive our entityManager
	private EntityManager entityManager;
	
	// Perform constructor dependency injection into the entityManager
	@Autowired
	public CourseDAOImplementation(EntityManager entityManager) {
		this.entityManager = entityManager; // Session Factory
	}

	@Override
	public List<Course> findAll() {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Create a query on all course
		Query<Course> query = session.createQuery("FROM Course", Course.class);
		
		// 3. Create a list of all courses
		List<Course> courseList = query.getResultList();
		
		return courseList;
	}

	@Override
	public Course findById(int id) {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Query the list of course for a single course
		Course course = session.get(Course.class, id);
		
		return course;
	}

	@Override
	public Course save(Course course) {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Save the course
		session.saveOrUpdate(course);
		
		return course;
	}

	@Override
	public void deleteById(int id) {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Find the course by id
		Course course = session.get(Course.class, id);
		
		session.delete(course);
	}

}
