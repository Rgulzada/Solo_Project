package com.dojo.java.gulsoftsolution.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.java.gulsoftsolution.models.User;
import com.dojo.java.gulsoftsolution.models.Login;
import com.dojo.java.gulsoftsolution.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userServ;
	
	@Autowired
	private HttpSession session;

	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	//This is the login and registration page
	@GetMapping("/login")
	public String Login(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new Login());
		return "login.jsp";
	}

	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
							BindingResult result, Model model, HttpSession session) {
		
		///starts here COntinueee
		
		return "login.jsp";
	}
	
	@PostMapping("/login")
	public String login() {
		return "login.jsp";
	}
}
