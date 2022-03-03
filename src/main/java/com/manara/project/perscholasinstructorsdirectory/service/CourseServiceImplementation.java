package com.manara.project.perscholasinstructorsdirectory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manara.project.perscholasinstructorsdirectory.model.Course;
import com.manara.project.perscholasinstructorsdirectory.repository.CourseDAO;

@Service
public class CourseServiceImplementation implements CourseService {

	// Create field to receive injection
	private CourseDAO courseDAO;
	
	@Autowired
	public CourseServiceImplementation(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	
	@Override
	@Transactional
	public List<Course> findAll() {
		return courseDAO.findAll();
	}

	@Override
	@Transactional
	public Course findById(int id) {
		return courseDAO.findById(id);
	}

	@Override
	@Transactional
	public Course save(Course course) {
		return courseDAO.save(course);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		courseDAO.deleteById(id);
	}

}
