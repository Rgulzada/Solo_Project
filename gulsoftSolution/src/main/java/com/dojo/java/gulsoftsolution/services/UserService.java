package com.dojo.java.gulsoftsolution.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.dojo.java.gulsoftsolution.models.Login;
import com.dojo.java.gulsoftsolution.models.User;
import com.dojo.java.gulsoftsolution.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public User create(User newUser) {
		return userRepo.save(newUser);
	}
	
	public User authenticate(String email) {
		return userRepo.findByEmail(email).orElse(null);
	}
	
	/*--------Register-----*/
	
	public User register(User newUser ,BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		
		// check if email exist
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "An account with that email already exists!");
		}
		// Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirmPass())) {
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	
    	// Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	 // Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	
    	return userRepo.save(newUser);
	}
	
	/*---------Login--------------*/
	public User login(Login newLogin, BindingResult result) {

		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        
    	// Find user in the DB by email
        // Reject if NOT present
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "User not found!");
    		return null;
    	}
    	
    	// User exists, retrieve user from DB
    	User user = potentialUser.get();
        
        // Reject if BCrypt password match fails
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	// Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    	
        // Otherwise, return the user object
        return user;
        
    }

	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else {
			return null;
		}
	}
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
}
