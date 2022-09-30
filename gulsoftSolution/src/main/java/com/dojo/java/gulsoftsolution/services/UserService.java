package com.dojo.java.gulsoftsolution.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.java.gulsoftsolution.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
}
