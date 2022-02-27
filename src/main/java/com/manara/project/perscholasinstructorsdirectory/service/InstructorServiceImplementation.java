package com.manara.project.perscholasinstructorsdirectory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manara.project.perscholasinstructorsdirectory.model.Instructor;
import com.manara.project.perscholasinstructorsdirectory.repository.InstructorDAO;

@Service
public class InstructorServiceImplementation implements InstructorService {
	
	// Create a field to inject DAO
	private InstructorDAO instructorDAO;
	
	@Autowired
	public InstructorServiceImplementation(InstructorDAO instructorDAO) {
		this.instructorDAO = instructorDAO;
	}

	@Override
	@Transactional
	public List<Instructor> findAll() {
		return instructorDAO.findAll();
	}

	@Override
	@Transactional
	public Instructor findById(int id) {
		return instructorDAO.findById(id);
	}

	@Override
	@Transactional
	public Instructor save(Instructor instructor) {
		return instructorDAO.save(instructor);
	}

	@Override
	@Transactional
	public void delete(int id) {
		instructorDAO.delete(id);
	}

}
