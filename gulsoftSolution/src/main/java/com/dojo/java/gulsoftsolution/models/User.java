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
	public User(
			@NotEmpty(message = "first name is required!") @Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters!") String firstname,
			@NotEmpty(message = "last name is required!") @Size(min = 3, max = 30, message = "last name must be between 3 and 30 characters!") String lastname,
			@NotEmpty(message = "Email is required!") @Size(message = "Please enter a valid email!") String email,
			@NotEmpty(message = "Password is required!") @Size(min = 8, max = 128) String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date updatedAt;
	
	public User() {}
	
	//Getters and setters
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPass() {
		return confirmPass;
	}


	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
		
}
