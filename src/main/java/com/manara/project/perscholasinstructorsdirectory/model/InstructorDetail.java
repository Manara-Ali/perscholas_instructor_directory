package com.manara.project.perscholasinstructorsdirectory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="linked_in_url")
	private String linkedInUrl;
	
	@Column(name="github_url")
	private String githubUrl;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="portfolio_link")
	private String portfolioLink;
	
	@Column(name="biography")
	private String biography;
	
	// CONSTRUCTORS
	public InstructorDetail() {}

	public InstructorDetail(String lindedInUrl, String githubUrl, String youtubeChannel, String portfolioLink,
			String biography) {
		this.linkedInUrl = lindedInUrl;
		this.githubUrl = githubUrl;
		this.youtubeChannel = youtubeChannel;
		this.portfolioLink = portfolioLink;
		this.biography = biography;
	}

	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLindedInUrl() {
		return linkedInUrl;
	}

	public void setLindedInUrl(String lindedInUrl) {
		this.linkedInUrl = lindedInUrl;
	}

	public String getGithubUrl() {
		return githubUrl;
	}

	public void setGithubUrl(String githubUrl) {
		this.githubUrl = githubUrl;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getPortfolioLink() {
		return portfolioLink;
	}

	public void setPortfolioLink(String portfolioLink) {
		this.portfolioLink = portfolioLink;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	// toString method
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", lindedInUrl=" + linkedInUrl + ", githubUrl=" + githubUrl
				+ ", youtubeChannel=" + youtubeChannel + ", portfolioLink=" + portfolioLink + ", biography=" + biography
				+ "]";
	};
}
