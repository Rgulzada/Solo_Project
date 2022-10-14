package com.dojo.java.gulsoftsolution.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	private String name;
	
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
	private String confirmPass;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date updatedAt;
	
	public User(
			@NotEmpty(message = "first name is required!") @Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters!") String name,
			@NotEmpty(message = "last name is required!") @Size(min = 3, max = 30, message = "last name must be between 3 and 30 characters!") String lastname,
			@NotEmpty(message = "Email is required!") @Size(message = "Please enter a valid email!") String email,
			@NotEmpty(message = "Password is required!") @Size(min = 8, max = 128) String password) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	
	//Define Relationship
	 @ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
				name = "users_listings",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "listing_id")
		)
	    private List<Information> informations;
	    
	    @Column(updatable=false)
	    @OneToMany(mappedBy="lead", fetch = FetchType.LAZY)
	    private List<Information> informationsLead;
	    
	    @Column(updatable=false)
	    @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
	    private List<Task> tasksCreated;
	  
	
	public User() {}
	
	//Getters and setters
	
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
	
	public List<Information> getInformations() {
		return informations;
	}
	public void setInformations(List<Information> informations) {
		this.informations = informations;
	}
	public List<Information> getInformationsLed() {
		return informationsLead;
	}
	public void setInformationsLed(List<Information> informationsLead) {
		this.informationsLead = informationsLead;
	}
	public List<Task> getTasksCreated() {
		return tasksCreated;
	}
	public void setTasksCreated(List<Task> tasksCreated) {
		this.tasksCreated = tasksCreated;
	}

}
