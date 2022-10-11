package com.dojo.java.gulsoftsolution.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Login {
	
	@NotEmpty(message = "Email is required!")
	@Size(message = "Please enter a valid email!")
	private String email;
	
	@NotEmpty(message = "Password is required!")
	@Size(min = 8, max = 128)
	private String password;
	
	public Login() {}
	
	//Getters and Setters
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
	
	
}
