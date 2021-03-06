package com.manara.project.perscholasinstructorsdirectory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manara.project.perscholasinstructorsdirectory.model.Instructor;
import com.manara.project.perscholasinstructorsdirectory.model.TeacherAssistant;
import com.manara.project.perscholasinstructorsdirectory.repository.TeacherAssistantDAO;

@Service
public class TeacherAssistantServiceImplementation implements TeacherAssistantService {
	
	// Create a field to receive our service
	private TeacherAssistantDAO teacherAssistantDAO;
	
	// Use constructor injection
	@Autowired
	public TeacherAssistantServiceImplementation(TeacherAssistantDAO teacherAssistantDAO) {
		this.teacherAssistantDAO = teacherAssistantDAO;
	}

	@Override
	@Transactional
	public List<TeacherAssistant> findAll() {
		return teacherAssistantDAO.findAll();
	}

	@Override
	@Transactional
	public TeacherAssistant save(TeacherAssistant teacherAssistant) {
		return teacherAssistantDAO.save(teacherAssistant);
	}

	@Override
	@Transactional
	public TeacherAssistant findById(int id) {
		return teacherAssistantDAO.findById(id);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		teacherAssistantDAO.deleteById(id);
	}

	@Override
	public TeacherAssistant save(TeacherAssistant teacherAssistant, int instructorId) {
		return teacherAssistantDAO.save(teacherAssistant, instructorId);
	}

}
