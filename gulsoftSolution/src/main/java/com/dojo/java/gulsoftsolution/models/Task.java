package com.dojo.java.gulsoftsolution.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, message="Name must be at least 3 characters long")
	private String name;
	
	@Size(min=3, message="Lastname must be at least 3 characters long")
	private String lastname;
	
	@Size(min=20, message="at least 3 sentences")
	private String summary;
	
	@Size(min=10, message="select at least one skill")
	private String skills;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="task_id")
	private User creator;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="information_id")
	private Information information;
	
	public Task() {}
	
	public Task( String name, String lastname, String summary,String skills) {
		this.name = name;
		this.lastname = lastname;
		this.summary = summary;
		this.skills = skills;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
}
