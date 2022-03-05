package com.manara.project.perscholasinstructorsdirectory.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manara.project.perscholasinstructorsdirectory.model.Instructor;
import com.manara.project.perscholasinstructorsdirectory.model.TeacherAssistant;

@Repository
public class TeacherAssistantDAOImplementation implements TeacherAssistantDAO {

	// Create a field to use as our Session Factory
	private EntityManager entityManager;
	
	// Use constructor injection to inject a Session Factory into our field
	@Autowired
	public TeacherAssistantDAOImplementation(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<TeacherAssistant> findAll() {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Create a query for all TA
		Query<TeacherAssistant> query = session.createQuery("FROM TeacherAssistant");
		
		// 3. Create a list of all TA
		List<TeacherAssistant> teacherAssistantList = query.getResultList();
		
		// 4. Return the list of TA
		return teacherAssistantList;
	}

	@Override
	public TeacherAssistant save(TeacherAssistant teacherAssistant) {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);

		// 2. Force a save on new TA
//		teacherAssistant.setId(0);
						
		// 3. Save the TA
		session.saveOrUpdate(teacherAssistant);
		
		return teacherAssistant;
	}


	@Override
	public TeacherAssistant findById(int id) {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Find teacher assistant
		TeacherAssistant teacherAssistant = session.get(TeacherAssistant.class, id);
		
		return teacherAssistant;
	}

	@Override
	public void deleteById(int id) {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Find the TA
		TeacherAssistant teacherAssistant = session.get(TeacherAssistant.class, id);
		
		// 3. Delete TA
		session.delete(teacherAssistant);
	}

	@Override
	public TeacherAssistant save(TeacherAssistant teacherAssistant, int instructorId) {
		// 1. Retrieve the current session
		Session session = entityManager.unwrap(Session.class);
		
		// 2. Save TA
		session.saveOrUpdate(teacherAssistant);
		
		return teacherAssistant;
	}

}
