package com.manara.project.perscholasinstructorsdirectory.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/// This is the many side of the relationship

@Entity
@Table(name="review")
public class Review {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	// CREATE A MANY TO ONE RELATIONSHIP WITH COURSE
	
	@ManyToOne(
			cascade= {
					CascadeType.PERSIST,
					CascadeType.MERGE,
					CascadeType.DETACH,
					CascadeType.REFRESH
			}
	)
	@JoinColumn(name="course_id")
	@JsonIgnoreProperties("reviewList")
	private Course course;
	
	// Getters and setters for course
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	// CONSTRUCTORS
	public Review() {}

	public Review(String comment) {
		this.comment = comment;
	}

	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	// toString method
	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	};
}
