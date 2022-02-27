package com.manara.project.perscholasinstructorsdirectory.repository;

import java.util.List;

import com.manara.project.perscholasinstructorsdirectory.model.Instructor;

public interface InstructorDAO {

	public List<Instructor> findAll();
}
