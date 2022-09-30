package com.dojo.java.gulsoftsolution.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Users")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "first name is required!")
	@Size(min = 3, max = 30, message="First name must be between 3 and 30 characters!")
	private String firstname;
	
	@NotEmpty(message = "last name is required!")
	@Size(min = 3, max = 30, message="last name must be between 3 and 30 characters!")
	private String lastname;
	
	@NotEmpty(message = "Email is required!")
	@Size(message = "Please enter a valid email!")
	private String email;
	
	@NotEmpty(message = "Password is required!")
	@Size(min = 8, max = 128)
	private String password;
	
	@Transient
	@NotEmpty(message = "Confirm password is required!")
	@Size(min = 8, max = 128)
	private String confirmPass;
	
	//Define Relationship
	
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date updatedAt;
	
	public User() {}
	

	//Define Getters and setters
	
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
		
}
