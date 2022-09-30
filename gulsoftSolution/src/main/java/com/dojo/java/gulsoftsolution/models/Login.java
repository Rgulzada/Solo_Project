package com.dojo.java.gulsoftsolution.models;

import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Login {
	
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
	
	public Login() {}
}
