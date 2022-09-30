package com.dojo.java.gulsoftsolution.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/login")
	public String Login() {
		return "login.jsp";
	}
}
