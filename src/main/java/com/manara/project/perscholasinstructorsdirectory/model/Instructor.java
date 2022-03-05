package com.manara.project.perscholasinstructorsdirectory.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="instructor")
public class Instructor {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	// CONSTRUCTORS
	public Instructor() {};
	
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	// ADD A ONE TO ONE RELATIONSHIP BETWEEN THE INSTRUCTOR AND INSTRUCTOR DETAIL
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	// Create getters and setters
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	// CREATE THE ONE TO MANY SIDE OF THE RELATIONSHIP FOR THE INSTRUCTOR AND COURSE
	
	@OneToMany(
			cascade= {
					CascadeType.PERSIST,
					CascadeType.MERGE,
					CascadeType.DETACH,
					CascadeType.REFRESH,
			},
			mappedBy="instructor"
	)
	@JsonIgnoreProperties("instructor")
	private List<Course> courses;
	
	// Add getters and setters for courses
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	// ADD A ONE TO MANY RELATIONSHIP BETWEEN INSTRUCTOR AND TEACHER ASSISTANT
	
	@OneToMany(
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE,
					CascadeType.DETACH,
					CascadeType.REFRESH
			},
			mappedBy="instructor"
	)
	@JsonIgnoreProperties("instructor")
	private List<TeacherAssistant> teacherAssistants;
	
	// Create getters and setters for teacherAssistantList
	public List<TeacherAssistant> getTeacherAssistants() {
		return teacherAssistants;
	}

	public void setTeacherAssistants(List<TeacherAssistant> teacherAssistants) {
		this.teacherAssistants = teacherAssistants;
	}
	

	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString method
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
	// Create a method to add course to instructor
	public void addCourse(Course course) {
		if(this.courses == null) {
			courses = new ArrayList<Course>();
		}
		
		// Add course to the list of courses
		courses.add(course);
		
		this.setCourses(courses);
		
		// Assign this course to the instructor
		course.setInstructor(this);
	}
	
	public void addTeacherAssistant(TeacherAssistant ...teacherAssistant) {
		
		// Assuming this instructor add no TA
		if(this.teacherAssistants == null) {
			List teacherAssistants = new ArrayList<TeacherAssistant>();
		}
		
		// Add the new TA to the list of TAs
		for(TeacherAssistant element : teacherAssistants) {
			teacherAssistants.add(element);
			
			this.setTeacherAssistants(teacherAssistants);
			
			// Set this TA to the teacher
			element.setInstructor(this);
		}
	}
}
