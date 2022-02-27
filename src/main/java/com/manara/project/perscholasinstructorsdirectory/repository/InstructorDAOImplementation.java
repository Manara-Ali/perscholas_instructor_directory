package com.manara.project.perscholasinstructorsdirectory.repository;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manara.project.perscholasinstructorsdirectory.model.Instructor;

@Repository
public class InstructorDAOImplementation implements InstructorDAO {

	// Create a field to receive the EntiyManager injection
	private EntityManager entityManager;
	
	// Use constructor injection
	@Autowired
	public InstructorDAOImplementation(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public List<Instructor> findAll() {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Create a query to retrieve all the instructors
		Query<Instructor> query = session.createQuery("FROM Instructor", Instructor.class);
		
		// 3. Create a list of all instructor
		List<Instructor> instructorList = query.getResultList();
		
		// 4. Return the list of instructor
		return instructorList;
	}

	@Override
	@Transactional
	public Instructor save(Instructor instructor) {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Save new instructor
		session.saveOrUpdate(instructor);
		
		// 3. Return the saved instructor
		return instructor;
	}

	@Override
	@Transactional
	public Instructor findById(int id) {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Retrieve the instructor using its id
		Instructor instructor = session.get(Instructor.class, id);
		
		return instructor;
	}

	@Override
	@Transactional
	public void delete(int id) {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Find the instructor
		Instructor instructor = session.get(Instructor.class, id);
		
		session.delete(instructor);
	}

}
